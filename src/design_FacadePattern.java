
//https://en.wikipedia.org/wiki/Facade_pattern

class CPU {
    void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    void start() {
        System.out.println("Memory Started");
    }
}
class Drive {
    void start() {
        System.out.println("Drive Mounted");
    }
}

class MacFacade {
    private CPU cpu ;
    private Memory mem ;
    private Drive drive ;

    MacFacade() {
        cpu = new CPU() ;
        mem = new Memory();
        drive = new Drive() ;
    }

    void start() {
        cpu.start() ;
        mem.start();
        drive.start();
    }
}

public class design_FacadePattern {
    public static void main(String[] args) {
        MacFacade mac = new MacFacade() ;
        mac.start();
    }
}
