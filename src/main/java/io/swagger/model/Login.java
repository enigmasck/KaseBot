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
 * Login
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-12T16:03:36.994Z[GMT]")
public class Login   {
  @JsonProperty("login_email")
  private String loginEmail = null;

  @JsonProperty("login_pw")
  private String loginPw = null;

  public Login loginEmail(String loginEmail) {
    this.loginEmail = loginEmail;
    return this;
  }

  /**
   * Get loginEmail
   * @return loginEmail
  **/
  @ApiModelProperty(value = "")

  public String getLoginEmail() {
    return loginEmail;
  }

  public void setLoginEmail(String loginEmail) {
    this.loginEmail = loginEmail;
  }

  public Login loginPw(String loginPw) {
    this.loginPw = loginPw;
    return this;
  }

  /**
   * Get loginPw
   * @return loginPw
  **/
  @ApiModelProperty(value = "")

  public String getLoginPw() {
    return loginPw;
  }

  public void setLoginPw(String loginPw) {
    this.loginPw = loginPw;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Login login = (Login) o;
    return Objects.equals(this.loginEmail, login.loginEmail) &&
        Objects.equals(this.loginPw, login.loginPw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginEmail, loginPw);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Login {\n");
    
    sb.append("    loginEmail: ").append(toIndentedString(loginEmail)).append("\n");
    sb.append("    loginPw: ").append(toIndentedString(loginPw)).append("\n");
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
