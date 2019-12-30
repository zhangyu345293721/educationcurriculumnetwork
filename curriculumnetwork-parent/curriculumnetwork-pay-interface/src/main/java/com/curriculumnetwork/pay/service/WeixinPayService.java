package com.curriculumnetwork.pay.service;

import java.util.Map;

/**
 * 微信支付服务
 *
 * @author : zhangyu
 */
public interface WeixinPayService {

    /**
     * 生成二维码
     *
     * @param out_trade_no 外部支付码
     * @param total_fee    总费用
     * @return
     */
    public Map createNative(String out_trade_no, String total_fee);

    /**
     * 查询支付订单状态
     *
     * @param out_trade_no 外部交易码
     * @return map
     */
    public Map queryPayStatus(String out_trade_no);


    /**
     * 关闭订单
     *
     * @param out_trade_no 外部交易码
     * @return map
     */
    public Map closePay(String out_trade_no);

}
