package com.github.marschall.minicommons;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

  private void repeatInto(char padChar, int count, StringBuilder buf) {
    while (count > 0) {
      buf.append(padChar);
      count -= 1;
    }
  }

  private void repeatInto(char padChar, int count, Appendable appendable) throws IOException {
    while (count > 0) {
      appendable.append(padChar);
      count -= 1;
    }
  }

  public void leftPadInto(String str, int size, char padChar, Appendable appendable) throws IOException {
    int toAdd = size - str.length();
    repeatInto(padChar, toAdd, appendable);
    appendable.append(str);
  }

  public void leftPadInto(String str, int size, char padChar, StringBuilder buf) {
    int toAdd = size - str.length();
    repeatInto(padChar, toAdd, buf);
    buf.append(str);
  }

  public void leftPadInto(Integer i, int size, char padChar, StringBuilder buf) {
    if (i == null) {
      repeatInto(padChar, size, buf);
      return;
    }
    // TODO
    buf.append(i.intValue());
  }

  public void leftPadInto(Long l, int size, char padChar, StringBuilder buf) {
    if (l == null) {
      repeatInto(padChar, size, buf);
      return;
    }
    // TODO
    buf.append(l.longValue());
  }

  public String leftPad(Integer i, int size, char padChar) {
    // TODO
    return null;
  }

  public String leftPad(Long l, int size, char padChar) {
    // TODO
    return null;
  }

  public static String leftPadOriginal(String str, int size, char padChar) {
    if (str == null) {
      return null;
    }
    int pads = size - str.length();
    if (pads <= 0) {
      return str; // returns original String when possible
    }
    return repeat(padChar, pads).concat(str);
  }

  private static String repeat(char ch, int repeat) {
    char[] buf = new char[repeat];
    for (int i = 0; i < repeat; ++i) {
      buf[i] = ch;
    }
    return new String(buf);
  }

  public static String leftPadFill(String str, int size, char padChar) {
    if (str == null) {
      return null;
    }
    int pads = size - str.length();
    if (pads <= 0) {
      return str; // returns original String when possible
    }
    return repeatFill(padChar, pads).concat(str);
  }

  private static String repeatFill(char ch, int repeat) {
    char[] buf = new char[repeat];
    Arrays.fill(buf, ch);
    return new String(buf);
  }

  public static String leftPadFillByte(String str, int size, char padChar) {
    if (str == null) {
      return null;
    }
    int pads = size - str.length();
    if (pads <= 0) {
      return str; // returns original String when possible
    }
    String prefix;
    if (padChar <= 255) {
      prefix = repeatFillLatin1(padChar, pads);
    } else {
      prefix = repeatFill(padChar, pads);
    }
    return prefix.concat(str);
  }

  private static String repeatFillLatin1(char ch, int repeat) {
    byte[] buf = new byte[repeat];
    Arrays.fill(buf, (byte) ch);
    return new String(buf, StandardCharsets.ISO_8859_1);
  }

  public static String leftPadBuilder(String str, int size, char padChar) {
    if (str == null) {
      return null;
    }
    int pads = size - str.length();
    if (pads <= 0) {
      return str; // returns original String when possible
    }
    StringBuilder buf = new StringBuilder(size);
    for (int i = 0; i < pads; i++) {
      buf.append(padChar);
    }
    buf.append(str);
    return buf.toString();
  }

}
