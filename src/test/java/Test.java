import linkedlist.SkipList;

public class Test {

    public static void main(String args[]){
        SkipList skipList = new SkipList();
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
        skipList.search(0);
        skipList.add(4);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.erase(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.add(1);
        skipList.search(1);
        skipList.erase(0);
        skipList.erase(1);
        skipList.search(1);
        skipList.erase(1);
        skipList.search(1);
    }
}
