package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RepoTradeSubmissionResponse
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class RepoTradeSubmissionResponse   {
  @JsonProperty("tradeId")
  private String tradeId = null;

  @JsonProperty("tradeStatus")
  private String tradeStatus = null;

  public RepoTradeSubmissionResponse tradeId(String tradeId) {
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

  public RepoTradeSubmissionResponse tradeStatus(String tradeStatus) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeSubmissionResponse repoTradeSubmissionResponse = (RepoTradeSubmissionResponse) o;
    return Objects.equals(this.tradeId, repoTradeSubmissionResponse.tradeId) &&
        Objects.equals(this.tradeStatus, repoTradeSubmissionResponse.tradeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, tradeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeSubmissionResponse {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    tradeStatus: ").append(toIndentedString(tradeStatus)).append("\n");
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
