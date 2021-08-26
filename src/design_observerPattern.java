
//Observer pattern
//https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/


import java.util.ArrayList;
import java.util.List;

interface  Man {
       public void flirt();
}

class Prem implements  Man {
   public void flirt() {
        System.out.println("Will you Marry me ?");
    }
}

class PremBig implements Man {
   public void flirt() {
        System.out.println("Dont follow me, I'm busy!!!");
    }
}

interface Woman {
    List<Man> observers = new ArrayList<>();
    void register(Man man) ;
    void noticeAllFlirtingBoys() ;
}

 class Pooja implements Woman {

    public void register(Man man) {
        observers.add(man);
    }
    public void noticeAllFlirtingBoys() {
        for(Man m: observers) {
            m.flirt();
        }
    }
}

public class design_observerPattern {
    public static void main(String[] args) {
        Pooja po = new Pooja() ;
        po.register(new Prem());
        po.register(new PremBig());
        po.noticeAllFlirtingBoys();
    }
}






























