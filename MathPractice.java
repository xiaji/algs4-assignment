public class MathPractice {
  public static int abs(int x) {
    if (x < 0) return -x;
    else return x;
  }

  public static double abs(double x) {
    if (x < 0.0) return -x;
    else return x;
  }

  public static boolean isPrime(int x) {
    if (x < 2) return false;
    for(int i = 2; i * i < x; i++) {
      if (x % i == 0) return false;
    }
    return true;
  }

  public static double sqrt(double c) {
    if (c < 0) return Double.NaN;
    double t = c, err = 1e-15;
    while(Math.abs(t - c/t) > err*t) {
      t = (t + c/t) / 2.0;
    }
    return t;
  }
}
