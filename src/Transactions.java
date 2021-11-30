
public class Transactions{

    protected int money;
    protected int deposit_counter = 0;
    protected int withdrawal_counter = 0;
    protected int transfer_counter = 0;

    public Transactions(){}

    public Transactions(int money, int deposit_counter, int withdrawal_counter, int transfer_counter) {
        this.money = money;
        this.deposit_counter = deposit_counter;
        this.withdrawal_counter = withdrawal_counter;
        this.transfer_counter = transfer_counter;
    }

    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        this.money = money;
    }


    public int getDeposit_counter() {
        return deposit_counter;
    }

    public void setDeposit_counter(int deposit_counter) {
        this.deposit_counter = deposit_counter;
    }

    public int getWithdrawal_counter() {
        return withdrawal_counter;
    }

    public void setWithdrawal_counter(int withdrawal_counter) {
        this.withdrawal_counter = withdrawal_counter;
    }

    public int getTransfer_counter() {
        return transfer_counter;
    }

    public void setTransfer_counter(int transfer_counter) {
        this.transfer_counter = transfer_counter;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "money=" + money +
                ", deposit_counter=" + deposit_counter +
                ", withdrawal_counter=" + withdrawal_counter +
                ", transfer_counter=" + transfer_counter +
                '}';
    }
}
