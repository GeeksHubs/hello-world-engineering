# Java 8 - Stream

## Build
[![Build Status](https://travis-ci.org/vicboma1/Java8-Stream.svg?branch=master)](https://travis-ci.org/vicboma1/Java8-Stream) 
[![Java](https://img.shields.io/badge/Java-1.8.0-blue.svg?plastic)](http://kotlinlang.org) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/)
[![Junit](https://img.shields.io/badge/Junit-5.3.1-orange.svg?plastic)](http://junit.org)
[![Mockito](https://img.shields.io/badge/Mokito-2.9.3-blue.svg?plastic)](https://site.mockito.org/)

## [Interface Stream.Builder<T>](https://github.com/GeeksHubs/hello-world-engineering/tree/main/java/src/test/java/BuilderTest.java)

* void 	                      accept(T t)
* default Stream.Builder<T> 	add(T t)
* Stream<T> 	                build()



## [Interface BaseStream [ T, Stream T ] - Generators](https://github.com/GeeksHubs/hello-world-engineering/tree/main/java/src/test/java/BaseStreamTest.java)
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



## [Instance Methods](https://github.com/GeeksHubs/hello-world-engineering/tree/main/java/src/test/java/InstanceMethodsStreamTest.java)

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


En la carpeta 'src/test/*.java' se encuentra los ficheros con la suite de test.

A continuación se muestran los resultados.

```
$"C:\Program Files\Java\jdk-11.0.6\bin\java.exe" -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar=54153:C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar;C:\Users\vbolinches\.m2\repository\org\junit\platform\junit-platform-launcher\1.6.2\junit-platform-launcher-1.6.2.jar;C:\Users\vbolinches\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.6.2\junit-jupiter-engine-5.6.2.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\plugins\junit\lib\junit-rt.jar;C:\Users\vbolinches\Downloads\Java8-Stream-master\java\target\test-classes;C:\Users\vbolinches\Downloads\Java8-Stream-master\java\target\classes;C:\Users\vbolinches\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.6.2\junit-jupiter-api-5.6.2.jar;C:\Users\vbolinches\.m2\repository\org\apiguardian\apiguardian-api\1.1.0\apiguardian-api-1.1.0.jar;C:\Users\vbolinches\.m2\repository\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;C:\Users\vbolinches\.m2\repository\org\junit\platform\junit-platform-commons\1.6.2\junit-platform-commons-1.6.2.jar;C:\Users\vbolinches\.m2\repository\org\junit\vintage\junit-vintage-engine\5.6.2\junit-vintage-engine-5.6.2.jar;C:\Users\vbolinches\.m2\repository\org\junit\platform\junit-platform-engine\1.6.2\junit-platform-engine-1.6.2.jar;C:\Users\vbolinches\.m2\repository\junit\junit\4.13\junit-4.13.jar;C:\Users\vbolinches\.m2\repository\org\hamcrest\hamcrest-library\2.2\hamcrest-library-2.2.jar;C:\Users\vbolinches\.m2\repository\org\hamcrest\hamcrest-core\2.2\hamcrest-core-2.2.jar;C:\Users\vbolinches\.m2\repository\org\hamcrest\hamcrest\2.2\hamcrest-2.2.jar;C:\Users\vbolinches\.m2\repository\org\mockito\mockito-core\2.21.0\mockito-core-2.21.0.jar;C:\Users\vbolinches\.m2\repository\net\bytebuddy\byte-buddy\1.8.15\byte-buddy-1.8.15.jar;C:\Users\vbolinches\.m2\repository\net\bytebuddy\byte-buddy-agent\1.8.15\byte-buddy-agent-1.8.15.jar;C:\Users\vbolinches\.m2\repository\org\objenesis\objenesis\2.6\objenesis-2.6.jar;C:\Users\vbolinches\.m2\repository\org\mockito\mockito-junit-jupiter\2.23.0\mockito-junit-jupiter-2.23.0.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 @w@C:\Users\vbolinches\AppData\Local\Temp\idea_working_dirs_junit.tmp @C:\Users\vbolinches\AppData\Local\Temp\idea_junit.tmp -socket54152

 -------------------------------------------------------
 T E S T S
-------------------------------------------------------
Results :
Tests run: 44, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.579 s
[INFO] Finished at: 2021-03-10T23:15:07Z
[INFO] Final Memory: 22M/168M
[INFO] ------------------------------------------------------------------------
```


