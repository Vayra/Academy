package person;

public class Person
{
    private String firstName;
    private String lastName;
    private String phoneNum;

    public Person()
    {
        firstName = "";
        lastName = "";
        phoneNum = "";
    }
    
    public Person(String first)
    {
        this.firstName = first;
    }

    public Person(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
    }

    public Person(String first, String last, String num)
    {
        this.firstName = first;
        this.lastName = last;
        this.phoneNum = num;
    }

    public String getName()
    {
        return this.firstName + " " + this.lastName;
    }

    public String getNum()
    {
        return this.phoneNum;
    }
    
    public boolean contains(String query)
    {
        return this.getName().contains(query);
    }
}