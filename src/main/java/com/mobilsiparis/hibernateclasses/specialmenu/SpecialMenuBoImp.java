package com.mobilsiparis.hibernateclasses.specialmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SpecialMenuBoImp implements SpecialMenuBo{


    @Autowired
    SpecialMenuDao specialMenuDao;

    @Override
    public void save(Object object) throws Exception {
        specialMenuDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
       specialMenuDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
        specialMenuDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        specialMenuDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
      return  specialMenuDao.allValues();
    }
}
