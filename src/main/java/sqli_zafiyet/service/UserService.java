package sqli_zafiyet.service;

import sqli_zafiyet.entity.User;
import sqli_zafiyet.repository.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public boolean getByNameAndPassword(String userName, String password){
        return userDao.getByNameAndPassword(userName, password);
    }

}
