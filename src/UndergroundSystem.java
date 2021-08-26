
/*
https://leetcode.com/problems/design-underground-system/
 */

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    public class StationEntry{
        int id ;
        int checkIn ;
        int checkOut ;
    }
    public Map<Integer,StationEntry> custInfo ;
    public Map <String, Map<Integer,StationEntry>> stationRegister ;

    public UndergroundSystem() {
        custInfo = new HashMap<Integer, StationEntry>() ;
        stationRegister = new HashMap<String, Map<Integer,StationEntry>>() ;
    }

    public void checkIn(int id, String stationName, int t) {
        if(!stationRegister.containsKey(stationName)){
            StationEntry entry = new StationEntry() ;
            entry.id = id ;
            entry.checkIn = t ;
            Map<Integer,StationEntry> newcustinfo = new HashMap<Integer,StationEntry>() ;
            newcustinfo.put(id,entry) ;
            stationRegister.put(stationName,newcustinfo) ;
        }
        else {
            Map<Integer,StationEntry> ce = stationRegister.get(stationName) ;
            if(!ce.containsKey(id)) {
                StationEntry entry = new StationEntry() ;
                entry.id = id ;
                entry.checkIn = t ;
                ce.put(id,entry) ;
            }
            else {
                ce.get(id).checkIn = t ;
            }
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(!stationRegister.containsKey(stationName)){
            StationEntry entry = new StationEntry() ;
            entry.id = id ;
            entry.checkOut = t ;
            Map<Integer,StationEntry> newcustinfo = new HashMap<Integer,StationEntry>() ;
            newcustinfo.put(id,entry) ;
            stationRegister.put(stationName,newcustinfo) ;
        }
        else {
            Map<Integer,StationEntry> ce = stationRegister.get(stationName) ;
            if(!ce.containsKey(id)) {
                StationEntry entry = new StationEntry() ;
                entry.id = id ;
                entry.checkOut = t ;
                ce.put(id,entry) ;
            }
            else {
                ce.get(id).checkOut = t ;
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {

        Map<Integer,StationEntry> startStationInfo = stationRegister.get(startStation) ;
        Map<Integer,StationEntry> endStationInfo = stationRegister.get(endStation) ;
        double avgCounter= 0;
        double sum = 0 ;
        for(Map.Entry<Integer,StationEntry> entry: startStationInfo.entrySet()) {
            int id = entry.getKey() ;
            if(endStationInfo.containsKey(id)) {
                if(endStationInfo.get(id).checkOut >0) {
                    avgCounter++ ;
                    sum += endStationInfo.get(id).checkOut-startStationInfo.get(id).checkIn ;
                }
            }
        }

        return sum/avgCounter ;
    }

    public static void main(String[] args) {
        UndergroundSystem obj = new UndergroundSystem() ;
        obj.checkIn(10,"Karimnagar",2);
        obj.checkOut(10,"Arunachalam",5);
        obj.checkIn(10,"Karimnagar",7);
        obj.checkOut(10,"Arunachalam",12);
        System.out.println(obj.getAverageTime("Karimnagar","Arunachalam"));
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
