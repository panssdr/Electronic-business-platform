package service;

import domain.Admin;

public interface    AdminService {
    Admin login(Admin admin);

    void update(String adminName, String newpassword);
}
