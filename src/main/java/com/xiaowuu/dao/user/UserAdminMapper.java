package com.xiaowuu.dao.user;

import com.xiaowuu.entity.user.UserAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserAdminMapper {


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
    UserAdmin findUserByNameAndPsw(@Param("userName") String userName, @Param("password") String password);
}
