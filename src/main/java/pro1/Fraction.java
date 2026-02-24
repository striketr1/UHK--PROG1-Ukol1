package pro1;

public class Fraction {

    private long numerator;
    private long denominator;

    public Fraction(long numerator, long denominator) {
        long gcd = NumericUtils.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction B) {
        this.numerator = this.numerator * B.denominator + B.numerator * this.denominator;
        this.denominator = this.denominator * B.denominator;
        return new Fraction(this.numerator, this.denominator);
    }

    public static Fraction parse(String s) {
        var result = new Fraction(0, 1);
        long numerator;
        long denominator;
        String[] split = s.split("\\+");

        for (var p : split) {
            Fraction f;
            if (p.contains("%")) {

                String n = p.replace("%", "").trim();
                numerator = Long.parseLong(n);
                f = new Fraction(numerator, 100);
            } else {
                var parts = p.split("/");
                numerator = Long.parseLong(parts[0].trim());
                denominator = Long.parseLong(parts[1].trim());
                f = new Fraction(numerator, denominator);
            }
            result = result.add(f);
        }

        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
