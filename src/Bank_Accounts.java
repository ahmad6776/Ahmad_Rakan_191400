public class Bank_Accounts extends Transactions{

    private String name;
    private int phone_number;
    private int age;
    private int civil_id;
    protected int balance;
    private int date;
    private String prefix = "4423";


    // empty constructor
    public Bank_Accounts() {}

    // constructor with 5 variables
    public Bank_Accounts(String name,int phone_number,int age,int civil_id,int balance){
        this.name = name;
        this.phone_number = phone_number;
        this.age = age;
        this.balance = balance;
        this.civil_id = civil_id;
    }

    // get money method
    public int getMoney() {
        return money;

    }

    // sum money method after transfer
    public void sum_Money(int money) {
        balance += this.money = money;
    }

    // set money that will go to the another account method
    public void set_transfer_Money(int money) {
        balance -= this.money = money;

    }

    // set name method
    public void setName(String name) {
        this.name = name;

    }

    // set phone number method
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    // set age method
    public void setAge(int age) {
        this.age = age;
    }

    // set civil id method
    public void setCivil_id(int civil_id) {
            this.civil_id = civil_id;
    }

    // set balance method
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // set date method
    public void setDate(int date) {
        this.date = date;
    }

    // get name method
    public String getName() {
        return name;
    }

    // get phone number method
    public int getPhone_number() {
        return phone_number;
    }

    // get age method
    public int getAge() {
        return age;
    }

    // get civil id method
    public int getCivil_id() {
        return civil_id;
    }

    // get balance method
    public int getBalance() {
        return balance;
    }

    // get date method
    public int getDate() {
        return date;
    }

    @Override
    // display account data
    public String toString()
    {
        return "Name:" +" " +name+ "  "+ "Civil_ID:" +prefix+" " +civil_id+"  "+"Age:" +" " +age
                +"  "+"Phone Number:" +" " +phone_number+"  "+ "Balance:" +" " +balance;
    }

    // override equals method
    @Override public boolean equals(Object s2)
    {
        Bank_Accounts s = (Bank_Accounts) s2;

        if ( this != s)
            return true;
        return false;
    }

}



