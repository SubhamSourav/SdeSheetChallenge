/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

public class _10Celebrity {
    public static int findCelebrity(int n) {
        int[] in = new int[n];
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Runner.knows(i, j)) {
                    out[i] += 1;
                    in[j] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (in[i] == n - 1 && out[i] == 0)
                return i;
        }
        return -1;
    }
}