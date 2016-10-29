package com.github.marschall.minicommons;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StringUtilsBenchmark {

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
            .include(".*StringUtilsBenchmark.*")
            .warmupIterations(8)
            .measurementIterations(8)
            .forks(4)
            .build();
    new Runner(options).run();
  }

  private String smallString;
  private String mediumString;

  @Setup
  public void setup() {
    this.smallString = "0";
    this.mediumString = "1234567890";
  }

  @Benchmark
  public String originalSmall() {
    return leftPadOriginal(this.smallString, 9, '0');
  }

  @Benchmark
  public String fillSmall() {
    return leftPadFill(this.smallString, 9, '0');
  }

  @Benchmark
  public String fillByteSmall() {
    return leftPadFillByte(this.smallString, 9, '0');
  }

  @Benchmark
  public String builderSmall() {
    return leftPadBuilder(this.smallString, 9, '0');
  }

  @Benchmark
  public String originalMedium() {
    return leftPadOriginal(this.mediumString, 20, '0');
  }

  @Benchmark
  public String fillMedium() {
    return leftPadFill(this.mediumString, 20, '0');
  }

  @Benchmark
  public String fillByteMedium() {
    return leftPadFillByte(this.mediumString, 20, '0');
  }

  @Benchmark
  public String builderMedium() {
    return leftPadBuilder(this.mediumString, 20, '0');
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
