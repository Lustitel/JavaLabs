package org.example.part1;

public class step3 implements OneVarR
{
    public double A,B,C,D,LLine,ULine;

    public step3(double A, double B, double C, double D, double LLine, double ULine) {
        if (LLine > ULine) throw new IllegalArgumentException("LLine > ULine");
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.LLine = LLine;
        this.ULine = ULine;
    }

    @Override
    public double evaluate(double x) {
        if (x < LLine || x > ULine) throw new IllegalArgumentException("x выходит за границы [" + LLine + ", " + ULine + "]");
        if (C * x + D == 0) throw new ArithmeticException("Деление на ноль в точке x = " + x);
        return (A * x + B) / (C * x + D);
    }

    @Override
    public double getLLine() {return LLine;}

    @Override
    public double getULine() {return ULine;}

    @Override
    public String toString() {return "f(x) = (" + A + "x + " + B + ") / (" + C + "x + " + D + ") на [" + LLine + ", " + ULine + "]";}
}