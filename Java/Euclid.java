/*
 * File: Euclid.java
 * Created by Tianming Wei
 * Example code created for Lab07, CSC115 201901
 * 
 */

public class Euclid {

    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) {
		return p;
	}			
	else {
		gcd(p, p%q);
		return p;
	}
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = 1440;
        int q = 408;
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
