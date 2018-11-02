package com.binarysearch;

import java.util.ArrayList;

abstract public class abstractBisearch {
    public ArrayList<Integer> arr = new ArrayList<>(50);;
    protected int left;
    protected int right;
    protected int mid;

    protected void start(){
        left = 0;
        right = arr.size()-1;
        mid = (right-left)/2;
    }

    public int nextLowestPos(int x){
        if(arr.get(0) >= x){
            return -1;
        } else if (arr.get(arr.size()-1) < x) {
            return arr.size()-1;
        } else {
            int p = valuePos(x);
            if (p >= 0) {
                return p - 1;
            }
        }
        return insertPos(x)-1;
    }
    public int nextHighestPos(int x){
        if(arr.get(0) > x){
            return 0;
        } else if (arr.get(arr.size()-1) <= x) {
            return -1;
        } else {
            int p = valuePos(x);
            if (p >= 0) {
                return p + 1;
            }
        }
        return insertPos(x);
    }


    abstract public int valuePos(int x);
    abstract public int insertPos(int x);
}
