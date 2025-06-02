package org.example;

@FunctionalInterface
public interface MaxAgeFunc <T1, T2, T3, U, R> {
    R check(T1 p1, T2 p2, T3 p3, U maxAge);
}
