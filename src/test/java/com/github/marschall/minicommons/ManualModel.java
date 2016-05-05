package com.github.marschall.minicommons;

import java.util.Objects;

public class ManualModel {

  private final Long id;
  private final String name;

  ManualModel(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Objects.hashCode(this.id);
    result = prime * result + Objects.hashCode(this.name);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof ManualModel)) {
      return false;
    }
    ManualModel other = (ManualModel) obj;
    return Objects.equals(this.id, other.id)
            && Objects.equals(this.name, other.name);
  }



}
