package org.javaboy.platform.adapter.controller.user;

import org.javaboy.common.utils.PlatformResult;
import org.javaboy.platform.application.user.service.UserAppService;
import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public PlatformResult<String> test(){
        return PlatformResult.success("zs");
    }

    @PostMapping("/create")
    public PlatformResult<Boolean> createUser(@RequestBody UserCreateRequest request) {
        return PlatformResult.success(userAppService.createUser(request));
    }


    @GetMapping("/query")
    public PlatformResult<String> queryUser(String keyword, long currentPage, long pageSize) {
        return PlatformResult.success("success");
    }

}
