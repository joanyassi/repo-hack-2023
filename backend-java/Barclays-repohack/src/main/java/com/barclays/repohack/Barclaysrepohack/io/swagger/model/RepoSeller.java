package com.barclays.repohack.Barclaysrepohack.io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RepoSeller
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")


public class RepoSeller   {
  @JsonProperty("seller_name")
  private String sellerName = null;

  @JsonProperty("seller_lei")
  private String sellerLei = null;

  @JsonProperty("seller_account")
  private String sellerAccount = null;

  public RepoSeller sellerName(String sellerName) {
    this.sellerName = sellerName;
    return this;
  }

  /**
   * Get sellerName
   * @return sellerName
   **/
  @Schema(example = "DEALER01", description = "")
  
    public String getSellerName() {
    return sellerName;
  }

  public void setSellerName(String sellerName) {
    this.sellerName = sellerName;
  }

  public RepoSeller sellerLei(String sellerLei) {
    this.sellerLei = sellerLei;
    return this;
  }

  /**
   * Get sellerLei
   * @return sellerLei
   **/
  @Schema(example = "DEALER01-LEI01", description = "")
  
    public String getSellerLei() {
    return sellerLei;
  }

  public void setSellerLei(String sellerLei) {
    this.sellerLei = sellerLei;
  }

  public RepoSeller sellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
    return this;
  }

  /**
   * Get sellerAccount
   * @return sellerAccount
   **/
  @Schema(example = "DEALER01-ACCOUNT01", description = "")
  
    public String getSellerAccount() {
    return sellerAccount;
  }

  public void setSellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepoSeller repoSeller = (RepoSeller) o;
    return Objects.equals(this.sellerName, repoSeller.sellerName) &&
        Objects.equals(this.sellerLei, repoSeller.sellerLei) &&
        Objects.equals(this.sellerAccount, repoSeller.sellerAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sellerName, sellerLei, sellerAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepoSeller {\n");
    
    sb.append("    sellerName: ").append(toIndentedString(sellerName)).append("\n");
    sb.append("    sellerLei: ").append(toIndentedString(sellerLei)).append("\n");
    sb.append("    sellerAccount: ").append(toIndentedString(sellerAccount)).append("\n");
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
