package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class UserAddress   {
  @JsonProperty("city")
  private String city = null;

  @JsonProperty("zip")
  private Long zip = null;

  public UserAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UserAddress zip(Long zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Get zip
   * minimum: 10000
   * maximum: 99999
   * @return zip
  **/
  @ApiModelProperty(value = "")

@Min(10000L) @Max(99999L)   public Long getZip() {
    return zip;
  }

  public void setZip(Long zip) {
    this.zip = zip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAddress userAddress = (UserAddress) o;
    return Objects.equals(this.city, userAddress.city) &&
        Objects.equals(this.zip, userAddress.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, zip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAddress {\n");
    
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
