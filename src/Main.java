import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println(calc(""));
    }

    public static String calc (String input) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] expression = s.split(" ", 3);

        if (expression[0].equals("I") || expression[0].equals("II") || expression[0].equals("III") ||  expression[0].equals("IV") || expression[0].equals("V")  ||  expression[0].equals("VI") || expression[0].equals("VII") || expression[0].equals("VIII") || expression[0].equals("IX") || expression[0].equals("X")) {
            {
                if (expression[2].equals("I") || expression[2].equals("II") || expression[2].equals("III") || expression[2].equals("IV") || expression[2].equals("V") || expression[2].equals("VI") || expression[2].equals("VII") || expression[2].equals("VIII") || expression[2].equals("IX") || expression[2].equals("X")) {

                    Roman roman1 = Roman.valueOf(expression[0]);
                    Roman roman2 = Roman.valueOf(expression[2]);

                    int resultInArab = 0;

                    if (roman1.getValue() > 0 && roman1.getValue() < 11 && roman2.getValue() > 0 && roman2.getValue() < 11) {
                        if (expression[1].equals("+")) {
                            resultInArab = roman1.getValue() + roman2.getValue();
                            Roman resultInRoman = Roman.values()[resultInArab];
                            System.out.println(resultInRoman);
                            return input;
                        } else if (expression[1].equals("-")) {
                            resultInArab = roman1.getValue() - roman2.getValue();
                            if (resultInArab == 0)
                            {
                                throw new IOException("0 в римской системе счисления отсутствует");
                            }
                            Roman resultInRoman = Roman.values()[resultInArab];
                            System.out.println(resultInRoman);
                            return input;
                        } else if (expression[1].equals("/")) {
                            resultInArab = roman1.getValue() / roman2.getValue();
                            Roman resultInRoman = Roman.values()[resultInArab];
                            System.out.println(resultInRoman);
                            return input;
                        } else if (expression[1].equals("*")) {
                            resultInArab = roman1.getValue() * roman2.getValue();
                            Roman resultInRoman = Roman.values()[resultInArab];
                            System.out.println(resultInRoman);
                            return input;

                        }
                    } else {
                        throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                }
                else {
                    throw new IOException("Используются разные системы счисления либо формат математической операции не удовляеторяет заданию");
                }
            }
        }

        else {

            {
                try
                {
                    int num1 = Integer.parseInt(expression[0].trim());
                    int num2 = Integer.parseInt(expression[2].trim());
                    if (num1 > 0 && num1 < 11 && num2 > 0 && num2 < 11) {
                        if (expression[1].equals("+"))
                            System.out.println(num1 + num2);
                        else if (expression[1].equals("-"))
                            System.out.println(num1 - num2);
                        else if (expression[1].equals("/"))
                            System.out.println(num1 / num2);
                        else if (expression[1].equals("*"))
                            System.out.println(num1 * num2);
                        return input;
                    }
                    else {
                        throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
                    }
                }

                catch (IOException e)
                {
                    System.out.println("Используются разные системы счисления");
                }
            }
        }
        return input;
    }
}