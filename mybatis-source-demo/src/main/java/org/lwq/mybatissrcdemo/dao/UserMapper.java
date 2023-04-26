package org.lwq.mybatissrcdemo.dao;

import org.lwq.mybatissrcdemo.entity.User;

public interface UserMapper {

    User queryUserInfoById(Long id);
}
