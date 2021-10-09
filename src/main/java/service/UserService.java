package service;

import domain.LoginItem;
import domain.User;

import java.util.List;

public interface UserService {
    List<User> findUser();
    public int addUsers(User user);
    public User login(User user);
    // 返回true说明用户名存在，返回false说明用户名不存在
    public boolean existsUsername(String name);

    User login(String username, String password);

    User getpassword(String username,String email);

    LoginItem showLoginItem(String username);

    void update(LoginItem loginItem);
}
