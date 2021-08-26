
/* Client server model based on threads */


 class Client extends  Thread {
    private Data data ;
    public Client (Data d) { this.data=d ;}

    public void run() {

        while(true){
            try {
                System.out.println("Client is waiting ........");
                wait();
            } catch(Exception e)
            {
                System.out.println("Client wait: Thread caught Exception ") ;
                //e.printStackTrace();
            }
            data.IncrementCounter();

            try {
                System.out.println("Client Increased counter and notifying all ...");
                notifyAll();
            }catch (Exception e) {
                System.out.println("Client Notify: Thread caught Exception ") ;
                //e.printStackTrace();
            }
        }
    }
}


 class Server extends  Thread {
    private Data data ;
    public Server ( Data d) { this.data = d ;}

    public void start() {

    }
    public void run() {
        try {
            System.out.println("Server Increased counter and notifying all ");
            notifyAll();
        }catch (Exception e) {
            System.out.println("Server Notify: Thread caught Exception ") ;
            //e.printStackTrace();
        }
        data.DecrementCounter();

        try {
            wait();
        } catch (Exception e) {
            System.out.println("Server caught exception....");
           // e.printStackTrace();
        }
    }
}

 class Data  {
    private int counter =0;
    public Data() {}

     public synchronized  void IncrementCounter() {
        System.out.println("Counter....before Incr"+counter);
        counter++;
        System.out.println("Counter....After Incr"+counter);
    }

     public synchronized  void DecrementCounter() {
        System.out.println("Counter....before Decr"+counter);
        counter--;
        System.out.println("Counter....After Decr"+counter);
    }
}

public class ClientServer {

    public static void main (String[] args) {
        Data d = new Data() ;
        Server s = new Server( d);
        s.start();
        Client c = new Client(d) ;
        c.start();

    }
}
