package org.javaboy.platform.domain.user.builder;

import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.javaboy.platform.domain.user.model.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * @author:majin.wj
 */
public class UserBuilder {

    public static User toUSer(UserCreateRequest request) {
        if (request == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }


}
