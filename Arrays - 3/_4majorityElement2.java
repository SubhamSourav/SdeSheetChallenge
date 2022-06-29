import java.util.ArrayList;

public class _4majorityElement2 {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int num1 = -1, num2 = -1, c1 = 0, c2 = 0, n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int ele : arr) {
            if (ele == num1)
                c1++;
            else if (ele == num2)
                c2++;
            else if (c1 == 0) {
                num1 = ele;
                c1++;
            } else if (c2 == 0) {
                num2 = ele;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        for (int ele : arr) {
            if (ele == num1)
                c1++;
        }
        if (c1 > (n / 3))
            ans.add(num1);

        c2 = 0;
        for (int ele : arr) {
            if (ele == num2)
                c2++;
        }
        if (c2 > (n / 3))
            ans.add(num2);

        return ans;
    }
}
