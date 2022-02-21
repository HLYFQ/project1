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
    static int ans=1;
    static Train[][] trains=new Train[100][100];
    //static Flight[][] flights=new Flight[100][];
    static  int Max_num=10000;
    static  int[] head= new int[Max_num];
    static  int[] to= new int[Max_num];
    static  int[] nex= new int[Max_num];
    static  int[] road_id= new int[Max_num];
    static  int[] road_i= new int[Max_num];
    static  int[] road_j= new int[Max_num];
    static  boolean[] vis= new boolean[Max_num];
    //static Queue<Train> q=new LinkedList<Train>();
    static int tot;
    static {
        try {
            bb = new BufferedWriter(new FileWriter("src\\Routes"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static void deletefiletext(int x){
        File file;
        if(x==1)
            file =new File("src\\TrainTime");
        else
            file =new File("src\\FlightSchedule");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addtrain() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\TrainTime",true));
        while (true) {
            System.out.println("请依次输入您要添加的信息：车次 站名 到站时间 发车时间  票价");
            String s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            Train train=new Train(str);
            trainlist.add(train);
            bufferedWriter.write(str+"\n");
            bufferedWriter.flush();
            System.out.println("是否继续添加：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0) {
                System.out.println("添加成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void addflight() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\FlightSchedule",true));
        while (true) {
            System.out.println("请依次输入您要添加的信息：航班号 起点站 终点战 起飞时间 到达时间  票价");
            String s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            Flight flight=new Flight(str);
            flightlist.add(flight);
            bufferedWriter.write(str+"\n");
            bufferedWriter.flush();
            System.out.println("是否继续添加：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("添加成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void deletetrain() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\TrainTime",true));
        while(true){
            System.out.println("请输入您想删除信息的编号：");
            //这个读的管道必须放在循环里面，以便重读
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\TrainTime"));
            String s;
            int ans=1;
            trainlist.clear();
            while((s=bufferedReader.readLine())!=null){
                trainlist.add(new Train(s));
                System.out.print(ans+" ");
                ans++;
                System.out.println(s);
            }
            int number=cin.nextInt();
            String ss=cin.nextLine();
            trainlist.remove(number-1);
            deletefiletext(1);
            for (int i = 0; i < trainlist.size(); i++) {
                String xin=trainlist.get(i).toString();
                bufferedWriter.write(xin+"\n");
                bufferedWriter.flush();
            }
            System.out.println("是否继续删除：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("删除成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void deleteflight() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\FlightSchedule",true));
        while (true) {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\FlightSchedule"));
            System.out.println("请输入您想删除信息的编号：");
            String s;
            int ans=1;
            //flightlist.clear();
            while((s=bufferedReader.readLine())!=null){
                flightlist.add(new Flight(s));
                System.out.print(ans+" ");
                ans++;
                System.out.println(s);
            }
            int number=cin.nextInt();
            String ss=cin.nextLine();
            flightlist.remove(number-1);
            deletefiletext(2);
            for (int i = 0; i < flightlist.size(); i++) {
                String xin=flightlist.get(i).toString();
                bufferedWriter.write(xin+"\n");
                bufferedWriter.flush();
            }
            System.out.println("是否继续删除：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("删除成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void moditytrain() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\TrainTime",true));
        while(true){
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\TrainTime"));
            System.out.println("请输入您想修改的编号：");
            String s;
            int ans=1;
            trainlist.clear();
            while((s=bufferedReader.readLine())!=null){
                trainlist.add(new Train(s));
                System.out.print(ans+" ");
                ans++;
                System.out.println(s);
            }
            int number=cin.nextInt();
            cin.nextLine();
            System.out.println("请输入您修改后的信息：车次 站名 到站时间 发车时间  票价");
            s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            trainlist.remove(number-1);
            trainlist.add(number-1,new Train(str));
            deletefiletext(1);
            for (int i = 0; i < trainlist.size(); i++) {
                String xin=trainlist.get(i).toString();
                bufferedWriter.write(xin+"\n");
                bufferedWriter.flush();
            }
            System.out.println("是否继续修改：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("修改成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void modityflight() throws Exception {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src\\FlightSchedule",true));
        while(true){
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\FlightSchedule"));
            System.out.println("请输入您想修改的编号：");
            String s;
            int ans=1;
            flightlist.clear();
            while((s=bufferedReader.readLine())!=null){
                flightlist.add(new Flight(s));
                System.out.print(ans+" ");
                ans++;
                System.out.println(s);
            }
            int number=cin.nextInt();
            cin.nextLine();
            System.out.println("请输入您修改后的信息：航班号 起点站 终点战 起飞时间 到达时间  票价");
            s=cin.nextLine();
            String str=s.replaceAll(redix," ");
            flightlist.remove(number-1);
            flightlist.add(number-1,new Flight(str));
            deletefiletext(2);
            for (int i = 0; i < flightlist.size(); i++) {
                String xin=flightlist.get(i).toString();
                bufferedWriter.write(xin+"\n");
                bufferedWriter.flush();
            }
            System.out.println("是否继续修改：是输入1，否输入0");
            int p=cin.nextInt();
            cin.nextLine();
            if(p==0){
                System.out.println("修改成功");
                bufferedWriter.close();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public static void zhongzhuan(String x,String y) throws Exception {

    }

    public static void add_train(int u,int v,int x,int y){
        tot++;
        to[tot]=v;
        nex[tot]=head[u];
        head[u]=tot;
        road_id[tot]=1;
        road_i[tot]=x;
        road_j[tot]=y;
    }
//    public static void add_airplane(int u,int v,int w){
//        tot++;
//        to[tot]=v;
//        nex[tot]=head[u];
//        head[u]=tot;
//        road_id[tot]=2;
//        road_i[tot]=w;
//    }
    public static int panduan=-1;
    public static ArrayList<bfs_zhongzhuan2> city =new ArrayList<>();
    public static void bfs_zhongzhuanhanshu(int x,int y){
        Queue<bfs_zhongzhuan> q=new LinkedList<bfs_zhongzhuan>();
        q.add(new bfs_zhongzhuan(x,0,1));
        while(!q.isEmpty()){
            bfs_zhongzhuan b=q.poll();
            int u=b.u;
            if(u==y){
                if(panduan!=1){
                    city.clear();
                    for(int j=0;j<b.v.size();j++){
                        if(j>=1){
                            if(b.v.get(j-1).road_i!=b.v.get(j).road_i){
                                panduan=2;
                                city.add(new bfs_zhongzhuan2(b.v.get(j-1).road_i,b.v.get(j-1).road_j));
                            }

                        }
                        else{
                            panduan=1;
                        }
                    }
                }

            }
            else{
                for(int i=head[u];i!=0;i=nex[i]){
                    ArrayList<bfs_zhongzhuan2> lin=new ArrayList<>();
                    for(int j=0;j<b.v.size();j++){
                        lin.add(b.v.get(j));
                    }
                    lin.add(new bfs_zhongzhuan2(road_i[i],road_j[i]));
                    q.add(new bfs_zhongzhuan(to[i],road_i[i],road_j[i],lin));
                }
            }
        }
        if(panduan==1){
            System.out.println("从起点到终点可以乘坐火车，并且不需要中转");
        }
        else{
            System.out.println("从起点到终点可以乘坐火车，但需要中转，需要中转的城市有");
            for (int i = 0; i < city.size(); i++) {
                System.out.println(trains[city.get(i).road_i][city.get(i).road_j-1].getName());
            }
        }
    }
    public static void bulidtu() throws InterruptedException {
        //把城市名换算成数字
        for (int i = 0; i < trainlist.size(); i++) {
            String nm=trainlist.get(i).getName();
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
        //车号标记
        ans=1;
        for (int i = 0; i < trainlist.size(); i++) {
            String nm=trainlist.get(i).getId();
            if(!n.containsKey(nm)){
                n.put(nm,ans);
                ans++;
            }
        }
        for (int i = 0; i < flightlist.size(); i++) {
            String nm=flightlist.get(i).getFightid();
            if(!n.containsKey(nm)){
                n.put(nm,ans);
                ans++;
            }
        }
        int[] len=new int[100];
        for (int i = 0; i < trainlist.size(); i++) {
            String nm = trainlist.get(i).getId();
            int num = n.get(nm);
            if (len[num]!=0) {
                add_train(m.get(trains[num][len[num] - 1].getName()), m.get(trainlist.get(i).getName()), num,len[num]+1);
            }
            trains[num][len[num]] = trainlist.get(i);
            len[num]++;
        }
        String shi,dao;
        shi=cin.next();//起始站和终止站
        dao=cin.next();
        bfs_zhongzhuanhanshu(m.get(shi),m.get(dao));
        int ll=0;
        for (int i = 0; i < flightlist.size(); i++) {
            if(flightlist.get(i).getStartplace().equals(shi)&&flightlist.get(i).getEndplace().equals(dao)){
                ll=1;
            }
        }
        if(ll==1){
            System.out.println("从起点到终点可以乘坐飞机");
        }
        Thread.sleep(3000);
    }
    public static void work() throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("src\\TrainTime"));
        BufferedReader bufferedReader1=new BufferedReader(new FileReader("src\\FlightSchedule"));
        trainlist.clear();
        flightlist.clear();
        String s;
        while ((s=bufferedReader.readLine())!=null){
            trainlist.add(new Train(s));
        }
        while ((s=bufferedReader1.readLine())!=null){
            flightlist.add(new Flight(s));
        }
        bulidtu();
    }

    public static void leastnumber(){

    }

    public static void check(){
        System.out.println("请输入出行最优原则,起点站，终点站，要乘坐的交通工具");
        String you,qi,zhong,tran;
        you=cin.next();//最少中转次数、最少出行费用、最短出行时间
        qi=cin.next();
        zhong=cin.next();
        tran=cin.next();
        if(you.equals("最少中转次数")){
            leastnumber();
        }
        else if(you.equals("最少出行费用")){
            //leastfee();
        }
        else if(you.equals("最短出行时间")){
            //leasttime();
        }
    }

    public static void main(String[] args) throws Exception {
        waihuan:while(true){
            System.out.println("-----------------菜单-----------------");
            System.out.println("对火车时刻信息进行添加请输入1：");
            System.out.println("对航班时刻信息进行添加请输入2：");
            System.out.println("对火车时刻信息进行删除请输入3：");
            System.out.println("对航班时刻信息进行删除请输入4：");
            System.out.println("对火车时刻信息进行修改请输入5：");
            System.out.println("对航班时刻信息进行修改请输入6：");
            System.out.println("开始查询交通工具请输入7");
            System.out.println("开始选择最优方案请输入8：");
            System.out.println("如要退出请输入9：");
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
                case 7: work();break;
                case 8: check() ;break ;
                case 9: break waihuan;
                default:
                    System.out.println("输入不合规，请重新输入");
            }
        }
        System.out.println("谢谢使用！撒悠啦啦！！！");
    }
}
