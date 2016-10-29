package com.github.marschall.minicommons;

import static org.junit.Assert.*;

import org.junit.Test;

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

    assertEquals(19, StringUtils.toStringLength(1_000_000_000_000_000_000L));
    assertEquals(19, StringUtils.toStringLength(Long.MAX_VALUE));
  }

}
