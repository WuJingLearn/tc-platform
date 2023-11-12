package org.javaboy.platform.domain.user.service;

import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.javaboy.platform.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:majin.wj
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(UserCreateRequest request) {
        userRepository.createUser(request);
    }
}
