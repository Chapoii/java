package Task2;

public class MultiThread {
    public static void main(String[] args) {

        printWithMultiThread();
    }

    public static void printWithMultiThread() {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();
    }

}
