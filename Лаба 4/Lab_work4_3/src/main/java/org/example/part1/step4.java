package org.example.part1;

public class step4 implements OneVarR
{
    public double A,B,LLine,ULine;

    public step4(double A, double B, double LLine, double ULine) {
        if (LLine > ULine) throw new IllegalArgumentException("LLine > ULine");
        this.A = A;
        this.B = B;
        this.LLine = LLine;
        this.ULine = ULine;
    }

    @Override
    public double evaluate(double x) {
        if (x < LLine || x > ULine) throw new IllegalArgumentException("x выходит за границы [" + LLine + ", " + ULine + "]");
        return A * Math.exp(x) + B;
    }

    @Override
    public double getLLine() {return LLine;}

    @Override
    public double getULine() {return ULine;}

    @Override
    public String toString() {return "f(x) = \" + A + \"exp(x) + \" + B + \" на [" + LLine + ", " + ULine + "]";}
}