package com.mobilsiparis.hibernateclasses.productvotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ProductVotesBoImp implements ProductVotesBo {

    @Autowired
    ProductVotesDao productVotesDao;

    @Override
    public void save(Object object) throws Exception {
      productVotesDao.save(object);
    }

    @Override
    public void update(Object object) throws Exception {
        productVotesDao.update(object);
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {
      productVotesDao.saveOrUpdate(object);
    }

    @Override
    public boolean delete(Object object) throws Exception {
        productVotesDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {

        return productVotesDao.allValues();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
