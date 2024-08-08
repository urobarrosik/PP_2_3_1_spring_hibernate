package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {return userDao.getUserById(id);}

    @Transactional
    @Override
    public void update(User user) {userDao.update(user);}

    @Transactional
    @Override
    public void delete(Long id) {userDao.delete(id);}

    @Transactional
    @Override
    public void addUserIfNotExist(User user) {userDao.addUserIfNotExist(user);}

}
