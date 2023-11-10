package Bit_Manipulation;

public class Largest_Coprime_Divisor {
    public static void main(String[] args) {
        System.out.println(gcd(5,68));
    }

    public static int cpFact(int A, int B)
    {
        //You Can Code Here
        while (gcd(A, B) != 1)
            A /= gcd(A, B);

        return A;

    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
