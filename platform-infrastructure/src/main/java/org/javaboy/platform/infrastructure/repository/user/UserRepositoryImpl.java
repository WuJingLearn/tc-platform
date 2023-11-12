package org.javaboy.platform.infrastructure.repository.user;

import org.javaboy.platform.client.request.user.UserCreateRequest;
import org.javaboy.platform.domain.user.repository.UserRepository;
import org.javaboy.platform.infrastructure.dao.user.UserMapper;
import org.javaboy.platform.infrastructure.dataobject.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private  UserMapper userMapper;

    @Override
    public void createUser(UserCreateRequest request) {
        UserDO userDO = new UserDO();
        userDO.setUsername(request.getUsername());
        userDO.setPassword(request.getPassword());
        userDO.setAvatar(request.getAvatar());
        userDO.setIsDeleted("n");
        userDO.setGmtCreate(new Date());
        userDO.setGmtModified(new Date());
        userMapper.insert(userDO);

    }
}
