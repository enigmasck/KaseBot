package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ResUnRes;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
  //@GeneratedValue(strategy=GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("cases_id")
  @Column(name="cases_id")
  private Long casesId = null;

  @JsonProperty("cases_type")
  @Column(name="cases_type")
  private String casesType = null;
  
  @JsonProperty("cases_notes")
  @Column(name="cases_notes")
  private String casesNotes = null;
  
  @JsonProperty("customer_id")
  @Column(name="customer_id")
  private String customerId = null;
  
  @JsonProperty("cases_status")
  @Column(name="cases_status")
  private String casesStatus = null;
  
  @JsonProperty("cases_create_timestamp")
  @Column(name="cases_create_timestamp")
  private LocalDateTime casesCreateTimestamp = null;

  public CaseInner caseId(Long caseId) {
    this.casesId = caseId;
    return this;
  }

  /**
   * Get caseId
   * @return caseId
  **/
  @ApiModelProperty(value = "")

  public Long getCaseId() {
    return casesId;
  }

  public void setCaseId(Long caseId) {
    this.casesId = caseId;
  }


  /**
   * Get caseEnd
   * @return caseEnd
  **/
  @ApiModelProperty(value = "")


  public CaseInner caseNotes(String caseNotes) {
    this.casesNotes = caseNotes;
    return this;
  }

  /**
   * Get caseNotes
   * @return caseNotes
  **/
  @ApiModelProperty(value = "")

@Size(min=2,max=5000)   public String getCaseNotes() {
    return casesNotes;
  }

  public void setCaseNotes(String caseNotes) {
    this.casesNotes = caseNotes;
  }

  public CaseInner caseStatus(String caseStatus) {
    this.casesStatus = caseStatus;
    return this;
  }

  /**
   * Get caseStatus
   * @return caseStatus
  **/
  @ApiModelProperty(value = "")

  @Valid
  public String getCaseStatus() {
    return casesStatus;
  }

  public void setCaseStatus(String caseStatus) {
    this.casesStatus = caseStatus;
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
    return Objects.equals(this.casesId, caseInner.casesId) &&
        Objects.equals(this.casesNotes, caseInner.casesNotes) &&
        Objects.equals(this.casesStatus, caseInner.casesStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(casesId, casesNotes, casesStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaseInner {\n");
    sb.append("    caseId: ").append(toIndentedString(casesId)).append("\n");
    sb.append("    caseNotes: ").append(toIndentedString(casesNotes)).append("\n");
    sb.append("    caseStatus: ").append(toIndentedString(casesStatus)).append("\n");
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
