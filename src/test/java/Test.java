import linkedlist.SkipList;
import searchsort.ContainerWithMostWater;

public class Test {

    public static void main(String args[]){
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] a = {4,4,2,11,0,11,5,11,13,8};
        water.maxArea(a);
    }
}
