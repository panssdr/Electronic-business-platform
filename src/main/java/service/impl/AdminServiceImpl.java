package service.impl;


import dao.AdminMapper;
import domain.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin login(Admin admin) {
        return adminMapper.findAdminByNameAndPwd(admin.getAdminName(),admin.getAdminPwd());
    }

    @Override
    public void update(String adminName, String newpassword) {
        adminMapper.update(adminName,newpassword);
    }
}
