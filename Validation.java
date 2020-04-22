package j1.l.p0022;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    //get input integer number between min and max
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        //force user input exectly integer number
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    //get input double number between min and max
    public double inputDouble(String mess, double min, double max) {

        //force user input exectly double number
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + "\n");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number.");
            }
        }
    }

    //get non-empty string
    public String inputString(String mess) {
        System.out.print(mess);
        //force user input exectly non-empty string
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }

    //get Y-N question
    public boolean inputYesNo(String mess) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                return true;
            } else if (input.equals("N") || input.equals("n")) {
                return false;
            } else {
                System.out.print("Wrong input!");
            }
        }
    }

    public float inputFloat(String mess) {

        //force user input exectly double number
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                float number = Float.parseFloat(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an float number.\n");
            }
        }
    }

    public int inputPositiveDecimal(String mess) {
        //force user input exectly integer number
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.print("Please input a positive decmal.\n");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number.\n");
            }
        }
    }

    public String inputPhone(String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            if (input.matches("^\\d{10}\\d*$")) {
                return input;
            } else {
                System.err.println("Phone is number with minimum 10 numbers");
            }
        }
    }

    public String inputEmail(String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            if (input.matches("[A-za-z]+[A-za-z0-9]+@[A-za-z0-9]+(\\.[A-za-z0-9]+)*\\.[A-za-z0-9]{2,3}")) {
                return input;
            } else {
                System.err.println("Email with format <account name>@<domain>.<domain>");
            }
        }
    }

    public String inputGraduationRank(String mess) {
        while (true) {
            String result = inputString(mess);
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    public int inputExprience(String mess, int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = inputInt(mess, 1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }

}
