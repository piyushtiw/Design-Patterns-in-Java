class Q {
    int num;

    boolean valSet = false;

    public synchronized void put(int num) throws InterruptedException {

        while(valSet) wait();
        this.num = num;
        System.out.println("Put " + num);
        valSet = true;
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (!valSet)wait();
        System.out.println("Get " + num);
        valSet = false;
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q){
        this.q = q;
        Thread t = new Thread(this, "producer");
        t.start();
    }

    public void run() {
        int i = 0;

        while (true) {
            try {
                q.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q){
        this.q = q;
        Thread t = new Thread(this, "consumer");
        t.start();
    }

    public void run() {
        while (true){
            try {
                q.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadCommunication {
    public static void main(String args[]) {
        Q q = new Q();

        new Producer(q);
        new Consumer(q);
    }
}
