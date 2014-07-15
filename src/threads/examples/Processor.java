package threads.examples;

import java.util.LinkedList;

public class Processor {

  private LinkedList<Integer> list = new LinkedList<Integer>();
  private final int LIMIT = 10;
  
  private Object lock = new Object();
  
  public void produce() throws InterruptedException{
    int val = 0;
    while(true){
      synchronized (lock) {
        while(list.size() == LIMIT){
          lock.wait();
        }
        System.out.println("Adding :" + val + 1);
        list.add(val++);
        lock.notify();
      }      
    }
  }
  
  public void consume() throws InterruptedException{
    int val;
    while(true){
      synchronized (lock) {
        while(list.size() == 0){
          lock.wait();
        }
        System.out.print("List size : " + list.size());
        val = list.removeFirst();
        System.out.println("Got value:" + val);
        lock.notify();
        }
      Thread.sleep(1000);
      }
  }
}
