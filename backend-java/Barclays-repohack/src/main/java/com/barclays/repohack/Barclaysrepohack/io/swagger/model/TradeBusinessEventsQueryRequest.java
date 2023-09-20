package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TradeBusinessEventsQueryRequest
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class TradeBusinessEventsQueryRequest   {
  @JsonProperty("tradeId")
  private String tradeId = null;

  @JsonProperty("fmi")
  private String fmi = null;

  @JsonProperty("fromDate")
  private OffsetDateTime fromDate = null;

  @JsonProperty("toDate")
  private OffsetDateTime toDate = null;

  public TradeBusinessEventsQueryRequest tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Get tradeId
   * @return tradeId
   **/
  @Schema(example = "UC2Q0EKXFH6260", description = "")
  
    public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public TradeBusinessEventsQueryRequest fmi(String fmi) {
    this.fmi = fmi;
    return this;
  }

  /**
   * Get fmi
   * @return fmi
   **/
  @Schema(example = "TRADE_MATCHING_SERVICE", description = "")
  
    public String getFmi() {
    return fmi;
  }

  public void setFmi(String fmi) {
    this.fmi = fmi;
  }

  public TradeBusinessEventsQueryRequest fromDate(OffsetDateTime fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
   **/
  @Schema(example = "2023-08-25T10:27:08.943Z", description = "")
  
    @Valid
    public OffsetDateTime getFromDate() {
    return fromDate;
  }

  public void setFromDate(OffsetDateTime fromDate) {
    this.fromDate = fromDate;
  }

  public TradeBusinessEventsQueryRequest toDate(OffsetDateTime toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
   **/
  @Schema(example = "2023-08-25T10:27:08.943Z", description = "")
  
    @Valid
    public OffsetDateTime getToDate() {
    return toDate;
  }

  public void setToDate(OffsetDateTime toDate) {
    this.toDate = toDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeBusinessEventsQueryRequest tradeBusinessEventsQueryRequest = (TradeBusinessEventsQueryRequest) o;
    return Objects.equals(this.tradeId, tradeBusinessEventsQueryRequest.tradeId) &&
        Objects.equals(this.fmi, tradeBusinessEventsQueryRequest.fmi) &&
        Objects.equals(this.fromDate, tradeBusinessEventsQueryRequest.fromDate) &&
        Objects.equals(this.toDate, tradeBusinessEventsQueryRequest.toDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, fmi, fromDate, toDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeBusinessEventsQueryRequest {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    fmi: ").append(toIndentedString(fmi)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
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
