package task10;

import java.util.ArrayList;
import java.util.Scanner;

public class Task10
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the new Console SuperBar!");
        ArrayList<Product> products = new ArrayList<Product>();
        
        // Build product list
        String[] inventory = {
            "Beer",
            "Cider",
            "Wine",
            "Rum",
            "Gin",
            "Vodka"
        };
        int[] prices = {5, 5, 10, 7, 8, 4};

        for (int i = 0; i < inventory.length; i++)
        {
            products.add(new Product(inventory[i], prices[i]));
        }
        
        double tax = 0.05;
        double curTotal = 0.0;
        ArrayList<Product> order = new ArrayList<Product>();
        String com;
        String[] command;
        Payment paymentOption;
        double amount;
        ArrayList<Sale> sales = new ArrayList<Sale>();

        while (true)
        {
            com = in.nextLine();
            command = com.toLowerCase().split(" ");


            if (command[0].equals("help"))
            {
                System.out.println("Available commands:");
                System.out.println("purchase {productname}\t\t-- adds {productname} to current order ");
                System.out.println("remove {productname}\t\t-- removes {productname} from current order");
                System.out.println("pay\t\t\t\t-- complete current order and proceed to checkout");
                System.out.println("list\t\t\t\t-- list current orders");
                System.out.println("total\t\t\t\t-- shows current total");
                System.out.println("inventory\t\t\t-- list available products");
                System.out.println("help\t\t\t\t-- displays this menu");
                System.out.println("exit\t\t\t\t-- exits the store");
            }

            else if (command[0].equals("exit")){break;}

            else if (command[0].equals("purchase"))
            {
                int index = findProdIndex(command[1], products);
                if (index != -1)
                {
                    Product prod = products.get(index);
                    order.add(prod);
                    curTotal += prod.price;
                }
            }

            else if (command[0].equals("remove"))
            {
                int index = findProdIndex(command[1], products);

                if (index != -1){
                    Product prod = products.get(index);
                    order.remove(prod);
                    curTotal -= prod.price;
                }
                
            }
            else if (command[0].equals("pay"))
            {
                double total = curTotal*(1+tax);
                System.out.println("Subtotal: $" + curTotal);
                System.out.printf("Tax:      $%.2f",curTotal*tax);
                System.out.println("Total:    $" + total);
                System.out.print("Please choose a payment method (cash|card): ");
                String paymentType = in.next();
                System.out.print('\n');

                if (paymentType.equals("card"))
                {
                    System.out.print("Is the card a credit or debit card? ");
                    String cardType = in.next();
                    System.out.print('\n');
                    CardType card = CardType.UNDEFINED;

                    while (card == CardType.UNDEFINED)
                    {
                        if (cardType.equals("credit")) card = CardType.CREDIT;
                        else if (cardType.equals("debit")) card = CardType.SAVINGS;
                        else
                        {
                            System.out.print("Card type not recognized. Please choose credit or debit: ");
                            cardType = in.next();
                            System.out.print('\n');
                        }
                    }

                    paymentOption = new Card(card, 1000.0); //Decide if initBalance is even needed later
                    amount = paymentOption.calcAmount(total);

                    if (amount == total)
                    {
                        System.out.println("$"+total+ " paid.");
                        sales.add(new Sale(amount, order));
                        System.out.println("Payment successful!");
                        curTotal = 0;
                        order = new ArrayList<Product>();
                    } else System.out.println("Payment failed!");
                }
                else if (paymentType.equals("cash"))
                {
                    System.out.print("Enter amount paid: ");
                    double tendered = in.nextDouble();

                    if (tendered >= total){
                        System.out.println("$"+tendered+" paid.");
                        paymentOption = new Cash(tendered);
                        amount = paymentOption.calcAmount(total);
                        System.out.println("Payment successful!\n");
                        curTotal = 0;
                        order = new ArrayList<Product>();
                    }
                    else {
                        System.out.println("Payment not enough. Choose pay again.");
                    }    
                }
                else {System.out.println("Payment choice not recognized. Choose pay again and pick betwee card or cash.");}
  
            }

            else if (command[0].equals("list"))
            {
                System.out.println("Current order list:");
                for (Product prod :order)
                {
                    System.out.println(prod.name);
                }
            }

            else if (command[0].equals("total")) 
            {
                System.out.println("Total:\t$" + curTotal);
            }
            
            else if (command[0].equals("inventory"))
            {
                for (Product prod:products)
                {
                    System.out.println(prod.name + "\t\t $" + prod.price);
                }
            }
            else {System.out.println("Command not recognized.");}
        }
    }

    public static int findProdIndex(String name, ArrayList<Product> products)
    {
        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).name.toLowerCase().equals(name)){return i;}
        }
        return -1;
    }
}