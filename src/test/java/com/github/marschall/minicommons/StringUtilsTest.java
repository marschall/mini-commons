package com.github.marschall.minicommons;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

  @Test
  public void toStringLengthInt() {
    assertEquals(1, StringUtils.toStringLength(0));
    assertEquals(1, StringUtils.toStringLength(9));

    assertEquals(2, StringUtils.toStringLength(10));
    assertEquals(2, StringUtils.toStringLength(99));

    assertEquals(3, StringUtils.toStringLength(100));
    assertEquals(3, StringUtils.toStringLength(999));

    assertEquals(4, StringUtils.toStringLength(1_000));
    assertEquals(4, StringUtils.toStringLength(9_999));

    assertEquals(5, StringUtils.toStringLength(10_000));
    assertEquals(5, StringUtils.toStringLength(99_999));

    assertEquals(6, StringUtils.toStringLength(100_000));
    assertEquals(6, StringUtils.toStringLength(999_999));

    assertEquals(7, StringUtils.toStringLength(1_000_000));
    assertEquals(7, StringUtils.toStringLength(9_999_999));

    assertEquals(8, StringUtils.toStringLength(10_000_000));
    assertEquals(8, StringUtils.toStringLength(99_999_999));

    assertEquals(9, StringUtils.toStringLength(100_000_000));
    assertEquals(9, StringUtils.toStringLength(999_999_999));

    assertEquals(10, StringUtils.toStringLength(1_000_000_000));
    assertEquals(10, StringUtils.toStringLength(Integer.MAX_VALUE));
  }

  @Test
  public void toStringLengthLong() {
    assertEquals(1, StringUtils.toStringLength(0L));
    assertEquals(1, StringUtils.toStringLength(9L));

    assertEquals(2, StringUtils.toStringLength(10L));
    assertEquals(2, StringUtils.toStringLength(99L));

    assertEquals(3, StringUtils.toStringLength(100L));
    assertEquals(3, StringUtils.toStringLength(999L));

    assertEquals(4, StringUtils.toStringLength(1_000L));
    assertEquals(4, StringUtils.toStringLength(9_999L));

    assertEquals(5, StringUtils.toStringLength(10_000L));
    assertEquals(5, StringUtils.toStringLength(99_999L));

    assertEquals(6, StringUtils.toStringLength(100_000L));
    assertEquals(6, StringUtils.toStringLength(999_999L));

    assertEquals(7, StringUtils.toStringLength(1_000_000L));
    assertEquals(7, StringUtils.toStringLength(9_999_999L));

    assertEquals(8, StringUtils.toStringLength(10_000_000L));
    assertEquals(8, StringUtils.toStringLength(99_999_999L));

    assertEquals(9, StringUtils.toStringLength(100_000_000L));
    assertEquals(9, StringUtils.toStringLength(999_999_999L));

    assertEquals(10, StringUtils.toStringLength(1_000_000_000L));
    assertEquals(10, StringUtils.toStringLength((long) Integer.MAX_VALUE));
    assertEquals(10, StringUtils.toStringLength(9_999_999_999L));

    assertEquals(11, StringUtils.toStringLength(10_000_000_000L));
    assertEquals(11, StringUtils.toStringLength(99_999_999_999L));

    assertEquals(19, StringUtils.toStringLength(1_000_000_000_000_000_000L));
    assertEquals(19, StringUtils.toStringLength(Long.MAX_VALUE));
  }

  @Test
  public void leftPadInteger() {
    assertEquals("***", StringUtils.leftPad((Integer) null, 3, '*'));
    assertEquals("001", StringUtils.leftPad(1, 3, '0'));
    assertEquals("111", StringUtils.leftPad(111, 3, '0'));
    assertEquals("1111", StringUtils.leftPad(1111, 3, '0'));
  }

  @Test
  public void leftPadLong() {
    assertEquals("***", StringUtils.leftPad((Long) null, 3, '*'));
    assertEquals("001", StringUtils.leftPad(1L, 3, '0'));
    assertEquals("111", StringUtils.leftPad(111L, 3, '0'));
    assertEquals("1111", StringUtils.leftPad(1111L, 3, '0'));
  }

  @Test
  public void leftPadStringIntoStringBuilder() {
    StringBuilder buf = new StringBuilder();
    StringUtils.leftPadInto((String) null, 3, '*', buf);
    assertEquals("***", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("1", 3, '0', buf);
    assertEquals("001", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("111", 3, '0', buf);
    assertEquals("111", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("1111", 3, '0', buf);
    assertEquals("1111", buf.toString());
  }

  @Test
  public void leftPadStringIntoAppendable() throws IOException {
    Appendable buf = new StringBuilder();
    StringUtils.leftPadInto((String) null, 3, '*', buf);
    assertEquals("***", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("1", 3, '0', buf);
    assertEquals("001", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("111", 3, '0', buf);
    assertEquals("111", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto("1111", 3, '0', buf);
    assertEquals("1111", buf.toString());
  }

  @Test
  public void leftPadIntegerIntoStringBuilder() {
    StringBuilder buf = new StringBuilder();
    StringUtils.leftPadInto((Integer) null, 3, '*', buf);
    assertEquals("***", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(1, 3, '0', buf);
    assertEquals("001", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(111, 3, '0', buf);
    assertEquals("111", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(1111, 3, '0', buf);
    assertEquals("1111", buf.toString());
  }

  @Test
  public void leftPadLongIntoStringBuilder() {
    StringBuilder buf = new StringBuilder();
    StringUtils.leftPadInto((Long) null, 3, '*', buf);
    assertEquals("***", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(1L, 3, '0', buf);
    assertEquals("001", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(111L, 3, '0', buf);
    assertEquals("111", buf.toString());

    buf = new StringBuilder();
    StringUtils.leftPadInto(1111L, 3, '0', buf);
    assertEquals("1111", buf.toString());
  }

}
