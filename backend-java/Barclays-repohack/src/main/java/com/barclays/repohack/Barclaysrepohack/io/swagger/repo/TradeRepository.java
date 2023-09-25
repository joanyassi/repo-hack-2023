package com.barclays.repohack.Barclaysrepohack.io.swagger.repo;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    Trade findByTradeIdEquals(String name);
}
