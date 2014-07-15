package threads.examples;

public class Account {

  private int balance = 10000;
  
  public void withdraw(int amount){
    balance = balance - amount;
  }
  
  public void deposit(int amount){
    balance = balance + amount;
  }
  
  //transfers 100 from acc1 to acc2
  public void transfer(Account acc1, Account acc2){
    acc1.withdraw(100);
    acc2.deposit(100);
  }
  
  public int getBalance(){
    return balance;
  }
}
