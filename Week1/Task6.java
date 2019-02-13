
public class Task6
{
    public static void main(String[] args)
    {
        float height = new Float(args[0]);
        int weight = new Integer(args[1]);

        float BMI = weight/(height*height);

        System.out.printf("Your BMI is %.1f. ", BMI);
        if (BMI >= 30.0)
        {
            System.out.printf("You are obese! Try eating less and getting some exercise");
        } else if (BMI >= 25.0)
        {
            System.out.println("You are overweight! Less snacks might do you good.");
        } else if (BMI >= 18.5){
            System.out.println("Your weight is within acceptable bounds, keep it up!");
        }
        else{
            System.out.println("You are underweight! Try eating some more.");
        }

        

    }
}