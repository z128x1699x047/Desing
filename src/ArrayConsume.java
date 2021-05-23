import java.util.concurrent.ArrayBlockingQueue;

public class ArrayConsume {
	private int queueSize = 20;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
    
    public static void main(String[] args)  {        
    	ArrayConsume test = new ArrayConsume();        
    	Producer producer = test.new Producer();        
    	Consumer consumer = test.new Consumer();                 
    	producer.start();        
    	consumer.start();    
    }
    //生產者
    class Producer extends Thread{                 
    	@Override        
    	public void run() {            
    		produce();        
    	}                 
    	private void produce() {            
    		while(true){                
    			try {                    
    				queue.put(1);                    
    				System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));                
    			} catch (InterruptedException e) {                    
    					e.printStackTrace();                
    			}            
    		}        
    	}   
    }
    //消費者
    class Consumer extends Thread{                 
    	@Override        
    	public void run() {            
    		consume();        
    	}                 
    	private void consume() {            
    		while(true){                
    			try {                    
    				queue.take();                    
    				System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");                
    			} catch (InterruptedException e) {                    
    				e.printStackTrace();                
    			}            
    		}       
    	}    
    }

}


