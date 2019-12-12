package dp;

/**
 *
 */
public class SuperEggDrop {

    public int superEggDrop(int k, int n){
        return dp(k,n);
    }

    private int dp(int k, int n){
        if (n==0){
            return 0;
        }
        if (k==1){
            return n;
        }
        int lo = 1;
        int hi = n;
        while(lo<=hi){
            int x = (hi+lo)/2;
            int l = dp(k-1,x-1);
            int h = dp(k,n-x);
            
        }
        return 0;
    }
}
