package com.github.marschall.minicommons;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CommonsBenchmark {

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
            .include(".*CommonsBenchmark.*")
            .warmupIterations(10)
            .measurementIterations(10)
            .forks(10)
            .build();
    new Runner(options).run();
  }

  @Benchmark
  public boolean equalsMini(TestState state) {
    return state.oneMini.equals(state.twoMini);
  }

  @Benchmark
  public boolean equalsCommons(TestState state) {
    return state.oneCommons.equals(state.twoCommons);
  }

  @Benchmark
  public boolean equalsManual(TestState state) {
    return state.oneManual.equals(state.twoManual);
  }

  @Benchmark
  public boolean equalsReflection(TestState state) {
    return state.oneReflection.equals(state.twoReflection);
  }

  @Benchmark
  public int hashCodeMini(TestState state) {
    return state.oneMini.hashCode();
  }

  @Benchmark
  public int hashCodeCommons(TestState state) {
    return state.oneCommons.hashCode();
  }

  @Benchmark
  public int hashCodeManual(TestState state) {
    return state.oneManual.hashCode();
  }

  @Benchmark
  public int hashCodeReflection(TestState state) {
    return state.oneReflection.hashCode();
  }

  @Benchmark
  public boolean arrayEqualsMini(TestState state) {
    return state.oneArrayMini.equals(state.twoArrayMini);
  }

  @Benchmark
  public boolean arrayEqualsCommons(TestState state) {
    return state.oneArrayCommons.equals(state.twoArrayCommons);
  }

  @Benchmark
  public int arrayHashCodeMini(TestState state) {
    return state.oneArrayMini.hashCode();
  }

  @Benchmark
  public int arrayHashCodeCommons(TestState state) {
    return state.oneArrayCommons.hashCode();
  }

  @Benchmark
  public int longHashCodeMini(TestState state) {
    return state.oneLongCommons.hashCode();
  }

  @Benchmark
  public int longHashCodeCommons(TestState state) {
    return state.oneLongCommons.hashCode();
  }


  @State(Scope.Thread)
  public static class TestState {

    Model oneMini;
    Model twoMini;

    ArrayModel oneArrayMini;
    ArrayModel twoArrayMini;

    LongModel oneLongMini;
    LongModel twoLongMini;

    CommonsModel oneCommons;
    CommonsModel twoCommons;

    CommonsArrayModel oneArrayCommons;
    CommonsArrayModel twoArrayCommons;

    CommonsLongModel oneLongCommons;
    CommonsLongModel twoLongCommons;

    ManualModel oneManual;
    ManualModel twoManual;

    ReflectionModel oneReflection;
    ReflectionModel twoReflection;

    @Setup(Level.Iteration)
    public void setup() {
      this.oneMini = new Model(1L, "not");
      this.twoMini = new Model(1L, "equal");

      this.oneArrayMini = new ArrayModel(1L, "name1", "not");
      this.twoArrayMini = new ArrayModel(1L, "name1", "equal");

      this.oneLongMini = new LongModel(1L, 1L);
      this.twoLongMini = new LongModel(1L, 2L);

      this.oneCommons = new CommonsModel(1L, "not");
      this.twoCommons = new CommonsModel(1L, "equal");

      this.oneArrayCommons = new CommonsArrayModel(1L, "name1", "not");
      this.twoArrayCommons = new CommonsArrayModel(1L, "name1", "equal");

      this.oneLongCommons = new CommonsLongModel(1L, 1L);
      this.twoLongCommons = new CommonsLongModel(1L, 2L);

      this.oneManual = new ManualModel(1L, "not");
      this.twoManual = new ManualModel(1L, "equal");

      this.oneReflection = new ReflectionModel(1L, "not");
      this.twoReflection = new ReflectionModel(1L, "equal");
    }
  }

}
