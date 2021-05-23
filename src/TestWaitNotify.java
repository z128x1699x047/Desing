import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestWaitNotify {
	 public static void main(String[] args){
	        Queue<Integer> queue = new LinkedList<>();
	        int maxSize = 20;
	        Producer p = new Producer(queue, maxSize);
	        Consumer c = new Consumer(queue, maxSize);
	        Thread pT = new Thread(p);
	        Thread pC = new Thread(c);
	        pT.start();
	        pC.start();
	}
}
//生产者
class Producer implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;
    public Producer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try{
                        System.out.println("Queue is Full");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                //System.out.println("Produce " + i);
                System.out.println(queue.size());
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}
//消费者
class Consumer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is Empty");
                    try{
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                int v = queue.remove();
                //System.out.println("Consume " + v);
                queue.notifyAll();
            }
        }
    }
}
