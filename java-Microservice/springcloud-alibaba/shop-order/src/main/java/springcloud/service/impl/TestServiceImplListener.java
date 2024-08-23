//package springcloud.service.impl;
//
//import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Service;
//import springcloud.dao.TxLogDao;
//import springcloud.entity.Order;
//import springcloud.entity.TxLog;
//
//@Service
////@RocketMQTransactionListener(txProducerGroup = "tx_producer_group")
//public class TestServiceImplListener implements RocketMQLocalTransactionListener {
//
//    @Autowired
//    private TestServiceImpl testService;
//
//
//    @Autowired
//    private TxLogDao txLogDao;
//
//    //执行本地事物
//    @Override
//    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
//
//        String txId = (String) msg.getHeaders().get("txId");
//
//        try {
//            //本地事物
//            Order order = (Order) arg;
//            testService.createOrder(txId,order);
//
//            return RocketMQLocalTransactionState.COMMIT;
//        } catch (Exception e) {
//            return RocketMQLocalTransactionState.ROLLBACK;
//        }
//    }
//
//    //消息回查
//    @Override
//    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
//        String txId = (String) msg.getHeaders().get("txId");
//        TxLog txLog = txLogDao.findById(txId).get();
//
//        if (txLog != null){
//            //本地事物(订单)成功了
//            return RocketMQLocalTransactionState.COMMIT;
//        }else {
//            return RocketMQLocalTransactionState.ROLLBACK;
//        }
//    }
//}