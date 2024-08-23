//package springcloud.service.impl;
//
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import springcloud.dao.OrderDao;
//import springcloud.dao.TxLogDao;
//import springcloud.entity.Order;
//import springcloud.entity.TxLog;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Service
//public class TestServiceImpl {
//
//    @Autowired
//    private OrderDao orderDao;
//
//    @Autowired
//    private TxLogDao txLogDao;
//
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//
//    public void createOrderBefore(Order order) {
//
//        String txId = UUID.randomUUID().toString();
//
//        //发送半事务消息
//        rocketMQTemplate.sendMessageInTransaction(
//                "tx_producer_group",
//                "tx_topic",
//                MessageBuilder.withPayload(order).setHeader("txId", txId).build(),
//                order
//        );
//    }
//
//    //创建订单
//    @Transactional
//    public void createOrder(String txId, Order order) {
//        //保存订单
//        orderDao.save(order);
//
//        TxLog txLog = new TxLog();
//        txLog.setTxId(txId);
//        txLog.setDate(new Date());
//
//        //记录事物日志
//        txLogDao.save(txLog);
//    }
//
//
//}
