import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by vicboma
 */
public class BaseStreamTest {

    /**
     * Int Stream Of
     *
     * @throws Exception
     */
    @Test
    public void intStreamOf() throws Exception {
        final int[] result = new int[]{0, 1, 2, 3, 4, 5};
        final IntStream stream = IntStream.of(result);
        stream.forEach(it -> {
            assertEquals(result[it], it);
        });
    }

    /**
     * Int Stream Range
     *
     * @throws Exception
     */
    @Test
    public void intStreamRange() throws Exception {
        final int[] result = new int[]{0, 1, 2, 3, 4, 5};
        final IntStream stream = IntStream.range(0, result.length);
        stream.forEach(it -> {
            assertEquals(result[it], it);
        });
    }

    /**
     * Int Stream Range Closed
     *
     * @throws Exception
     */
    @Test
    public void intStreamRangeClosed() throws Exception {
        final int[] result = new int[]{0, 1, 2, 3, 4, 5};
        final IntStream stream = IntStream.rangeClosed(0, result.length - 1);
        stream.forEach(it -> {
            assertEquals(result[it], it);
        });
    }

    /**
     * Int Stream Empty
     *
     * @throws Exception
     */
    @Test
    public void intStreamEmpty() throws Exception {
        final IntStream stream = IntStream.empty();
        stream.forEach(it -> {
            fail("In Stream not null");
        });
        assertNotNull(stream);
    }

    /**
     * Int Stream Generate
     *
     * @throws Exception
     */
    @Test
    public void intStreamGenerate() throws Exception {
        final int[] i = new int[]{0};
        final IntStream stream = IntStream.generate(() -> {
            i[0]++;
            return (i[0] * i[0]);
        });

        stream.limit(4).forEach(it -> {
            assertTrue(getHashMap().get(it));
        });
    }

    /**
     * Int Stream iterate
     *
     * @throws Exception
     */
    @Test
    public void intStreamIterate() throws Exception {
        final IntStream stream = IntStream.iterate(1, i -> i * i);

        stream.limit(4).forEach(it -> {
            assertTrue(getHashMap().get(it));
        });
    }

    private Map<Integer, Boolean> getHashMap() {
        return new HashMap() {
            {
                put(1, true);
                put(2, false);
                put(8, false);
                put(13, false);
                put(4, true);
                put(5, false);
                put(10, false);
                put(14, false);
                put(9, true);
                put(6, false);
                put(11, false);
                put(15, false);
                put(16, true);
                put(7, false);
                put(12, false);
                put(3, false);
            }
        };
    }

    /**
     * Int Stream concat
     *
     * @throws Exception
     */
    @Test
    public void intStreamConcat() throws Exception {
        final int[] result = new int[]{0, 1, 2, 3, 4, 5};
        final IntStream stream = IntStream.concat(IntStream.of(0, 1, 2, 3), IntStream.of(1, 2, 3, 4, 5));
        stream.forEach(it -> {
            assertEquals(result[it], it);
        });
    }

    /**
     * Double Stream
     *
     * @throws Exception
     */
    @Test
    public void doubleStream() throws Exception {
        final double[] result = new double[]{0.0, 1.0, 2.2, 3.1, 4.2, 5.3};
        final DoubleStream stream = DoubleStream.of(result);
        stream.forEach(it -> {
            Assert.assertEquals(result[(int) it], it);
        });
    }


    /**
     * Long Stream
     *
     * @throws Exception
     */
    @Test
    public void longStream() throws Exception {
        final long[] result = new long[]{0L, 1L, 2L, 3L, 4L, 5L};
        final LongStream stream = LongStream.of(result);
        stream.forEach(it -> {
            assertEquals(it, result[(int) it]);
        });
    }
}