import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
*   A bank account has a balance that can be changed by 
*   deposits and withdrawals.
*/
public class BankAccount
{
   private double balance;
   private Lock balanceChangeLock;
   
   /**
   *   Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balance = 0;
      balanceChangeLock = new ReentrantLock();
   }

   /**
   *   Deposits money into the bank account.
   *   @param amount the amount to deposit
   */
   public void deposit(double amount)
   {
      balanceChangeLock.lock();
      try
      {
         double newBalance = balance + amount;
         balance = newBalance;
         System.out.println("After deposit: " + balance);
      }
      finally
      {
         balanceChangeLock.unlock();
      }
   }
   
   /**
   *   Withdraws money from the bank account.
   *   @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      balanceChangeLock.lock();
      try
      {
      
         double newBalance = balance - amount;
         balance = newBalance;
         System.out.println("After withdraw: " + balance);
      }
      finally
      {
         balanceChangeLock.unlock();
      }
   }
   
   /**
   *   Gets the current balance of the bank account.
   *   @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }
   
   
}
