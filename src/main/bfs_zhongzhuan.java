package main;

import java.util.ArrayList;

public class bfs_zhongzhuan {
    public int u;
    public int road_i;
    public int road_j;
    public ArrayList<bfs_zhongzhuan2> v=new ArrayList<>();

    public bfs_zhongzhuan(int u, int road_i,int road_j) {
        this.u = u;
        this.road_i = road_i;
        this.road_j=road_j;
    }

    public bfs_zhongzhuan(int u, int road_i,int road_j, ArrayList<bfs_zhongzhuan2> v) {
        this.u = u;
        this.road_i = road_i;
        this.road_j=road_j;
        for (int i = 0; i < v.size(); i++) {
            this.v.add(new bfs_zhongzhuan2(v.get(i).road_i,v.get(i).road_j));
        }
    }
}
