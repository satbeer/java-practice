package threads.examples;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample implements Runnable{

  private CountDownLatch latch;
  
  
  public CountdownLatchExample(CountDownLatch latch){
    this.latch = latch;
  }
  public void run(){
    System.out.println("Started.");
    
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    latch.countDown();
    System.out.println(latch.getCount());
    
  }
  
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    CountDownLatch latch = new CountDownLatch(3);
    for(int i=0; i<3; i++){
      executor.submit(new CountdownLatchExample(latch));
    }
    
    try {
      latch.await();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("completed.");
    executor.shutdown();
  }
}
