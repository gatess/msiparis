package com.mobilsiparis.hibernateclasses.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by ishak on 10.07.2014.
 */
@Component
public class UserBoImp implements UserBo {
    @Autowired
    private UserDao userDao;


    @Override
    public void save(Object object) throws Exception {
        userDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        userDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        userDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        userDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {

        return userDao.allValues();

    }

    @Override
    public Object findByPassword(String password) {
        return userDao.findByPassword(password);
    }
}
