Mini Commons [![Build Status](https://travis-ci.org/marschall/mini-commons.svg?branch=master)](https://travis-ci.org/marschall/mini-commons) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/mini-commons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.marschall/mini-commons)
============

Like [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/) but lighter weight.

```xml
<dependency>
    <groupId>com.github.marschall</groupId>
    <artifactId>mini-commons</artifactId>
    <version>0.1.0</version>
</dependency>
```

For example [org.apache.commons.lang3.builder.EqualsBuilder#append(Object, Object)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/builder/EqualsBuilder.html#append(java.lang.Object,%20java.lang.Object)) has a byte code size of 327 which is above the default inline limit of 325. Our version is much smaller because it simply delegates to `java.util.Objects` and can be inlined.

Changes to Apache Commons Lang:

 * Removed reflective `equals` and `hashCode`. You generally use `equals` and `hashCode` for hash based collections, reflection has no place there.
 * Removed initialOddNumbe and multiplierOddNumber from HashCodeBuilder. We have never seen anybody use anything else than the default.
 * EqualsBuilder#append(Object, Object) and HashCodeBuilder#append(Object) are simpler and faster due to removed support for arrays.
   * If you want array support use EqualsBuilder#appendDeep(Object, Object) or HashCodeBuilder#appendDeep(Object). Is this the same pattern that `java.util.Objects` and `java.util.Arrays` use.
 * Delegate to `java.util.Objects`, `java.util.Arrays`, `java.lang.Long`, `java.lang.Double` where possible.
   * This may benefit from [future optimizations](http://openjdk.java.net/jeps/8044082).
 * More JDK compliant hashing:
   * use 31 instead of 37 as a hash code multiplier
   * use JDK hash code for booleans

We have a [micro benchmark suite](https://github.com/marschall/mini-commons/blob/master/src/test/java/com/github/marschall/minicommons/CommonsBenchmark.java) where we get about three times the throughput of Apache Commons Lang for `equals` methods. The throughput is comparable to writing `equals` methods without `EqualsBuilder`.

```
Benchmark                               Mode  Cnt    Score   Error   Units
CommonsBenchmark.equalsCommons         thrpt  100   86.528 ± 0.329  ops/us
CommonsBenchmark.equalsManual          thrpt  100  230.947 ± 1.048  ops/us
CommonsBenchmark.equalsMini            thrpt  100  225.705 ± 1.392  ops/us
```

[Javadoc](http://www.javadoc.io/doc/com.github.marschall/mini-commons/)

