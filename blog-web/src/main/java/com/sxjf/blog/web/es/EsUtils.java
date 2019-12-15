package com.sxjf.blog.web.es;


import com.alibaba.fastjson.JSON;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangyang
 * @description 工具类
 * @Date 2019/12/9
 */
public class EsUtils {

    /***
     *功能描述: 创建索引
     * @author wangyang
     * @param [indexName, indexType, aliasName]
     * @return void
     */
    public static void createIndex(String indexName, String alias, Map<String, Object> mapping) throws IOException {
        String s = JSON.toJSONString(mapping);
        System.out.println(s);
        if (indexExists(indexName)) {
            //throw new GsApiException("该索引已存在");
        }
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        //索引设置
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)   //分片数
                .put("index.number_of_replicas", 2) //备份数
        );
        request.mapping(mapping);
        //别名
        request.alias(new Alias(alias));
        request.setTimeout(TimeValue.timeValueMinutes(2));
        request.setMasterTimeout(TimeValue.timeValueMinutes(1));
        request.waitForActiveShards(ActiveShardCount.DEFAULT);
        try {
            ESClientConfig.getEsClient().indices().create(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            RestStatus a = exception.status();
            //throw new GsApiException(exception.getDetailedMessage());
        }
    }

    public static XContentBuilder buildEsMapping(String Object) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("message");
                {
                    builder.field("type", "text");
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();
        return builder;
    }

    /***
     *功能描述: 删除索引
     * @author wangyang
     * @param indexName
     * @return void
     */
    public static void deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        request.timeout(TimeValue.timeValueMinutes(2));
        request.timeout("2m");
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        request.masterNodeTimeout("1m");
        try {
            ESClientConfig.getEsClient().indices().delete(request, RequestOptions.DEFAULT).isAcknowledged();
        } catch (ElasticsearchException exception) {
            //throw new GsApiException(exception.getDetailedMessage());
        }

    }

    /***
     *功能描述: 刷新指定索引
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void refreIndex(String indexName) throws IOException {
        RefreshRequest request = new RefreshRequest(indexName);
        try {
            ESClientConfig.getEsClient().indices().refresh(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                //throw new GsApiException("刷新失败，指定索引不存在");
            }
        }
    }

    /***
     *功能描述: 刷新所有索引
     * @author wangyang
     * @param []
     * @return void
     */
    public static void refreAll() throws IOException {
        RefreshRequest requestAll = new RefreshRequest();
        ESClientConfig.getEsClient().indices().refresh(requestAll, RequestOptions.DEFAULT);
    }

    /***
     *功能描述: 判断索引是否存在
     * @author wangyang
     * @param [indexName]
     * @return boolean
     */
    public static boolean indexExists(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        return ESClientConfig.getEsClient().indices().exists(request, RequestOptions.DEFAULT);
    }

    /***
     *功能描述: 打开索引
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void openIndex(String... indexName) throws IOException {
        OpenIndexRequest request = new OpenIndexRequest(indexName);
        request.timeout(TimeValue.timeValueMinutes(2));
        request.timeout("2m");
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        request.masterNodeTimeout("1m");
        request.waitForActiveShards(2);
        request.waitForActiveShards(ActiveShardCount.DEFAULT);
        request.indicesOptions(IndicesOptions.strictExpandOpen());
        ESClientConfig.getEsClient().indices().open(request, RequestOptions.DEFAULT);
    }

    /***
     *功能描述: 关闭索引
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void closeIndex(String... indexName) throws IOException {
        CloseIndexRequest request = new CloseIndexRequest(indexName);
        request.timeout(TimeValue.timeValueMinutes(2));
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        ESClientConfig.getEsClient().indices().close(request, RequestOptions.DEFAULT);
    }

    /***
     *功能描述: 清除指定索引缓存
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void clearCache(String indexName) throws IOException {
        try {
            ClearIndicesCacheRequest requestMultiple = new ClearIndicesCacheRequest(indexName);
            requestMultiple.queryCache(true);
            requestMultiple.fieldDataCache(true);
            requestMultiple.requestCache(true);
            ESClientConfig.getEsClient().indices().clearCache(requestMultiple, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                //throw new GsApiException("清除缓存失败,该索引不存在");
            }
        }
    }

    /***
     *功能描述: 清除索引缓存
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void clearAllCache() throws IOException {
        try {
            ClearIndicesCacheRequest requestAll = new ClearIndicesCacheRequest();
            requestAll.queryCache(true);
            requestAll.fieldDataCache(true);
            requestAll.requestCache(true);
            ESClientConfig.getEsClient().indices().clearCache(requestAll, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {

            }
        }

    }

    //别名
    public static Map<String, Set<AliasMetaData>> getAlias(String aliasName) throws IOException {
        GetAliasesRequest requestWithAliases = new GetAliasesRequest(aliasName);
        requestWithAliases.local(true);
        GetAliasesResponse response = ESClientConfig.getEsClient().indices().getAlias(requestWithAliases, RequestOptions.DEFAULT);
        return response.getAliases();
    }

    /***
     *功能描述: 创建文档
     * @author wangyang
     * @param [indexName, documentId, source]
     * @return void
     */
    public static void createDocument(String indexName, String documentId, Map<String, Object> source) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName)
                .id(documentId)
                .source(source)
                .opType(DocWriteRequest.OpType.CREATE);
        try {
            ESClientConfig.getEsClient().index(indexRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("已经存在具有相同索引和ID的文档");
            }
            if (e.status() == RestStatus.BAD_REQUEST) {
                //throw new GsApiException("该文档与Mapping结构不符");
            }
            //throw new GsApiException(e.getDetailedMessage());
        }
    }

    /***
     *功能描述: 创建文档
     * @author wangyang
     * @param [indexName, documentId, source]
     * @return void
     */
    public static void createDocument(String indexName, String documentId, String jsonData) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName)
                .id(documentId)
                .source(jsonData, XContentType.JSON)
                .opType(DocWriteRequest.OpType.CREATE);
        try {
            ESClientConfig.getEsClient().index(indexRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("已经存在具有相同索引和ID的文档");
            }
        }
    }

    /***
     *功能描述: 获取文档
     * @author wangyang
     * @param [indexName, documentId]
     * @return java.lang.String
     */
    public static String getDocument(String indexName, String documentId) throws IOException {
        GetRequest getRequest = new GetRequest(indexName, documentId);
        try {
            GetResponse getResponse = ESClientConfig.getEsClient().get(getRequest, RequestOptions.DEFAULT);
            if (getResponse.isExists()) {
                return getResponse.getSourceAsString();
            }
            //throw new GsApiException("文档不存在");
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {
                //throw new GsApiException("索引不存在404引发的异常");
            }
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
        return null;
    }

    /***
     *功能描述: 判断文档是否存在
     * @author wangyang
     * @param [indexName, documentId]
     * @return boolean
     */
    public static boolean documentExists(String indexName, String documentId) throws IOException {
        GetRequest getRequest = new GetRequest(indexName, documentId);
        getRequest.fetchSourceContext(new FetchSourceContext(false));   //禁用_获取source
        getRequest.storedFields("_ none_"); //禁用_获取字段
        return ESClientConfig.getEsClient().exists(getRequest, RequestOptions.DEFAULT);
    }

    /***
     *功能描述: 删除文档
     * @author wangyang
     * @param [indexName, documentId]
     * @return void
     */
    public static void deleteDocumentById(String indexName, String documentId) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, documentId);
        deleteRequest.timeout(TimeValue.timeValueMinutes(2));
        deleteRequest.timeout("2m");
        DeleteResponse deleteResponse = null;
        try {
            deleteResponse = ESClientConfig.getEsClient().delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
        if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
            //throw new GsApiException("要删除的文档不存在");
        }
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {    //处理成功分片数量少于总分片数量的情况
            //TODO
        }
        if (shardInfo.getFailed() > 0) {    // 其他可能故障
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
                //TODO
            }
        }
    }

    /***
     *功能描述: 更新文档
     * @author wangyang
     * @param [indexName, documentId, jsonString]
     * @return void
     */
    public static void updateDocument(String indexName, String documentId, Object obj) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, documentId);
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        request.retryOnConflict(3); //重试次数
        //request.docAsUpsert(true);  //若文档不存在 用作upsert文档
        //request.fetchSource(true);  //是否开启源检索 _若开启，处理响应中不存在文档源的情况
        request.doc(JSON.toJSONString(obj), XContentType.JSON);
        try {
            UpdateResponse updateResponse = ESClientConfig.getEsClient().update(
                    request, RequestOptions.DEFAULT);
            ReplicationResponse.ShardInfo shardInfo = updateResponse.getShardInfo();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {    //处理成功分片数量少于总分片数量的情况
                //TODO
            }
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure : // 其他可能故障
                        shardInfo.getFailures()) {
                    String reason = failure.reason();
                    //TODO
                }
            }
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {
                //log.error("文档不存在");
            }
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
    }

    public static void updateDocument(String indexName, String documentId, Map<String, Object> jsonMap) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, documentId);
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        request.retryOnConflict(3);
        request.doc(jsonMap);
        try {
            UpdateResponse updateResponse = ESClientConfig.getEsClient().update(
                    request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {
                //log.error("文档不存在");
            }
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
    }

    public static void updateDocument(String indexName, String documentId, XContentBuilder xContentBuilder) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, documentId);
        request.timeout(TimeValue.timeValueSeconds(1));
        request.retryOnConflict(3);
        request.timeout("1s");
        request.doc(xContentBuilder);
        try {
            UpdateResponse updateResponse = ESClientConfig.getEsClient().update(
                    request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {

            }
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
    }

    public static void updateDocument(String indexName, String documentId, String field, String value) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, documentId);
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        request.retryOnConflict(3);
        request.doc(field, value);
        try {
            UpdateResponse updateResponse = ESClientConfig.getEsClient().update(
                    request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.NOT_FOUND) {
                //log.error("文档不存在");
            }
            if (e.status() == RestStatus.CONFLICT) {
                //throw new GsApiException("文档具有不同的版本号,版本冲突");
            }
        }
    }

    /***
     *功能描述:
     * @author wangyang
     * @param [indexName]
     * @return void
     */
    public static void flush(String indexName) throws IOException {
        FlushRequest requestMultiple = new FlushRequest(indexName);
        requestMultiple.indicesOptions(IndicesOptions.lenientExpandOpen());
        requestMultiple.waitIfOngoing(true);
        requestMultiple.force(true);
        try {
            ESClientConfig.getEsClient().indices().flush(requestMultiple, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                //throw new GsApiException("索引不存在");
            }
        }
    }

    /***
     *功能描述: 内存到磁盘
     * @author wangyang
     * @param []
     * @return void
     */
    public void flushAll() throws IOException {
        try {
            FlushRequest requestAll = new FlushRequest();
            requestAll.indicesOptions(IndicesOptions.lenientExpandOpen());
            requestAll.waitIfOngoing(true);
            requestAll.force(true);
            ESClientConfig.getEsClient().indices().flush(requestAll, RequestOptions.DEFAULT);
        } catch (ElasticsearchException exception) {
            if (exception.status() == RestStatus.NOT_FOUND) {
                //log.error("", exception);
                //log.error("刷新失败");
            }
        }
    }

//    public void buildXContent(Map<String, Object> dataMap){
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.timeField("updated", new Date());
//            builder.field("reason", "daily update");
//        }
//        builder.endObject();
//    }


}
