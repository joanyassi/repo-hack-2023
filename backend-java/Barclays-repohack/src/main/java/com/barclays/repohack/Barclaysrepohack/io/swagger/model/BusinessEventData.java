package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.BusinessEventDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusinessEventData
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class BusinessEventData   {
  @JsonProperty("tradeId")
  private String tradeId = null;


  @JsonProperty("effectiveDate")
  private String effectiveDate;

  @JsonProperty("businessEvents")
  @Valid
  private List<BusinessEventDto> businessEvents = null;

  public BusinessEventData tradeId(String tradeId) {
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

  public BusinessEventData businessEvents(List<BusinessEventDto> businessEvents) {
    this.businessEvents = businessEvents;
    return this;
  }
  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public BusinessEventData addBusinessEventsItem(BusinessEventDto businessEventsItem) {
    if (this.businessEvents == null) {
      this.businessEvents = new ArrayList<BusinessEventDto>();
    }
    this.businessEvents.add(businessEventsItem);
    return this;
  }

  /**
   * Get businessEvents
   * @return businessEvents
   **/
  @Schema(description = "")
      @Valid
    public List<BusinessEventDto> getBusinessEvents() {
    return businessEvents;
  }

  public void setBusinessEvents(List<BusinessEventDto> businessEvents) {
    this.businessEvents = businessEvents;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessEventData businessEventData = (BusinessEventData) o;
    return Objects.equals(this.tradeId, businessEventData.tradeId) &&
        Objects.equals(this.businessEvents, businessEventData.businessEvents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, businessEvents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessEventData {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    businessEvents: ").append(toIndentedString(businessEvents)).append("\n");
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
