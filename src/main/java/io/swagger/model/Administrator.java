/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author enigmasck
 */
@Entity
@Table(name = "administrator")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class Administrator {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("id")
  private Integer administrator_id = null;

  @JsonProperty("firstName")
  private String fname = null;

  @JsonProperty("lastName")
  private String lname = null;

  @JsonProperty("login_name")
  private String login_name = null;
  
  @JsonProperty("password")
  private String password = null;

  public Administrator id(Integer id) {
    this.administrator_id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  public Integer getId() {
    return administrator_id;
  }

  public void setId(Integer id) {
    this.administrator_id = id;
  }

  public Administrator firstName(String firstName) {
    this.fname = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")

  public String getFirstName() {
    return fname;
  }

  public void setFirstName(String firstName) {
    this.fname = firstName;
  }

  public Administrator lastName(String lastName) {
    this.lname = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")

  public String getLastName() {
    return lname;
  }

  public void setLastName(String lastName) {
    this.lname = lastName;
  }

  /**
   * Get login_name
   * @return login_name
  **/
  
  public Administrator login_name(String login_name) {
    this.login_name = login_name;
    return this;
  }

  public String getLoginName() {
    return login_name;
  }

  public void setLoginName(String login_name) {
    this.login_name = login_name;
  }


  /**
   * Get password
   * @return password
  **/
  
  public String getPassword(){
      return this.password;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Administrator admin = (Administrator) o;
    return Objects.equals(this.administrator_id, admin.administrator_id) &&
        Objects.equals(this.fname, admin.fname) &&
        Objects.equals(this.lname, admin.lname) &&
        Objects.equals(this.login_name, admin.login_name);
        //Objects.equals(this.address, user.address);
  }

  /*@Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, address);
  }*/

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Administrator {\n");
    
    sb.append("    id: ").append(toIndentedString(administrator_id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(fname)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lname)).append("\n");
    sb.append("    login_name: ").append(toIndentedString(login_name)).append("\n");
    //sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
