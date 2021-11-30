import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class MainJob extends Bank_Accounts implements Comparator<Bank_Accounts> {


    static ArrayList<Bank_Accounts> account = new ArrayList<Bank_Accounts>() ;
    static ArrayList<Integer> transaction = new ArrayList<Integer>();

    private static int counter =0;

    // to display the date
    private static Date time = new Date();
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // add accounts
    public static void Add_Account(Bank_Accounts a)
    {
        if (Account_Check(a))
            if (ID_Check(a)) {
            account.add(a);
            System.out.println(a.toString());
            System.out.println("Successful operations");
            System.out.println(formatter.format(time));
        }
        else{ System.out.println("---------------the ID number is exist.Please change it-----------");
                System.out.println(formatter.format(time));
        }
        else{ System.out.println("this Civil ID "+a.getCivil_id()+"---------------is exist.-----------");
                System.out.println(formatter.format(time));
        }

    }

    // checking id number
    public static boolean ID_Check(Bank_Accounts a)
    {
        boolean Unique = true;

        for (Bank_Accounts e: account) {
            if (e.getCivil_id() == a.getCivil_id())
                Unique=false;
        }
        return Unique;
    }

    // checking account
    public static boolean Account_Check(Bank_Accounts a)
    {
        boolean Unique = true;
        for (Bank_Accounts e: account) {
            if (e.getCivil_id() == a.getCivil_id())
                Unique=false;
        }
        return Unique;
    }

   /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /// deposit transaction
    public static int deposit(int amount,Bank_Accounts b) {
        if(amount!=0) {
            if (b.deposit_counter == 0) {
                b.balance = b.balance + amount;
                transaction.add(b.balance);
                System.out.println("Deposit operation successful.The amount of total balance after deposit for "+b.getName()
                        +" account is: "+b.getBalance());
                System.out.println(formatter.format(time));
                b.deposit_counter++;
            }
            else
                System.out.println(b.getName()+" please you are not allowed to deposit more than one time");

        }
        else {
            System.out.println("there is no money to deposit");
            System.out.println(formatter.format(time));
        }
        return 0;
    }


    /// withdrawal transaction
    public static int withdrawal(int amount, Bank_Accounts b) {
        if(amount!=0) {
            if (b.withdrawal_counter == 0) {
                b.balance = b.balance - amount;
                transaction.add(b.balance);
                System.out.println("Withdrawal operation successful.The amount of total balance after withdrawal for "
                        +b.getName()
                        +" account is: "+b.getBalance());
                System.out.println(formatter.format(time));
                b.withdrawal_counter++;
            }
            else
                System.out.println(b.getName()+" you are not allowed to withdrawal more than one time");

        }
        else{
            System.out.println("there is no money to withdrawal");
            System.out.println(formatter.format(time));
        }
        return 0;
    }

    /// transfer transaction
    public static void transfer_money(Bank_Accounts b1,Bank_Accounts b2)
    {
        // if statement to be sure that the transfer operation will execute just for one time to every account
        if (b1.transfer_counter == 0 ) {
            b2.sum_Money(b1.money);
            b1.balance -= b1.money;
            System.out.println("Transfer operation successful.");
            System.out.println(formatter.format(time));
            b1.transfer_counter++;

        }

       else
          System.out.println(b1.getName()+" you are not allowed to transfer more than one time");

        counter++;
    }

    public void max_transfer(Bank_Accounts b1,Bank_Accounts b2,Bank_Accounts b3)
    {

        if (b1.getMoney()>b2.getMoney())
            System.out.println(b1.getName()+" account"+" "+"is the max amount of money has been\n" +
                    "transferred between 2 accounts = "+b1.money+"$");

        else if (b1.getMoney()<b2.getMoney()&& b2.getMoney() >b3.getMoney())
            System.out.println(b2.getName()+" account"+" "+"is the max amount of money has been\n" +
                    "transferred between 2 accounts = "+b2.money+"$");
        else
            System.out.println(b3.getName()+" account"+" "+"is the max amount of money has been\n" +
                    "transferred between 2 accounts = "+b3.money+"$");

        System.out.println(formatter.format(time));

    }

    @Override
    public int compare(Bank_Accounts b2, Bank_Accounts b3) {

        if (this.getCivil_id() > b2.getCivil_id())
            return 2;

        else if (this.getCivil_id() < b2.getCivil_id()&& b2.getCivil_id() > b3.getCivil_id())
            return 1;

        else
            return -1;

    }

    public void print_txt_file(Bank_Accounts b1,Bank_Accounts b2,Bank_Accounts b3)
    {

        try
        {
            PrintWriter print = new PrintWriter(new File(".Bank account data.txt"));
            print.println(b1.toString());
            print.println( "Deposit operation successful.");
            print.println( "please you are not allowed to deposit more than one time.");
            print.println( "Withdrawal operation successful.");
            print.println( "Transfer operation successful.");
            print.println();

            print.println(b2.toString());
            print.println( "Deposit operation successful.");
            print.println( "please you are not allowed to deposit more than one time.");
            print.println( "Withdrawal operation successful.");
            print.println( "you are not allowed to withdrawal more than one time.");
            print.println( "Transfer operation successful.");
            print.println();

            print.println(b3.toString());
            print.println( "Deposit operation successful.");
            print.println( "please you are not allowed to deposit more than one time.");
            print.println( "Withdrawal operation successful.");
            print.println( "Transfer operation successful.");
            print.println( "you are not allowed to transfer more than one time.");


            print.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public String toString() {
        return "MainJob{" +
                "balance=" + balance +
                ", money=" + money +
                ", deposit_counter=" + deposit_counter +
                ", withdrawal_counter=" + withdrawal_counter +
                ", transfer_counter=" + transfer_counter +
                '}';
    }
}


