package com.github.marschall.minicommons;

public class ArrayModel {

  private final Object[] data;

  public ArrayModel(Long id, String name, String description) {
    this.data = new Object[]{id, name, description};
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof ArrayModel)) {
      return false;
    }
    ArrayModel other = (ArrayModel) obj;
    return new com.github.marschall.minicommons.EqualsBuilder()
            .append(this.data, other.data)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new com.github.marschall.minicommons.HashCodeBuilder()
            .append(this.data)
            .toHashCode();
  }

}
