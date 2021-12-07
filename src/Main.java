import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] userInput = GetUserInput();

        if(validateUserInput(userInput)){
            int sum = calculateSumForNumber(userInput[1]);
            if (sum < 11)
            {
                String result = convertSumToString(sum);
                printOutput(userInput[0], result);
            }
        }
    }

    private static void printOutput(String name, String result) {
        System.out.printf("Привет %s! Сумма цифр в числе = %s", name, result);
    }

    private static String convertSumToString(int sum) {
        String result = "";
        switch (sum){
            case 1: result = "один";
                break;
            case 2: result = "два";
                break;
            case 3: result = "три";
                break;
            case 4: result = "четыре";
                break;
            case 5: result = "пять";
                break;
            case 6: result = "шесть";
                break;
            case 7: result = "семь";
                break;
            case 8: result = "восемь";
                break;
            case 9: result = "девять";
                break;
            case 10: result = "десять";
                break;
        }
        return result;
    }

    public static String[] GetUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите через пробел имя и число с числом разрядов не менее 2 и не более 5: ");
        String input = scanner.nextLine();
        if(!input.isEmpty()){
            return input.split(" ");
        }
        else return null;
    }

    public static boolean validateUserInput(String[] input){
        boolean flag = true;
        if (input.length!=0){
            flag = CheckNameInput(input[0]);
            flag = CheckNumberInput(input[1]);
        }
        return flag;
    }

    public static boolean CheckNameInput(String name) {
        boolean flag = true;
        for(char symbol : name.toCharArray()){
            if (!Character.isLetter(symbol)){flag = false;}
        }
        return flag;
    }

    public static boolean CheckNumberInput(String digit) {
        boolean flag = true;
        for(char symbol : digit.toCharArray()){
            if (!Character.isDigit(symbol)){flag = false;}
        }

        if (digit.length() < 2 || digit.length() >5) flag = false;
        return flag;
    }

    public static int calculateSumForNumber(String digit) {
        int number = Integer.parseInt(digit);
        return sumNumber(number);
    }

    public static int sumNumber(int num) {
        return num<10 ? num : (num%10 + sumNumber(num / 10));
    }
}

