package com.sxjf.blog.web.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Author wangyang
 * @description Elasticsearch Config
 * @Date 2019/12/9
 */
@Configuration
public class ESClientConfig {

    private static String HOST_NAME = "39.98.56.121";
    private static Integer PORT = 9200;
    private static String SCHEME = "http";

    private static RestHighLevelClient client;

    public static RestHighLevelClient getEsClient() {
        if (client == null) {
            client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(HOST_NAME, PORT, SCHEME)));
        }
        return client;
    }

    public static void close() throws IOException {
        client.close();
    }

}
