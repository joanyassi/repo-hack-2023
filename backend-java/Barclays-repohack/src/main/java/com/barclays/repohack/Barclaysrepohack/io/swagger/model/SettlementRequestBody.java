package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SettlementRequestBody
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")
public class SettlementRequestBody   {
  @JsonProperty("businessEventData")
  private JsonNode businessEventData = null;

  public SettlementRequestBody businessEventData(JsonNode businessEventData) {
    this.businessEventData = businessEventData;
    return this;
  }

  /**
   * Get businessEventData
   * @return businessEventData
   **/
  @Schema(description = "")
  
    @Valid
    public JsonNode getBusinessEventData() {
    return businessEventData;
  }

  public void setBusinessEventData(JsonNode businessEventData) {
    this.businessEventData = businessEventData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementRequestBody settlementRequestBody = (SettlementRequestBody) o;
    return Objects.equals(this.businessEventData, settlementRequestBody.businessEventData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(businessEventData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettlementRequestBody {\n");
    
    sb.append("    businessEventData: ").append(toIndentedString(businessEventData)).append("\n");
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
