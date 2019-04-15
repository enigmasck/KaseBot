package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ResUnRes;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResolOnUnresolInner
 */
@Entity
@Table(name = "resolve_unresolve_rpt_vw")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class ResolOnUnresolInner   {
  @Id
  @JsonProperty("report_key")
  private String report_key = null;
  
  @JsonProperty("total_cases")
  @Column(name = "total_count")
  private Long totalCases = null;

  @JsonProperty("date_time")
  @Column(name = "case_date")
  private LocalDate dateTime = null;

  @JsonProperty("status")
  @Column(name = "cases_status")
  private ResUnRes status = null;

  public ResolOnUnresolInner totalCases(Long totalCases) {
    this.totalCases = totalCases;
    return this;
  }

  /**
   * Get totalCases
   * @return totalCases
  **/
  @ApiModelProperty(value = "")

  public Long getTotalCases() {
    return totalCases;
  }

  public void setTotalCases(Long totalCases) {
    this.totalCases = totalCases;
  }

  public ResolOnUnresolInner dateTime(LocalDate dateTime) {
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

  public ResolOnUnresolInner status(ResUnRes status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")

  @Valid
  public ResUnRes getStatus() {
    return status;
  }

  public void setStatus(ResUnRes status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResolOnUnresolInner resolOnUnresolInner = (ResolOnUnresolInner) o;
    return Objects.equals(this.totalCases, resolOnUnresolInner.totalCases) &&
        Objects.equals(this.dateTime, resolOnUnresolInner.dateTime) &&
        Objects.equals(this.status, resolOnUnresolInner.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCases, dateTime, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResolOnUnresolInner {\n");
    
    sb.append("    totalCases: ").append(toIndentedString(totalCases)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
