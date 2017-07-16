package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id; // entry id
    private int count; // number of entries
    
    public UF(int N) {
        // initialize entry array id
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            this.id[i] = i;
    }
    
    public int count() {
        return this.count;
    }
    
    public boolean connected(int p, int q) {
        return false;
        // TODO: finish this implementation
    }
    
    public void union(int p, int q) {
        // TODO: finish this implementation
    }
    
    public static void main(String[] args) {
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
    }
}
