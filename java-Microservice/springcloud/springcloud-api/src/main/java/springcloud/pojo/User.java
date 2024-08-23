package springcloud.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

//所有实体类务必都序列化，否则传输通信会出错
//序列化就是为了防止用户访问量过多 服务器内存多度消耗
//序列化是把对象转换成字节数组可以传输和持久化
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String people;
    private String phone;
    private String role;

}
