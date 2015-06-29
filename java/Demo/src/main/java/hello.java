
public class hello implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
 
    public static void main(String[] args) {
        hello he = new hello();
        new Thread(he,"A").start();
        new Thread(he,"B").start();
        new Thread(he).start();
    }
}
