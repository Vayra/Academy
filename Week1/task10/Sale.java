package task10;

import java.util.ArrayList;

public class Sale
{
    double amount;
    ArrayList<Product> items; 

    public Sale(double amount, ArrayList<Product> items)
    {
        this.amount = amount;
        this.items = items;
    }
}