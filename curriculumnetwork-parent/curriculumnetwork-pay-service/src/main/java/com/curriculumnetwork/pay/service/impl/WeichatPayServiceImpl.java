package com.curriculumnetwork.pay.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.WXPayUtil;
import com.curriculumnetwork.pay.service.WeixinPayService;

import util.HttpClient;

/**
 * 微信支付接口实现
 *
 * @author: zhangyu
 */
@Service
public class WeichatPayServiceImpl implements WeixinPayService {
    private static Logger logger = LoggerFactory.getLogger(DefaultBinSuggestionAlgorithm.class);

    @Value("${appid}")
    private String appid;

    @Value("${partner}")
    private String partner;

    @Value("${partnerkey}")
    private String partnerkey;

    /**
     * 本地交易
     *
     * @param out_trade_no 外部交易码
     * @param total_fee    总共费用
     * @return 参数map
     */
    @Override
    public Map createNative(String out_trade_no, String total_fee) {
        // 1.参数封装
        Map param = new HashMap();
        param.put("appid", appid);// 公众账号ID
        param.put("mch_id", partner);// 商户
        param.put("nonce_str", WXPayUtil.generateNonceStr());// 随机字符串
        param.put("body", "curriculumnetwork");
        param.put("out_trade_no", out_trade_no);// 交易订单号
        param.put("total_fee", total_fee);// 金额（分）
        param.put("spbill_create_ip", "127.0.0.1");
        param.put("trade_type", "NATIVE");// 交易类型

        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            System.out.println("请求的参数：" + xmlParam);

            // 2.发送请求
            HttpClient httpClient = new HttpClient(
                    "https://api.mch.weixin.qq.com/pay/unifiedorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlParam);
            httpClient.post();

            // 3.获取结果
            String xmlResult = httpClient.getContent();

            Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);
            System.out.println("微信返回结果" + mapResult);
            Map map = new HashMap<>();
            map.put("code_url", mapResult.get("code_url"));// 生成支付二维码的链接
            map.put("out_trade_no", out_trade_no);
            map.put("total_fee", total_fee);

            return map;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new HashMap();
        }
    }

    /**
     * 请求支付状态
     *
     * @param out_trade_no 外部交易码
     * @return 参数map
     */
    @Override
    public Map queryPayStatus(String out_trade_no) {
        // 1.封装参数
        Map param = new HashMap();
        param.put("appid", appid);
        param.put("mch_id", partner);
        param.put("out_trade_no", out_trade_no);
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            // 2.发送请求
            HttpClient httpClient = new HttpClient(
                    "https://api.mch.weixin.qq.com/pay/orderquery");
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlParam);
            httpClient.post();

            // 3.获取结果
            String xmlResult = httpClient.getContent();
            Map<String, String> map = WXPayUtil.xmlToMap(xmlResult);
            System.out.println("调动查询API返回结果：" + xmlResult);

            return map;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.info(e.getMessage());
            return new HashMap();
        }
    }

    /**
     * 关闭交易
     *
     * @param out_trade_no 外部交易码
     * @return 参数map
     */
    @Override
    public Map closePay(String out_trade_no) {
        // 1.封装参数
        Map param = new HashMap();
        param.put("appid", appid);
        param.put("mch_id", partner);
        param.put("out_trade_no", out_trade_no);
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            // 2.发送请求
            HttpClient httpClient = new HttpClient(
                    "https://api.mch.weixin.qq.com/pay/closeorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlParam);
            httpClient.post();

            // 3.获取结果
            String xmlResult = httpClient.getContent();
            Map<String, String> map = WXPayUtil.xmlToMap(xmlResult);
            System.out.println("调动查询API返回结果：" + xmlResult);

            return map;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new HashMap();
        }
    }
}
