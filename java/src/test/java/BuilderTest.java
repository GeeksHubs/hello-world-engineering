import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma
 */
public class BuilderTest {

    /**
     * void 	accept(T t)
     * Adds an element to the stream being built.
     *
     * @throws Exception
     */
    @Test
    public void streamAccept() throws Exception {
        final int result = 1;

        final Stream.Builder<Object> builder = getBuilder();
        final Stream.Builder<Object> builderSpy = spy(builder);

        builderSpy.accept(new Integer(0));
        verify(builderSpy).accept(new Integer(0));

        Assert.assertEquals(result, builderSpy.build().count());
    }

    /**
     * Default Stream.Builder<T> 	add(T t)
     * Adds an element to the stream being built.
     *
     * @throws Exception
     */
    @Test
    public void streamAdd() throws Exception {
        final int result = 3;

        final Stream.Builder<Object> builder = getBuilder();

        final Stream.Builder<Object> builderSpy = spy(builder);

        builderSpy
                .add(new Integer(0))
                .add(new Integer(1))
                .add(new Integer(2));

        verify(builderSpy).add(new Integer(0));
        verify(builderSpy).add(new Integer(1));
        verify(builderSpy).add(new Integer(2));

        Assert.assertEquals(result, builderSpy.build().count());
    }


    /**
     * Stream<T> 	build()
     * Builds the stream, transitioning this builder to the built state.
     *
     * @throws Exception
     */
    @Test
    public void streamBuild() throws Exception {
        final Integer[] arrayInteger = new Integer[]{new Integer(0), new Integer(1), new Integer(2)};

        Stream.builder()
                .add(new Integer(0))
                .add(new Integer(1))
                .add(new Integer(2))
                .build()
                .forEach(it -> {
                    final Integer result = (Integer) it;
                    final Integer expected = arrayInteger[result.intValue()];
                    Assert.assertEquals(expected, result);
                });
    }

    /**
     * Implement Interface  Stream.Builder
     *
     * @return
     */
    private Stream.Builder getBuilder() {
        return new Stream.Builder() {
            private Set<Object> set = new HashSet<Object>();

            @Override
            public void accept(Object o) {
                set.add(o);
            }

            @Override
            public Stream.Builder add(Object o) {
                accept(o);
                return this;
            }

            @Override
            public Stream build() {
                return set.stream();
            }
        };
    }
}