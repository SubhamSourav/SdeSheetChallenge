public class _1nthRoot {
    public static double findNthRootOfM(int n, long m) {
        double t = 1.0 / n;
        double k = Math.pow(m, t);
        return k;
    }
}