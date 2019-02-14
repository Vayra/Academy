package task10;


public interface Payment
{
    public double calcAmount(double amount);
}

/*
public abstract class Payment
{
    protected double balance;

    public Payment()
    {
        this.balance = 0.0;
    }

    public Payment(double initBalance)
    {
        this.balance = initBalance;
    }

    public boolean makePayment(double amount){return true;}
    public double addMoney(double amount){return 0.0;}
    public double checkBalance(){return 0.0;}


}*/