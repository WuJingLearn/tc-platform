package org.javaboy.platform.application.user.service;

import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.javaboy.platform.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 */
@Component
public class UserAppService {


    @Autowired
    private UserRepository userRepository;

    public Boolean createUser(UserCreateRequest request) {
        userRepository.createUser(request);
        return true;
    }

}
