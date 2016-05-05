package com.github.marschall.minicommons;

public class CommonsModel {

  private final Long id;
  private final String name;

  CommonsModel(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof CommonsModel)) {
      return false;
    }
    CommonsModel other = (CommonsModel) obj;
    return new org.apache.commons.lang3.builder.EqualsBuilder()
            .append(this.id, other.id)
            .append(this.name, other.name)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new org.apache.commons.lang3.builder.HashCodeBuilder()
            .append(this.id)
            .append(this.name)
            .toHashCode();
  }



  public static void main(String[] args) {
    benchmarkHashCode();
  }

  static void benchmarkHashCode() {
    int hashCode = 0;
    CommonsModel one = new CommonsModel(1L, "name1");
    for (int i = 0; i < 100_000_000; i++) {
      hashCode += one.hashCode();
    }
    System.out.println(hashCode);
  }

  static void benchmarkEquals() {
    CommonsModel one = new CommonsModel(1L, "name1");
    CommonsModel two = new CommonsModel(1L, "name2");
    for (int i = 0; i < 100_000_000; i++) {
      if (one.equals(two)) {
        return;
      }
    }
  }

}
