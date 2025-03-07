package org.example;

import java.util.Arrays;

import static java.lang.Math.*;

public class Task1
{
    public static void main(String[] args) {
        Task1 equation = new Task1(1, -3, 2);
        System.out.println(equation);
        System.out.println("Корни: " + Arrays.toString(equation.execute()));
    }

    double a,b,c;
    public Task1(double a,double b, double c) {
        if(a==0) throw new IllegalArgumentException("Коэффициент a не может быть равен 0 (это не квадратное уравнение).");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] execute()
    {
        double D = b*b - 4*a*c;
        double[] answer;
        if(D < 0) answer = new double[0];
        else if(D == 0) {
            answer = new double[1];
            answer[0] = -b / (2 * a);
        } else {
            answer = new double[2];
            answer[0] = (-b + sqrt(D)) / (2 * a);
            answer[1] = (-b - sqrt(D)) / (2 * a);
        }
        return answer;
    }

    @Override
    public String toString() {return "Уравнение: " + a + "x^2 + " + b + "x + " + c;}
}