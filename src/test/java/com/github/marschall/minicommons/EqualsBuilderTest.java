package com.github.marschall.minicommons;

import static org.junit.Assert.*;

import org.junit.Test;

public class EqualsBuilderTest {

  @Test
  public void appendSuper() {
    assertTrue(new EqualsBuilder()
            .appendSuper(true)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .appendSuper(true)
            .isEquals());
  }

  @Test
  public void appendObject() {
    assertTrue(new EqualsBuilder()
            .append("one", new String("one"))
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append("one", "two")
            .isEquals());


    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append("one", "one")
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append("one", null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append("one", null)
            .isEquals());

    // arrays
    Object array = new String[]{"one"};
    assertTrue(new EqualsBuilder()
            .append(array, array) // identity
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append((Object) new String[]{"one"}, (Object) new String[]{"one"})
            .isEquals());
  }

  @Test
  public void appendObjectDeep() {
    assertTrue(new EqualsBuilder()
            .appendDeep("one", new String("one"))
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep("one", "two")
            .isEquals());


    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .appendDeep("one", "one")
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .appendDeep("one", null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep("one", null)
            .isEquals());

    // arrays
    Object array = new String[]{"one"};
    assertTrue(new EqualsBuilder()
            .appendDeep(array, array) // identity
            .isEquals());

    assertTrue(new EqualsBuilder()
            .appendDeep((Object) new String[]{"one"}, (Object) new String[]{"one"})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .appendDeep((Object) new String[][]{new String[]{"one"}}, (Object) new String[]{"one"})
            .isEquals());

    assertTrue(new EqualsBuilder()
            .appendDeep((Object) new String[][]{new String[]{"one"}}, (Object) new String[][]{new String[]{"one"}})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep((Object) new String[][]{new String[]{"one"}}, (Object) new String[][]{new String[]{"two"}})
            .isEquals());
  }

  @Test
  public void appendObjectArrayDeep() {
    assertTrue(new EqualsBuilder()
            .appendDeep(new String[]{"one"}, new String[]{"one"})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep(new String[]{"one"}, new String[]{"two"})
            .isEquals());


    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .appendDeep(new String[]{"one"}, new String[]{"one"})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .appendDeep(new String[]{"one"}, new String[]{null})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep(new String[]{null}, new String[]{"one"})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep(new String[]{"one"}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep(null, new String[]{"one"})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .appendDeep(new String[][]{new String[]{"one"}}, new String[]{"one"})
            .isEquals());

    assertTrue(new EqualsBuilder()
            .appendDeep(new String[][]{new String[]{"one"}}, new String[][]{new String[]{"one"}})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendDeep(new String[][]{new String[]{"one"}}, new String[][]{new String[]{"two"}})
            .isEquals());
  }

  @Test
  public void appendDouble() {
    assertTrue(new EqualsBuilder()
            .append(1.0d, 1.0d)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(1.0d, 1.0d)
            .isEquals());

    assertTrue(new EqualsBuilder()
            .append(Double.NaN, Double.NaN)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(0.0d, -0.0d)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)
            .isEquals());
  }

  @Test
  public void appendFloat() {
    assertTrue(new EqualsBuilder()
            .append(1.0f, 1.0f)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(1.0f, 1.0f)
            .isEquals());

    assertTrue(new EqualsBuilder()
            .append(Float.NaN, Float.NaN)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(0.0f, -0.0f)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY)
            .isEquals());
  }

  @Test
  public void appendLong() {
    assertTrue(new EqualsBuilder()
            .append(1L, 1L)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(1L, 1L)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(1L, 2L)
            .isEquals());
  }

  @Test
  public void appendInt() {
    assertTrue(new EqualsBuilder()
            .append(1, 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(1, 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(1, 2)
            .isEquals());
  }

  @Test
  public void appendShort() {
    assertTrue(new EqualsBuilder()
            .append((short) 1, (short) 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append((short) 1, (short) 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append((short) 1, (short) 2)
            .isEquals());
  }

  @Test
  public void appendChar() {
    assertTrue(new EqualsBuilder()
            .append('1', '1')
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append('1', '1')
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append('1', '2')
            .isEquals());
  }

  @Test
  public void appendByte() {
    assertTrue(new EqualsBuilder()
            .append((byte) 1, (byte) 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append((byte) 1, (byte) 1)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append((byte) 1, (byte) 2)
            .isEquals());
  }

  @Test
  public void appendBoolean() {
    assertTrue(new EqualsBuilder()
            .append(true, true)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(true, true)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(true, false)
            .isEquals());
  }

  @Test
  public void appendObjectArray() {
    assertTrue(new EqualsBuilder()
            .append(new String[]{"one"}, new String[]{"one"})
            .isEquals());
    assertTrue(new EqualsBuilder()
            .append(new String[]{"one"}, new String[]{new String("one")})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new String[]{"one"}, new String[]{"one", "two"})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new String[]{"one"}, new String[]{"two"})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new String[]{"one"}, new String[]{"one"})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new String[]{"one"}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new String[]{"one"}, new String[]{null})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new String[]{null}, new String[]{"one"})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new String[]{"one"})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new String[][]{new String[]{"one"}}, new String[]{"one"})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new String[][]{new String[]{"one"}}, new String[][]{new String[]{"one"}})
            .isEquals());
  }

  @Test
  public void appendDoubleArray() {
    assertTrue(new EqualsBuilder()
            .append(new double[]{1.0d}, new double[]{1.0d})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new double[]{1.0d}, new double[]{1.0d, 2.0d})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new double[]{1.0d}, new double[]{2.0d})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new double[]{1.0d}, new double[]{1.0d})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new double[]{1.0d}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new double[]{1.0d})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new double[][]{new double[]{1.0d}}, new double[]{1.0d})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new double[][]{new double[]{1.0d}}, new double[][]{new double[]{1.0d}})
            .isEquals());
  }

  @Test
  public void appendFloatArray() {
    assertTrue(new EqualsBuilder()
            .append(new float[]{1.0f}, new float[]{1.0f})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new float[]{1.0f}, new float[]{1.0f, 2.0f})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new float[]{1.0f}, new float[]{2.0f})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new float[]{1.0f}, new float[]{1.0f})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new float[]{1.0f}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new float[]{1.0f})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new float[][]{new float[]{1.0f}}, new float[]{1.0f})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new float[][]{new float[]{1.0f}}, new float[][]{new float[]{1.0f}})
            .isEquals());
  }

  @Test
  public void appendLongArray() {
    assertTrue(new EqualsBuilder()
            .append(new long[]{1L}, new long[]{1L})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new long[]{1L}, new long[]{1L, 2L})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new long[]{1L}, new long[]{2L})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new long[]{1L}, new long[]{1L})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new long[]{1L}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new long[]{1L})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new long[][]{new long[]{1L}}, new long[]{1L})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new long[][]{new long[]{1L}}, new long[][]{new long[]{1L}})
            .isEquals());
  }

  @Test
  public void appendIntArray() {
    assertTrue(new EqualsBuilder()
            .append(new int[]{1}, new int[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new int[]{1}, new int[]{1, 2})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new int[]{1}, new int[]{2})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new int[]{1}, new int[]{1})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new int[]{1}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new int[]{1})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new int[][]{new int[]{1}}, new int[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new int[][]{new int[]{1}}, new int[][]{new int[]{1}})
            .isEquals());
  }

  @Test
  public void appendShortArray() {
    assertTrue(new EqualsBuilder()
            .append(new short[]{1}, new short[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new short[]{1}, new short[]{1, 2})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new short[]{1}, new short[]{2})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new short[]{1}, new short[]{1})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new short[]{1}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new short[]{1})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new short[][]{new short[]{1}}, new short[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new short[][]{new short[]{1}}, new short[][]{new short[]{1}})
            .isEquals());
  }

  @Test
  public void appendCharArray() {
    assertTrue(new EqualsBuilder()
            .append(new char[]{'1'}, new char[]{'1'})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new char[]{'1'}, new char[]{'1', '2'})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new char[]{'1'}, new char[]{'2'})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new char[]{'1'}, new char[]{'1'})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new char[]{'1'}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new char[]{'1'})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new char[][]{new char[]{'1'}}, new char[]{'1'})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new char[][]{new char[]{'1'}}, new char[][]{new char[]{'1'}})
            .isEquals());
  }

  @Test
  public void appendByteArray() {
    assertTrue(new EqualsBuilder()
            .append(new byte[]{1}, new byte[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new byte[]{1}, new byte[]{1, 2})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new byte[]{1}, new byte[]{2})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new byte[]{1}, new byte[]{1})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new byte[]{1}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new byte[]{1})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new byte[][]{new byte[]{1}}, new byte[]{1})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new byte[][]{new byte[]{1}}, new byte[][]{new byte[]{1}})
            .isEquals());
  }

  @Test
  public void appendBoleanArray() {
    assertTrue(new EqualsBuilder()
            .append(new boolean[]{true}, new boolean[]{true})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new boolean[]{true}, new boolean[]{true, false})
            .isEquals());
    assertFalse(new EqualsBuilder()
            .append(new boolean[]{true}, new boolean[]{false})
            .isEquals());

    // chaining
    assertFalse(new EqualsBuilder()
            .appendSuper(false)
            .append(new boolean[]{true}, new boolean[]{true})
            .isEquals());

    // nulls
    assertFalse(new EqualsBuilder()
            .append(new boolean[]{true}, null)
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(null, new boolean[]{true})
            .isEquals());

    // multi dimensional arrays
    assertFalse(new EqualsBuilder()
            .append(new boolean[][]{new boolean[]{true}}, new boolean[]{true})
            .isEquals());

    assertFalse(new EqualsBuilder()
            .append(new boolean[][]{new boolean[]{true}}, new boolean[][]{new boolean[]{true}})
            .isEquals());
  }

}
