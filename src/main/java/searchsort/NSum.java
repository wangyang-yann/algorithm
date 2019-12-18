package searchsort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class NSum {

    public List<List<Integer>> nSum(int[] nums, int target, int n){
        List<List<Integer>> ans = new ArrayList();
        if (n>2){
            for (int i=0;i<nums.length-n+1;i++){
                int[] nums0 = new int[nums.length-i-1];
                for (int k=i+1;k<nums.length;k++){
                    nums0[k-i-1] = nums[k];
                }
                List<List<Integer>> s = nSum(nums0,target-nums[i],n-1);
                if (s.size()!=0){
                    for(List<Integer> l:s){
                        l.add(nums[i]);
                    }
                    ans.addAll(s);
                }
            }
        } else {
            int i = 0;
            int j = nums.length-1;
            while(i<j){
                if (nums[i]+nums[j]==target){
                    List<Integer> l = new ArrayList();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    ans.add(l);
                    i++;
                    j--;
                } else if (nums[i]+nums[j]<target){
                    i++;
                } else {
                    j--;
                }
            }
        }
        return distinct(ans);
    }

    private List<List<Integer>> distinct(List<List<Integer>> ls){
        return ls.stream().distinct().collect(Collectors.toList());
    }

    private int[] quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums,int lo, int hi){
        if (lo>=hi){
            return;
        }
        int i=lo;
        int j=hi;
        int t = nums[lo];
        while(i<j){
            while(nums[j]>=t && i<j){
                j--;
            }
            if (i<j){
                nums[i]=nums[j];
                nums[j]=t;
                while(nums[i]<=t && i<j){
                    i++;
                }
                if (i<j){
                    nums[j]=nums[i];
                    nums[i]=t;
                }
            }
        }
        quickSort(nums,lo,i-1);
        quickSort(nums,i+1,hi);
    }
}