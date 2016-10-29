package com.github.marschall.minicommons;

import java.io.IOException;

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
    StringBuilder buf = new StringBuilder(size);
    int repeat = size - toStringLength(i);
    repeatInto(padChar, repeat, buf);
    if (i != null) {
      buf.append(i.intValue());
    }
    return buf.toString();
  }

  public String leftPad(Long l, int size, char padChar) {
    StringBuilder buf = new StringBuilder(size);
    int repeat = size - toStringLength(l);
    repeatInto(padChar, repeat, buf);
    if (l != null) {
      buf.append(l.longValue());
    }
    return buf.toString();
  }


}
