package com.xiaowuu.service.user;

import com.xiaowuu.dao.user.UserAdminMapper;
import com.xiaowuu.entity.user.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userAdminService")
public class UserAdminServiceImpl implements UserAdminService{

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Override
    public int updateByLogin(UserAdmin userAdmin) {
        return userAdminMapper.updateByLogin(userAdmin);
    }

    @Override
    public UserAdmin findUserByNameAndPsw(String userName, String password) {
        return userAdminMapper.findUserByNameAndPsw(userName, password);
    }
}
