package dp;

/**
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.
 **/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s==null || s.equals("")){
            return "";
        }
        if (s.length()==1){
            return s;
        }
        return middlePoint(s);
    }

    //动态规划
    private String dp(String s){
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        dp[0][0] = true;
        dp[0][1] = s.charAt(0)==s.charAt(1);
        int i=1;
        int j=2;
        //todo
        while (j<s.length()){
            if (dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                dp[i][j] = true;
            }
        }
        return "";
    }

    //找中间点法 O(n2)
    private String middlePoint(String s){
        String ans = "";
        int n = s.length();
        for (int i=0;i<2*n-1;i++){
            if (i%2==1){
                int k=i/2;
                int j=i/2+1;
                while (k>=0 && j<n){
                    if (s.charAt(k)!=s.charAt(j)){
                        break;
                    }
                    k--;
                    j++;
                }
                String t = s.substring(k+1,j);
                if (t.length()>ans.length()){
                    ans = t;
                }
            } else {
                int k=i/2-1;
                int j=i/2+1;
                while (k>=0 && j<n){
                    if (s.charAt(k)!=s.charAt(j)){
                        break;
                    }
                    k--;
                    j++;
                }
                String t = s.substring(k+1,j);
                if (t.length()>ans.length()){
                    ans = t;
                }
            }
        }
        return ans;
    }

    //Manacher 算法
}
