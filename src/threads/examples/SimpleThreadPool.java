package threads.examples;

import java.util.LinkedList;

public class SimpleThreadPool {

  private WorkerThread workers[];
  private LinkedList<Runnable> taskQueue;
  
  public SimpleThreadPool(int poolSize){
    taskQueue = new LinkedList<Runnable>();
    workers = new WorkerThread[poolSize];
    for(int i = 0; i < workers.length; i++){
      workers[i] = new WorkerThread();
      workers[i].start();
    }
  }
  
  
  public void enqueueTaks(Runnable r){
    synchronized (taskQueue) {
      taskQueue.addLast(r);
      taskQueue.notify();
    }
  }
  private class WorkerThread extends Thread{
    @Override
    public void run() {
      Runnable r;
      while(true){
        synchronized (taskQueue) {
           while(taskQueue.isEmpty()){
             try {
              taskQueue.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
           }
           r = taskQueue.removeFirst();
        }
        try{
          r.run();
        }catch(Throwable t){
          //we don't want to stop our worker thread in case some exception occcurs in task
          t.printStackTrace();
        }
        
      }
    }
  }
  
  
}
