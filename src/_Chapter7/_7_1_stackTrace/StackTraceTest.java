package _Chapter7._7_1_stackTrace;

import java.util.Scanner;

public class StackTraceTest {
  public static int factorial(int n) {
    System.out.println("factorial(" + n + "):");
    var t = new Throwable();
    var frames = t.getStackTrace();
    for (StackTraceElement f : frames) {
      System.out.println(f);
    }
    int r;
    if (n <= 1) {
      r = 1;
    } else {
      r = n * factorial(n - 1);
    }
    System.out.println("return " + r);
    return r;
  }

  public static void main(String[] args) {
    var in = new Scanner(System.in);
    System.out.println("Enter n: ");
    int n = in.nextInt();
    factorial(n);
  }
}
