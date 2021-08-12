package com.mobilsiparis.hibernateclasses.urun;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
public interface UrunDao extends Operations {
    public List findByKategoriId(Integer katId);
    public Object findById(Integer id);
}
