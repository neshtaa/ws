import org.junit.Assert;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class SumCounterTest {

    @org.junit.jupiter.api.Test
    void compute() {
        int[] array = new int[1000000];
        Arrays.fill(array, 1);
        Long expected = 1000000L;
        Long actual = new ForkJoinPool().invoke(new SumCounter(array));
        Assert.assertEquals(expected, actual);
    }
}