package com.github.marschall.minicommons;

import java.io.IOException;

/**
 * Utility methods for dealing with {@link String}s.
 */
public final class StringUtils {

  private static final int[] INT_LENGTHS = new int[] {
      0,
      9,
      99,
      999,
      9_999,
      99_999,
      999_999,
      9_999_999,
      99_999_999,
      999_999_999
  };

  private static final long[] LONG_LENGTHS = new long[] {
      0L,
      9L,
      99L,
      999L,
      9_999L,
      99_999L,
      999_999L,
      9_999_999L,
      99_999_999L,
      999_999_999L,
      9_999_999_999L,
      99_999_999_999L,
      999_999_999_999L,
      9_999_999_999_999L,
      99_999_999_999_999L,
      999_999_999_999_999L,
      9_999_999_999_999_999L,
      99_999_999_999_999_999L,
      999_999_999_999_999_999L,
  };

  private StringUtils() {
    throw new AssertionError("not instantiable");
  }

  static int toStringLength(Integer i) {
    if (i == null) {
      return 0;
    }
    return toStringLength(i.intValue());
  }

  static int toStringLength(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("can't padd negative lengths");
    }
    int length = 1;
    while (length < INT_LENGTHS.length && i > INT_LENGTHS[length]) {
      length += 1;
    }
    return length;
  }

  static int toStringLength(Long l) {
    if (l == null) {
      return 0;
    }
    return toStringLength(l.longValue());
  }

  static int toStringLength(long l) {
    if (l < 0) {
      throw new IllegalArgumentException("can't padd negative lengths");
    }
    int length = 1;
    while (length < LONG_LENGTHS.length && l > LONG_LENGTHS[length]) {
      length += 1;
    }
    return length;
  }

  private static void repeatInto(char padChar, int count, StringBuilder buf) {
    while (count > 0) {
      buf.append(padChar);
      count -= 1;
    }
  }

  private static void repeatInto(char padChar, int count, Appendable appendable) throws IOException {
    while (count > 0) {
      appendable.append(padChar);
      count -= 1;
    }
  }

  public static void leftPadInto(String str, int size, char padChar, Appendable appendable) throws IOException {
    int toAdd = size - str.length();
    repeatInto(padChar, toAdd, appendable);
    appendable.append(str);
  }

  public static void leftPadInto(String str, int size, char padChar, StringBuilder buf) {
    int toAdd = size - str.length();
    repeatInto(padChar, toAdd, buf);
    buf.append(str);
  }

  public static void leftPadInto(Integer i, int size, char padChar, StringBuilder buf) {
    if (i == null) {
      repeatInto(padChar, size, buf);
      return;
    }
    buf.append(i.intValue());
  }

  public static void leftPadInto(Long l, int size, char padChar, StringBuilder buf) {
    if (l == null) {
      repeatInto(padChar, size, buf);
      return;
    }
    buf.append(l.longValue());
  }

  /**
   * Left pad an Integer with a specified character to a specified length.
   *
   * <p>If the given Integer is {@code null} then only the pad character
   * will be in the final String.</p>
   *
   * <pre><code>
   * StringUtils.leftPad((Integer) null, 3, '*') = "***"
   * StringUtils.leftPad(1, 3, '0')              = "001"
   * StringUtils.leftPad(111, 3, '0')            = "111"
   * StringUtils.leftPad(1111, 3, '0')           = "1111"
   * </code></pre>
   *
   * @param i the Integer to pad, may be {@code null} but not negative
   * @param size the size to pad to, not negative
   * @param padChar the character to pad with
   * @return left padded Integer
   */
  public static String leftPad(Integer i, int size, char padChar) {
    StringBuilder buf = new StringBuilder(size);
    int repeat = size - toStringLength(i);
    repeatInto(padChar, repeat, buf);
    if (i != null) {
      buf.append(i.intValue());
    }
    return buf.toString();
  }

  /**
   * Left pad an Long with a specified character to a specified length.
   *
   * <p>If the given Long is {@code null} then only the pad character
   * will be in the final String.</p>
   *
   * <pre><code>
   * StringUtils.leftPad((Long) null, 3, '*') = "***"
   * StringUtils.leftPad(1, 3, '0')              = "001"
   * StringUtils.leftPad(111, 3, '0')            = "111"
   * StringUtils.leftPad(1111, 3, '0')           = "1111"
   * </code></pre>
   *
   * @param l the Long to pad, may be {@code null} but not negative
   * @param size the size to pad to, not negative
   * @param padChar the character to pad with
   * @return left padded Long
   */
  public static String leftPad(Long l, int size, char padChar) {
    StringBuilder buf = new StringBuilder(size);
    int repeat = size - toStringLength(l);
    repeatInto(padChar, repeat, buf);
    if (l != null) {
      buf.append(l.longValue());
    }
    return buf.toString();
  }


}