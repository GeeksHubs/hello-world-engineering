import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by vicboma
 */
public class InstanceMethodsStreamTest {

    /**
     * Returns whether all elements of this stream match the provided predicate
     *
     * @throws Exception
     */
    @Test
    public void allMatch() throws Exception {
        final boolean result = IntStream.of(0, 1, 2, 3, 4, 5, 6)
                .allMatch(value -> value % 1 == 0);
        Assert.assertTrue(result);
    }


    /**
     * Returns whether all elements of this stream match the provided predicate
     *
     * @throws Exception
     */
    @Test
    public void allMatchFail() throws Exception {
        final boolean result = IntStream.of(0, 1, 2, 3, 4, 5, 6)
                .allMatch(value -> value % 2 == 0);
        Assert.assertFalse(result);
    }

    /**
     * Returns whether any elements of this stream match the provided predicate
     *
     * @throws Exception
     */
    @Test
    public void anyMatch() throws Exception {
        final boolean result = DoubleStream.of(0.0, 3.0, 9.2, 20.3)
                .anyMatch(value -> value % 2.0 == 0);
        Assert.assertTrue(result);
    }


    /**
     * Returns whether any elements of this stream match the provided predicate
     *
     * @throws Exception
     */
    @Test
    public void anyMatchFail() throws Exception {
        final boolean result = LongStream.of(1L, 2L, 3L, 4L, 5L, 6L)
                .anyMatch(value -> value % 8L == 0);
        Assert.assertFalse(result);
    }


    /**
     * Performs a mutable reduction operation on the elements of this stream using a Collector.
     *
     * @throws Exception
     */
    @Test
    public void collect() throws Exception {
        final double expected = 10.0;
        final DoubleSummaryStatistics result = Arrays.asList(1.0, 2.0, 3.0, 4.0)
                .stream()
                .collect(Collectors.summarizingDouble(it -> it));

        Assert.assertTrue(expected == result.getSum());
    }


    /**
     * Performs a mutable reduction operation on the elements of this stream using a Collector.
     *
     * @throws Exception
     */
    @Test
    public void collectGroupingBy() throws Exception {
        String expected = "{victor=2, bolinches=1}";
        final List<String> list = new ArrayList() {  //inline declaration
            {
                add("victor");
                add("victor");
                add("bolinches");
            }
        };

        final Map<String, Long> counted = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        Assert.assertEquals(expected, counted.toString());
    }

    /**
     * Performs a mutable reduction operation on the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void collectSupplierBiConsumerCombiner() throws Exception {
        String expected = "VictorManuelBolinchesJava8";
        final StringBuilder sb = Stream.of("Victor", "Manuel", "Bolinches", "Java8")
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);

        Assert.assertEquals(expected, sb.toString());

    }

    /**
     * Performs a mutable reduction operation on the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void collectSupplierBiConsumerCombiner2() throws Exception {
        String expected = "[Victor, Bolinches, Java8, Manuel]";
        final Stream<String> stream = Stream.of("Victor", "Manuel", "Bolinches", "Java8")
                .collect(() -> new HashSet(), Set::add, Set::addAll)
                .stream();


        Assert.assertEquals(expected, Arrays.toString(stream.toArray()));

    }

    /**
     * Returns the count of elements in this stream.
     *
     * @throws Exception
     */
    @Test
    public void longCount() throws Exception {
        final int expected = 4;
        final long result = Stream.of("Victor", "Manuel", "Bolinches", "Java8")
                .collect(() -> new HashSet(), Set::add, Set::addAll)
                .stream().count();

        Assert.assertEquals(expected, result);
    }


    /**
     * Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
     *
     * @throws Exception
     */
    @Test
    public void distinct() throws Exception {
        final long expected = 5;
        final long result = Arrays.asList("Distinct", "Victor", "Manuel", "Bolinches", "Java8", "Distinct")
                .stream()
                .distinct()
                .count();

        Assert.assertEquals(expected, result);
    }

    /**
     * Returns a stream consisting of the elements of this stream that match the given predicate.
     *
     * @throws Exception
     */
    @Test
    public void filter() throws Exception {
        final long expected = 4;
        final long result = Arrays.asList("Distinct", "Victor", "Manuel", "Bolinches", "Java8", "Distinct")
                .stream()
                .filter(it -> !it.equals("Distinct"))
                .count();

        Assert.assertEquals(expected, result);
    }

    /**
     * Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
     *
     * @throws Exception
     */
    @Test
    public void findAny() throws Exception {
        final List<String> list = Arrays.asList("Distinct", "Victor", "Manuel", "Bolinches", "Java8", "Distinct");
        final Optional<String> result = list.stream().findAny();

        Assert.assertTrue(list.contains(result.get()));
    }

    /**
     * Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
     *
     * @throws Exception
     */
    @Test
    public void findFirst() throws Exception {
        String expected = "Manuel";
        final List<String> list = Arrays.asList("Victor", "Manuel", "Bolinches", "Java8", "Distinct");
        final Optional<String> result = list.stream().filter(it -> it.endsWith("l")).findFirst();

        Assert.assertEquals(expected, result.get());
    }

    private class A {
        String name;
        List<B> Bs = new ArrayList<>();

        A(String name) {
            this.name = name;
        }
    }

    private class B {
        String name;

        B(String name) {
            this.name = name;
        }
    }

    /**
     * Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
     *
     * @throws Exception
     */
    @Test
    public void flatMap() throws Exception {
        String expected = "B1 - A1B2 - A1B3 - A1B1 - A2B2 - A2B3 - A2B1 - A3B2 - A3B3 - A3B1 - A4B2 - A4B3 - A4B1 - A5B2 - A5B3 - A5B1 - A6B2 - A6B3 - A6";
        final StringBuilder sb = new StringBuilder();
        IntStream.range(1, 7)
                .mapToObj(i -> new A("A" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new B("B" + i + " - " + f.name))
                        .forEach(f.Bs::add)
                )
                .flatMap(f -> f.Bs.stream())
                .forEach(b -> sb.append(b.name));

        Assert.assertEquals(expected, sb.toString());
    }

    /**
     * Returns an DoubleStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
     *
     * @throws Exception
     */
    @Test
    public void flatMapToDoubleSum() throws Exception {
        final double expected = 22.1;
        final double[][] array = {{10.0, 12.0}, {0.0, 0.1}};
        final DoubleStream is1 = Stream.of(array).flatMapToDouble(row -> Arrays.stream(row));
        final double sum = is1.sum();
        Assert.assertTrue(expected == sum);
    }

    /**
     * Returns an IntStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
     *
     * @throws Exception
     */
    @Test
    public void flatMapToIntCount() throws Exception {
        final int expected = 6;
        final int[][] array = {{1, 2}, {3, 4}, {5, 6}};
        final IntStream is1 = Stream.of(array).flatMapToInt(row -> Arrays.stream(row));
        final long count = is1.count();
        Assert.assertTrue(expected == count);
    }

    /**
     * Returns an IntStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
     *
     * @throws Exception
     */
    @Test
    public void flatMapToIntSum() throws Exception {
        final int expected = 21;
        final int[][] array = {{1, 2}, {3, 4}, {5, 6}};
        final IntStream is1 = Stream.of(array).flatMapToInt(row -> Arrays.stream(row));
        final long sum = is1.sum();
        Assert.assertTrue(expected == sum);
    }

    /**
     * Returns an LongStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
     *
     * @throws Exception
     */
    @Test
    public void flatMapToLong() throws Exception {
        final long expected = 21L;
        final long[][] array = {{10L, 10L}, {0L, 1L}};
        final LongStream is1 = Stream.of(array).flatMapToLong(row -> Arrays.stream(row));
        final long sum = is1.sum();
        Assert.assertTrue(expected == sum);
    }

    /**
     * Performs an action for each element of this stream.
     *
     * @throws Exception
     */
    @Test
    public void forEach() throws Exception {
        Arrays.asList("Victor", "Manuel", "Bolinches", "Java8", "Distinct")
                .stream()
                .forEach(it -> {
                    Assert.assertTrue(it instanceof String);
                });
    }

    /**
     * Performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.
     *
     * @throws Exception
     */
    @Test
    public void forEachOrdered() throws Exception {
        final List<String> expected = Arrays.asList("Victor", "Manuel", "Bolinches", "Java8", "Distinct");
        final List<String> result = new ArrayList();
        Arrays.asList("Victor", "Manuel", "Bolinches", "Java8", "Distinct")
                .stream()
                .forEach(it -> {
                    result.add(it);
                });
        Assert.assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(result.toArray()));
    }


    /**
     * Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
     *
     * @throws Exception
     */
    @Test
    public void limit() throws Exception {
        final int result = 16;
        final int[] i = new int[]{3};
        final IntStream stream = IntStream.generate(() -> {
            i[0]++;
            return (i[0] * i[0]);
        });

        stream.limit(1).forEach(it -> {
            assertTrue(it == result);
        });
    }


    /**
     * Returns a stream consisting of the results of applying the given function to the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void map() throws Exception {
        String expected = "B1 - A1B1 - A2B1 - A3B1 - A4B1 - A5B1 - A6";
        final StringBuilder sb = new StringBuilder();
        IntStream.range(1, 7)
                .mapToObj(i -> new A("A" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new B("B" + i + " - " + f.name))
                        .forEach(f.Bs::add)
                )
                .map(f -> f.Bs.stream())
                .forEach(b -> sb.append(b.findFirst().get().name));

        Assert.assertEquals(expected, sb.toString());
    }

    /**
     * Returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void mapToIntMax() throws Exception {
        final int expected = 6;
        final int result = Stream.of("A1", "B2", "C3")
                .map(s -> s.substring(1))
                .mapToInt(i -> new Integer(i))
                .sum();

        Assert.assertTrue(expected == result);
    }

    /**
     * Returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void mapToDoubleMax() throws Exception {
        final int expected = 3;
        final OptionalDouble result = Stream.of("A1.0", "B2.0", "C3.0")
                .map(s -> s.substring(1))
                .mapToDouble(d -> new Double(d))
                .max();

        Assert.assertTrue(expected == result.getAsDouble());
    }

    /**
     * Returns a LongStream consisting of the results of applying the given function to the elements of this stream.
     *
     * @throws Exception
     */
    @Test
    public void mapToLongMin() throws Exception {
        final long expected = 1L;
        final OptionalLong result = Stream.of("A1", "B2", "C3")
                .map(s -> s.substring(1))
                .mapToLong(l -> new Long(l))
                .min();

        Assert.assertTrue(expected == result.getAsLong());
    }


    /**
     * Returns whether no elements of this stream match the provided predicate.
     *
     * @throws Exception
     */
    @Test
    public void noneMatch() throws Exception {
        final boolean result = Arrays.asList("Victor", "Manuel", "Bolinches", "Java8", "Distinct")
                .stream()
                .noneMatch(it -> it.equals("Ma"));

        Assert.assertTrue(result);

    }


    /**
     * Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.
     *
     * @throws Exception
     */
    @Test
    public void reduce() throws Exception {
        final int expected = 789;
        final int result = Arrays.asList(18, 19, 29, 23, 43, 266, 789)
                .stream()
                .reduce((p1, p2) -> p1 > p2 ? p1 : p2)
                .get();

        Assert.assertTrue(expected == result);
    }

    /**
     * Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.
     *
     * @throws Exception
     */
    @Test
    public void reduceIdenty() throws Exception {
        final int expected = 1000;
        final int result = Stream.of(18, 19, 29, 23, 43, 266, 789)
                .reduce(new Integer(1000), (p1, p2) -> p1 > p2 ? p1 : p2)
                .intValue();

        Assert.assertTrue(expected == result);
    }

    /**
     * Performs a reduction on the elements of this stream, using the provided identity, accumulation and combining functions.
     *
     * @throws Exception
     */
    @Test
    public void reduceIdentyBiFunction() throws Exception {
        final int expected = 1187;
        final int result = Stream.of(18, 19, 29, 23, 43, 266, 789)
                .reduce(0, (sum, p) -> sum += p, (sum1, sum2) -> sum1 + sum2)
                .intValue();

        Assert.assertTrue(expected == result);
    }


    /**
     * Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
     *
     * @throws Exception
     */
    @Test
    public void skip() throws Exception {
        final int expected = 889;
        final int result = Stream.of(18, 19, 29, 23, 43, 100, 789)
                .skip(5)
                .reduce(0, (sum, p) -> sum += p, (sum1, sum2) -> sum1 + sum2)
                .intValue();

        Assert.assertTrue(expected == result);
    }


    /**
     * Returns whether no elements of this stream match the provided predicate.
     *
     * @throws Exception
     */
    @Test
    public void sorted() throws Exception {
        final Stream expected = Arrays.asList("A", "B", "B", "C", "C").stream();
        final Stream result = Arrays.asList("A", "B", "C", "B", "C")
                .stream()
                .sorted();

        Assert.assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(result.toArray()));

    }


    /**
     * Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
     *
     * @throws Exception
     */
    @Test
    public void sortedComparator() throws Exception {
        final Stream expected = Arrays.asList("A", "B", "B", "C", "C").stream();
        final Stream result = Arrays.asList("A", "B", "C", "B", "C")
                .stream().sorted((a, b) -> a.compareTo(b));


        Assert.assertEquals(Arrays.toString(expected.toArray()), Arrays.toString(result.toArray()));

    }
}