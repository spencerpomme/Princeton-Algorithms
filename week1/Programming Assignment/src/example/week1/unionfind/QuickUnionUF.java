package example.week1.unionfind;

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            this.id[i] = i;
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
        int i = this.root(p);
        int j = this.root(q);
        this.id[i] = j;
    }
}
