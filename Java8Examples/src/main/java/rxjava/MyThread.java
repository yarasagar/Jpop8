package rxjava;

public class MyThread {
    public static void main(String[] args) {
        //lambda and method reference example
        Thread thread = new Thread(() -> runIt());
        thread.run();
        Thread thread2 = new Thread(MyThread::runIt);
        thread2.run();
    }
    public static void runIt(){
        System.out.println("Hello");
    }
}
