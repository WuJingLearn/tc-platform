package org.javaboy.platform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author:majin.wj
 */
@RestController("/test")
public class ControllerTest {

    @PostConstruct
    public void init(){
        System.out.println("controller test 1");
    }
    @GetMapping("/get")
    public String test2(){
        return "zs";
    }


    @GetMapping("/")
    public String test3(){
        return "zs";
    }

}
