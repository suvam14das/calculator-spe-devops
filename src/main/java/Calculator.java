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
                    System.out.println("[SQUARE ROOT] Result : " + squareroot(n1));
                    break;
                case 2:
                    System.out.println("Enter Number");
                    n1 = s.nextDouble();
                    System.out.println("[FACTORIAL] Result : " + factorial(n1));
                    break;
                case 3:
                    System.out.println("Enter Number");
                    n1 = s.nextDouble();
                    System.out.println("[NATURAL LOGARITHM] Result : " + naturallog(n1));
                    break;
                case 4:
                    System.out.println("Enter First Number");
                    n1 = s.nextDouble();
                    System.out.println("Enter Second Number");
                    n2 = s.nextDouble();
                    System.out.println("[POWER] Result : " + power(n1, n2));
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }

    public static double squareroot(double n){
        double result = 0;
        try{
            logger.info("Calculating square root for "+n);
            if(n<0){
                result = Double.NaN;
                throw new ArithmeticException("Square root of negative number is imaginary");
            }else{
                result = Math.sqrt(n);
            }
        }catch(ArithmeticException error){
            logger.error("Invalid number for square root calculation");
        }finally{
            logger.info("Result of square root is "+result);
        }
        return result;
    }

    public static double factorial(double n){
        double result = 1;
        try{
            logger.info("Calculating factorial for "+n);
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
            }
        }catch(ArithmeticException error){
            logger.error("Invalid number for factorial calculation");
        }finally{
            logger.info("Result of factorial is "+result);
        }
        return result;
    }

    public static double naturallog(double n){
        double result = 0;
        try{
            logger.info("Calculating natural log for "+n);
            if(n<=0){
                result = Double.NaN;
                throw new ArithmeticException("Natural log takes values >= 0");
            }else{
                result = Math.log(n);
            }
        }catch(ArithmeticException error){
            logger.error("Invalid number for natural logarithm calculation");
        }finally{
            logger.info("Result of natural log is "+result);
        }

        return result;
    }

    public static double power(double n1, double n2){
        double result = 0;
        try{
            logger.info("Calculating power of "+n1+" raised to "+n2);
            if(n1==0 && n2==0){
                result = Double.NaN;
                throw new ArithmeticException("Zero raised to zero is undefined");
            }else
            {
                result = Math.pow(n1,n2);
            }
        }catch(ArithmeticException error){
            logger.error("Invalid set of numbers for power calculation");
        }finally{
            logger.info("Result of power is "+result);
        }

        return result;
    }


}
