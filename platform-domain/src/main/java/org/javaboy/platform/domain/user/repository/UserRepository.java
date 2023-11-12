package org.javaboy.platform.domain.user.repository;

import org.javaboy.platform.client.request.user.UserCreateRequest;

/**
 * @author:majin.wj
 */
public interface UserRepository {

    void createUser(UserCreateRequest request);

}
