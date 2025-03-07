package org.example.part2;

import org.example.part1.OneVarR;

public interface FuncInterface<T extends OneVarR> {
    double calculate(T function);
}