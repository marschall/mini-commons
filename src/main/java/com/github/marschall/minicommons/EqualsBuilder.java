package com.github.marschall.minicommons;

import java.util.Objects;

/**
 * Assists in implementing {@link Object#equals(Object)} methods.
 *
 * <p> This class provides methods to build a good equals method for any
 * class. It follows rules laid out in
 * <a href="http://www.oracle.com/technetwork/java/effectivejava-136174.html">Effective Java</a>
 * , by Joshua Bloch. In particular the rule for comparing <code>doubles</code>,
 * <code>floats</code>, and arrays can be tricky. Also, making sure that
 * <code>equals()</code> and <code>hashCode()</code> are consistent can be
 * difficult.</p>
 *
 * <p>Two Objects that compare as equals must generate the same hash code,
 * but two Objects with the same hash code do not have to be equal.</p>
 *
 * <p>All relevant fields should be included in the calculation of equals.
 * Derived fields may be ignored. In particular, any field used in
 * generating a hash code must be used in the equals method, and vice
 * versa.</p>
 *
 * <p>Typical use for the code is as follows:</p>
 * <pre>
 * public boolean equals(Object obj) {
 *   if (obj == null) { return false; }
 *   if (obj == this) { return true; }
 *   if (obj.getClass() != getClass()) {
 *     return false;
 *   }
 *   MyClass rhs = (MyClass) obj;
 *   return new EqualsBuilder()
 *                 .appendSuper(super.equals(obj))
 *                 .append(field1, rhs.field1)
 *                 .append(field2, rhs.field2)
 *                 .append(field3, rhs.field3)
 *                 .isEquals();
 *  }
 * </pre>
 *
 * <p> Alternatively, there is a method that uses reflection to determine
 * the fields to test. Because these fields are usually private, the method,
 * <code>reflectionEquals</code>, uses <code>AccessibleObject.setAccessible</code> to
 * change the visibility of the fields. This will fail under a security
 * manager, unless the appropriate permissions are set up correctly. It is
 * also slower than testing explicitly.  Non-primitive fields are compared using
 * <code>equals()</code>.</p>
 *
 * <p> A typical invocation for this method would look like:</p>
 * <pre>
 * public boolean equals(Object obj) {
 *   return EqualsBuilder.reflectionEquals(this, obj);
 * }
 * </pre>
 */
public final class EqualsBuilder {

  /**
   * If the fields tested are equals.
   * The default value is <code>true</code>.
   */
  private boolean isEquals;

  /**
   * <p>Constructor for EqualsBuilder.</p>
   *
   * <p>Starts off assuming that equals is <code>true</code>.</p>
   * @see Object#equals(Object)
   */
  public EqualsBuilder() {
    isEquals = true;
  }

  /**
   * <p>Test if two <code>Object</code>s are equal using their
   * <code>equals</code> method.</p>
   *
   * @param lhs  the left hand object
   * @param rhs  the right hand object
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(Object lhs, Object rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Objects.equals(lhs, rhs);
    return this;
  }

  /**
   * <p>Test if two <code>Object</code>s are equal using their
   * <code>equals</code> method.</p>
   *
   * <p>Unlike {@link #append(Object, Object)} also deals with
   * arrays.</p>
   *
   * @param lhs  the left hand object
   * @param rhs  the right hand object
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder appendGeneric(Object lhs, Object rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    Class<?> lhsClass = lhs.getClass();
    if (!lhsClass.isArray()) {
      // The simple case, not an array, just test the element
      isEquals = lhs.equals(rhs);
    } else if (lhs.getClass() != rhs.getClass()) {
      // Here when we compare different dimensions, for example: a boolean[][] to a boolean[]
      isEquals = false;
    }
    // 'Switch' on type of array, to dispatch to the correct handler
    // This handles multi dimensional arrays of the same depth
    else if (lhs instanceof long[]) {
      append((long[]) lhs, (long[]) rhs);
    } else if (lhs instanceof int[]) {
      append((int[]) lhs, (int[]) rhs);
    } else if (lhs instanceof short[]) {
      append((short[]) lhs, (short[]) rhs);
    } else if (lhs instanceof char[]) {
      append((char[]) lhs, (char[]) rhs);
    } else if (lhs instanceof byte[]) {
      append((byte[]) lhs, (byte[]) rhs);
    } else if (lhs instanceof double[]) {
      append((double[]) lhs, (double[]) rhs);
    } else if (lhs instanceof float[]) {
      append((float[]) lhs, (float[]) rhs);
    } else if (lhs instanceof boolean[]) {
      append((boolean[]) lhs, (boolean[]) rhs);
    } else {
      // Not an array of primitives
      append((Object[]) lhs, (Object[]) rhs);
    }
    return this;
  }

  /**
   * <p>
   * Test if two <code>long</code> s are equal.
   * </p>
   *
   * @param lhs
   *                  the left hand <code>long</code>
   * @param rhs
   *                  the right hand <code>long</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(long lhs, long rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Test if two <code>int</code>s are equal.</p>
   *
   * @param lhs  the left hand <code>int</code>
   * @param rhs  the right hand <code>int</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(int lhs, int rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Test if two <code>short</code>s are equal.</p>
   *
   * @param lhs  the left hand <code>short</code>
   * @param rhs  the right hand <code>short</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(short lhs, short rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Test if two <code>char</code>s are equal.</p>
   *
   * @param lhs  the left hand <code>char</code>
   * @param rhs  the right hand <code>char</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(char lhs, char rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Test if two <code>byte</code>s are equal.</p>
   *
   * @param lhs  the left hand <code>byte</code>
   * @param rhs  the right hand <code>byte</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(byte lhs, byte rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Test if two <code>double</code>s are equal by testing that the
   * pattern of bits returned by <code>doubleToLong</code> are equal.</p>
   *
   * <p>This handles NaNs, Infinities, and <code>-0.0</code>.</p>
   *
   * <p>It is compatible with the hash code generated by
   * <code>HashCodeBuilder</code>.</p>
   *
   * @param lhs  the left hand <code>double</code>
   * @param rhs  the right hand <code>double</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(double lhs, double rhs) {
    if (isEquals == false) {
      return this;
    }
    return append(Double.doubleToLongBits(lhs), Double.doubleToLongBits(rhs));
  }

  /**
   * <p>Test if two <code>float</code>s are equal byt testing that the
   * pattern of bits returned by doubleToLong are equal.</p>
   *
   * <p>This handles NaNs, Infinities, and <code>-0.0</code>.</p>
   *
   * <p>It is compatible with the hash code generated by
   * <code>HashCodeBuilder</code>.</p>
   *
   * @param lhs  the left hand <code>float</code>
   * @param rhs  the right hand <code>float</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(float lhs, float rhs) {
    if (isEquals == false) {
      return this;
    }
    return append(Float.floatToIntBits(lhs), Float.floatToIntBits(rhs));
  }

  /**
   * <p>Test if two <code>booleans</code>s are equal.</p>
   *
   * @param lhs  the left hand <code>boolean</code>
   * @param rhs  the right hand <code>boolean</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(boolean lhs, boolean rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * <p>Performs a deep comparison of two <code>Object</code> arrays.</p>
   *
   * <p>This also will be called for the top level of
   * multi-dimensional, ragged, and multi-typed arrays.</p>
   *
   * @param lhs  the left hand <code>Object[]</code>
   * @param rhs  the right hand <code>Object[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(Object[] lhs, Object[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>long</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(long, long)} is used.</p>
   *
   * @param lhs  the left hand <code>long[]</code>
   * @param rhs  the right hand <code>long[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(long[] lhs, long[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>int</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(int, int)} is used.</p>
   *
   * @param lhs  the left hand <code>int[]</code>
   * @param rhs  the right hand <code>int[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(int[] lhs, int[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>short</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(short, short)} is used.</p>
   *
   * @param lhs  the left hand <code>short[]</code>
   * @param rhs  the right hand <code>short[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(short[] lhs, short[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>char</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(char, char)} is used.</p>
   *
   * @param lhs  the left hand <code>char[]</code>
   * @param rhs  the right hand <code>char[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(char[] lhs, char[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>byte</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(byte, byte)} is used.</p>
   *
   * @param lhs  the left hand <code>byte[]</code>
   * @param rhs  the right hand <code>byte[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(byte[] lhs, byte[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>double</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(double, double)} is used.</p>
   *
   * @param lhs  the left hand <code>double[]</code>
   * @param rhs  the right hand <code>double[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(double[] lhs, double[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>float</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(float, float)} is used.</p>
   *
   * @param lhs  the left hand <code>float[]</code>
   * @param rhs  the right hand <code>float[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(float[] lhs, float[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Deep comparison of array of <code>boolean</code>. Length and all
   * values are compared.</p>
   *
   * <p>The method {@link #append(boolean, boolean)} is used.</p>
   *
   * @param lhs  the left hand <code>boolean[]</code>
   * @param rhs  the right hand <code>boolean[]</code>
   * @return EqualsBuilder - used to chain calls.
   */
  public EqualsBuilder append(boolean[] lhs, boolean[] rhs) {
    if (isEquals == false) {
      return this;
    }
    if (lhs == rhs) {
      return this;
    }
    if (lhs == null || rhs == null) {
      isEquals = false;
      return this;
    }
    if (lhs.length != rhs.length) {
      isEquals = false;
      return this;
    }
    for (int i = 0; i < lhs.length && isEquals; ++i) {
      append(lhs[i], rhs[i]);
    }
    return this;
  }

  /**
   * <p>Returns <code>true</code> if the fields that have been checked
   * are all equal.</p>
   *
   * @return boolean
   */
  public boolean isEquals() {
    return this.isEquals;
  }

}
