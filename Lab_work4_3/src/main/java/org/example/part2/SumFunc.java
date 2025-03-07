package org.example.part2;

import org.example.part1.OneVarR;

public class SumFunc <T extends OneVarR> implements FuncInterface<T>{

    @Override
    public double calculate(T function) {
        double a = function.getLLine();
        double b = function.getULine();
        double middle = (a + b) / 2.0;

        // Суммируем значения функции в трёх точках
        return function.evaluate(a) + function.evaluate(middle) + function.evaluate(b);
    }
}