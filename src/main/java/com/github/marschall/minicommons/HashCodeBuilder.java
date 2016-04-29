package com.github.marschall.minicommons;

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
 * <pre>
 * public class Person {
 *   String name;
 *   int age;
 *   boolean smoker;
 *   ...
 *
 *   public int hashCode() {
 *     // you pick a hard-coded, randomly chosen, non-zero, odd number
 *     // ideally different for each class
 *     return new HashCodeBuilder(17, 37).
 *       append(name).
 *       append(age).
 *       append(smoker).
 *       toHashCode();
 *   }
 * }
 * </pre>
 *
 * <p>
 * If required, the superclass <code>hashCode()</code> can be added using {@link #appendSuper}.
 * </p>
 *
 * <p>
 * Alternatively, there is a method that uses reflection to determine the fields to test. Because these fields are
 * usually private, the method, <code>reflectionHashCode</code>, uses <code>AccessibleObject.setAccessible</code>
 * to change the visibility of the fields. This will fail under a security manager, unless the appropriate permissions
 * are set up correctly. It is also slower than testing explicitly.
 * </p>
 *
 * <p>
 * A typical invocation for this method would look like:
 * </p>
 *
 * <pre>
 * public int hashCode() {
 *   return HashCodeBuilder.reflectionHashCode(this);
 * }
 * </pre>
 *
 * @since 1.0
 * @version $Id: HashCodeBuilder.java 1627889 2014-09-26 21:19:12Z djones $
 */
public final class HashCodeBuilder {

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
   * <p>
   * Append a <code>hashCode</code> for a <code>boolean</code>.
   * </p>
   * <p>
   * This adds <code>1</code> when true, and <code>0</code> when false to the <code>hashCode</code>.
   * </p>
   * <p>
   * This is in contrast to the standard <code>java.lang.Boolean.hashCode</code> handling, which computes
   * a <code>hashCode</code> value of <code>1231</code> for <code>java.lang.Boolean</code> instances
   * that represent <code>true</code> or <code>1237</code> for <code>java.lang.Boolean</code> instances
   * that represent <code>false</code>.
   * </p>
   * <p>
   * This is in accordance with the <i>Effective Java</i> design.
   * </p>
   *
   * @param value
   *            the boolean to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(boolean value) {
    total = total * 37 + (value ? 0 : 1);
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>boolean</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(boolean[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (boolean element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>byte</code>.
   * </p>
   *
   * @param value
   *            the byte to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(byte value) {
    total = total * 37 + value;
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>byte</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(byte[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (byte element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>char</code>.
   * </p>
   *
   * @param value
   *            the char to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(char value) {
    total = total * 37 + value;
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>char</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(char[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (char element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>double</code>.
   * </p>
   *
   * @param value
   *            the double to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(double value) {
    return append(Double.doubleToLongBits(value));
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>double</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(double[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (double element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>float</code>.
   * </p>
   *
   * @param value
   *            the float to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(float value) {
    total = total * 37 + Float.floatToIntBits(value);
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>float</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(float[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (float element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for an <code>int</code>.
   * </p>
   *
   * @param value
   *            the int to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(int value) {
    total = total * 37 + value;
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for an <code>int</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(int[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (int element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>long</code>.
   * </p>
   *
   * @param value
   *            the long to add to the <code>hashCode</code>
   * @return this
   */
  // NOTE: This method uses >> and not >>> as Effective Java and
  //       Long.hashCode do. Ideally we should switch to >>> at
  //       some stage. There are backwards compat issues, so
  //       that will have to wait for the time being. cf LANG-342.
  public HashCodeBuilder append(long value) {
    total = total * 37 + ((int) (value ^ (value >> 32)));
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>long</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(long[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (long element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for an <code>Object</code>.
   * </p>
   *
   * @param object
   *            the Object to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(Object object) {
    if (object == null) {
      total = total * 37;
    } else {
      total = total * 37 + object.hashCode();
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for an <code>Object</code>.
   * </p>
   *
   * <p>Unlike {@link #append(Object)} also deals with arrays.</p>
   *
   * @param object
   *            the Object to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder appendGeneric(Object object) {
    if (object == null) {
      total = total * 37;

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
          append((Object[]) object);
        }
      } else {
        total = total * 37 + object.hashCode();
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for an <code>Object</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(Object[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (Object element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>short</code>.
   * </p>
   *
   * @param value
   *            the short to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(short value) {
    total = total * 37 + value;
    return this;
  }

  /**
   * <p>
   * Append a <code>hashCode</code> for a <code>short</code> array.
   * </p>
   *
   * @param array
   *            the array to add to the <code>hashCode</code>
   * @return this
   */
  public HashCodeBuilder append(short[] array) {
    if (array == null) {
      total = total * 37;
    } else {
      for (short element : array) {
        append(element);
      }
    }
    return this;
  }

  /**
   * <p>
   * Adds the result of super.hashCode() to this builder.
   * </p>
   *
   * @param superHashCode
   *            the result of calling <code>super.hashCode()</code>
   * @return this HashCodeBuilder, used to chain calls.
   * @since 2.0
   */
  public HashCodeBuilder appendSuper(int superHashCode) {
    total = total * 37 + superHashCode;
    return this;
  }

  /**
   * <p>
   * Return the computed <code>hashCode</code>.
   * </p>
   *
   * @return <code>hashCode</code> based on the fields appended
   */
  public int toHashCode() {
    return total;
  }

}
