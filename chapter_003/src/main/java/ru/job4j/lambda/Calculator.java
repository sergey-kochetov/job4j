package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {

    public interface Operation {
        double calc(int left, int right);
    }

    public void multiple(int start, int finish, int value, Operation op) {
        for (int index = start; index != finish; index++) {
            System.out.println(
                    op.calc(value, index)
            );
        }
    }



    public void multiple2(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static class MathUtil {
        public static double add(int left, int second) {
            return left + second;
        }

        public static double div(int left, int second) {
            return left / second;
        }
    }

}
