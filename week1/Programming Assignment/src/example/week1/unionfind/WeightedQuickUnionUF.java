package example.week1.unionfind;

/**
 * This is an improved implementation of the QuickUnionUF class, used the idea
 * of weighted tree concatenation and path compression.
 */
public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
            this.sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != this.id[i]) {
            this.id[i] = this.id[this.id[i]];
            i = this.id[i];
        }
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
}
