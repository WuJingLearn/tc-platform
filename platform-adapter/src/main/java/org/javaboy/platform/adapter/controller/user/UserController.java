package org.javaboy.platform.adapter.controller.user;

import org.javaboy.common.utils.PlatformResult;
import org.javaboy.platform.application.user.service.UserAppService;
import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:majin.wj
 */
@RequestMapping("/user")
@RestController
public class UserController {

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
