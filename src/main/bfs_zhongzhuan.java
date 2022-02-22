package main;

import java.util.ArrayList;

public class bfs_zhongzhuan {
    public int u;

    public ArrayList<bfs_zhongzhuan2> v=new ArrayList<>();

    public bfs_zhongzhuan(int u) {
        this.u = u;
    }

    public bfs_zhongzhuan(int u, ArrayList<bfs_zhongzhuan2> v) {
        this.u = u;
        for (int i = 0; i < v.size(); i++) {
            this.v.add(v.get(i));
        }
    }
}

class bfs_zhongzhuan2{
    String hao;
    int id;

    public bfs_zhongzhuan2(String hao, int id) {
        this.hao = hao;
        this.id = id;
    }
}