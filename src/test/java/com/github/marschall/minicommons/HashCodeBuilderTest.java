package com.github.marschall.minicommons;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashCodeBuilderTest {


  @Test
  public void appendLong() {

    assertEquals(
            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode(),
            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode(),
            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(1L).toHashCode(),
            new HashCodeBuilder().append(1L).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(0L).toHashCode(),
            new HashCodeBuilder().append(0L).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(-1L).toHashCode(),
            new HashCodeBuilder().append(-1L).toHashCode());

//    assertNotEquals(
//            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode(),
//            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode(),
            new HashCodeBuilder().append(1L).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode(),
            new HashCodeBuilder().append(0L).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(Long.MAX_VALUE).toHashCode(),
            new HashCodeBuilder().append(-1L).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode(),
            new HashCodeBuilder().append(1L).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode(),
            new HashCodeBuilder().append(0L).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(Long.MIN_VALUE).toHashCode(),
            new HashCodeBuilder().append(-1L).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(1L).toHashCode(),
            new HashCodeBuilder().append(0L).toHashCode());
    assertNotEquals(
            new HashCodeBuilder().append(1L).toHashCode(),
            new HashCodeBuilder().append(-1L).toHashCode());

//    assertNotEquals(
//            new HashCodeBuilder().append(0L).toHashCode(),
//            new HashCodeBuilder().append(-1L).toHashCode());
  }

  @Test
  public void appendDouble() {
    assertEquals(
            new HashCodeBuilder().append(1.0d).toHashCode(),
            new HashCodeBuilder().append(1.0d).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(Double.NaN).toHashCode(),
            new HashCodeBuilder().append(Double.NaN).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(0.0d).toHashCode(),
            new HashCodeBuilder().append(-0.0d).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(Double.POSITIVE_INFINITY).toHashCode(),
            new HashCodeBuilder().append(Double.NEGATIVE_INFINITY).toHashCode());
  }

}
