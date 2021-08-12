package com.mobilsiparis.hibernateclasses;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HP
 * Date: 16.12.2012
 * Time: 09:52
 * To change this template use File | Settings | File Templates.
 */
public interface Operations {
    public void save(Object object) throws Exception;

    public void update(Object object) throws Exception;

    public void saveOrUpdate(Object object) throws Exception;

    public boolean delete(Object object) throws Exception;

    public List allValues() throws Exception;

}
