package com.github.marschall.minicommons;

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
    return StringUtils.leftPadOriginal(this.smallString, 9, '0');
  }

  @Benchmark
  public String fillSmall() {
    return StringUtils.leftPadFill(this.smallString, 9, '0');
  }

  @Benchmark
  public String fillByteSmall() {
    return StringUtils.leftPadFillByte(this.smallString, 9, '0');
  }

  @Benchmark
  public String builderSmall() {
    return StringUtils.leftPadBuilder(this.smallString, 9, '0');
  }

  @Benchmark
  public String originalMedium() {
    return StringUtils.leftPadOriginal(this.mediumString, 20, '0');
  }

  @Benchmark
  public String fillMedium() {
    return StringUtils.leftPadFill(this.mediumString, 20, '0');
  }

  @Benchmark
  public String fillByteMedium() {
    return StringUtils.leftPadFillByte(this.mediumString, 20, '0');
  }

  @Benchmark
  public String builderMedium() {
    return StringUtils.leftPadBuilder(this.mediumString, 20, '0');
  }

}
