package week2_0325;

    import java.io.*;
    import java.util.*;

    public class example{
        static int[] tree;
        static int size = 0;
        public static void main(String[] args) throws IOException {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int x = 0;
            pq.offer(x); // pq 에 x 추가
            int y = pq.poll(); // pq에 가장 높은 노드의 값을 y에 저장하고 큐에서 제거

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

    // 값 제거
    static int remove(){
        if(size ==0) return 0;
        int top = tree[size];

        tree[1] = tree[size];
        tree[size--] = 0;

        int idx = 1;
        while(idx*2 <= size){
            int l=idx*2, r=idx*2+1;

            if(r>size || tree[l]<tree[r] && tree[idx]>tree[l]){
                swap(idx, l);
                idx = l;
            }
            else if(r<=size && tree[idx]>tree[r]){
                swap(idx, r);
                idx = r;
            }
            else break;
        }
        return top;
    }
}