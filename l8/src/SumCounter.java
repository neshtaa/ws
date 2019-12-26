import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
//import java.util.concurrent.SubmissionPublisher;

class ArrayGenerator {
    private int[] array;
    ArrayGenerator() {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        array = arr;
    }

    public int[] getArray() {
        return array;
    }
}


public class SumCounter extends RecursiveTask<Long> {
    private int[] array;

    SumCounter(int[] arr) {
        array = arr;
    }


    @Override
    protected Long compute() {
        long sum = 0;
        if (array.length > 20) {
            int length = array.length / 2;
            int[] firstHalf = new int[length];
            int[] secondHalf = new int[array.length - length];
            System.arraycopy(array, 0, firstHalf, 0, firstHalf.length);
            System.arraycopy(array, length, secondHalf, 0, secondHalf.length);
            SumCounter subTask1 = new SumCounter(firstHalf);
            SumCounter subTask2 = new SumCounter(secondHalf);
            subTask1.fork();
            subTask2.fork();
            sum = subTask1.join() + subTask2.join();
        } else {
            for (int number: array) {
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayGenerator generator = new ArrayGenerator();
        int[] array = generator.getArray();
        Long result = new ForkJoinPool().invoke(new SumCounter(array));
        System.out.println("Result of computing: " + result);
    }
}
