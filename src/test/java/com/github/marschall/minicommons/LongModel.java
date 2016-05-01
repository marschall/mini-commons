package com.github.marschall.minicommons;

public class LongModel {

  private final long key;
  private final long value;

  public LongModel(long key, long value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return false;
    }
    if (!(obj instanceof LongModel)) {
      return false;
    }
    LongModel other = (LongModel) obj;
    return new com.github.marschall.minicommons.EqualsBuilder()
            .append(this.key, other.key)
            .append(this.value, other.value)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new com.github.marschall.minicommons.HashCodeBuilder()
            .append(this.key)
            .append(this.value)
            .toHashCode();
  }

}
