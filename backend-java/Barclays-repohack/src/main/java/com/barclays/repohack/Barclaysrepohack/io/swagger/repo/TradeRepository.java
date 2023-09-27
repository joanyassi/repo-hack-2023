package com.barclays.repohack.Barclaysrepohack.io.swagger.repo;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    Trade findByTradeIdEquals(String name);
    @Query(value = "SELECT * FROM TRADE t WHERE t.buyer =:loggedInUser or t.seller =:loggedInUser", nativeQuery = true)
    List<Trade> getTradesforLoggedInUser(@Param("loggedInUser") String loggedInUser);
}
