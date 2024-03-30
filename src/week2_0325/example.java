package week2_0325;

import java.io.*;
import java.util.*;

public class example{
    static int[] tree;
    static int size = 0;
    public static void main(String[] args) throws IOException {

    }
    static int swap(int x, int y){
        return x;
    }

    // 값 추가
    static void add(int x){
        tree[++size] = x;

        int idx = size;
        while(idx>1){
            // 부모노드가 자식노드보다 값이 더 큰경우
            if(tree[idx] < tree[idx/2]) swap(idx, idx/2);
            else break;
            idx /= 2;
        }
    }



}