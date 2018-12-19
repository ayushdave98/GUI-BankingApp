/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.StackTraceElement;
import java.util.*;

/**
 *
 * @author ayush
 */
public class guiMain extends Application {
    Customer c;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        GridPane Main = new GridPane();
        Main.setPadding(new Insets(10,10,10,10));
        GridPane Manage = new GridPane();
        Manage.setPadding(new Insets(10,10,10,10));
        GridPane addC = new GridPane();
        Manage.setPadding(new Insets(10,10,10,10));
        GridPane deleteC = new GridPane();
        Manage.setPadding(new Insets(10,10,10,10));
        GridPane cust = new GridPane();
        Manage.setPadding(new Insets(10,10,10,10));        
        GridPane depositM = new GridPane();
        depositM.setPadding(new Insets(10,10,10,10));  
        GridPane withdrawM = new GridPane();
        withdrawM.setPadding(new Insets(10,10,10,10)); 
        GridPane purchaseM = new GridPane();
        purchaseM.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(Main, 300, 250);
        Scene scene2 = new Scene(Manage, 300, 250);  
        Scene scene3 = new Scene(addC, 300, 250); 
        Scene scene4 = new Scene(deleteC, 300, 250);
        Scene scene5 = new Scene(cust, 300, 250);
        Scene scene6 = new Scene(depositM, 300, 250);
        Scene scene7 = new Scene(withdrawM, 300, 250);
        Scene scene8 = new Scene(purchaseM, 300, 250);
        
        
//Main Login Page Setup
        Main.setVgap(5);
        Main.setHgap(5);
        final Label message = new Label("");
        Label username = new Label("Username");
        GridPane.setConstraints(username,0,10);
        TextField username1 = new TextField();
        GridPane.setConstraints(username1,1,10);
        Label pass = new Label("Password");
        GridPane.setConstraints(pass,0,11);
        PasswordField pass1 = new PasswordField();
        GridPane.setConstraints(pass1,1,11);
        Label role = new Label("Role");
        GridPane.setConstraints(role,0,12); 
        TextField role1 = new TextField();
        GridPane.setConstraints(role1,1,12);        
        Button login = new Button();
        login.setText("Login");
        GridPane.setConstraints(login,1,13);
        GridPane.setConstraints(message,1,14);
        //Customer c;
            login.setOnAction((ActionEvent e)-> {
             File f = new File(username1.getText());   
            if(username1.getText().equals("admin") && pass1.getText().equals("admin") && role1.getText().equals("manager")) {
                message.setText("Correct Login Credentials");
                primaryStage.setScene(scene2);
            }
            else if(f.exists()) {
                try {
                BufferedReader b = new BufferedReader(new FileReader(f));
                String s;
                while((s=b.readLine())!=null) {
                    String [] a = s.split(" ");
                    if(a[1].equals(pass1.getText()) && a[4].equals("customer")) {
                        primaryStage.setScene(scene5);
                        if(a[3].equals("Silver"))
                            c = new Customer(username1.getText(),pass1.getText(),Double.parseDouble(a[2]), new Silver());
                        else if(a[3].equals("Gold"))
                            c = new Customer(username1.getText(),pass1.getText(),Double.parseDouble(a[2]), new Gold());
                        else
                            c = new Customer(username1.getText(),pass1.getText(),Double.parseDouble(a[2]), new Platinum());
                    }
                    else
                        message.setText("Incorrect Password");
                }
                
                } catch(IOException g) {
                    g.printStackTrace();
                }
            }
            else
                message.setText("Incorrect Credentials");
            username1.clear();
            pass1.clear();
            role1.clear();
        });
        
        Main.getChildren().addAll(username,username1,pass,pass1,login,message,role,role1);
//-----------------------------------------------------------------------   
//Manager Control Page Setup
        Manage.setVgap(5);
        Manage.setHgap(5);
        Button add = new Button();
        Button delete = new Button();
        Button back1 = new Button("Logout");
        Label manager = new Label("Manager Control");
        add.setText("Add a Customer");
        delete.setText("Delete a Customer");
        GridPane.setConstraints(add,0,10);
        GridPane.setConstraints(delete,1,10);
        GridPane.setConstraints(manager,0,0);
        GridPane.setConstraints(back1,1,15);
        Manage.getChildren().addAll(add,delete,manager,back1);
        
        add.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene3);
        });
        
        delete.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene4);
        });
        
        back1.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene);
        });
 //-----------------------------------------------------------------------   
//Adding Customer Page    
        addC.setVgap(5);
        addC.setHgap(5);
        
        Label customer = new Label("Please enter customer information below");
        final Label message2 = new Label("");
        TextField username3 = new TextField();
        username3.setPromptText("Enter username");
        TextField pass3 = new TextField();
        pass3.setPromptText("Enter password");
        Button submit = new Button();
        submit.setText("Submit");
        Button back = new Button();
        back.setText("Back to Manager page");
        GridPane.setConstraints(customer,0,0);
        GridPane.setConstraints(username3,0,10);
        GridPane.setConstraints(pass3,0,11);
        GridPane.setConstraints(submit,0,12);
        GridPane.setConstraints(back,0,14);
        GridPane.setConstraints(message2,0,13);
        addC.getChildren().addAll(customer,username3,pass3,submit,message2,back);       
 
        submit.setOnAction((ActionEvent e)-> {

            File z = new File(username3.getText());
            if(z.exists()) {
                message2.setText("Account already exists");
                username3.clear();
                pass3.clear();                
            }
            else {
                try {
                BufferedWriter w = new BufferedWriter(new FileWriter(username3.getText(),true));
                w.append(username3.getText()+" "+pass3.getText()+" "+"100"+" "+"Silver" +  " "+"customer");
                w.close();
                message2.setText("Account Created Sucessfully");
                username3.clear();
                pass3.clear();
                } catch(IOException f) {
                    f.printStackTrace();

                }
            }
            
        });   
        
        
        back.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene2);
        });
        
//-----------------------------------------------------------------------   
//Deleting Customer Page  
        deleteC.setVgap(5);
        deleteC.setHgap(5);
        
        Label deleteCustomer = new Label("Please enter the username of the customer being deleted below");
        final Label message3 = new Label();
        TextField username4 = new TextField();
        username4.setPromptText("Enter username");
        Button delete2 = new Button();
        delete2.setText("Delete");
        Button back2 = new Button();
        back2.setText("Back to Manager page");
        GridPane.setConstraints(deleteCustomer,0,0);
        GridPane.setConstraints(username4,0,10);
        GridPane.setConstraints(delete2,0,11);
        GridPane.setConstraints(message3,0,13);
        GridPane.setConstraints(back2,0,12);
        deleteC.getChildren().addAll(deleteCustomer,username4,delete2,message3,back2);   
        
        delete2.setOnAction ((ActionEvent e)-> {
            try {
            File f = new File(username4.getText());
            if(f.delete()) {
                message3.setText("Account Deleted Sucesfully");
                username4.clear();                
            }
            else {
                message3.setText("Acount Does not Exist");
                username4.clear();
            }
            }   catch(Exception f) {
                f.printStackTrace();
            }
        });
        
        
        back2.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene2);
        });        
        
        
//-----------------------------------------------------------------------   
//Customer Control Page Setup
        cust.setVgap(1);
        cust.setHgap(1);
        Button deposit = new Button();
        Button withdraw = new Button();
        Button online = new Button();
        Button balance = new Button();
        Button level = new Button("Get Customer Level");
        Button back3 = new Button();
        back3.setText("Logout");
        Label Customer = new Label("Customer Control");
        final Label balance1 = new Label(); 
        final Label level1 = new Label();
        deposit.setText("Deposit");
        withdraw.setText("Withdraw");
        balance.setText("Get Balance");
        online.setText("Online Purchase");
        GridPane.setConstraints(deposit,0,3);
        GridPane.setConstraints(withdraw,0,4);
        GridPane.setConstraints(balance,0,5);
        GridPane.setConstraints(online,0,6);
        GridPane.setConstraints(level,0,7);
        GridPane.setConstraints(back3,0,8);
        GridPane.setConstraints(balance1,0,1);
        GridPane.setConstraints(level1,0,2);
        GridPane.setConstraints(Customer,0,0);
        //GridPane.setConstraints(levelu,100,100);
        cust.getChildren().addAll(deposit,withdraw,balance,online,Customer,back3,balance1,level,level1);
 
          back3.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene);
        }); 
        deposit.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene6);
        });
        
        
        withdraw.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene7);
        });
        
        balance.setOnAction((ActionEvent e)-> {
            balance1.setText("Your balance is $" + c.getBalance());
        });
        
        level.setOnAction((ActionEvent e)-> {
            level1.setText("Customer Level: " + c.getState().toString());
        });        
        


        online.setOnAction((ActionEvent e)-> {
            primaryStage.setScene(scene8);
        });

//-----------------------------------------------------------------------   
//Deposit Page Setup
        depositM.setVgap(5);
        depositM.setHgap(5);
        
        Label DepositMenu = new Label("Deposit Money");
        final Label message4 = new Label();
        Button submit1 = new Button();
        Button back4 = new Button();
        TextField dMoney = new TextField();
        submit1.setText("Submit");
        back4.setText("Back");
        dMoney.setText("Enter the amount");
        GridPane.setConstraints(DepositMenu,0,0); 
        GridPane.setConstraints(dMoney,0,10);
        GridPane.setConstraints(submit1,0,11);
        GridPane.setConstraints(back4,0,12);
        GridPane.setConstraints(message4,0,13);
        depositM.getChildren().addAll(DepositMenu,submit1,dMoney,back4,message4); 

       
          back4.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene5);
        }); 
          
          submit1.setOnAction ((ActionEvent e)-> {
              double d=Double.parseDouble(dMoney.getText());
            if(d<=0) {
              message4.setText("Deposit Amount must be postive");
              dMoney.clear();
            }
            else {
                c.deposit(d);
                c.getState().changeState(c);
                message4.setText("Deposited Succesfully");
                dMoney.clear();
                //System.out.println(c.getUser());
                overWrite(c.getUser(),c.getPass(),c.getBalance(),c.getState().toString());
                //System.out.println(c.getBalance());
            }

        }); 
        
          
 
//-----------------------------------------------------------------------   
//Withdraw Page Setup          
        withdrawM.setVgap(5);
        withdrawM.setHgap(5);          
          
        Label WithdrawMenu = new Label("Withdraw Money");
        final Label message5 = new Label();    
        Button submit2 = new Button();
        Button back5 = new Button();
        TextField wMoney = new TextField();
        submit2.setText("Submit");
        back5.setText("Back");
        wMoney.setText("Enter the amount");
        GridPane.setConstraints(WithdrawMenu,0,0); 
        GridPane.setConstraints(wMoney,0,10);
        GridPane.setConstraints(submit2,0,11);
        GridPane.setConstraints(back5,0,12);
        GridPane.setConstraints(message5,0,13);
        withdrawM.getChildren().addAll(WithdrawMenu,submit2,wMoney,back5,message5);        
          
          back5.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene5);
        });           
          
          submit2.setOnAction ((ActionEvent e)-> {
              double p=Double.parseDouble(wMoney.getText());
            if(p>c.getBalance()) {
                message5.setText("Insufficient Funds");
                wMoney.clear();
            }
            else if(p<=0.0) {
                message5.setText("Withdrawal Amount must be postive");
                wMoney.clear();
            }
            else {
                c.withdraw(p);
                c.getState().changeState(c);
                message5.setText("Succesful Withdrawal");
                wMoney.clear();
                overWrite(c.getUser(),c.getPass(),c.getBalance(),c.getState().toString());
                //System.out.println(c.getBalance());
                //System.out.println(p);
            }
        }); 
          
          

//-----------------------------------------------------------------------   
//Online Purchase Page Setup           
        purchaseM.setVgap(5);
        purchaseM.setHgap(5); 

        Label PurchaseMenu = new Label("Online Purchase");
        Button submit3 = new Button("Submit");
        Button back6 = new Button("Back");        
        TextField pMoney = new TextField("Enter the amount"); 
        final Label message6 = new Label();
        GridPane.setConstraints(PurchaseMenu,0,0);  
        GridPane.setConstraints(pMoney,0,10);
        GridPane.setConstraints(submit3,0,11);
        GridPane.setConstraints(message6,0,12);
        GridPane.setConstraints(back6,0,13);
        purchaseM.getChildren().addAll(PurchaseMenu,submit3,pMoney,back6,message6);     
        
          back6.setOnAction ((ActionEvent e)-> {
            primaryStage.setScene(scene5);
        });        
        
          submit3.setOnAction ((ActionEvent e)-> {
              double o=Double.parseDouble(pMoney.getText());
            if(o>c.getBalance()) {
                message6.setText("Insufficient Funds");
                pMoney.clear();
            }
            else if(o<50) {
                message6.setText("Purchase Amount must be atleast $50");
                pMoney.clear();
            }
            else {
                if(c.getState().toString().equals("Silver")) {
                    if((o+20)>c.getBalance()) {
                        message6.setText("Insufficient Funds");
                    }
                    else {
                    c.setPurchase(o+20);
                    c.getState().changeState(c);
                    message6.setText("Succesful Purchase");
                    pMoney.clear();
                    overWrite(c.getUser(),c.getPass(),c.getBalance(),c.getState().toString()); 
                    }
                }
                else if(c.getState().toString().equals("Gold")){
                    if((o+10)>c.getBalance()) {
                        message6.setText("Insufficient Funds");
                    }
                    else {
                    c.setPurchase(o+10);
                    c.getState().changeState(c);   
                    message6.setText("Succesful Purchase");
                    pMoney.clear();
                    overWrite(c.getUser(),c.getPass(),c.getBalance(),c.getState().toString());
                    }                    
                }
                else {
                    c.setPurchase(o);
                    c.getState().changeState(c);                     
                    message6.setText("Succesful Purchase");
                    pMoney.clear();
                    overWrite(c.getUser(),c.getPass(),c.getBalance(),c.getState().toString());
                }
            }
        });   
          
          
        
        primaryStage.setTitle("Bank");
        primaryStage.setScene(scene);
        primaryStage.show();       
       
   
    }
    
    public void overWrite(String f,String p,double b, String s) {
        //System.out.println(f);
        try {
            BufferedWriter ow = new BufferedWriter(new FileWriter(f,false));
            ow.append(f+ " " + p + " " + b + " " + s + " " + "customer");
            ow.close();
        } catch(IOException g) {
            g.printStackTrace();
        }
    }
       

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
