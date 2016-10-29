package com.github.marschall.minicommons;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void toStringLength() {
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

}
