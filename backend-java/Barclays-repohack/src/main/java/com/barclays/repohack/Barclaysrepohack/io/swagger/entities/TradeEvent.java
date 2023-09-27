package com.barclays.repohack.Barclaysrepohack.io.swagger.entities;


import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TradeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trade tradeId;

    @CreationTimestamp
    private Date timestamp;

    @Size(max = 200)
    private String event;

    @Column(columnDefinition="TEXT")
    @Lob
    private String before;

    @Column(columnDefinition="TEXT")
    @Lob
    private String after;

    private String participant;

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trade getTradeId() {
        return tradeId;
    }

    public void setTradeId(Trade tradeId) {
        this.tradeId = tradeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
