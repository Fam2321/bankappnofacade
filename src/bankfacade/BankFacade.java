/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;
import bankcustomers.Facade;

/**
 *
 * @author sarun
 */
public class BankFacade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<AccountIf> cust1Accounts = new ArrayList();
        AccountIf acc = new BankAccount(12345);
        cust1Accounts.add(acc);
        acc = new BankAccount(67890);
        cust1Accounts.add(acc);
        CustomerIf cust1 = new BankCustomer("John", cust1Accounts);
        ArrayList<AccountIf> cust1Accounts2 = new ArrayList();
        AccountIf acc2 = new BankAccount(54321);
        cust1Accounts2.add(acc2);
        acc2 = new BankAccount(98760);
        cust1Accounts2.add(acc2);
        CustomerIf cust2 = new BankCustomer("Dewin", cust1Accounts2);
        ArrayList<CustomerIf> custList = new ArrayList();
        custList.add(cust1);
        custList.add(cust2);
        Facade facade = Facade.getMyFacadeObject(custList);
        
        facade.doDeposit(500, cust1, 12345);
        facade.doDeposit(1000, cust1, 67890);
        facade.getBankAccount(cust1, 12345);
        facade.getBankAccount(cust1, 67890);
        
        facade.doDeposit(500, cust2, 54321);
        facade.doDeposit(1000, cust2, 98760);
        facade.getBankAccount(cust2, 54321);
        facade.getBankAccount(cust2, 98760);
        
        facade.doDeposit(1000, cust1, 67890);
        facade.doDeposit(500, cust2, 54321);
        
        facade.getBankCustomer("John");
        facade.getBankCustomer("Dewin");
    }
    
}
