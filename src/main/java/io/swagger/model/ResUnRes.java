package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets ResUnRes
 */
public enum ResUnRes {
  RESOLVED("Resolved"),
    UNRESOLVED("Unresolved"),
    IN_PROGRESS("In Progress");

  private String value;

  ResUnRes(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ResUnRes fromValue(String text) {
    for (ResUnRes b : ResUnRes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
