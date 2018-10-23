package com.binarysearch;

import java.util.ArrayList;

public class bisearchesA {
    public ArrayList<Integer> arr = new ArrayList<>(50);
    private int left;
    private int right;
    private int mid;

    private void start(){
        left = 0;
        right = arr.size()-1;
        mid = (right-left)/2;
    }

    public int valuePos(int x){
        start();
        if(arr.get(0) > x){
            return -1;
        } else if (arr.get(arr.size()-1) < x) {
            return -1;
        } else {
            while (left <= right) {
                int v = arr.get(mid);
                if (v < x) {
                    left = mid + 1;
                } else if (v > x) {
                    right = mid;
                    if (right == left) {
                        break;
                    }
                } else {
                    return mid;
                }
                mid = left + (right - left) / 2;
            }
        }
        return -1;
    }

    public int insertPos(int x){
        start();
        if(arr.get(0) > x){
            return 0;
        } else if (arr.get(arr.size()-1) < x) {
            return arr.size();
        } else {
            while (left <= right) {
                int v = arr.get(mid);
                if (v < x) {
                    left = mid + 1;
                } else if (v > x) {
                    right = mid;
                    if (right == left) {
                        return right;
                    }
                } else {
                    return mid;
                }
                mid = left + (right - left) / 2;
            }
        }
        return mid;
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
}
