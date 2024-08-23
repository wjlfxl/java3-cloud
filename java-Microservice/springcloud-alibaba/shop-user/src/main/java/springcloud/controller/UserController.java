package springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.dta.UserDto;

//@RestController
//@RequestMapping("users")
//public class UserController {
//    @Autowired
//    UserService userService;
//    @GetMapping("/{id}")
//    public UserDto getUserById(@PathVariable("id") int userId){
//        return userService.getUserById(userId);
//    }
//    @GetMapping("/login")
//    public UserDto login(UserDto user){
//        return userService.login(user);
//    }
//}
