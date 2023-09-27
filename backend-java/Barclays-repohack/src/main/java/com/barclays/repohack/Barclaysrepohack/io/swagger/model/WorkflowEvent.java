package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WorkflowEvent
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class WorkflowEvent   {
  @JsonProperty("eventSequence")
  private Integer eventSequence = null;

  @JsonProperty("requestId")
  private UUID requestId = null;

  @JsonProperty("tradeStatus")
  private String tradeStatus = null;

  @JsonProperty("tradeMatchingStatus")
  private String tradeMatchingStatus = null;

  @JsonProperty("eventTimeStamp")
  private Date eventTimeStamp = null;

  public WorkflowEvent eventSequence(Integer eventSequence) {
    this.eventSequence = eventSequence;
    return this;
  }

  /**
   * Get eventSequence
   * @return eventSequence
   **/
  @Schema(example = "1", description = "")
  
    public Integer getEventSequence() {
    return eventSequence;
  }

  public void setEventSequence(Integer eventSequence) {
    this.eventSequence = eventSequence;
  }

  public WorkflowEvent requestId(UUID requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * Get requestId
   * @return requestId
   **/
  @Schema(example = "5e970526-6ebe-4d9f-bab5-9f05fa07dcfd", description = "")
  
    @Valid
    public UUID getRequestId() {
    return requestId;
  }

  public void setRequestId(UUID requestId) {
    this.requestId = requestId;
  }

  public WorkflowEvent tradeStatus(String tradeStatus) {
    this.tradeStatus = tradeStatus;
    return this;
  }

  /**
   * Get tradeStatus
   * @return tradeStatus
   **/
  @Schema(example = "TRADE_ACCEPTED", description = "")
  
    public String getTradeStatus() {
    return tradeStatus;
  }

  public void setTradeStatus(String tradeStatus) {
    this.tradeStatus = tradeStatus;
  }

  public WorkflowEvent tradeMatchingStatus(String tradeMatchingStatus) {
    this.tradeMatchingStatus = tradeMatchingStatus;
    return this;
  }

  /**
   * Get tradeMatchingStatus
   * @return tradeMatchingStatus
   **/
  @Schema(example = "TRADE_MATCH_SUCCESS", description = "")
  
    public String getTradeMatchingStatus() {
    return tradeMatchingStatus;
  }

  public void setTradeMatchingStatus(String tradeMatchingStatus) {
    this.tradeMatchingStatus = tradeMatchingStatus;
  }

  public WorkflowEvent eventTimeStamp(Date eventTimeStamp) {
    this.eventTimeStamp = eventTimeStamp;
    return this;
  }

  /**
   * Get eventTimeStamp
   * @return eventTimeStamp
   **/
  @Schema(example = "2023-08-25T10:26:24.441Z", description = "")
  
    @Valid
    public Date getEventTimeStamp() {
    return eventTimeStamp;
  }

  public void setEventTimeStamp(Date eventTimeStamp) {
    this.eventTimeStamp = eventTimeStamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowEvent workflowEvent = (WorkflowEvent) o;
    return Objects.equals(this.eventSequence, workflowEvent.eventSequence) &&
        Objects.equals(this.requestId, workflowEvent.requestId) &&
        Objects.equals(this.tradeStatus, workflowEvent.tradeStatus) &&
        Objects.equals(this.tradeMatchingStatus, workflowEvent.tradeMatchingStatus) &&
        Objects.equals(this.eventTimeStamp, workflowEvent.eventTimeStamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventSequence, requestId, tradeStatus, tradeMatchingStatus, eventTimeStamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowEvent {\n");
    
    sb.append("    eventSequence: ").append(toIndentedString(eventSequence)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    tradeStatus: ").append(toIndentedString(tradeStatus)).append("\n");
    sb.append("    tradeMatchingStatus: ").append(toIndentedString(tradeMatchingStatus)).append("\n");
    sb.append("    eventTimeStamp: ").append(toIndentedString(eventTimeStamp)).append("\n");
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
