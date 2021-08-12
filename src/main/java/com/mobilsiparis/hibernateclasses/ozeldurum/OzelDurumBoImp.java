package com.mobilsiparis.hibernateclasses.ozeldurum;

import com.mobilsiparis.hibernateclasses.kategori.KategoriDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OzelDurumBoImp implements OzelDurumBo{

    @Autowired
    OzelDurumDao ozelDurumDao;

    @Override
    public void save(Object object) throws Exception {
        ozelDurumDao.save(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object object) throws Exception {
        ozelDurumDao.update(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdate(Object object) throws Exception {

        ozelDurumDao.saveOrUpdate(object);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean delete(Object object) throws Exception {
        ozelDurumDao.delete(object);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List allValues() throws Exception {
        ozelDurumDao.allValues();
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findByUrunId(Integer urunId) {
        return ozelDurumDao.findByUrunId(urunId);
    }

    @Override
    public Object findById(Integer id) {
       return ozelDurumDao.findById(id);
    }

    @Override
    public Boolean ozelDurumKontrol(Integer urunId) {
      return ozelDurumDao.ozelDurumKontrol(urunId);
    }
}
