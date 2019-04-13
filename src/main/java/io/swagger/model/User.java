package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.UserAddress;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User
 */
@Entity
@Table(name = "customer")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class User   {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @JsonProperty("id")
  private Integer customer_id = null;

  @JsonProperty("firstName")
  private String fname = null;

  @JsonProperty("lastName")
  private String lname = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("address")
  @Valid
  @OneToMany
  @JoinColumn(name="customer_id")
  private List<UserAddress> address = null;
  
  private String password = null;

  public User id(Integer id) {
    this.customer_id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  public Integer getId() {
    return customer_id;
  }

  public void setId(Integer id) {
    this.customer_id = id;
  }

  public User firstName(String firstName) {
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

  public User lastName(String lastName) {
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

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User address(List<UserAddress> address) {
    this.address = address;
    return this;
  }

  public User addAddressItem(UserAddress addressItem) {
    if (this.address == null) {
      this.address = new ArrayList<UserAddress>();
    }
    this.address.add(addressItem);
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<UserAddress> getAddress() {
    return address;
  }

  public void setAddress(List<UserAddress> address) {
    this.address = address;
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
    User user = (User) o;
    return Objects.equals(this.customer_id, user.customer_id) &&
        Objects.equals(this.fname, user.fname) &&
        Objects.equals(this.lname, user.lname) &&
        Objects.equals(this.email, user.email);
        //Objects.equals(this.address, user.address);
  }

  /*@Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, address);
  }*/

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(customer_id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(fname)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
