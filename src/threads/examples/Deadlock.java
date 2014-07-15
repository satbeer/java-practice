package threads.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

  
  private Account acc1 = new Account();
  private Account acc2 = new Account();
  
  private Lock lock1 = new ReentrantLock();
  private Lock lock2 = new ReentrantLock();
  
  private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException{
    boolean lock1Obtained =  false;
    boolean lock2Obtained = false;
   while(true){
     try{
        lock1Obtained = lock1.tryLock();
        lock2Obtained = lock2.tryLock();
     }finally{
       if(lock1Obtained && lock2Obtained){
         return;
       }
       if(lock1Obtained){
         lock1.unlock();
       }
       if(lock2Obtained){
         lock2.unlock();
       }
     }
     Thread.sleep(1);
     }
  }
  
  public void firstThread() throws InterruptedException{
    acquireLock(lock1, lock2);
    try{
    for(int i=0; i <100; i++){
      acc1.transfer(acc1, acc2);
    }
    }finally{
      lock1.unlock();
      lock2.unlock();
    }
  }
  
  public void secondThread() throws InterruptedException{
    acquireLock(lock1, lock2);
    try{
    for(int i=0; i <100; i++){
      acc1.transfer(acc1, acc2);
    }
    }finally{
      lock1.unlock();
      lock2.unlock();
    }
  }
  
  public void finalMethod(){
    System.out.println("Total balance:" + (acc1.getBalance() + acc2.getBalance()));
  }
}
