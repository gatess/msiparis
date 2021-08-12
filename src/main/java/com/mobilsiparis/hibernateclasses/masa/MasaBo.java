package com.mobilsiparis.hibernateclasses.masa;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public interface MasaBo extends Operations {
        public Masa findMasa(int masaNo);
        public List bosMasalar();
}
