/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcustomers;

import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

/**
 *
 * @author 60050257
 */
public class Facade {
    private static Facade FacadeObj = null;
    ArrayList<CustomerIf> custList = new ArrayList();
    private Facade(ArrayList<CustomerIf> cust) {
        custList = cust;
    }
    public static Facade getMyFacadeObject(ArrayList<CustomerIf> custList) {
        if (FacadeObj == null) {
            FacadeObj = new Facade(custList);
        } 
        return FacadeObj;
    }
    
    public void doDeposit(double amt, CustomerIf cust, int accNo){
        AccountIf acc = cust.getAccount(accNo);
        acc.deposit(amt);
    }
    
    public void getBankAccount(CustomerIf cust, int accNo){
        AccountIf acc = cust.getAccount(accNo);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
    }
    
    public void getBankCustomer(String custName){
        custList.stream().filter(cust -> (cust.getCustomerName().equals(custName))).map(cust -> {
            System.out.println("Name = " + cust.getCustomerName());
            return cust;
        }).map(cust -> cust.getllAccounts()).forEachOrdered(accounts -> {
            accounts.forEach(account -> {
                System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
            });
        });
    }
}
