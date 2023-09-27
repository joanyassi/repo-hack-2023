package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * RepoBuyer
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class RepoBuyer   {
  @JsonProperty("buyer_name")
  private String buyerName = null;

  @JsonProperty("buyer_lei")
  private String buyerLei = null;

  @JsonProperty("buyer_account")
  private String buyerAccount = null;

  public RepoBuyer buyerName(String buyerName) {
    this.buyerName = buyerName;
    return this;
  }

  /**
   * Get buyerName
   * @return buyerName
   **/
  @Schema(example = "CLIENT02", description = "")
  
    public String getBuyerName() {
    return buyerName;
  }

  public void setBuyerName(String buyerName) {
    this.buyerName = buyerName;
  }

  public RepoBuyer buyerLei(String buyerLei) {
    this.buyerLei = buyerLei;
    return this;
  }

  /**
   * Get buyerLei
   * @return buyerLei
   **/
  @Schema(example = "CLIENT02-LEI01", description = "")
  
    public String getBuyerLei() {
    return buyerLei;
  }

  public void setBuyerLei(String buyerLei) {
    this.buyerLei = buyerLei;
  }

  public RepoBuyer buyerAccount(String buyerAccount) {
    this.buyerAccount = buyerAccount;
    return this;
  }

  /**
   * Get buyerAccount
   * @return buyerAccount
   **/
  @Schema(example = "CLIENT02-ACCOUNT01", description = "")
  
    public String getBuyerAccount() {
    return buyerAccount;
  }

  public void setBuyerAccount(String buyerAccount) {
    this.buyerAccount = buyerAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoBuyer repoBuyer = (RepoBuyer) o;
    return Objects.equals(this.buyerName, repoBuyer.buyerName) &&
        Objects.equals(this.buyerLei, repoBuyer.buyerLei) &&
        Objects.equals(this.buyerAccount, repoBuyer.buyerAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerName, buyerLei, buyerAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoBuyer {\n");
    
    sb.append("    buyerName: ").append(toIndentedString(buyerName)).append("\n");
    sb.append("    buyerLei: ").append(toIndentedString(buyerLei)).append("\n");
    sb.append("    buyerAccount: ").append(toIndentedString(buyerAccount)).append("\n");
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
