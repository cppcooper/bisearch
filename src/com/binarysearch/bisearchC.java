package com.binarysearch;

public class bisearchC extends abstractBisearch {

    @Override
    public int valuePos(int x) {
        start();
        if(x < arr.get(left)){
            return -1;
        } else if (x > arr.get(right)){
            return -1;
        }
        return valuePos(x,left,right);
    }

    private int valuePos(int x, int l, int r){
        if(l<=r){
            int m = l + (r-l)/2;
            int v = arr.get(m);
            if(v==x){
                return m;
            }else if(x<v){
                return valuePos(x,l,m-1);
            }else{
                return valuePos(x,m+1,r);
            }
        }
        return -1;
    }

    @Override
    public int insertPos(int x) {
        start();
        if(x < arr.get(left)){
            return 0;
        } else if (x > arr.get(right)){
            return right+1;
        }
        return insertPos(x,left,right);
    }

    private int insertPos(int x, int l, int r){
        int m = l + (r-l)/2;
        if(l<=r){
            int v = arr.get(m);
            if(v==x){
                return m;
            }else if(x<v){
                return insertPos(x,l,m-1);
            }else{
                return insertPos(x,m+1,r);
            }
        }
        return m;
    }
}
