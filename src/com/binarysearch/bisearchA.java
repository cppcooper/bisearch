package com.binarysearch;


public class bisearchA extends abstractBisearch {

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
}
