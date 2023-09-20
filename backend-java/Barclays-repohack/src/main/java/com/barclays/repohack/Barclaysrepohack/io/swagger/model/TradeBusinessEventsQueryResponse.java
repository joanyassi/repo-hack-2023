package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.BusinessEventData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TradeBusinessEventsQueryResponse
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class TradeBusinessEventsQueryResponse   {
  @JsonProperty("tradeMatchingService")
  @Valid
  private List<BusinessEventData> tradeMatchingService = null;

  @JsonProperty("tradeClearingService")
  @Valid
  private List<BusinessEventData> tradeClearingService = null;

  @JsonProperty("tradeSettlementService")
  @Valid
  private List<BusinessEventData> tradeSettlementService = null;

  public TradeBusinessEventsQueryResponse tradeMatchingService(List<BusinessEventData> tradeMatchingService) {
    this.tradeMatchingService = tradeMatchingService;
    return this;
  }

  public TradeBusinessEventsQueryResponse addTradeMatchingServiceItem(BusinessEventData tradeMatchingServiceItem) {
    if (this.tradeMatchingService == null) {
      this.tradeMatchingService = new ArrayList<BusinessEventData>();
    }
    this.tradeMatchingService.add(tradeMatchingServiceItem);
    return this;
  }

  /**
   * Get tradeMatchingService
   * @return tradeMatchingService
   **/
  @Schema(description = "")
      @Valid
    public List<BusinessEventData> getTradeMatchingService() {
    return tradeMatchingService;
  }

  public void setTradeMatchingService(List<BusinessEventData> tradeMatchingService) {
    this.tradeMatchingService = tradeMatchingService;
  }

  public TradeBusinessEventsQueryResponse tradeClearingService(List<BusinessEventData> tradeClearingService) {
    this.tradeClearingService = tradeClearingService;
    return this;
  }

  public TradeBusinessEventsQueryResponse addTradeClearingServiceItem(BusinessEventData tradeClearingServiceItem) {
    if (this.tradeClearingService == null) {
      this.tradeClearingService = new ArrayList<BusinessEventData>();
    }
    this.tradeClearingService.add(tradeClearingServiceItem);
    return this;
  }

  /**
   * Get tradeClearingService
   * @return tradeClearingService
   **/
  @Schema(description = "")
      @Valid
    public List<BusinessEventData> getTradeClearingService() {
    return tradeClearingService;
  }

  public void setTradeClearingService(List<BusinessEventData> tradeClearingService) {
    this.tradeClearingService = tradeClearingService;
  }

  public TradeBusinessEventsQueryResponse tradeSettlementService(List<BusinessEventData> tradeSettlementService) {
    this.tradeSettlementService = tradeSettlementService;
    return this;
  }

  public TradeBusinessEventsQueryResponse addTradeSettlementServiceItem(BusinessEventData tradeSettlementServiceItem) {
    if (this.tradeSettlementService == null) {
      this.tradeSettlementService = new ArrayList<BusinessEventData>();
    }
    this.tradeSettlementService.add(tradeSettlementServiceItem);
    return this;
  }

  /**
   * Get tradeSettlementService
   * @return tradeSettlementService
   **/
  @Schema(description = "")
      @Valid
    public List<BusinessEventData> getTradeSettlementService() {
    return tradeSettlementService;
  }

  public void setTradeSettlementService(List<BusinessEventData> tradeSettlementService) {
    this.tradeSettlementService = tradeSettlementService;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeBusinessEventsQueryResponse tradeBusinessEventsQueryResponse = (TradeBusinessEventsQueryResponse) o;
    return Objects.equals(this.tradeMatchingService, tradeBusinessEventsQueryResponse.tradeMatchingService) &&
        Objects.equals(this.tradeClearingService, tradeBusinessEventsQueryResponse.tradeClearingService) &&
        Objects.equals(this.tradeSettlementService, tradeBusinessEventsQueryResponse.tradeSettlementService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeMatchingService, tradeClearingService, tradeSettlementService);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeBusinessEventsQueryResponse {\n");
    
    sb.append("    tradeMatchingService: ").append(toIndentedString(tradeMatchingService)).append("\n");
    sb.append("    tradeClearingService: ").append(toIndentedString(tradeClearingService)).append("\n");
    sb.append("    tradeSettlementService: ").append(toIndentedString(tradeSettlementService)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
