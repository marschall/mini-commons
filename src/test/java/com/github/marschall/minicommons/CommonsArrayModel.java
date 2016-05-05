package com.github.marschall.minicommons;

public class CommonsArrayModel {

  private final Object[] data;

  public CommonsArrayModel(Long id, String name, String description) {
    this.data = new Object[]{id, name, description};
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof CommonsArrayModel)) {
      return false;
    }
    CommonsArrayModel other = (CommonsArrayModel) obj;
    return new org.apache.commons.lang3.builder.EqualsBuilder()
            .append(this.data, other.data)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new org.apache.commons.lang3.builder.HashCodeBuilder()
            .append(this.data)
            .toHashCode();
  }

}
