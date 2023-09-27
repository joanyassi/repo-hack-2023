package com.barclays.repohack.Barclaysrepohack.io.swagger.entities;

import javax.annotation.Nullable;
import javax.persistence.*;

@Entity

public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String tradeId;

    private String buyer;

    private String seller;

    public Trade(){}
    public Trade(String tradeId, String buyer, String seller){
        this.tradeId = tradeId;
        this.buyer = buyer;
        this.seller = seller;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
