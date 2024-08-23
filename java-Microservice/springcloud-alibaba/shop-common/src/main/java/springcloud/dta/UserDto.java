package springcloud.dta;

import lombok.Data;

@Data
public class UserDto {
    private Integer uid;//主键
    private String username;//用户名
    private String password;//密码
    private String telephone;//手机号
    private String token;
}
