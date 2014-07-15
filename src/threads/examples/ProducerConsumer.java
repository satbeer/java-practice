package threads.examples;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

  private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
  
  private static class Producer implements Runnable{

    @Override
    public void run() {
      Random random = new Random();
      while(true){
        try {
          queue.put(random.nextInt());
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    
  }
  
  private static class Consumer implements Runnable{

    @Override
    public void run() {
      while(true){
        try {
          Thread.sleep(1000);
          Integer  val = queue.take();
          System.out.println("Taken value:" + val + "; Queue size : " + queue.size());
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    
  }
  
  public static void main(String[] args) throws InterruptedException {
    Thread prod = new Thread(new Producer());
    Thread cons = new Thread(new Consumer());
    prod.start();
    cons.start();
    prod.join();
    cons.join();
    System.out.println("finished");
  }
}
