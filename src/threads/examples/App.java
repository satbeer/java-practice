package threads.examples;

public class App {

  
  public static void main(String[] args) {
    final Deadlock p = new Deadlock();
    
    Thread producer = new Thread(new Runnable() {
      
      @Override
      public void run() {
        try {
          p.firstThread();
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
          p.secondThread();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    
    producer.start();
    consumer.start();
    
    try {
      producer.join();
      consumer.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    p.finalMethod();
  }
  
}
