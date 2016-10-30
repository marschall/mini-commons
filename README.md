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

Changes to Apache Commons Lang:

 * Removed reflective `equals` and `hashCode`. You generally use `equals` and `hashCode` for hash based collections, reflection has no place there.
 * Removed initialOddNumber and multiplierOddNumber from HashCodeBuilder. We have never seen anybody use anything else than the default.
 * `EqualsBuilder#append(Object, Object)` and `HashCodeBuilder#append(Object)` are simpler due to removed support for arrays.
   * If you want array support use `EqualsBuilder#appendDeep(Object, Object)` or `HashCodeBuilder#appendDeep(Object)`. Is this the same pattern that `java.util.Objects` and `java.util.Arrays` use.
 * Delegate to `java.util.Objects`, `java.util.Arrays`, `java.lang.Long`, `java.lang.Double` where possible.
   * This may benefit from [future optimizations](http://openjdk.java.net/jeps/8044082).
 * More JDK compliant hashing:
   * use 31 instead of 37 as a hash code multiplier
   * use JDK hash code for booleans

[Javadoc](http://www.javadoc.io/doc/com.github.marschall/mini-commons/)

