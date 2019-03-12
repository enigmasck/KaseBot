package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AvgCaseDurInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class AvgCaseDurInner   {
  @JsonProperty("case_duration")
  private Double caseDuration = null;

  @JsonProperty("date_time")
  private LocalDate dateTime = null;

  public AvgCaseDurInner caseDuration(Double caseDuration) {
    this.caseDuration = caseDuration;
    return this;
  }

  /**
   * Get caseDuration
   * @return caseDuration
  **/
  @ApiModelProperty(value = "")

  public Double getCaseDuration() {
    return caseDuration;
  }

  public void setCaseDuration(Double caseDuration) {
    this.caseDuration = caseDuration;
  }

  public AvgCaseDurInner dateTime(LocalDate dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDate dateTime) {
    this.dateTime = dateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvgCaseDurInner avgCaseDurInner = (AvgCaseDurInner) o;
    return Objects.equals(this.caseDuration, avgCaseDurInner.caseDuration) &&
        Objects.equals(this.dateTime, avgCaseDurInner.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseDuration, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvgCaseDurInner {\n");
    
    sb.append("    caseDuration: ").append(toIndentedString(caseDuration)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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
