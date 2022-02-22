package main;

import java.io.Serializable;

public class Train implements Serializable {
    private String id;
    private String name;
    private String endname;
    private int starttime;
    private int endtime;
    private int price;

    public Train() {
    }

    public Train(String id, String name,String endname, int starttime, int endtime, int price) {
        this.id = id;
        this.name = name;
        this.endname=endname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
    }
    public Train(String str) {
        String redix="\\s+";
        String str2=str.replaceAll(redix," ");
        String[] data=str2.split(" ");
        id=data[0];
        name=data[1];
        endname=data[2];
        int sstarttime=((data[3].charAt(0)-'0')*10+(data[3].charAt(1)-'0'))*60+(data[3].charAt(3)-'0')*10+(data[3].charAt(4)-'0');
        int eendtime=((data[4].charAt(0)-'0')*10+(data[4].charAt(1)-'0'))*60+(data[4].charAt(3)-'0')*10+(data[4].charAt(4)-'0');
        starttime=sstarttime;
        endtime=eendtime;
        price=Integer.parseInt(data[5]);
    }
    @Override
    public String toString() {
        return id + " "+name+ " "+endname+" "+translate(starttime) +" "+translate(endtime) +" "+price;
    }
    public static String translate(int time){
        String s=new String();
        if(time==-1){
            return "--:--";
        }
        int h=time/60;
        int m=time%60;
        if(h<10) s=s+'0'+h;
        else s=s+h+"";
        s=s+':';
        if(m<10) s=s+'0'+m;
        else s=s+m+"";
        return s;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getEndname() {
        return endname;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEndName(String endname) {
        this.endname = endname;
    }
    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public void setEndtime(int endtime) {
        this.endtime = endtime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
