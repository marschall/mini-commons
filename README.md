Mini Commons [![Build Status](https://travis-ci.org/marschall/mini-commons.svg?branch=master)](https://travis-ci.org/marschall/mini-commons)
============

Like [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/) but lighter weight.

Changes to Commons Lang:

 * reflective equals and hashCode removed
 * remove initialOddNumbe and multiplierOddNumber from HashCodeBuilder
 * EqualsBuilder#append(Object, Object) and HashCodeBuilder#append(Object) are simpler and faster due to removed support for arrays
   * if you want array support use  EqualsBuilder#appendDeep(Object, Object) or HashCodeBuilder#appendDeep(Object)
 * delegate to `java.util.Objects`, `java.util.Arrays`, `java.lang.Long`, `java.lang.Double` where possible
   * may benefit from [future optimizations](http://openjdk.java.net/jeps/8044082)

More JDK compliant hashing:

 * use 31 instead of 37 as a hash code multiplier
 * use JDK hash code for booleans

To be specific [org.apache.commons.lang3.builder.EqualsBuilder#append(Object, Object)](https://commons.apache.org/proper/commons-lang/javadocs/api-3.4/org/apache/commons/lang3/builder/EqualsBuilder.html#append(java.lang.Object,%20java.lang.Object)) has a byte code size of 327 which is above the default inline limit of 325.

