package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class Test1 {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @org.junit.Test
    public void test2(){

        System.out.println(userService.findUser());
    }
}


