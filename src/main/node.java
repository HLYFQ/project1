package main;

public class node {
    public int to;
    public int qitime;
    public String hao;
    public int zhongtime;
    public int fee;
    public int nex;
    int id;

    public node(int to, int qitime, String hao,int nex, int zhongtime, int fee, int id) {
        this.to = to;
        this.qitime = qitime;
        this.hao = hao;
        this.nex=nex;
        this.zhongtime = zhongtime;
        this.fee = fee;
        this.id = id;
    }

    public node() {

    }
}
