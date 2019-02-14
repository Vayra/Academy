package task10;

public class Cash implements Payment
{
    public double amountTendered;
    public double changeGiven;

    public Cash(double amount)
    {
        this.amountTendered = amount;
    }

    public double calcAmount(double amount)
    {
        changeGiven = this.amountTendered - amount;
        System.out.println("$"+changeGiven+" returned as change.");
        return amountTendered;
    }
    /*public Cash()
    {
        super();
    }

    public Cash(double initBalance)
    {
        super(initBalance);
    }

    public boolean makePayment(double amount)
    {
        if (this.balance >= amount) 
        {
            this.balance -= amount;
            return true;
        }
        return false;
    }
    public double addMoney(double amount)
    {
        this.balance += amount;
        return this.balance;
    }
    public double checkBalance()
    {
        return this.balance;
    }*/
}