/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountchallenge;

/**
 *
 * @author User
 */
public class ClassChallenge {
    public static void main(String[] args) {
          Account acc1 = new Account(1, 0.00, "Jericho", "pasco@gmail.com", "09264568965");
           
          System.out.println(acc1.toString()); 
          boolean withdrawn = false;
          boolean deposited = false;
          
          if (acc1.depositFund(1000)){     
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 1000
          }
          if(acc1.depositFund(2500)){
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 3500
          }
          if(acc1.depositFund(-500)){
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 3500
          }
          if(acc1.withdrawFund(500)){
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 3000
          }
          if(acc1.withdrawFund(4000)){
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 3000
          }
          if(acc1.withdrawFund(-100)){
              System.out.println("Account Balance: Php " + acc1.getAccountBal());   //account BAL = 3000
          }
          
          System.out.println(acc1.toString()); 
    }
}
