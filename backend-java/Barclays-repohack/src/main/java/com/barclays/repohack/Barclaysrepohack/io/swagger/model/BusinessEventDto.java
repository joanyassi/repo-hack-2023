package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusinessEventDto
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class BusinessEventDto   {
  @JsonProperty("businessEventName")
  private String businessEventName = null;

  @JsonProperty("businessEventSeq")
  private Integer businessEventSeq = null;

  @JsonProperty("businessEventData")
  private com.fasterxml.jackson.databind.JsonNode businessEventData = null;

  @JsonProperty("eventCreatedDate")
  private Date eventCreatedDate = null;

  public BusinessEventDto businessEventName(String businessEventName) {
    this.businessEventName = businessEventName;
    return this;
  }

  /**
   * Get businessEventName
   * @return businessEventName
   **/
  @Schema(example = "TradeContractFormedEvent", description = "")
  
    public String getBusinessEventName() {
    return businessEventName;
  }

  public void setBusinessEventName(String businessEventName) {
    this.businessEventName = businessEventName;
  }

  public BusinessEventDto businessEventSeq(Integer businessEventSeq) {
    this.businessEventSeq = businessEventSeq;
    return this;
  }

  /**
   * Get businessEventSeq
   * @return businessEventSeq
   **/
  @Schema(example = "1", description = "")
  
    public Integer getBusinessEventSeq() {
    return businessEventSeq;
  }

  public void setBusinessEventSeq(Integer businessEventSeq) {
    this.businessEventSeq = businessEventSeq;
  }

  public BusinessEventDto businessEventData(com.fasterxml.jackson.databind.JsonNode businessEventData) {
    this.businessEventData = businessEventData;
    return this;
  }

  /**
   * Get businessEventData
   * @return businessEventData
   **/
  @Schema(description = "")
  
    @Valid
    public com.fasterxml.jackson.databind.JsonNode getBusinessEventData() {
    return businessEventData;
  }

  public void setBusinessEventData(JsonNode businessEventData) {
    this.businessEventData = businessEventData;
  }

  public BusinessEventDto eventCreatedDate(Date eventCreatedDate) {
    this.eventCreatedDate = eventCreatedDate;
    return this;
  }

  /**
   * Get eventCreatedDate
   * @return eventCreatedDate
   **/
  @Schema(example = "2023-08-25T10:26:24.441Z", description = "")
  
    @Valid
    public Date getEventCreatedDate() {
    return eventCreatedDate;
  }

  public void setEventCreatedDate(Date eventCreatedDate) {
    this.eventCreatedDate = eventCreatedDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessEventDto businessEventDto = (BusinessEventDto) o;
    return Objects.equals(this.businessEventName, businessEventDto.businessEventName) &&
        Objects.equals(this.businessEventSeq, businessEventDto.businessEventSeq) &&
        Objects.equals(this.businessEventData, businessEventDto.businessEventData) &&
        Objects.equals(this.eventCreatedDate, businessEventDto.eventCreatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(businessEventName, businessEventSeq, businessEventData, eventCreatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessEventDto {\n");
    
    sb.append("    businessEventName: ").append(toIndentedString(businessEventName)).append("\n");
    sb.append("    businessEventSeq: ").append(toIndentedString(businessEventSeq)).append("\n");
    sb.append("    businessEventData: ").append(toIndentedString(businessEventData)).append("\n");
    sb.append("    eventCreatedDate: ").append(toIndentedString(eventCreatedDate)).append("\n");
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
