package main;

public class Flight {
    private String fightid;
    private String startplace;
    private String endplace;
    private int starttime;
    private int endtime;
    private int price;

    public Flight() {
    }
    public Flight(String str) {
        String redix="\\s+";
        String str2=str.replaceAll(redix," ");
        String[] data=str2.split(" ");
        fightid=data[0];
        startplace=data[1];
        endplace=data[2];
        int Sstarttime=((data[3].charAt(0)-'0')*10+data[3].charAt(1)-'0')*60+(data[3].charAt(3)-'0')*10+data[3].charAt(4)-'0';
        int Eendtime=((data[4].charAt(0)-'0')*10+data[4].charAt(1)-'0')*60+(data[4].charAt(3)-'0')*10+data[4].charAt(4)-'0';
        starttime=Sstarttime;
        endtime=Eendtime;
        price=Integer.parseInt(data[5]);
    }
    public Flight(String fightid, String startplace, String endplace, int starttime, int endtime, int price) {
        this.fightid = fightid;
        this.startplace = startplace;
        this.endplace = endplace;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
    }

    @Override
    public String toString() {
        return fightid +" "+startplace +" "+endplace +" "+translate(starttime) +" "+translate(endtime) +" "+price;
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




    public String getFightid() {
        return fightid;
    }

    public void setFightid(String fightid) {
        this.fightid = fightid;
    }

    public String getStartplace() {
        return startplace;
    }

    public void setStartplace(String startplace) {
        this.startplace = startplace;
    }

    public String getEndplace() {
        return endplace;
    }

    public void setEndplace(String endplace) {
        this.endplace = endplace;
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
