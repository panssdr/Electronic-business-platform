package dao;

import domain.LoginItem;
import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();
    public int  addUsers(User user);
    User findUserByUnameAndUpwd(@Param("username") String uname, @Param("password") String upwd);
    User queryUserByUsername(@Param("username") String name);

    User getpassword( @Param("username") String username, @Param("email") String email);

    LoginItem showLoginItem(@Param("username") String username);

    void update(LoginItem loginItem);
}
