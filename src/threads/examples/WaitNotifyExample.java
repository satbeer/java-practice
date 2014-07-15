package threads.examples;

import java.util.Scanner;
/**
 * Wait and notify works on same lock object.
 * Both of these methods should only be called fro syncronized block.
 * Wait releases the locks and the thread waits for other thread to notify.
 * Unlike wait notify does not releases the lock but just wakes up the waiting thread. 
 * @author satbeer
 *
 */
public class WaitNotifyExample {
  
  public void produce() throws InterruptedException{
    synchronized (this) {
      System.out.println("Producer thread started");
      wait();
      System.out.println("Resumed");
      
    }
  }
  
  public void consume() throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    Thread.sleep(2000);
    synchronized (this) {
      System.out.println("Waiting for return key");
      scanner.nextLine();
      System.out.println("return key pressed");
      notify();
      //notify does not release the lock. As this is withing sync block it will sleep for 
      //5 secs and then resume waiting thread.
      System.out.println("sleeping for 5 seconds before resuming waiing thread");
      Thread.sleep(5000);
    }
  }

  
  public static void main(String[] args) {
    final WaitNotifyExample p = new WaitNotifyExample();
    Thread producer = new Thread(new Runnable() {
      
      @Override
      public void run() {
        try {
          p.produce();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    
    Thread consumer = new Thread(new Runnable() {
      
      @Override
      public void run() {
        try {
          p.consume();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
      }
    });
    
    producer.start();
    consumer.start();
    
  }
}
