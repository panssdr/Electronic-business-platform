package service.impl;

import dao.UserMapper;
import domain.LoginItem;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findUser() {
       return  userMapper.selectUser();
    }

    @Override
    public int addUsers(User user) {
          return   userMapper.addUsers(user);
    }

    @Override
    public User login(User user) {
        return userMapper.findUserByUnameAndUpwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
        if(userMapper.queryUserByUsername(name)==null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public User login(String username, String password) {
        return userMapper.findUserByUnameAndUpwd(username,password);
    }

    @Override
    public User getpassword(String username, String email) {
        return userMapper.getpassword(username,email);
    }

    @Override
    public LoginItem showLoginItem(String username) {
        return userMapper.showLoginItem(username);
    }

    @Override
    public void update(LoginItem loginItem) {
        userMapper.update(loginItem);
    }
}
