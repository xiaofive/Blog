package com.sxjf.blog.web.es.Entity.sales;


/**
 * @Author wangyang
 * @description es_so_order
 * @Date 2019/12/13
 */
public class EsSalesOrderHeader {

    String invoiceCxRefId;  // 开票客户
    String recvCxRefId;  // 收货客户
    String balaTypeRefId;  // 结算方式

    String cxBillRefId;  // 客户订单号
    String incomeTerm;  // 收款协议

    public String getInvoiceCxRefId() {
        return invoiceCxRefId;
    }

    public void setInvoiceCxRefId(String invoiceCxRefId) {
        this.invoiceCxRefId = invoiceCxRefId;
    }

    public String getRecvCxRefId() {
        return recvCxRefId;
    }

    public void setRecvCxRefId(String recvCxRefId) {
        this.recvCxRefId = recvCxRefId;
    }

    public String getBalaTypeRefId() {
        return balaTypeRefId;
    }

    public void setBalaTypeRefId(String balaTypeRefId) {
        this.balaTypeRefId = balaTypeRefId;
    }

    public String getCxBillRefId() {
        return cxBillRefId;
    }

    public void setCxBillRefId(String cxBillRefId) {
        this.cxBillRefId = cxBillRefId;
    }

    public String getIncomeTerm() {
        return incomeTerm;
    }

    public void setIncomeTerm(String incomeTerm) {
        this.incomeTerm = incomeTerm;
    }

}
