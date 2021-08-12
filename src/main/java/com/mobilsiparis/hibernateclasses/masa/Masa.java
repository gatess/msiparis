package com.mobilsiparis.hibernateclasses.masa;

import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 15.12.2013
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@Component
@Entity
@Table(name="masa")
public class Masa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer masaNo;

    public Integer getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(Integer masaNo) {
        this.masaNo = masaNo;
    }

    @Column(name="isfull",columnDefinition = "bit(1) default 0")
    private boolean isfull;

    public boolean isIsfull() {
        return isfull;
    }

    public void setIsfull(boolean isfull) {
        this.isfull = isfull;
    }

}
