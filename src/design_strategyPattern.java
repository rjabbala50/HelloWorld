

//Strategy Pattern
// https://en.wikipedia.org/wiki/Strategy_pattern


interface TouringPlan {
    void journey() ;
}

class aleppy implements TouringPlan {
    public void journey() {
        System.out.println("I'm going to Alleppy");
    }
}

class trivendrum implements TouringPlan {
    public void journey() {
        System.out.println("I'm in Beach");
    }
}

class PremTravel {
    TouringPlan travel ;
    void start( int daysinhand) {
        if(daysinhand == 2) {
            travel = new aleppy();
            travel.journey();
        }
        else {
            travel = new trivendrum() ;
            travel.journey();
        }
    }
}

public class design_strategyPattern {
    public static void main(String[] args) {
        PremTravel prem = new PremTravel() ;
        prem.start(2);
        prem.start(5) ;
    }
}
