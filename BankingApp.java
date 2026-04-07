/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingapp;

import javax.swing.*;
import java.awt.*;
public class BankingApp {

    public double balance;
    private String deposit;
    private String withdraw;
    
    public BankingApp(double balance, String deposit, String withdraw){
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }
     
    public void DisplayBalance(JFrame frame){ //to show balance
        JOptionPane.showMessageDialog(frame, "Your balance is:\n" + balance, "Bank Balance", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public double DepositMoney(JFrame frame, double depositAmount){ //to deposit
       deposit = JOptionPane.showInputDialog(frame, "How much would you like to deposit?", "Deposit money", JOptionPane.QUESTION_MESSAGE);
       if(deposit == null) return balance;
       try{ //if they did not enter a number
        return depositAmount = Double.parseDouble(deposit) + balance;
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        return balance;
    }
    }
    
    public double WithdrawMoney(JFrame frame, double withdrawalAmount){ //to withdarw
        withdraw = JOptionPane.showInputDialog(frame, "How much would you like to withdraw?", "Withdraw Money", JOptionPane.QUESTION_MESSAGE);
        if(withdraw == null) return balance;
       try{ 
        double amount = Double.parseDouble(withdraw);
        if(amount > balance){ //if they entereted more than the balance
            JOptionPane.showMessageDialog(frame, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
            return balance;
        }
        return withdrawalAmount = balance - amount;
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        return balance;
    }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banking App");
        
        String password = "karabo";
        String input;

    do { //so they can enter the password as many times
         input = JOptionPane.showInputDialog(frame, "Enter your password:", "Login", JOptionPane.QUESTION_MESSAGE);
        if(input == null) System.exit(0);
        if(!input.equals(password)){
        JOptionPane.showMessageDialog(frame, "Incorrect password! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    } while(!input.equals(password));
        
        BankingApp app = new BankingApp(0.0, "", "");
        
        JLabel label = new JLabel("Welcome to the banking app. Please choose your options.");
        
        JButton depositButton = new JButton("Deposit");
        
        depositButton.addActionListener(e ->{
            app.balance = app.DepositMoney(frame, app.balance);
        });
        
        JButton withdrawButton = new JButton("Withdraw");
        
       withdrawButton.addActionListener(e ->{
           app.balance = app.WithdrawMoney(frame, app.balance);
       });
       
       JButton balanceButton = new JButton("Balance");
       
       balanceButton.addActionListener(e ->{
           app.DisplayBalance(frame);
       });
        
        frame.setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        labelPanel.add(label);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(balanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        
        frame.add(labelPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setSize(350,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
