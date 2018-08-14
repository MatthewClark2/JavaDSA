package prj.clark.cs.dsa.struct.stack;

import java.util.function.Consumer;

public class StackRunner {
    private static final int PROGRAM_WIDTH = 30;

    private static final Consumer<Stack<String>> push = stack -> stack.push("");
    private static final Consumer<Stack<String>> pop = Stack::pop;

    public static void main(String[] args) {
        long start, end;

        System.out.printf("%8s | %8s | %8s | %12s\n",
                "Impl", "Method", "Count", "Time");

        int iterations = getIterations(args);

        Stack<String> arrayStack = new ArrayStack<>();
        Stack<String> linkedListStack = new LinkedListStack<>();

        long[] arrayStackResult = timeStackOperation(
                arrayStack, push, iterations);

        System.out.println(resultOutput(
                "Array", "Push", iterations, elapsed(arrayStackResult)));

        long[] listStackResult = timeStackOperation(
                linkedListStack, push, iterations);

        System.out.println(resultOutput(
                "Linked", "Push", iterations, elapsed(listStackResult)));

        arrayStackResult = timeStackOperation(
                arrayStack, pop, iterations);

        System.out.println(resultOutput(
                "Array", "Pop", iterations, elapsed(arrayStackResult)));

        listStackResult = timeStackOperation(
                linkedListStack, pop, iterations);

        System.out.println(resultOutput(
                "Linked", "Pop", iterations, elapsed(listStackResult)));
    }

    private static String resultOutput(String implementation, String method, int iterations, long time) {
        return String.format("%8s | %8s | %8d | %12d",
                implementation, method, iterations, time);
    }

    private static long[] timeStackOperation(Stack<String> stack, Consumer<Stack<String>> fn, int cycles) {
        long start, stop;
        start = System.currentTimeMillis();

        for (int i = 0; i < cycles; ++i) {
            fn.accept(stack);
        }

        stop = System.currentTimeMillis();

        return new long[]{start, stop};
    }

    private static int getIterations(String[] args) {
        return 10000000;
    }

    private static long elapsed(long[] longs) {
        return longs[1] - longs[0];
    }
}
