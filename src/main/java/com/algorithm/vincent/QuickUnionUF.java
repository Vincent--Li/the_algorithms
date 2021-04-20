package com.algorithm.vincent;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for(int i = 0; i < N ; i++){
            id[i] = i;
        }
    }

    public int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    public boolean connected(int i, int j){
        return root(i) == root(j);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(1,3);
        uf.union(5,7);
        uf.union(5,9);
        uf.union(2,4);
        uf.union(4,6);
        uf.union(8,9);

        System.out.println(uf.connected(0,9));
        System.out.println(uf.connected(2,6));
        System.out.println(uf.connected(7,9));
    }
}
