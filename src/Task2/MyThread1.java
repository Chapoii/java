package Task2;

public class MyThread1 extends Thread {
    public void run() {
        synchronized (MyArray.lock){
            for(int i=0;i<5;i++){
                System.out.println(MyArray.arr1[i]);
                MyArray.lock.notify();
                try {
                    if(i==4)break;
                    MyArray.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
