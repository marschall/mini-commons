package com.github.marschall.minicommons;

import java.util.Arrays;
import java.util.Objects;

/**
 * Assists in implementing {@link Object#hashCode()} methods.
 *
 * <p>
 * This class enables a good <code>hashCode</code> method to be built for any class. It follows the rules laid out in
 * the book <a href="http://www.oracle.com/technetwork/java/effectivejava-136174.html">Effective Java</a> by Joshua Bloch. Writing a
 * good <code>hashCode</code> method is actually quite difficult. This class aims to simplify the process.
 * </p>
 *
 * <p>
 * The following is the approach taken. When appending a data field, the current total is multiplied by the
 * multiplier then a relevant value
 * for that data type is added. For example, if the current hashCode is 17, and the multiplier is 37, then
 * appending the integer 45 will create a hashcode of 674, namely 17 * 37 + 45.
 * </p>
 *
 * <p>
 * All relevant fields from the object should be included in the <code>hashCode</code> method. Derived fields may be
 * excluded. In general, any field used in the <code>equals</code> method must be used in the <code>hashCode</code>
 * method.
 * </p>
 *
 * <p>
 * To use this class write code as follows:
 * </p>
 *
 * <pre><code>
 * public class Person {
 *   String name;
 *   int age;
 *   boolean smoker;
 *   ...
 *
 *   public int hashCode() {
 *     return new HashCodeBuilder()
 *       .append(name)
 *       .append(age)
 *       .append(smoker)
 *       .toHashCode();
 *   }
 * }
 * </code></pre>
 *
 * <p>
 * If required, the superclass <code>hashCode()</code> can be added using {@link #appendSuper}.
 * </p>
 */
public final class HashCodeBuilder {

  private static final int MULTPLIER = 31;

  /**
   * Running total of the hashCode.
   */
  private int total;

  /**
   * <p>
   * Uses two hard coded choices for the constants needed to build a <code>hashCode</code>.
   * </p>
   */
  public HashCodeBuilder() {
    total = 17;
  }

  /**
   * Append a <code>hashCode</code> for a <code>boolean</code>.
   *
   * @param value
   *            the boolean to add to the <code>hashCode</code>
   * @return this
   * @see java.lang.Boolean#hashCode(boolean)
   */
  public HashCodeBuilder append(boolean value) {
    total = total * MULTPLIER + Boolean.hashCode(value);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>boolean</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(boolean[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>byte</code>.
   *
   * @param value
   *            the byte to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(byte value) {
    total = total * MULTPLIER + value;
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>byte</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(byte[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>char</code>.
   *
   * @param value
   *            the char to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(char value) {
    total = total * MULTPLIER + value;
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>char</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(char[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>double</code>.
   *
   * @param value
   *            the double to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(double value) {
    total = total * MULTPLIER + Double.hashCode(value);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>double</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(double[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>float</code>.
   *
   * @param value
   *            the float to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(float value) {
    total = total * MULTPLIER + Float.hashCode(value);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>float</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(float[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>int</code>.
   *
   * @param value
   *            the int to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(int value) {
    total = total * MULTPLIER + value;
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>int</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(int[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>long</code>.
   *
   * @param value
   *            the long to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(long value) {
    total = total * MULTPLIER + Long.hashCode(value);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>long</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(long[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>Object</code>.
   *
   * @param object
   *            the Object to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(Object object) {
    total = total * MULTPLIER + Objects.hashCode(object);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>Object</code>.
   *
   * <p>Unlike {@link #append(Object)} also deals with arrays.</p>
   *
   * @param object
   *            the Object to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder appendDeep(Object object) {
    if (object == null) {
      total = total * MULTPLIER;

    } else {
      if(object.getClass().isArray()) {
        // 'Switch' on type of array, to dispatch to the correct handler
        // This handles multi dimensional arrays
        if (object instanceof long[]) {
          append((long[]) object);
        } else if (object instanceof int[]) {
          append((int[]) object);
        } else if (object instanceof short[]) {
          append((short[]) object);
        } else if (object instanceof char[]) {
          append((char[]) object);
        } else if (object instanceof byte[]) {
          append((byte[]) object);
        } else if (object instanceof double[]) {
          append((double[]) object);
        } else if (object instanceof float[]) {
          append((float[]) object);
        } else if (object instanceof boolean[]) {
          append((boolean[]) object);
        } else {
          // Not an array of primitives
          appendDeep((Object[]) object);
        }
      } else {
        total = total * MULTPLIER + object.hashCode();
      }
    }
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>Object</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(Object[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for an <code>Object</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder appendDeep(Object[] object) {
    total = total * MULTPLIER + Arrays.deepHashCode(object);
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>short</code>.
   *
   * @param value
   *            the short to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(short value) {
    total = total * MULTPLIER + value;
    return this;
  }

  /**
   * Append a <code>hashCode</code> for a <code>short</code> array.
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(short[] array) {
    total = total * MULTPLIER + Arrays.hashCode(array);
    return this;
  }

  /**
   * Adds the result of super.hashCode() to this builder.
   *
   * @param superHashCode
   *            the result of calling <code>super.hashCode()</code>
   * @return this HashCodeBuilder, used to chain calls.
   */
  public HashCodeBuilder appendSuper(int superHashCode) {
    total = total * MULTPLIER + superHashCode;
    return this;
  }

  /**
   * Return the computed <code>hashCode</code>.
   *
   * @return <code>hashCode</code> based on the fields appended
   */
  public int toHashCode() {
    return total;
  }

}
