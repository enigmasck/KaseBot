package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ResUnRes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CaseInner
 */
@Entity
@Table(name = "cases")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class CaseInner   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("cases_id")
  private Long caseId = null;

  @JsonProperty("cases_start")
  private OffsetDateTime caseStart = null;

  @JsonProperty("cases_end")
  private OffsetDateTime caseEnd = null;

  @JsonProperty("cases_notes")
  private String caseNotes = null;

  @JsonProperty("cases_status")
  private ResUnRes caseStatus = null;

  public CaseInner caseId(Long caseId) {
    this.caseId = caseId;
    return this;
  }

  /**
   * Get caseId
   * @return caseId
  **/
  @ApiModelProperty(value = "")

  public Long getCaseId() {
    return caseId;
  }

  public void setCaseId(Long caseId) {
    this.caseId = caseId;
  }

  public CaseInner caseStart(OffsetDateTime caseStart) {
    this.caseStart = caseStart;
    return this;
  }

  /**
   * Get caseStart
   * @return caseStart
  **/
  @ApiModelProperty(value = "")

  @Valid
  public OffsetDateTime getCaseStart() {
    return caseStart;
  }

  public void setCaseStart(OffsetDateTime caseStart) {
    this.caseStart = caseStart;
  }

  public CaseInner caseEnd(OffsetDateTime caseEnd) {
    this.caseEnd = caseEnd;
    return this;
  }

  /**
   * Get caseEnd
   * @return caseEnd
  **/
  @ApiModelProperty(value = "")

  @Valid
  public OffsetDateTime getCaseEnd() {
    return caseEnd;
  }

  public void setCaseEnd(OffsetDateTime caseEnd) {
    this.caseEnd = caseEnd;
  }

  public CaseInner caseNotes(String caseNotes) {
    this.caseNotes = caseNotes;
    return this;
  }

  /**
   * Get caseNotes
   * @return caseNotes
  **/
  @ApiModelProperty(value = "")

@Size(min=2,max=5000)   public String getCaseNotes() {
    return caseNotes;
  }

  public void setCaseNotes(String caseNotes) {
    this.caseNotes = caseNotes;
  }

  public CaseInner caseStatus(ResUnRes caseStatus) {
    this.caseStatus = caseStatus;
    return this;
  }

  /**
   * Get caseStatus
   * @return caseStatus
  **/
  @ApiModelProperty(value = "")

  @Valid
  public ResUnRes getCaseStatus() {
    return caseStatus;
  }

  public void setCaseStatus(ResUnRes caseStatus) {
    this.caseStatus = caseStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaseInner caseInner = (CaseInner) o;
    return Objects.equals(this.caseId, caseInner.caseId) &&
        Objects.equals(this.caseStart, caseInner.caseStart) &&
        Objects.equals(this.caseEnd, caseInner.caseEnd) &&
        Objects.equals(this.caseNotes, caseInner.caseNotes) &&
        Objects.equals(this.caseStatus, caseInner.caseStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, caseStart, caseEnd, caseNotes, caseStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaseInner {\n");
    
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    caseStart: ").append(toIndentedString(caseStart)).append("\n");
    sb.append("    caseEnd: ").append(toIndentedString(caseEnd)).append("\n");
    sb.append("    caseNotes: ").append(toIndentedString(caseNotes)).append("\n");
    sb.append("    caseStatus: ").append(toIndentedString(caseStatus)).append("\n");
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
