package com.mobilsiparis.hibernateclasses.productvotes;

import com.mobilsiparis.hibernateclasses.urun.Urun;
import org.hibernate.annotations.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Gokhan
 * Date: 11.03.2014
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */

@Component
@Entity
@Table(name ="product_votes")
public class ProductVotes {

    private Integer voteId;
    private Integer urunId;
    private Integer vote;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "vote_id")
    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    @Column(name = "urun_id")

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    @Column(name = "vote")
    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

}
