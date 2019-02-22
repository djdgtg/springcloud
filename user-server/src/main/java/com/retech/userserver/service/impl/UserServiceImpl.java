package com.retech.userserver.service.impl;

import com.retech.common.entity.User;
import com.retech.common.entity.UserExample;
import com.retech.common.mapper.UserMapper;
import com.retech.common.utils.ActionResult;
import com.retech.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinc
 * @date 2019/2/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ActionResult getUserById(Integer id) {
        return ActionResult.ok(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public ActionResult getUserList() {
        return ActionResult.ok(userMapper.selectByExample(new UserExample()));
    }

    @Override
    public ActionResult add(User user) {
        int count = userMapper.insert(user);
        if(count>0){
            return ActionResult.ok();
        }
        return ActionResult.build(-1,"添加用户失败！");
    }

    @Override
    public ActionResult update(Integer id, User user) {
        int count = userMapper.updateByPrimaryKey(user);
        if(count>0){
            return ActionResult.ok();
        }
        return ActionResult.build(-1,"更新用户失败！");
    }

    @Override
    public ActionResult deleteById(Integer id) {
        int count = userMapper.deleteByPrimaryKey(id);
        if(count>0){
            return ActionResult.ok();
        }
        return ActionResult.build(-1,"添加用户失败！");
    }
}
