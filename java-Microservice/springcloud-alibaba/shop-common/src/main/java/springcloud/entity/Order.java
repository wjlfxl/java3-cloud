package springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//订单
@Entity(name = "shop_order") //实体类对应数据表的关系，name是表名
@Data  //不写set、get方法
@AllArgsConstructor  //有参
@NoArgsConstructor   //无参
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Long oid;//订单id
    //用户
    private Integer uid;//用户id
    private String username;//用户名
    //商品
    private Integer pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价
    //数量
    private Integer number;//购买数量
}