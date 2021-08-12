package com.mobilsiparis.hibernateclasses.kategori;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 09.12.2013
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public interface KategoriBo extends Operations {

        public Kategori findById(Integer Id);
}
