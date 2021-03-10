# Java 8 - Stream

## Build
[![Build Status](https://travis-ci.org/vicboma1/Java8-Stream.svg?branch=master)](https://travis-ci.org/vicboma1/Java8-Stream) 
[![Java](https://img.shields.io/badge/Java-1.8.0-blue.svg?plastic)](http://kotlinlang.org) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/)
[![Junit](https://img.shields.io/badge/Junit-4.11-orange.svg?plastic)](http://junit.org)
[![Analytics](https://ga-beacon.appspot.com/UA-68658653-8/kotlin-koans/readme)](https://github.com/igrigorik/ga-beacon)

## [Interface Stream.Builder<T>](https://github.com/vicboma1/Java8-Stream/blob/master/src/test/java/BuilderTest.java)

* void 	                      accept(T t)
* default Stream.Builder<T> 	add(T t)
* Stream<T> 	                build()



## [Interface BaseStream [ T, Stream T ] - Generators](https://github.com/vicboma1/Java8-Stream/blob/master/src/test/java/BaseStreamTest.java)
```
DoubleStream, IntStream, LongStream, Stream<T>
```

* static T Stream T concat(Stream<? extends T> a, Stream<? extends T> b)
* static T Stream T of(T... values)
* static T Stream T of(T t)
* static T Stream T empty()
* static T Stream T generate(Supplier<T> s)
* static T Stream T iterate(T seed, UnaryOperator<T> f)
* static IntStream  range(int startInclusive, int endExclusive)
* static IntStream  rangeClosed(int startInclusive, int endInclusive)



## [Instance Methods](https://github.com/vicboma1/Java8-Stream/blob/master/src/test/java/InstanceMethodsStreamTest.java)

* boolean	allMatch (Predicate<? super T> predicate)
* boolean anyMatch (Predicate<? super T> predicate)
* [R,A] R	collect (Collector<? super T,A,R> collector)
* [R] R	  collect (Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
* long	  count()
* Stream T distinct()
* Stream T	filter (Predicate<? super T> predicate)
* Optional T	findAny()
* Optional T	findFirst()
* R Stream R	flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
* DoubleStream	flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)
* IntStream	flatMapToInt(Function<? super T,? extends IntStream> mapper)
* LongStream flatMapToLong(Function<? super T,? extends LongStream> mapper)
* void	forEach(Consumer<? super T> action)
* void	forEachOrdered(Consumer<? super T> action)
* Stream T	limit(long maxSize)
* R Stream R	map(Function<? super T,? extends R> mapper)
* DoubleStream	mapToDouble(ToDoubleFunction<? super T> mapper)
* IntStream	mapToInt(ToIntFunction<? super T> mapper)
* LongStream	mapToLong(ToLongFunction<? super T> mapper)
* Optional T	max(Comparator<? super T> comparator)
* Optional T	min(Comparator<? super T> comparator)
* boolean	noneMatch(Predicate<? super T> predicate)
* Stream T	peek(Consumer<? super T> action)
* Optional T	reduce(BinaryOperator<T> accumulator)
* T	reduce(T identity, BinaryOperator<T> accumulator)
* U U	reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
* Stream<T>	skip(long n)
* Stream<T>	sorted()
* Stream<T>	sorted(Comparator<? super T> comparator)
* Object[]	toArray()
* A A[]	toArray(IntFunction<A[]> generator)


