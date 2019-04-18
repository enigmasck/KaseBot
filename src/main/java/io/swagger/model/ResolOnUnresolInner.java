package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ResUnRes;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

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
  private Integer totalCases = null;

  @JsonProperty("date_time")
  @Column(name = "case_date")
  //@ApiModelProperty(required = true,example = "2016-01-01")
  //@JsonFormat(pattern = DATE_FORMAT)
  //@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
  //@ApiModelProperty(required = true, dataType = "org.joda.time.LocalDate")
  private LocalDateTime dateTime = null;

  @JsonProperty("status")
  @Column(name = "cases_status")
  private String status = null;

  public ResolOnUnresolInner totalCases(Integer totalCases) {
    this.totalCases = totalCases;
    return this;
  }

  /**
   * Get totalCases
   * @return totalCases
  **/
  @ApiModelProperty(value = "")

  public Integer getTotalCases() {
    return totalCases;
  }

  public void setTotalCases(Integer totalCases) {
    this.totalCases = totalCases;
  }

  public ResolOnUnresolInner dateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public ResolOnUnresolInner status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")

  @Valid
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
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
