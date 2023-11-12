package org.javaboy.platform.domain.user.service;

import org.javaboy.platform.client.request.user.UserCreateRequest;

/**
 * @author:majin.wj
 */
public interface UserService {
    void createUser(UserCreateRequest request);
}
