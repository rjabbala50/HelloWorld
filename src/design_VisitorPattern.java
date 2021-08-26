
//Visitor pattern
//https://en.wikipedia.org/wiki/Visitor_pattern


import java.util.List;

interface room {
    void accept(Guest guest) ;
}

interface Guest {
    void visit(Hall hall) ;
    void visit (Bedroom bedroom) ;
    void visit(House house) ;
}

class Hall implements room {
     public void accept(Guest guest) {
        guest.visit(this);
    }
}
class Bedroom implements room {
     public void accept(Guest guest) {
        guest.visit(this);
    }
}

class House implements room {
     List<room> house ;
     public House() {
        this.house =  List.of(new Hall(), new Bedroom());
     }
     public void accept(Guest guest) {
        for(room r : house) {
            r.accept(guest);
        }
        guest.visit(this);
    }
}

class visitHouse implements Guest {

    @Override
    public void visit(Hall hall) {
        System.out.println("Visit Hall");
    }

    @Override
    public void visit(Bedroom bedroom) {
        System.out.println("Visit Bedroom");
    }

    @Override
    public void visit(House house) {
        System.out.println("Visit Hosue");
    }
}

public class design_VisitorPattern {
    public static void main(String[] args) {
         House h  = new House() ;
        h.accept(new visitHouse());
    }
}
