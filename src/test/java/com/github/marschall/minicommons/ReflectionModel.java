package com.github.marschall.minicommons;

public class ReflectionModel {

  private final Long id;
  private final String name;

  ReflectionModel(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
  }

}
