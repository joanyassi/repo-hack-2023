package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RepoTradeDetails
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")

@JsonIgnoreProperties
public class RepoTradeDetails   {
  @JsonProperty("trade_date")
  private String tradeDate = null;

  @JsonProperty("effective_date")
  private String effectiveDate = null;

  @JsonProperty("maturity_date")
  private String maturityDate = null;

  @JsonProperty("repo_rate")
  private BigDecimal repoRate = null;

  @JsonProperty("rate_daycount_convention")
  private String rateDaycountConvention = null;

  @JsonProperty("collateral_id")
  private String collateralId = null;

  @JsonProperty("collateral_notional")
  private BigDecimal collateralNotional = null;

  @JsonProperty("collateral_dirty_price")
  private BigDecimal collateralDirtyPrice = null;

  @JsonProperty("collateral_haircut")
  private BigDecimal collateralHaircut = null;

  @JsonProperty("trade_ccy")
  private String tradeCcy = null;

  @JsonProperty("cash_amount")
  private BigDecimal cashAmount = null;

  @JsonProperty("termination_cash_amount")
  private BigDecimal terminationCashAmount = null;

  public RepoTradeDetails tradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
    return this;
  }

  /**
   * Get tradeDate
   * @return tradeDate
   **/
  @Schema(example = "2023-09-20", description = "")
  
    public String getTradeDate() {
    return tradeDate;
  }

  public void setTradeDate(String tradeDate) {
    this.tradeDate = tradeDate;
  }

  public RepoTradeDetails effectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

  /**
   * Get effectiveDate
   * @return effectiveDate
   **/
  @Schema(example = "2023-09-20", description = "")
  
    public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public RepoTradeDetails maturityDate(String maturityDate) {
    this.maturityDate = maturityDate;
    return this;
  }

  /**
   * Get maturityDate
   * @return maturityDate
   **/
  @Schema(example = "2023-09-25", description = "")
  
    public String getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(String maturityDate) {
    this.maturityDate = maturityDate;
  }

  public RepoTradeDetails repoRate(BigDecimal repoRate) {
    this.repoRate = repoRate;
    return this;
  }

  /**
   * Get repoRate
   * @return repoRate
   **/
  @Schema(example = "0.05", description = "")
  
    @Valid
    public BigDecimal getRepoRate() {
    return repoRate;
  }

  public void setRepoRate(BigDecimal repoRate) {
    this.repoRate = repoRate;
  }

  public RepoTradeDetails rateDaycountConvention(String rateDaycountConvention) {
    this.rateDaycountConvention = rateDaycountConvention;
    return this;
  }

  /**
   * Get rateDaycountConvention
   * @return rateDaycountConvention
   **/
  @Schema(example = "ACT_360", description = "")
  
    public String getRateDaycountConvention() {
    return rateDaycountConvention;
  }

  public void setRateDaycountConvention(String rateDaycountConvention) {
    this.rateDaycountConvention = rateDaycountConvention;
  }

  public RepoTradeDetails collateralId(String collateralId) {
    this.collateralId = collateralId;
    return this;
  }

  /**
   * Get collateralId
   * @return collateralId
   **/
  @Schema(example = "GBX3U42BMJ1", description = "")
  
    public String getCollateralId() {
    return collateralId;
  }

  public void setCollateralId(String collateralId) {
    this.collateralId = collateralId;
  }

  public RepoTradeDetails collateralNotional(BigDecimal collateralNotional) {
    this.collateralNotional = collateralNotional;
    return this;
  }

  /**
   * Get collateralNotional
   * @return collateralNotional
   **/
  @Schema(example = "7000000", description = "")
  
    @Valid
    public BigDecimal getCollateralNotional() {
    return collateralNotional;
  }

  public void setCollateralNotional(BigDecimal collateralNotional) {
    this.collateralNotional = collateralNotional;
  }

  public RepoTradeDetails collateralDirtyPrice(BigDecimal collateralDirtyPrice) {
    this.collateralDirtyPrice = collateralDirtyPrice;
    return this;
  }

  /**
   * Get collateralDirtyPrice
   * @return collateralDirtyPrice
   **/
  @Schema(example = "93.9", description = "")
  
    @Valid
    public BigDecimal getCollateralDirtyPrice() {
    return collateralDirtyPrice;
  }

  public void setCollateralDirtyPrice(BigDecimal collateralDirtyPrice) {
    this.collateralDirtyPrice = collateralDirtyPrice;
  }

  public RepoTradeDetails collateralHaircut(BigDecimal collateralHaircut) {
    this.collateralHaircut = collateralHaircut;
    return this;
  }

  /**
   * Get collateralHaircut
   * @return collateralHaircut
   **/
  @Schema(example = "0.02", description = "")
  
    @Valid
    public BigDecimal getCollateralHaircut() {
    return collateralHaircut;
  }

  public void setCollateralHaircut(BigDecimal collateralHaircut) {
    this.collateralHaircut = collateralHaircut;
  }

  public RepoTradeDetails tradeCcy(String tradeCcy) {
    this.tradeCcy = tradeCcy;
    return this;
  }

  /**
   * Get tradeCcy
   * @return tradeCcy
   **/
  @Schema(example = "GBP", description = "")
  
    public String getTradeCcy() {
    return tradeCcy;
  }

  public void setTradeCcy(String tradeCcy) {
    this.tradeCcy = tradeCcy;
  }

  public RepoTradeDetails cashAmount(BigDecimal cashAmount) {
    this.cashAmount = cashAmount;
    return this;
  }

  /**
   * Get cashAmount
   * @return cashAmount
   **/
  @Schema(example = "6441540", description = "")
  
    @Valid
    public BigDecimal getCashAmount() {
    return cashAmount;
  }

  public void setCashAmount(BigDecimal cashAmount) {
    this.cashAmount = cashAmount;
  }

  public RepoTradeDetails terminationCashAmount(BigDecimal terminationCashAmount) {
    this.terminationCashAmount = terminationCashAmount;
    return this;
  }

  /**
   * Get terminationCashAmount
   * @return terminationCashAmount
   **/
  @Schema(example = "6444187.21", description = "")
  
    @Valid
    public BigDecimal getTerminationCashAmount() {
    return terminationCashAmount;
  }

  public void setTerminationCashAmount(BigDecimal terminationCashAmount) {
    this.terminationCashAmount = terminationCashAmount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoTradeDetails repoTradeDetails = (RepoTradeDetails) o;
    return Objects.equals(this.tradeDate, repoTradeDetails.tradeDate) &&
        Objects.equals(this.effectiveDate, repoTradeDetails.effectiveDate) &&
        Objects.equals(this.maturityDate, repoTradeDetails.maturityDate) &&
        Objects.equals(this.repoRate, repoTradeDetails.repoRate) &&
        Objects.equals(this.rateDaycountConvention, repoTradeDetails.rateDaycountConvention) &&
        Objects.equals(this.collateralId, repoTradeDetails.collateralId) &&
        Objects.equals(this.collateralNotional, repoTradeDetails.collateralNotional) &&
        Objects.equals(this.collateralDirtyPrice, repoTradeDetails.collateralDirtyPrice) &&
        Objects.equals(this.collateralHaircut, repoTradeDetails.collateralHaircut) &&
        Objects.equals(this.tradeCcy, repoTradeDetails.tradeCcy) &&
        Objects.equals(this.cashAmount, repoTradeDetails.cashAmount) &&
        Objects.equals(this.terminationCashAmount, repoTradeDetails.terminationCashAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeDate, effectiveDate, maturityDate, repoRate, rateDaycountConvention, collateralId, collateralNotional, collateralDirtyPrice, collateralHaircut, tradeCcy, cashAmount, terminationCashAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoTradeDetails {\n");
    
    sb.append("    tradeDate: ").append(toIndentedString(tradeDate)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    maturityDate: ").append(toIndentedString(maturityDate)).append("\n");
    sb.append("    repoRate: ").append(toIndentedString(repoRate)).append("\n");
    sb.append("    rateDaycountConvention: ").append(toIndentedString(rateDaycountConvention)).append("\n");
    sb.append("    collateralId: ").append(toIndentedString(collateralId)).append("\n");
    sb.append("    collateralNotional: ").append(toIndentedString(collateralNotional)).append("\n");
    sb.append("    collateralDirtyPrice: ").append(toIndentedString(collateralDirtyPrice)).append("\n");
    sb.append("    collateralHaircut: ").append(toIndentedString(collateralHaircut)).append("\n");
    sb.append("    tradeCcy: ").append(toIndentedString(tradeCcy)).append("\n");
    sb.append("    cashAmount: ").append(toIndentedString(cashAmount)).append("\n");
    sb.append("    terminationCashAmount: ").append(toIndentedString(terminationCashAmount)).append("\n");
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
