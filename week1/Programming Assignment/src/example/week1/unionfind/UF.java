package example.week1.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id; // entry id
    private int[] sz; // size of the component
    private int count; // number of entries

    public UF(int N) {
        // initialize entry array id
        this.count = N;
        this.id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
            this.sz[i] = 1;
        }
    }

    public int count() {
        return this.count;
    }
    
    private int root(int i) {
        while (i != this.id[i])
            i = this.id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
        int i = this.root(p);
        int j = this.root(q);
        if (i == j)
            return;
        if (this.sz[i] < this.sz[j]) {
            this.id[i] = j;
            this.sz[j] += this.sz[i];
        } else {
            this.id[j] = i;
            this.sz[i] += this.sz[j];
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
        StdOut.println("End");
    }
}
