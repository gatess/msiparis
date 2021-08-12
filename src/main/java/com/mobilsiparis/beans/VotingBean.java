package com.mobilsiparis.beans;

import com.mobilsiparis.helper.Vote;
import com.mobilsiparis.hibernateclasses.hesap.Hesap;
import com.mobilsiparis.hibernateclasses.hesap.HesapBo;
import com.mobilsiparis.hibernateclasses.hesapistek.HesapIstek;
import com.mobilsiparis.hibernateclasses.hesapistek.HesapIstekBo;
import com.mobilsiparis.hibernateclasses.productvotes.ProductVotes;
import com.mobilsiparis.hibernateclasses.productvotes.ProductVotesBo;
import com.mobilsiparis.hibernateclasses.siparis.Siparis;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrun;
import com.mobilsiparis.hibernateclasses.siparisurun.SiparisUrunBo;
import com.mobilsiparis.hibernateclasses.urun.Urun;
import com.mobilsiparis.hibernateclasses.urun.UrunBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "votingbean")
@Scope(value = "session")
public class VotingBean {

    Boolean control = true;
    private List<SiparisUrun> takenOrders = new ArrayList<SiparisUrun>();
    private List<ProductVotes> ordersToVote= new ArrayList<ProductVotes>();
    private List<Urun> products = new ArrayList<Urun>();
    private List<Vote> names= new ArrayList<Vote>();

    @Autowired
    Urun urun;

    @Autowired
    HesapIstek hesapIstek;

    @Autowired
    HesapIstekBo hesapIstekBo;

    @Autowired
    MasaBean masaBean;

    @Autowired
    Hesap hesap;

    @Autowired
    HesapBo hesapBo;
    @Autowired
    SiparisUrunBo siparisUrunBo;

    @Autowired
    SiparisBean siparisBean;

    @Autowired
    Siparis siparis;

    @Autowired
    ProductVotes productVotes;

    @Autowired
    ProductVotesBo productVotesBo;

    @Autowired
    UrunBo urunBo;


    @PostConstruct
    public void afterConstruct(){

        if(control){

            siparis=siparisBean.getSiparis();

            takenOrders= siparisUrunBo.findBySiparisId(siparis.getSiparisId());

            for (int i=0;i<takenOrders.size();i++){
                urun=(Urun)urunBo.findById(takenOrders.get(i).getUrunId());
                products.add(urun);
                names.add(new Vote(urun.getAdi()));
                productVotes.setUrunId(urun.getUrunId());
                ordersToVote.add(productVotes);
            }
            control=false;

        }
       /* for(int i=0;i<takenOrders.size();i++){

          productVotes.setUrunId(takenOrders.get(i).getUrunId());
          productVotes.setUrun((Urun)urunBo.findById(productVotes.getUrunId()));
          ordersToVote.add(productVotes);

        }*/

    }
    public void doVotingWithDialog(ActionEvent event){

        if(control){
        siparis=siparisBean.getSiparis();

        takenOrders= siparisUrunBo.findBySiparisId(siparis.getSiparisId());

        for (int i=0;i<takenOrders.size();i++){
            urun=(Urun)urunBo.findById(takenOrders.get(i).getUrunId());
            products.add(urun);
            names.add(new Vote(urun.getAdi()));
            productVotes.setUrunId(urun.getUrunId());
            ordersToVote.add(productVotes);
        }
        }
        control=false;
    }

    public void doVoting(ActionEvent event)throws Exception{

               for(int i=0;i<ordersToVote.size();i++){

                   ordersToVote.get(i).setVote(names.get(i).getVote());
                   productVotesBo.save(ordersToVote.get(i));
               }
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        try {    Integer id = (Integer)hesapIstekBo.findMaxId();
            Date date = new Date();
            int hesapId=masaBean.getHesap().getHesapId();
            if(id!=null)
                hesapIstek.setHesapIstekId(id+1);
            else
                hesapIstek.setHesapIstekId(1);
            hesapIstek.setHesapId(hesapId);
            hesapIstek.setTarih(date);
            hesapIstekBo.save(hesapIstek);
        }
        catch (Exception e){

            e.printStackTrace();

        }
    }


    public List<SiparisUrun> getTakenOrders() {
        return takenOrders;
    }

    public void setTakenOrders(List<SiparisUrun> takenOrders) {
        this.takenOrders = takenOrders;
    }

    public List<ProductVotes> getOrdersToVote() {
        return ordersToVote;
    }

    public void setOrdersToVote(List<ProductVotes> ordersToVote) {
        this.ordersToVote = ordersToVote;
    }

    public ProductVotes getProductVotes() {
        return productVotes;
    }

    public void setProductVotes(ProductVotes productVotes) {
        this.productVotes = productVotes;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public List<Urun> getProducts() {
        return products;
    }

    public void setProducts(List<Urun> products) {
        this.products = products;
    }

    public List<Vote> getNames() {
        return names;
    }

    public void setNames(List<Vote> names) {
        this.names = names;
    }

    public Boolean getControl() {
        return control;
    }

    public void setControl(Boolean control) {
        this.control = control;
    }
}
