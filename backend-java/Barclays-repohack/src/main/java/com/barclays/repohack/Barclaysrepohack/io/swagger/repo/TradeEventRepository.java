package com.barclays.repohack.Barclaysrepohack.io.swagger.repo;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.TradeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeEventRepository extends JpaRepository<TradeEvent, Long> {

    List<TradeEvent> findByTradeId(Long tradeId);

}
