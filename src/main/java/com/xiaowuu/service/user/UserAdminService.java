package com.xiaowuu.service.user;

import com.xiaowuu.entity.user.UserAdmin;

public interface UserAdminService {

    /**
     * 管理员登陆 更新登陆时间  和  登陆ip
     * @param userAdmin
     * @return
     */
    int updateByLogin(UserAdmin userAdmin);

    /**
     * 管理员登陆判断  用户名 和 密码
     * @param userName
     * @param password
     * @return
     */
    UserAdmin findUserByNameAndPsw(String userName, String password);
}
