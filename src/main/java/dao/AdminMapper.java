package dao;

import domain.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin findAdminByNameAndPwd(@Param("adminName") String adminName, @Param("adminPwd") String adminPwd);

    void update(@Param("adminName") String adminName, @Param("newpassword") String newpassword);
}
