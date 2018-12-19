/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *OVERVIEW: The class creates a Customer object consisting of a username
 * password, balance, state and role. The class allows for the customer to deposit
 * withdraw and make online purchases. The class is mutable as it has public
 * getter methods.
 * RI: returns true if c.balance is greater than 0 AND c.deposit is greater than 0 AND (c.withdraw is greater than 0 but less than c.balance) 
 * AND (c.onlinePurchase is greater than  0 AND c.onlinePurchase is less than c.balance) AND c.getPass!=null AND c.getUser!=null
 * otherwise, returns false
 * 
 * AF(c)= An abstraction function for Customer B
 * B.username=c.username
 * B.password=c.password
 * B.balance=c.balance
 * B.getState=c.getState
 * @author ayush
 */
public class Customer {
    
    private State myState;
    private static double balance=0;
    private double purchase =0;
    private double deposit=0;
    private double withdraw=0;
    private String username;
    private String pass;
    
    public Customer(String username, String pass, double b, State f) {
        myState= f;
        balance=b;
        this.username=username;
        this.pass=pass;
    }
    
/**
 *REQUIRES: s to be new Silver(), new Gold() or new Platinum()
 *MODIFIES: None
 *EFFECTS: Sets the customer's current balance variable to s
 * @param s Used to set the state of the customer
 */
    public void setState(State s) {
        myState=s;
    }
    
/**
 *REQUIRES: None 
 *MODIFIES: None
 *EFFECTS: Returns the current state of the customer
 * 
 */
    public State getState() {
        return myState;
    }
    
/**
 *REQUIRES: s to be greater than zero
 *MODIFIES: None
 *EFFECTS: updates the current balance by adding d to it
 * @param d Used to deposit money/increase current balance
 */ 
    public void deposit(double d) {
        deposit=d;
        balance+=d;
        
    }
    
 
/**
 *REQUIRES: w to be greater than 0 but less than or equal to balance
 *MODIFIES: None
 *EFFECTS: Updates the current balance by subtracting w from it
 * @param w Used to withdraw money/decrease current balance
 */   
    public void withdraw(double w) {
        withdraw=w;
        balance-=w;
    }
    
    
/**
 *REQUIRES: None  
 *MODIFIES: None
 *EFFECTS: Returns the customer's current balance
 * 
 */ 
    public double getBalance() {
        return balance;
    }

/**
 *REQUIRES: p to be greater than 50 but less than or equal to the balance
 *MODIFIES: None
 *EFFECTS: Sets purchase amount to p and updates current balance by subtracting p from it
 * @param p Used to make an online purchase/decrease current balance
 */   
    public void setPurchase(double p) {
        purchase=p;
        balance-=p;
    }

/**
 *REQUIRES: None  
 *MODIFIES: None
 *EFFECTS: returns the purchase amount
 * 
 */  
    public double getPurchase() {
        return purchase;
    }

/**
 *REQUIRES: u to be of any length
 *MODIFIES: None
 *EFFECTS: Sets the customer's username to u
 * @param u Used for initializing the customer's username
 */   
    public void setUser(String u) {
        username=u;
    }

/**
 *REQUIRES: None  
 *MODIFIES:None
 *EFFECTS: Returns the customer's username
 * 
 */   
    public String getUser() {
        return username;
    }

/**
 *REQUIRES: pass to be of any length
 *MODIFIES: None
 *EFFECTS: Sets the customer's password to pass
 * @param pass Used for initializing the customer's password
 */    
    public void setPass(String pass) {
        this.pass=pass;
    }

/**
 *REQUIRES: None  
 *MODIFIES: None
 *EFFECTS: Returns the customer's password
 * 
 */    
    public String getPass() {
        return pass;
    }
    
    public boolean repOk() {
        if(balance>0 && (withdraw>0 && withdraw<balance) && (purchase>0 && purchase<balance) && pass!=null & username!=null)
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        return username+ " " + pass + " " + balance + " " + myState.toString() + "customer";   
    }
    
}
