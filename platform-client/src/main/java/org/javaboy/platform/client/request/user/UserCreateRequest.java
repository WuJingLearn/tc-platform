package org.javaboy.platform.client.request.user;

import lombok.Data;

/**
 * @author:majin.wj 创建用户请求
 */
@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String avatar;
}
