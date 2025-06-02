package org.example;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaRunner {

    // Метод для применения лямбда-выражения, принимающего один аргумент
    public static <T, R> R runFunction(Function<T, R> function, T input) {
        return function.apply(input); //вызов метода интерфейса Function, применяет переданную лямбда-функцию к входному параметру
    }


    // Метод для применения лямбда-выражения, принимающего два аргумента
    public static <T1, T2, R>  Boolean runBiPredicate(BiPredicate<T1, T2> biPredicate, T1 input1, T2 input2) {
        return biPredicate.test(input1, input2);
    }

    // Метод для проверки, что все три человека моложе maxAge
    public static Boolean checkAll(MaxAgeFunc<Human,Human,Human,Integer,Boolean> function,
                                   Human h1, Human h2, Human h3, Integer maxAge) {
        return function.check(h1,h2,h3, maxAge);
    }
}