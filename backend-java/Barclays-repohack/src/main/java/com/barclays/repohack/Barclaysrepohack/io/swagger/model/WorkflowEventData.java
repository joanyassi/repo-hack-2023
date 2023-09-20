package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.WorkflowEvent;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WorkflowEventData
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class WorkflowEventData   {
  @JsonProperty("tradeId")
  private String tradeId = null;

  @JsonProperty("workflowEvents")
  @Valid
  private List<WorkflowEvent> workflowEvents = null;

  public WorkflowEventData tradeId(String tradeId) {
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

  public WorkflowEventData workflowEvents(List<WorkflowEvent> workflowEvents) {
    this.workflowEvents = workflowEvents;
    return this;
  }

  public WorkflowEventData addWorkflowEventsItem(WorkflowEvent workflowEventsItem) {
    if (this.workflowEvents == null) {
      this.workflowEvents = new ArrayList<WorkflowEvent>();
    }
    this.workflowEvents.add(workflowEventsItem);
    return this;
  }

  /**
   * Get workflowEvents
   * @return workflowEvents
   **/
  @Schema(description = "")
      @Valid
    public List<WorkflowEvent> getWorkflowEvents() {
    return workflowEvents;
  }

  public void setWorkflowEvents(List<WorkflowEvent> workflowEvents) {
    this.workflowEvents = workflowEvents;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowEventData workflowEventData = (WorkflowEventData) o;
    return Objects.equals(this.tradeId, workflowEventData.tradeId) &&
        Objects.equals(this.workflowEvents, workflowEventData.workflowEvents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, workflowEvents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowEventData {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    workflowEvents: ").append(toIndentedString(workflowEvents)).append("\n");
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
