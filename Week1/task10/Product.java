package task10;

public class Product
{
    public String name;
    public int price;
    
    public Product()
    {
        name = "Invalid Product";
        price = 0;
    }
    
    public Product(String name, int amount)
    {
        this.name = name;
        this.price = amount;
    }
}