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
  public int hashCodeMini(TestState state) {
    return state.oneMini.hashCode();
  }

  @Benchmark
  public int hashCodeCommons(TestState state) {
    return state.oneCommons.hashCode();
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


  @State(Scope.Thread)
  public static class TestState {

    ModelClass oneMini;
    ModelClass twoMini;

    ArrayModel oneArrayMini;
    ArrayModel twoArrayMini;

    CommonsModelClass oneCommons;
    CommonsModelClass twoCommons;

    CommonsArrayModel oneArrayCommons;
    CommonsArrayModel twoArrayCommons;

    @Setup(Level.Iteration)
    public void setup() {
      this.oneMini = new ModelClass(1L, "name1");
      this.twoMini = new ModelClass(1L, "name2");

      this.oneArrayMini = new ArrayModel(1L, "name1", "desc1");
      this.twoArrayMini = new ArrayModel(1L, "name1", "desc2");

      this.oneCommons = new CommonsModelClass(1L, "name1");
      this.twoCommons = new CommonsModelClass(1L, "name2");

      this.oneArrayCommons = new CommonsArrayModel(1L, "name1", "desc1");
      this.twoArrayCommons = new CommonsArrayModel(1L, "name1", "desc2");
    }
  }

}
