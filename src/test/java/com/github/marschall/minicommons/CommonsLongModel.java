package com.github.marschall.minicommons;

public class CommonsLongModel {

  private final long key;
  private final long value;

  public CommonsLongModel(long key, long value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof LongModel)) {
      return false;
    }
    CommonsLongModel other = (CommonsLongModel) obj;
    return new org.apache.commons.lang3.builder.EqualsBuilder()
            .append(this.key, other.key)
            .append(this.value, other.value)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new org.apache.commons.lang3.builder.HashCodeBuilder()
            .append(this.key)
            .append(this.value)
            .toHashCode();
  }

}
