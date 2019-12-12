package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
Design a Skiplist without using any built-in libraries.
A Skiplist is a data structure that takes O(log(n)) time to add, erase and search.
Comparing with treap and red-black tree which has the same function and performance,
the code length of Skiplist can be comparatively short and the idea behind Skiplists are just simple linked lists
**/
public class SkipList {

    private Map<Integer,Node> headNodes = new HashMap<>();

    static class Node{
        int val;
        Node next;
        Node pre;
        Node down;

        Node(int val){
            this.val = val;
        }
    }

    public SkipList() {
        headNodes.put(1,new Node(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        Node n = headNodes.get(headNodes.size());
        while (n!=null){
            if (n.val==target){
                return true;
            }
            if (n.val>target){
                return false;
            }
            if (n.next==null || n.next.val>target){
                n = n.down;
            } else {
                n = n.next;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = getLevel();
        Node d = null;
        for (int i=1;i<=level;i++){
            if (i<=headNodes.size()){
                Node h = headNodes.get(i);
                while (h.next!=null && h.next.val<num){
                    h = h.next;
                }
                Node n = new Node(num);
                n.next = h.next;
                if (h.next!=null){
                    h.next.pre = n;
                }
                h.next = n;
                n.pre = h;
                n.down = d;
                d = n;
            } else {
                Node n = new Node(num);
                Node h = new Node(Integer.MIN_VALUE);
                headNodes.put(i,h);
                h.down = headNodes.get(i-1);
                h.next = n;
                n.pre = h;
                n.down = d;
                d = n;
            }
        }
    }

    private int getLevel(){
        int level = 1;
        while (Math.random()<0.5){
            level++;
        }
        return level;
    }

    public boolean erase(int num) {
        Node t = headNodes.get(headNodes.size());
        boolean erase = false;
        while (t!=null){
            if (t.next==null){
                t = t.down;
            } else {
                if (t.next.val==num){
                    t = t.next;
                    erase = true;
                    while (t!=null){
                        t.pre.next=t.next;
                        if (t.next!=null){
                            t.next.pre=t.pre;
                        }
                        t = t.down;
                    }
                } else if (t.next.val<num){
                    t = t.next;
                } else {
                    t = t.down;
                }
            }
        }
        return erase;
    }

}
