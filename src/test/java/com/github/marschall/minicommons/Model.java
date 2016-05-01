package com.github.marschall.minicommons;

public class Model {

  private final Long id;
  private final String name;

  Model(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return false;
    }
    if (!(obj instanceof Model)) {
      return false;
    }
    Model other = (Model) obj;
    return new com.github.marschall.minicommons.EqualsBuilder()
            .append(this.id, other.id)
            .append(this.name, other.name)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new com.github.marschall.minicommons.HashCodeBuilder()
            .append(this.id)
            .append(this.name)
            .toHashCode();
  }

  public static void main(String[] args) {
    benchmarkHashCode();
  }

  static void benchmarkHashCode() {
    int hashCode = 0;
    Model one = new Model(1L, "name1");
    for (int i = 0; i < 100_000_000; i++) {
      hashCode += one.hashCode();
    }
    System.out.println(hashCode);
  }

  static void benchmarkEquals() {
    Model one = new Model(1L, "name1");
    Model two = new Model(1L, "name2");
    for (int i = 0; i < 100_000_000; i++) {
      if (one.equals(two)) {
        return;
      }
    }
  }

}