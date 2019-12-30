package com.curriculumnetwork.page.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.curriculumnetwork.page.service.ItemPageService;

import java.util.logging.Logger;


/**
 * 网页删除监听器
 * @author:zhangyu
 */

@Component
public class PageDeleteListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(PageDeleteListener.class);

    @Autowired
    private ItemPageService itemPageService;

    @Override
    public void onMessage(Message message) {

        ObjectMessage objectMessage = (ObjectMessage) message;
        try {
            Long[] goodsIds = (Long[]) objectMessage.getObject();
            logger.info("接收到消息:" + goodsIds);
            boolean b = itemPageService.deleteItemHtml(goodsIds);
            logger.info("删除网页：" + b);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
