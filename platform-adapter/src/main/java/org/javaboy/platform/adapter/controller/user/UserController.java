package org.javaboy.platform.adapter.controller.user;

import org.javaboy.common.utils.Result;
import org.javaboy.platform.application.user.service.UserAppService;
import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author:majin.wj
 */
@RestController("/user")
public class UserController {

    /*   @PostConstruct
       public void init(){
           System.out.println("UserController start");
           UserCreateRequest request = new UserCreateRequest();
           request.setAvatar("");
           request.setUsername("ww");
           request.setPassword("zs");
           Result<Boolean> user = createUser(request);
           System.out.println("创建用户:"+user.getData());
       }
   */
    @Autowired
    private UserAppService userAppService;

    @PostMapping("/create")
    public Result<Boolean> createUser(@RequestBody UserCreateRequest request) {
        return Result.success(userAppService.createUser(request));
    }


    @GetMapping("/query")
    public Result<String> queryUser(String keyword, long currentPage, long pageSize) {
        return Result.success("success");
    }

}
