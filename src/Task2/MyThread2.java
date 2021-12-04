package Task2;

public class MyThread2 extends Thread {
    public void run() {
        synchronized (MyArray.lock){
            for(int i=0;i<5;i++){
                System.out.println(MyArray.arr2[i]);
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
