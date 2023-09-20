package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.WorkflowEventData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TradeWorkflowStatusResponse
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class TradeWorkflowStatusResponse   {
  @JsonProperty("tradeMatchingService")
  @Valid
  private List<WorkflowEventData> tradeMatchingService = null;

  @JsonProperty("tradeClearingService")
  @Valid
  private List<WorkflowEventData> tradeClearingService = null;

  @JsonProperty("tradeSettlementService")
  @Valid
  private List<WorkflowEventData> tradeSettlementService = null;

  public TradeWorkflowStatusResponse tradeMatchingService(List<WorkflowEventData> tradeMatchingService) {
    this.tradeMatchingService = tradeMatchingService;
    return this;
  }

  public TradeWorkflowStatusResponse addTradeMatchingServiceItem(WorkflowEventData tradeMatchingServiceItem) {
    if (this.tradeMatchingService == null) {
      this.tradeMatchingService = new ArrayList<WorkflowEventData>();
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
    public List<WorkflowEventData> getTradeMatchingService() {
    return tradeMatchingService;
  }

  public void setTradeMatchingService(List<WorkflowEventData> tradeMatchingService) {
    this.tradeMatchingService = tradeMatchingService;
  }

  public TradeWorkflowStatusResponse tradeClearingService(List<WorkflowEventData> tradeClearingService) {
    this.tradeClearingService = tradeClearingService;
    return this;
  }

  public TradeWorkflowStatusResponse addTradeClearingServiceItem(WorkflowEventData tradeClearingServiceItem) {
    if (this.tradeClearingService == null) {
      this.tradeClearingService = new ArrayList<WorkflowEventData>();
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
    public List<WorkflowEventData> getTradeClearingService() {
    return tradeClearingService;
  }

  public void setTradeClearingService(List<WorkflowEventData> tradeClearingService) {
    this.tradeClearingService = tradeClearingService;
  }

  public TradeWorkflowStatusResponse tradeSettlementService(List<WorkflowEventData> tradeSettlementService) {
    this.tradeSettlementService = tradeSettlementService;
    return this;
  }

  public TradeWorkflowStatusResponse addTradeSettlementServiceItem(WorkflowEventData tradeSettlementServiceItem) {
    if (this.tradeSettlementService == null) {
      this.tradeSettlementService = new ArrayList<WorkflowEventData>();
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
    public List<WorkflowEventData> getTradeSettlementService() {
    return tradeSettlementService;
  }

  public void setTradeSettlementService(List<WorkflowEventData> tradeSettlementService) {
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
    TradeWorkflowStatusResponse tradeWorkflowStatusResponse = (TradeWorkflowStatusResponse) o;
    return Objects.equals(this.tradeMatchingService, tradeWorkflowStatusResponse.tradeMatchingService) &&
        Objects.equals(this.tradeClearingService, tradeWorkflowStatusResponse.tradeClearingService) &&
        Objects.equals(this.tradeSettlementService, tradeWorkflowStatusResponse.tradeSettlementService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeMatchingService, tradeClearingService, tradeSettlementService);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeWorkflowStatusResponse {\n");
    
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
