package com.retech.userserver.service;

import com.retech.common.entity.User;
import com.retech.common.utils.ActionResult;

public interface UserService {
    ActionResult getUserById(Integer id);

    ActionResult getUserList();

    ActionResult add(User user);

    ActionResult update(Integer id, User user);

    ActionResult deleteById(Integer id);
}
