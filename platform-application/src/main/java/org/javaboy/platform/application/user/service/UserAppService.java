package org.javaboy.platform.application.user.service;

import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.javaboy.platform.domain.user.builder.UserBuilder;
import org.javaboy.platform.domain.user.model.entity.User;
import org.javaboy.platform.domain.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author:majin.wj
 */
@Component
public class UserAppService {


    @Autowired
    private UserRepository userRepository;

    public Boolean createUser(UserCreateRequest request) {
        Assert.isNull(request.getAvatar(),"头像缺失");
        Assert.isNull(request.getUsername(),"用户名缺失");
        Assert.isNull(request.getPassword(),"密码缺失");
        User user = UserBuilder.toUSer(request);
        userRepository.createUser(user);
        return true;
    }

}
