import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testing {

    public static void main(String[] args) {

        //// creating the accounts
        Bank_Accounts b1 = new Bank_Accounts("ahmad", 98545520, 40, 775599823, 1000);
        Bank_Accounts b2 = new Bank_Accounts("mohammed", 67765760, 25, 644223384, 854);
        Bank_Accounts b3 = new Bank_Accounts("sara", 50635819, 30, 445455568, 500);
        Bank_Accounts b4 = new Bank_Accounts("ahmad", 98545520, 40, 775599823, 1000);

        MainJob m = new MainJob();

        //////// adding first account
        MainJob.Add_Account(b1);
        System.out.println("-------------------------------------------");
        MainJob.deposit(550, b1);
        System.out.println("-------------------------------------------");
        MainJob.deposit(580, b1);
        System.out.println("-------------------------------------------");
        MainJob.withdrawal(600, b1);
        System.out.println("-------------------------------------------");
        b1.set_transfer_Money(150);
        System.out.println("b4 balance : before transfer money to it = " + b4.getBalance());
        MainJob.transfer_money(b1, b4);
        System.out.println("b4 balance : after transfer money to it = " + b4.getBalance());
        System.out.println("////////////////////////////////////////////////////");

        //////// adding second account
        MainJob.Add_Account(b2);
        System.out.println("-------------------------------------------");
        MainJob.deposit(654, b2);
        System.out.println("-------------------------------------------");
        MainJob.deposit(509, b2);
        System.out.println("-------------------------------------------");
        MainJob.withdrawal(400, b2);

        MainJob.withdrawal(200, b2);
        System.out.println("-------------------------------------------");
        b2.set_transfer_Money(200);
        System.out.println("b3 balance : before transfer money to it = " + b3.getBalance());
        MainJob.transfer_money(b2, b3);
        System.out.println("b3 balance : after transfer money to it = " + b3.getBalance());
        System.out.println("////////////////////////////////////////////////////");

        //////// adding third account
        MainJob.Add_Account(b3);
        System.out.println("-------------------------------------------");
        MainJob.deposit(300, b3);
        System.out.println("-------------------------------------------");
        MainJob.deposit(120, b3);
        System.out.println("-------------------------------------------");
        MainJob.withdrawal(360, b3);
        System.out.println("-------------------------------------------");
        b3.set_transfer_Money(100);
        System.out.println("b1 balance : before transfer money to it = " + b1.getBalance());
        MainJob.transfer_money(b3, b1);

        MainJob.transfer_money(b3, b2);
        System.out.println("b1 balance : after transfer money to it = " + b1.getBalance());
        System.out.println("////////////////////////////////////////////////////");

        //// to show the max amount that has been transferred btw all accounts
        m.max_transfer(b1, b2, b3);

        //// error adding same data account in the following code
        MainJob.Add_Account(b4);

        System.out.println("--------------------------------------------------------");
        System.out.println("these two accounts are equals to each other = " + b4.equals(b1));
        System.out.println("--------------------------------------------------------");

        //// Sorting accounts according to civil id
        Collections.sort(MainJob.account, m);

        for (Bank_Accounts h : MainJob.account) {
            System.out.println(h);
        }

        m.print_txt_file(b1, b2, b3);


    }
}

