import java.util.ArrayList;

public class _1searchIn2DMatrix {
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int t) {
		int low=0,high = (m*n)-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(t>mat.get(mid/n).get(mid%n))low=mid+1;
            else if(t<mat.get(mid/n).get(mid%n))high=mid-1;
            else return true;
            
        }
        
        return false;
	}
}
