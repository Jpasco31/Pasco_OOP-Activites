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
public class Account {
    private int accountNum;
    private double accountBal;
    private String customerName;
    private String email;
    private String phoneNum;

    public Account() {
        this(0,0,"","","");
    }

    public Account(int accountNum, double accountBal, String customerName, String email, String phoneNum) {
        this.accountNum = accountNum;
        this.accountBal = accountBal;
        this.customerName = customerName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getAccountBal() {
        return accountBal;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public boolean depositFund(double amount){
        if(amount < 0){
            return false;
        } else {
            this.accountBal += amount;
            return true;
        }
//        this.accountBal += amount > 0 ? amount: 0;
    }
    
    public boolean withdrawFund(double amount){
        if(amount < 0 || amount > this.accountBal){
            return false;
        } else {
            this.accountBal -= amount;
            return true;
        }
//      this.accountBal -= amount > 0 && amount <= this.accountBal ? amount: 0;
        
    }

    @Override
    public String toString() {
        return "Account{" + "accountNum= " + accountNum + ", accountBal= " + accountBal + ", customerName= " + customerName + ", email= " + email + ", phoneNum= " + phoneNum + '}';
    }
    
    
}
