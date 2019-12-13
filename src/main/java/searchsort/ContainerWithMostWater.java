package searchsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // int ans = 0;
        // for (int i=0;i<height.length-1;i++){
        //     for (int j=i+1;j<height.length;j++){
        //         int t = (j-i)*Math.min(height[i],height[j]);
        //         if (t>ans){
        //             ans = t;
        //         }
        //     }
        // }
        // return ans;
        return doublePointer(height);
    }

    public int doublePointer(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    private int better(int[] height){
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        int max = maxIndex(height);
        left.add(0);
        for (int i=1;i<=max;i++){
            if (height[i]>height[left.get(left.size()-1)]){
                left.add(i);
            }
        }
        right.add(height.length-1);
        for (int j=height.length-2;j>max;j--){
            if (height[j]>height[right.get(right.size()-1)]){
                right.add(j);
            }
        }
        int ans = 0;
        for (int i=0;i<right.size();i++){
            int r = right.get(i);
            for(int j=0;j<left.size();j++){
                int l = left.get(j);
                int t = (r-l)*Math.min(height[r],height[l]);
                if (t>ans){
                    ans = t;
                }
            }
        }
        return ans;
    }

    private int maxIndex(int[] height){
        int max = height[0];
        int ans = 0;
        for (int i=1;i<height.length;i++){
            if (height[i]>max){
                max = height[i];
                ans = i;
            }
        }
        return ans;
    }
}
