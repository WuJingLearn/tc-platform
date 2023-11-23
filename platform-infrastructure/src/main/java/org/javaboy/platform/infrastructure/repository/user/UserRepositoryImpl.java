package org.javaboy.platform.infrastructure.repository.user;

import org.javaboy.platform.domain.user.model.entity.User;
import org.javaboy.platform.domain.user.repository.UserRepository;
import org.javaboy.platform.infrastructure.dao.user.UserMapper;
import org.javaboy.platform.infrastructure.dataobject.user.UserDO;
import org.springframework.beans.BeanUtils;
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
    public int createUser(User user) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user,userDO);
        userDO.setIsDeleted("n");
        userDO.setGmtCreate(new Date());
        userDO.setGmtModified(new Date());
        return userMapper.insert(userDO);
    }
}
