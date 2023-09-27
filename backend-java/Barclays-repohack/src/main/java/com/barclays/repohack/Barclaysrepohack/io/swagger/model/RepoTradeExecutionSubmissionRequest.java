package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoBuyer;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoSeller;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoTradeDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RepoTradeExecutionSubmissionRequest
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class RepoTradeExecutionSubmissionRequest   {
  @JsonProperty("trade_id")
  private String tradeId = null;

  @JsonProperty("buyer")
  private RepoBuyer buyer = null;

  @JsonProperty("seller")
  private RepoSeller seller = null;

  @JsonProperty("trade_details")
  private RepoTradeDetails tradeDetails = null;

  public RepoTradeExecutionSubmissionRequest tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Get tradeId
   * @return tradeId
   **/
  @Schema(example = "UC2TFZSG4HB0D70", description = "")
  
    public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public RepoTradeExecutionSubmissionRequest buyer(RepoBuyer buyer) {
    this.buyer = buyer;
    return this;
  }

  /**
   * Get buyer
   * @return buyer
   **/
  @Schema(description = "")
  
    @Valid
    public RepoBuyer getBuyer() {
    return buyer;
  }

  public void setBuyer(RepoBuyer buyer) {
    this.buyer = buyer;
  }

  public RepoTradeExecutionSubmissionRequest seller(RepoSeller seller) {
    this.seller = seller;
    return this;
  }

  /**
   * Get seller
   * @return seller
   **/
  @Schema(description = "")
  
    @Valid
    public RepoSeller getSeller() {
    return seller;
  }

  public void setSeller(RepoSeller seller) {
    this.seller = seller;
  }

  public RepoTradeExecutionSubmissionRequest tradeDetails(RepoTradeDetails tradeDetails) {
    this.tradeDetails = tradeDetails;
    return this;
  }

  /**
   * Get tradeDetails
   * @return tradeDetails
   **/
  @Schema(description = "")
  
    @Valid
    public RepoTradeDetails getTradeDetails() {
    return tradeDetails;
  }

  public void setTradeDetails(RepoTradeDetails tradeDetails) {
    this.tradeDetails = tradeDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeExecutionSubmissionRequest repoTradeExecutionSubmissionRequest = (RepoTradeExecutionSubmissionRequest) o;
    return Objects.equals(this.tradeId, repoTradeExecutionSubmissionRequest.tradeId) &&
        Objects.equals(this.buyer, repoTradeExecutionSubmissionRequest.buyer) &&
        Objects.equals(this.seller, repoTradeExecutionSubmissionRequest.seller) &&
        Objects.equals(this.tradeDetails, repoTradeExecutionSubmissionRequest.tradeDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, buyer, seller, tradeDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeExecutionSubmissionRequest {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    buyer: ").append(toIndentedString(buyer)).append("\n");
    sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
    sb.append("    tradeDetails: ").append(toIndentedString(tradeDetails)).append("\n");
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
