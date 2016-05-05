package com.github.marschall.minicommons;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashCodeBuilderTest {


  @Test
  public void appendObject() {

    assertEquals(new HashCodeBuilder().append(1).toHashCode(), 528);
    assertEquals(new HashCodeBuilder().append((Object) null).toHashCode(), 527);


    assertNotEquals(new HashCodeBuilder().append((Object) new String[]{"one"}).toHashCode(),
                    new HashCodeBuilder().append((Object) new String[]{"one"}).toHashCode());
  }


  @Test
  public void appendSuper() {
    assertNotEquals(new HashCodeBuilder().append("one").toHashCode(),
                    new HashCodeBuilder().appendSuper(1).append("one").toHashCode());
  }

  @Test
  public void appendObjectArray() {
    assertEquals(new HashCodeBuilder().append(new String[]{"one"}).toHashCode(),
                 new HashCodeBuilder().append(new String[]{"one"}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new String[]{"one"}).toHashCode(),
                    new HashCodeBuilder().append(new String[]{null}).toHashCode());
  }

  @Test
  public void appendDeepObject() {

    assertEquals(new HashCodeBuilder().appendDeep(1).toHashCode(), 528);
    assertEquals(new HashCodeBuilder().appendDeep((Object) null).toHashCode(), 527);

    assertNotEquals(new HashCodeBuilder().appendDeep("one").toHashCode(),
                    new HashCodeBuilder().appendDeep((Object) new String[]{"one"}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new String[]{"one"}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new String[]{"one"}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new String[][]{new String[]{"one"}}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new String[][]{new String[]{"one"}}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new long[]{1L}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new long[]{1L}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new int[]{1}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new int[]{1}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new short[]{1}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new short[]{1}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new byte[]{1}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new byte[]{1}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new char[]{'1'}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new char[]{'1'}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new double[]{1.0d}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new double[]{1.0d}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new float[]{1.0f}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new float[]{1.0f}).toHashCode());

    assertEquals(new HashCodeBuilder().appendDeep((Object) new boolean[]{true}).toHashCode(),
                 new HashCodeBuilder().appendDeep((Object) new boolean[]{true}).toHashCode());
  }

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

  @Test
  public void appendFloat() {
    assertEquals(
            new HashCodeBuilder().append(1.0f).toHashCode(),
            new HashCodeBuilder().append(1.0f).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(Float.NaN).toHashCode(),
            new HashCodeBuilder().append(Float.NaN).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(0.0f).toHashCode(),
            new HashCodeBuilder().append(-0.0f).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(Float.POSITIVE_INFINITY).toHashCode(),
            new HashCodeBuilder().append(Float.NEGATIVE_INFINITY).toHashCode());
  }

  @Test
  public void appendBoolean() {

    assertEquals(
            new HashCodeBuilder().append(true).toHashCode(),
            new HashCodeBuilder().append(true).toHashCode());

    assertEquals(
            new HashCodeBuilder().append(false).toHashCode(),
            new HashCodeBuilder().append(false).toHashCode());

    assertNotEquals(
            new HashCodeBuilder().append(false).toHashCode(),
            new HashCodeBuilder().append(true).toHashCode());
  }

  @Test
  public void appendLongArray() {
    assertEquals(new HashCodeBuilder().append(new long[]{1L}).toHashCode(),
                 new HashCodeBuilder().append(new long[]{1L}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new long[]{1L}).toHashCode(),
                    new HashCodeBuilder().append(new long[]{2L}).toHashCode());
  }

  @Test
  public void appendIntArray() {
    assertEquals(new HashCodeBuilder().append(new int[]{1}).toHashCode(),
                 new HashCodeBuilder().append(new int[]{1}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new int[]{1}).toHashCode(),
                    new HashCodeBuilder().append(new int[]{2}).toHashCode());
  }

  @Test
  public void appendShortArray() {
    assertEquals(new HashCodeBuilder().append(new short[]{1}).toHashCode(),
                 new HashCodeBuilder().append(new short[]{1}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new short[]{1}).toHashCode(),
                    new HashCodeBuilder().append(new short[]{2}).toHashCode());
  }

  @Test
  public void appendByteArray() {
    assertEquals(new HashCodeBuilder().append(new byte[]{1}).toHashCode(),
            new HashCodeBuilder().append(new byte[]{1}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new byte[]{1}).toHashCode(),
                    new HashCodeBuilder().append(new byte[]{2}).toHashCode());
  }

  @Test
  public void appendCharArray() {
    assertEquals(new HashCodeBuilder().append(new char[]{'1'}).toHashCode(),
                 new HashCodeBuilder().append(new char[]{'1'}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new char[]{'1'}).toHashCode(),
                    new HashCodeBuilder().append(new char[]{'2'}).toHashCode());
  }

  @Test
  public void appendDoubleArray() {
    assertEquals(new HashCodeBuilder().append(new double[]{1.0d}).toHashCode(),
                 new HashCodeBuilder().append(new double[]{1.0d}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new double[]{1.0d}).toHashCode(),
                    new HashCodeBuilder().append(new double[]{2.0d}).toHashCode());
  }

  @Test
  public void appendFloatArray() {
    assertEquals(new HashCodeBuilder().append(new float[]{1.0f}).toHashCode(),
                 new HashCodeBuilder().append(new float[]{1.0f}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new float[]{1.0f}).toHashCode(),
                    new HashCodeBuilder().append(new float[]{2.0f}).toHashCode());
  }

  @Test
  public void appendBooleanArray() {
    assertEquals(new HashCodeBuilder().append(new boolean[]{true}).toHashCode(),
                 new HashCodeBuilder().append(new boolean[]{true}).toHashCode());

    assertNotEquals(new HashCodeBuilder().append(new boolean[]{true}).toHashCode(),
                    new HashCodeBuilder().append(new boolean[]{false}).toHashCode());
  }

}
