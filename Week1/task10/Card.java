package task10;

public class Card implements Payment //extends Payment
{
    private double amount;
    private CardType card;
    private double creditLimit;

    public Card(double amount)
    {
        this.amount = amount;
        this.card = CardType.CREDIT;
    }

    public Card(CardType card, double initBalance)
    {
        amount = initBalance;
        this.card = card;
        if (card == CardType.CREDIT) creditLimit = 1000.0;
        else creditLimit = 0.0;
    }

    public boolean authorize(double amount)
    {
        // Are we supposed to care about how if the card can pay?
        if (this.amount + this.creditLimit >= amount)
        {
            this.amount -= amount;
            return true;
        } else return false;
    }

    public double calcAmount(double amount)
    {
        return amount;
    }
    /*protected double creditLimit;
    protected CardType cardType;
    public Card()
    {
        super();
        cardType = CardType.CREDIT;
        creditLimit = 1000.0;
    }

    public Card(CardType card)
    {
        super();
        cardType = card;
        if (cardType == CardType.CREDIT) creditLimit = 1000.0;
        else creditLimit = 0.0;
    }

    public Card(CardType card, double initBalance)
    {
        super(initBalance);
        cardType = card;
        if (cardType == CardType.CREDIT) creditLimit = 1000.0;
        else creditLimit = 0.0;
    }

    public Card(CardType card, double initBalance, double limit)
    {
        super(initBalance);
        cardType = card;
        if (cardType == CardType.CREDIT) creditLimit = limit;
        else {
            creditLimit = 0.0;
            System.out.println("Error: CardType Savings does not support a credit limit");
        }
    }

    public boolean makePayment(double amount)
    {
        if (this.balance + this.creditLimit >= amount) {
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
    }

    public double checkCreditLimit()
    {
        return this.creditLimit;
    }

    public boolean updateCreditLimit(double newLimit)
    {
        if (newLimit + balance >= 0.0)
        {
            this.creditLimit = newLimit;
            return true;
        }
        else return false;
    }
    */
}