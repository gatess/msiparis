package com.mobilsiparis.hibernateclasses.kategori;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 09.12.2013
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public interface KategoriDao extends Operations{

    public Kategori findById(Integer id);
}
