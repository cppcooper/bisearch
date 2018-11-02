package com.binarysearch;


public class bisearchB extends abstractBisearch {
    
    public int valuePos(int x){
        start();
        if(x < arr.get(0)){
            return -1;
        } else if (x > arr.get(arr.size()-1)) {
            return -1;
        } else {
            int increment = (right-left)/2;
            for(mid = increment; arr.get(mid) != x ;mid+=increment){
                int v = arr.get(mid);
                if(v < x){
                    left = mid + 1;
                    increment = 1 + (right-left)/2;
                }else if(v > x){
                    right = mid;
                    increment = 0 - 1 - (right-left)/2;
                    if(left==right){
                        return -1;
                    }
                }else{
                    return mid;
                }
            }
        }
        return mid;
    }

    public int insertPos(int x){
        start();
        if(x < arr.get(0)){
            return 0;
        } else if (x > arr.get(arr.size()-1)) {
            return arr.size();
        } else {
            int increment = (right-left)/2;
            for(mid = increment; arr.get(mid) != x ;mid+=increment){
                int v = arr.get(mid);
                if (v < x) {
                    left = mid + 1;
                    increment = 1 + (right-left)/2;
                } else if (v > x) {
                    right = mid;
                    increment = 0 - 1 - (right-left)/2;
                    if (left == right) {
                        return right;
                    }
                } else {
                    return mid;
                }
            }
        }
        return mid;
    }
}
