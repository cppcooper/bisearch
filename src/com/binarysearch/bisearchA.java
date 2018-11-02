package com.binarysearch;


public class bisearchA extends abstractBisearch {

    public int valuePos(int x){
        start();
        if(x < arr.get(left)){
            return -1;
        } else if (x > arr.get(right)) {
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
        if(x < arr.get(left)){
            return 0;
        } else if (x > arr.get(right)) {
            return arr.size();
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
        return mid;
    }
}
