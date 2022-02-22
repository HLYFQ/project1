package main;

import java.io.*;
import java.util.*;

public class main {
    static Scanner cin=new Scanner(System.in);
    static ArrayList<Train> trainlist=new ArrayList();
    static ArrayList<Flight> flightlist=new ArrayList();
    static String redix="\\s+";
    static BufferedWriter bb;
    static Map<String ,Integer> m=new HashMap<>();
    static Map<String ,Integer> n=new HashMap<>();
    static Train[][] trains=new Train[100][100];
    //static Flight[][] flights=new Flight[100][];
    static  int Max_num=10000;
    static  int[] head= new int[Max_num];
    static  int[] head2= new int[Max_num];
    static  node[] edge=new node[Max_num];
    static  node[] edge2=new node[Max_num];
    static  boolean[] vis= new boolean[Max_num];
    static int tot;
    static {
        try {
            bb = new BufferedWriter(new FileWriter("src\\Routes"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addtrain() throws Exception {
        while (true) {
            System.out.println("请依次输入您要添加的信息：车次 起点站 终点站 到站时间 发车时间  票价");
            String s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            Train train=new Train(str);
            trainlist.add(train);
            System.out.println("是否继续添加：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0) {
                System.out.println("添加成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void addflight() throws Exception {
        while (true) {
            System.out.println("请依次输入您要添加的信息：航班号 起点站 终点战 起飞时间 到达时间  票价");
            String s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            Flight flight=new Flight(str);
            flightlist.add(flight);
            System.out.println("是否继续添加：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("添加成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void deletetrain() throws Exception {
        while(true){
            System.out.println("请输入您想删除信息的编号：");
            String s;
            int ans=1;
            for (int i = 0; i < trainlist.size(); i++) {
                System.out.print(ans+" ");
                ans++;
                System.out.println(trainlist.get(i).toString());
            }
            int number=cin.nextInt();
            String ss=cin.nextLine();
            trainlist.remove(number-1);
            System.out.println("是否继续删除：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("删除成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void deleteflight() throws Exception {
        while (true) {
            System.out.println("请输入您想删除信息的编号：");
            String s;
            int ans=1;
            for (int i = 0; i < flightlist.size(); i++) {
                System.out.print(ans+" ");
                ans++;
                System.out.println(flightlist.get(i).toString());
            }
            int number=cin.nextInt();
            String ss=cin.nextLine();
            flightlist.remove(number-1);
            System.out.println("是否继续删除：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("删除成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void moditytrain() throws Exception {
        while(true){
            System.out.println("请输入您想修改的编号：");
            String s;
            int ans=1;
            for (int i = 0; i < trainlist.size(); i++) {
                System.out.print(ans+" ");
                ans++;
                System.out.println(trainlist.get(i).toString());
            }
            int number=cin.nextInt();
            cin.nextLine();
            System.out.println("请输入您修改后的信息：车次 起点站 终点站 到站时间 发车时间  票价");
            s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            trainlist.remove(number-1);
            trainlist.add(number-1,new Train(str));
            System.out.println("是否继续修改：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("修改成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void modityflight() throws Exception {
        while(true){
            System.out.println("请输入您想修改的编号：");
            String s;
            int ans=1;
            for (int i = 0; i < flightlist.size(); i++) {
                System.out.print(ans+" ");
                ans++;
                System.out.println(flightlist.get(i).toString());
            }
            int number=cin.nextInt();
            cin.nextLine();
            System.out.println("请输入您修改后的信息：航班号 起点站 终点战 起飞时间 到达时间  票价");
            s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            flightlist.remove(number-1);
            flightlist.add(number-1,new Flight(str));
            System.out.println("是否继续修改：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("修改成功");
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void zhongzhuan(String x,String y) throws Exception {

    }

    public static void add_train(int u,int v,String hao,int qitime,int zhongtime,int fee,int id){
        tot++;
        edge[tot]=new node();
        edge[tot].to=v;
        edge[tot].nex=head[u];
        head[u]=tot;
        edge[tot].qitime=qitime;
        edge[tot].zhongtime=zhongtime;
        edge[tot].hao=hao;
        edge[tot].fee=fee;
        edge[tot].id=id;
    }

    public static void add_airplane(int u,int v,String hao,int qitime,int zhongtime,int fee,int id){
        tot++;
        edge2[tot]=new node();
        edge2[tot].to=v;
        edge2[tot].nex=head2[u];
        head2[u]=tot;
        edge2[tot].qitime=qitime;
        edge2[tot].zhongtime=zhongtime;
        edge2[tot].hao=hao;
        edge2[tot].fee=fee;
        edge2[tot].id=id;
    }

    public static ArrayList<Integer> city =new ArrayList<>();
    public static void bfs_leastnumber(int x,int y){
        int panduan=-1;
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=100;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                if(panduan!=1){
                    city.clear();
                    panduan=1;
                    for(int j=1;j<b.v.size();j++){
                        if(!b.v.get(j).hao.equals(b.v.get(j-1).hao)){
                            panduan=-1;
                            city.add(b.v.get(j-1).id);
                        }

                    }
                }
                ppp= Math.min(ppp,city.size());
            }
            else{
                for(int i=head[u];i!=-1;i=edge[i].nex){
                    if(vis[edge[i].to]==false){
                        ArrayList<bfs_zhongzhuan2> lin=new ArrayList<>();
                        for(int j=0;j<b.v.size();j++){
                            lin.add(b.v.get(j));
                        }
                        lin.add(new bfs_zhongzhuan2(edge[i].hao,edge[i].id));
                        q.add(new bfs_zhongzhuan(edge[i].to,lin));
                    }

                }
            }
        }
        if(panduan==1){
            System.out.println("中转次数最少的方案：中转次数为0");
        }
        else{
            System.out.println("中转次数最少的方案：中转次数为"+ppp);
        }
    }

    static  ArrayList<Integer> timee=new ArrayList<>();
    public static void bfs_leasttime(int x,int y){
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=1000000;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                int cha=trainlist.get(b.v.get(b.v.size()-1).id).getEndtime()-trainlist.get(b.v.get(0).id).getEndtime();
                if(cha<=ppp){
                    timee.clear();
                    for(int j=0;j<b.v.size();j++){
                        timee.add(b.v.get(j).id);
                    }
                    ppp=cha;
                }
            }
            else{
                for(int i=head[u];i!=-1;i=edge[i].nex){
                    if(vis[edge[i].to]==false) {
                        if (u == x) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge[i].hao, edge[i].id));
                            q.add(new bfs_zhongzhuan(edge[i].to, lin));
                        } else if (edge[i].zhongtime >= trainlist.get(b.v.get(b.v.size() - 1).id).getEndtime()) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge[i].hao, edge[i].id));
                            q.add(new bfs_zhongzhuan(edge[i].to, lin));
                        }
                    }
                }
            }
        }
        System.out.println("花费时间最少的方案:(花费时间为"+ppp+"min)");
        for (int i = 0; i < timee.size(); i++) {
            System.out.println(trainlist.get(timee.get(i)).toString());
        }
    }

    static  ArrayList<Integer> price=new ArrayList<>();
    public static void bfs_leastprice(int x,int y){
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=1000000000;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                int cha=0;
                for (int i = 0; i < b.v.size(); i++) {
                    cha+=trainlist.get(b.v.get(i).id).getPrice();
                }
                if(cha<=ppp){
                    timee.clear();
                    for(int j=0;j<b.v.size();j++){
                        timee.add(b.v.get(j).id);
                    }
                    ppp=cha;
                }
            }
            else{
                for(int i=head[u];i!=-1;i=edge[i].nex){
                    if(vis[edge[i].to]==false) {
                        if (u == x) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge[i].hao, edge[i].id));
                            q.add(new bfs_zhongzhuan(edge[i].to, lin));
                        } else if (edge[i].zhongtime >= trainlist.get(b.v.get(b.v.size() - 1).id).getEndtime()) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge[i].hao, edge[i].id));
                            q.add(new bfs_zhongzhuan(edge[i].to, lin));
                        }
                    }
                }
            }
        }
        System.out.println("花费时间最少的方案:(花费金钱为"+ppp+"元)");
        for (int i = 0; i < timee.size(); i++) {
            System.out.println(trainlist.get(timee.get(i)).toString());
        }
    }

    public static void bulidtu() throws InterruptedException {
        //把城市名换算成数字
        Arrays.fill(head,-1);
        Arrays.fill(head2,-1);
        int ans=1;
        for (int i = 0; i < trainlist.size(); i++) {
            String nm=trainlist.get(i).getName();
            if(!m.containsKey(nm)){
                m.put(nm,ans);
                ans++;
            }
            nm=trainlist.get(i).getEndname();
            if(!m.containsKey(nm)){
                m.put(nm,ans);
                ans++;
            }
        }
        for (int i = 0; i < flightlist.size(); i++) {
            String nm=flightlist.get(i).getStartplace();
            if(!m.containsKey(nm)){
                m.put(nm,ans);
                ans++;
            }
            nm=flightlist.get(i).getEndplace();
            if(!m.containsKey(nm)){
                m.put(nm,ans);
                ans++;
            }
        }
        for (int i = 0; i < trainlist.size(); i++) {
            String hao = trainlist.get(i).getId();
            int qi=m.get(trainlist.get(i).getName());
            int dao=m.get(trainlist.get(i).getEndname());
            int qitime=trainlist.get(i).getStarttime();
            int daotime=trainlist.get(i).getEndtime();
            int price=trainlist.get(i).getPrice();
            add_train(qi,dao,hao,qitime,daotime,price,i);
            //int u,int v,String hao,int qitime,int zhongtime,int fee,int id
        }
        tot=0;
        for (int i = 0; i < flightlist.size(); i++) {
            String hao = flightlist.get(i).getFightid();
            int qi=m.get(flightlist.get(i).getStartplace());
            int dao=m.get(flightlist.get(i).getEndplace());
            int qitime=flightlist.get(i).getStarttime();
            int daotime=flightlist.get(i).getEndtime();
            int price=flightlist.get(i).getPrice();
            add_airplane(qi,dao,hao,qitime,daotime,price,i);
            //int u,int v,String hao,int qitime,int zhongtime,int fee,int id
        }
    }




    public static ArrayList<Integer> city2 =new ArrayList<>();
    public static void bfs_leastnumber2(int x,int y){
        int panduan=-1;
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=100;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                if(panduan!=1){
                    city2.clear();
                    panduan=1;
                    for(int j=1;j<b.v.size();j++){
                        if(!b.v.get(j).hao.equals(b.v.get(j-1).hao)){
                            panduan=-1;
                            city2.add(b.v.get(j-1).id);
                        }
                    }
                }
                ppp= Math.min(ppp,city2.size());
            }
            else{
                for(int i=head2[u];i!=-1;i=edge2[i].nex){
                    if(vis[edge2[i].to]==false){
                        ArrayList<bfs_zhongzhuan2> lin=new ArrayList<>();
                        for(int j=0;j<b.v.size();j++){
                            lin.add(b.v.get(j));
                        }
                        lin.add(new bfs_zhongzhuan2(edge2[i].hao,edge2[i].id));
                        q.add(new bfs_zhongzhuan(edge2[i].to,lin));
                    }

                }
            }
        }
        if(panduan==1){
            System.out.println("中转次数最少的方案：中转次数为0");
        }
        else{
            System.out.println("中转次数最少的方案：中转次数为"+ppp);
        }
    }

    static  ArrayList<Integer> timee2=new ArrayList<>();
    public static void bfs_leasttime2(int x,int y){
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=1000000;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                int cha=flightlist.get(b.v.get(b.v.size()-1).id).getEndtime()-flightlist.get(b.v.get(0).id).getEndtime();
                if(cha<=ppp){
                    timee2.clear();
                    for(int j=0;j<b.v.size();j++){
                        timee2.add(b.v.get(j).id);
                    }
                    ppp=cha;
                }
            }
            else{
                for(int i=head2[u];i!=-1;i=edge2[i].nex){
                    if(vis[edge2[i].to]==false) {
                        if (u == x) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge2[i].hao, edge2[i].id));
                            q.add(new bfs_zhongzhuan(edge2[i].to, lin));
                        } else if (edge2[i].zhongtime >= flightlist.get(b.v.get(b.v.size() - 1).id).getEndtime()) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge2[i].hao, edge2[i].id));
                            q.add(new bfs_zhongzhuan(edge2[i].to, lin));
                        }
                    }
                }
            }
        }
        System.out.println("花费时间最少的方案:(花费时间为"+ppp+"min)");
        for (int i = 0; i < timee2.size(); i++) {
            System.out.println(flightlist.get(timee2.get(i)).toString());
        }
    }

    static  ArrayList<Integer> price2=new ArrayList<>();
    public static void bfs_leastprice2(int x,int y){
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x));
        int ppp=1000000000;
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            vis[u]=true;
            if(u==y){
                int cha=0;
                for (int i = 0; i < b.v.size(); i++) {
                    cha+=flightlist.get(b.v.get(i).id).getPrice();
                }
                if(cha<=ppp){
                    timee2.clear();
                    for(int j=0;j<b.v.size();j++){
                        timee2.add(b.v.get(j).id);
                    }
                    ppp=cha;
                }
            }
            else{
                for(int i=head2[u];i!=-1;i=edge2[i].nex){
                    if(vis[edge2[i].to]==false) {
                        if (u == x) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge2[i].hao, edge2[i].id));
                            q.add(new bfs_zhongzhuan(edge2[i].to, lin));
                        } else if (edge2[i].zhongtime >= flightlist.get(b.v.get(b.v.size() - 1).id).getEndtime()) {
                            ArrayList<bfs_zhongzhuan2> lin = new ArrayList<>();
                            for (int j = 0; j < b.v.size(); j++) {
                                lin.add(b.v.get(j));
                            }
                            lin.add(new bfs_zhongzhuan2(edge2[i].hao, edge2[i].id));
                            q.add(new bfs_zhongzhuan(edge2[i].to, lin));
                        }
                    }
                }
            }
        }
        System.out.println("花费时间最少的方案:(花费金钱为"+ppp+"元)");
        for (int i = 0; i < timee2.size(); i++) {
            System.out.println(flightlist.get(timee2.get(i)).toString());
        }

    }

    public static void work() throws Exception {
        bulidtu();

        System.out.println("请输入出发站和目的站：");
        String shi,dao;
        shi="武汉";
        dao="昆明";
//        shi=cin.next();//起始站和终止站
//        dao=cin.next();
        System.out.println("交通工具为火车");
        bfs_leastnumber(m.get(shi),m.get(dao));
        Arrays.fill(vis,false);
        bfs_leasttime(m.get(shi),m.get(dao));
        Arrays.fill(vis,false);
        bfs_leastprice(m.get(shi),m.get(dao));
        tot=1;
        System.out.println("\n");
        System.out.println("交通工具为飞机");
        Arrays.fill(vis,false);
        bfs_leastnumber2(m.get(shi),m.get(dao));
        Arrays.fill(vis,false);
        bfs_leasttime2(m.get(shi),m.get(dao));
        Arrays.fill(vis,false);
        bfs_leastprice2(m.get(shi),m.get(dao));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\TrainTime"));
        BufferedReader bufferedReader1=new BufferedReader(new FileReader("src\\FlightSchedule"));
        String sp;
        trainlist.clear();
        while((sp=bufferedReader.readLine())!=null){
            trainlist.add(new Train(sp));
        }
        bufferedReader.close();
        flightlist.clear();
        while((sp=bufferedReader1.readLine())!=null){
            flightlist.add(new Flight(sp));
        }
        bufferedReader1.close();
        waihuan:while(true){
            System.out.println("-----------------菜单-----------------");
            System.out.println("对火车时刻信息进行添加请输入1：");
            System.out.println("对航班时刻信息进行添加请输入2：");
            System.out.println("对火车时刻信息进行删除请输入3：");
            System.out.println("对航班时刻信息进行删除请输入4：");
            System.out.println("对火车时刻信息进行修改请输入5：");
            System.out.println("对航班时刻信息进行修改请输入6：");
            System.out.println("开始选择最优方案请输入7：");
            System.out.println("如要退出请输入8：");
            System.out.println("请选择你要进行的操作：");
            int s=cin.nextInt();
            String ss=cin.nextLine();
            switch (s){
                case 1: addtrain();break;
                case 2: addflight();break;
                case 3: deletetrain();break;
                case 4: deleteflight();break;
                case 5: moditytrain();break;
                case 6: modityflight();break;
                case 7: work();break waihuan;
                case 8: break waihuan;
                default:
                    System.out.println("输入不合规，请重新输入");
            }
        }
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\TrainTime"));
        BufferedWriter bufferedWriter1=new BufferedWriter(new FileWriter("src\\FlightSchedule"));
        for (int i = 0; i < trainlist.size(); i++) {
            String str;
            str=trainlist.get(i).toString();
            bufferedWriter.write(str+"\n");
            bufferedWriter.flush();
        }
        for (int i = 0; i < flightlist.size(); i++) {
            String str;
            str=flightlist.get(i).toString();
            bufferedWriter1.write(str+"\n");
            bufferedWriter1.flush();
        }
        bufferedWriter.close();
        bufferedWriter1.close();
        System.out.println("谢谢使用！撒悠啦啦！！！");
    }
}
