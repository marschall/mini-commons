package com.github.marschall.minicommons;

import java.util.Arrays;
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
 * <pre><code>
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
 * </code></pre>
 */
public final class EqualsBuilder {

  /**
   * If the fields tested are equals.
   * The default value is <code>true</code>.
   */
  private boolean isEquals;

  /**
   * Constructor for EqualsBuilder.
   *
   * <p>Starts off assuming that equals is <code>true</code>.</p>
   * @see Object#equals(Object)
   */
  public EqualsBuilder() {
    isEquals = true;
  }

  /**
   * Adds the result of <code>super.equals()</code> to this builder.
   *
   * @param superEquals  the result of calling <code>super.equals()</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder appendSuper(boolean superEquals) {
      if (isEquals == false) {
          return this;
      }
      isEquals = superEquals;
      return this;
  }

  /**
   * Test if two <code>Object</code>s are equal using their
   * <code>equals</code> method.
   *
   * @param lhs  the left hand object
   * @param rhs  the right hand object
   * @return EqualsBuilder - used to chain calls
   * @see Objects#deepEquals(Object, Object)
   */
  public EqualsBuilder append(Object lhs, Object rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Objects.equals(lhs, rhs);
    return this;
  }

  /**
   * Test if two <code>Object</code>s are equal using their
   * <code>equals</code> method.
   *
   * <p>Unlike {@link #append(Object, Object)} also deals with
   * arrays.</p>
   *
   * @param lhs  the left hand object
   * @param rhs  the right hand object
   * @return EqualsBuilder - used to chain calls
   * @see Objects#deepEquals(Object, Object)
   */
  public EqualsBuilder appendDeep(Object lhs, Object rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Objects.deepEquals(lhs, rhs);
    return this;
  }

  /**
   * Test if two <code>long</code> s are equal.
   *
   * @param lhs
   *                  the left hand <code>long</code>
   * @param rhs
   *                  the right hand <code>long</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(long lhs, long rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Test if two <code>int</code>s are equal.
   *
   * @param lhs  the left hand <code>int</code>
   * @param rhs  the right hand <code>int</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(int lhs, int rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Test if two <code>short</code>s are equal.
   *
   * @param lhs  the left hand <code>short</code>
   * @param rhs  the right hand <code>short</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(short lhs, short rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Test if two <code>char</code>s are equal.
   *
   * @param lhs  the left hand <code>char</code>
   * @param rhs  the right hand <code>char</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(char lhs, char rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Test if two <code>byte</code>s are equal.
   *
   * @param lhs  the left hand <code>byte</code>
   * @param rhs  the right hand <code>byte</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(byte lhs, byte rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Test if two <code>double</code>s are equal by testing that the
   * pattern of bits returned by <code>doubleToLong</code> are equal.
   *
   * <p>This handles NaNs, Infinities, and <code>-0.0</code>.</p>
   *
   * <p>It is compatible with the hash code generated by
   * <code>HashCodeBuilder</code>.</p>
   *
   * @param lhs  the left hand <code>double</code>
   * @param rhs  the right hand <code>double</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(double lhs, double rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (Double.doubleToLongBits(lhs) == Double.doubleToLongBits(rhs));
    return this;
  }

  /**
   * Test if two <code>float</code>s are equal byt testing that the
   * pattern of bits returned by doubleToLong are equal.
   *
   * <p>This handles NaNs, Infinities, and <code>-0.0</code>.</p>
   *
   * <p>It is compatible with the hash code generated by
   * <code>HashCodeBuilder</code>.</p>
   *
   * @param lhs  the left hand <code>float</code>
   * @param rhs  the right hand <code>float</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(float lhs, float rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (Float.floatToIntBits(lhs) == Float.floatToIntBits(rhs));
    return this;
  }

  /**
   * Test if two <code>booleans</code>s are equal.
   *
   * @param lhs  the left hand <code>boolean</code>
   * @param rhs  the right hand <code>boolean</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(boolean lhs, boolean rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = (lhs == rhs);
    return this;
  }

  /**
   * Performs a one level comparison of two <code>Object</code> arrays.
   *
   * @param lhs  the left hand <code>Object[]</code>
   * @param rhs  the right hand <code>Object[]</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(Object[] lhs, Object[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
    return this;
  }

  /**
   * Performs a deep comparison of two <code>Object</code> arrays.
   *
   * <p>This also will be called for the top level of
   * multi-dimensional, ragged, and multi-typed arrays.</p>
   *
   * @param lhs  the left hand <code>Object[]</code>
   * @param rhs  the right hand <code>Object[]</code>
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder appendDeep(Object[] lhs, Object[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.deepEquals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(long[] lhs, long[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(int[] lhs, int[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(short[] lhs, short[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(char[] lhs, char[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(byte[] lhs, byte[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(double[] lhs, double[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(float[] lhs, float[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
   * @return EqualsBuilder - used to chain calls
   */
  public EqualsBuilder append(boolean[] lhs, boolean[] rhs) {
    if (isEquals == false) {
      return this;
    }
    isEquals = Arrays.equals(lhs, rhs);
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
