package com.github.marschall.minicommons;

public class ModelClass {

  private final Long id;
  private final String name;

  ModelClass(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return false;
    }
    if (!(obj instanceof ModelClass)) {
      return false;
    }
    ModelClass other = (ModelClass) obj;
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
    ModelClass one = new ModelClass(1L, "name1");
    for (int i = 0; i < 100_000_000; i++) {
      hashCode += one.hashCode();
    }
    System.out.println(hashCode);
  }

  static void benchmarkEquals() {
    ModelClass one = new ModelClass(1L, "name1");
    ModelClass two = new ModelClass(1L, "name2");
    for (int i = 0; i < 100_000_000; i++) {
      if (one.equals(two)) {
        return;
      }
    }
  }

}