import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        while(true) {
            double n1, n2;
            System.out.println("----------Scientific Calculator: Enter choice-------");
            System.out.println("1. Square root ");
            System.out.println("2. Factorial ");
            System.out.println("3. Natural Logarithm ");
            System.out.println("4. Power  ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Number");
                    n1 = s.nextDouble();
                    System.out.println("Result : " + squareroot(n1));
                    break;
                case 2:
                    System.out.println("Enter Number");
                    n1 = s.nextDouble();
                    System.out.println("Result : " + factorial(n1));
                    break;
                case 3:
                    System.out.println("Enter Number");
                    n1 = s.nextDouble();
                    System.out.println("Result : " + naturallog(n1));
                    break;
                case 4:
                    System.out.println("Enter First Number");
                    n1 = s.nextDouble();
                    System.out.println("Enter Second Number");
                    n2 = s.nextDouble();
                    System.out.println("Result : " + power(n1, n2));
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }

    public static double squareroot(double n){
        double result = 0;
        try{
            logger.info("[SQUARE ROOT] Calculating square root for "+n);
            if(n<0){
                result = Double.NaN;
                throw new ArithmeticException("Square root of negative number is imaginary");
            }else{
                result = Math.sqrt(n);
                logger.info("[SQUARE ROOT - RESULT] Result of square root is "+result);
            }
        }catch(ArithmeticException error){
            logger.error("[SQUARE ROOT - EXCEPTION] Invalid number for square root calculation");
        }
        return result;
    }

    public static double factorial(double n){
        double result = 1;
        try{
            logger.info("[FACTORIAL] Calculating factorial for "+n);
            if(n<0){
                result = Double.NaN;
                throw new ArithmeticException("Factorial function takes positive number");
            }else if(Math.floor(n) != n){
                result = Double.NaN;
                throw new ArithmeticException("Factorial function takes integer number");
            }else{
                while(n>0){
                    result *= n;
                    n--;
                }
                logger.info("[FACTORIAL - RESULT] Result of factorial is "+result);
            }
        }catch(ArithmeticException error){
            logger.error("[FACTORIAL - EXCEPTION] Invalid number for factorial calculation");
        }
        return result;
    }

    public static double naturallog(double n){
        double result = 0;
        try{
            logger.info("[NATURAL LOG] Calculating natural log for "+n);
            if(n<=0){
                result = Double.NaN;
                throw new ArithmeticException("Natural log takes values >= 0");
            }else{
                result = Math.log(n);
                logger.info("[NATURAL LOG - RESULT] Result of natural log is "+result);
            }
        }catch(ArithmeticException error){
            logger.error("[NATURAL LOG - EXCEPTION] Invalid number for natural logarithm calculation");
        }
        return result;
    }

    public static double power(double n1, double n2){
        double result = 0;
        try{
            logger.info("[POWER] Calculating power of "+n1+" raised to "+n2);
            if(n1==0 && n2==0){
                result = Double.NaN;
                throw new ArithmeticException("Zero raised to zero is undefined");
            }else
            {
                result = Math.pow(n1,n2);
                logger.info("[POWER - RESULT] Result of power is "+result);
            }
        }catch(ArithmeticException error){
            logger.error("[POWER EXCEPTION] Invalid set of numbers for power calculation");
        }
        return result;
    }


}
