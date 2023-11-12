package org.javaboy.platform.infrastructure.dataobject.user;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
@TableName("user")
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private Date gmtCreate;
    private Date gmtModified;
    private String isDeleted;
}
