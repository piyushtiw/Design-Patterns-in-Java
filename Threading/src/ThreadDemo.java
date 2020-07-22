import java.io.IOException;

class Hie extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Hie");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hello extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Hie1 implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Hie");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hello1 implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main( String args[] ) throws InterruptedException {
        Hie hi = new Hie();
        Hello hello = new Hello();

//        hi.start();
//        hello.start();


        Runnable hi1 = new Hie1();
        Runnable hello1 = new Hello1();

        Thread t1 = new Thread(hi1);
        Thread t2 = new Thread(hello1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Bye");
    }
}
