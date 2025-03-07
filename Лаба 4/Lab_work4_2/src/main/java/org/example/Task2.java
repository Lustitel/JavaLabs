package org.example;

import java.util.Arrays;

public class Task2
{
    public Task1 moduleTask1;
    public Task2(Task1 moduleTask1)
    {
        if(moduleTask1 == null)
        {
            throw new IllegalArgumentException("Не может быть null");
        }
        this.moduleTask1 = moduleTask1;
    }

    public double getMaxElement()
    {
        double[] roots = moduleTask1.execute();
        if(roots.length == 0)
        {
            throw new IllegalStateException("Нет корней у квадратного уравнения.");
        }
        return Arrays.stream(roots).max().orElseThrow();
    }
    @Override
    public String toString() {
        return "Квадратный трёхчлен: " + moduleTask1;
    }
    public static void main(String[] args) {
        Task1 equation = new Task1(1, -3, 2);
        Task2 rootFinder = new Task2(equation);
        System.out.println(rootFinder);
        System.out.println("Больший корень: " + rootFinder.getMaxElement());
    }
}