package com.mobilsiparis.hibernateclasses.ozeldurum;

import com.mobilsiparis.hibernateclasses.Operations;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 13.12.2013
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public interface OzelDurumBo extends Operations {
   public List findByUrunId(Integer urunId);
    public Object findById(Integer id);
    public Boolean ozelDurumKontrol(Integer urunId);
}
