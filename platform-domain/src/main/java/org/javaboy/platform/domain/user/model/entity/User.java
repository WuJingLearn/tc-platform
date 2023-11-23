package org.javaboy.platform.domain.user.model.entity;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String avatar;

}
