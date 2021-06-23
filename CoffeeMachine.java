package machine;
import java.util.Scanner;

public class CoffeeMachine {

    //The machine has the following amount of ingredients
    static int currentWater = 400;
    static int currentMilk = 540;
    static int currentCoffeeBeans = 120;
    static int currentCups = 9;
    static int money = 550;

    static String action; //buy, fill, take, remaining or exit
    static String coffeeType;
    static String back;

    public static void main(String[] args) {
        writeAction();
    }

    static void machineState() {
        System.out.println("The coffee machine has:");
        System.out.println(currentWater + " of water");
        System.out.println(currentMilk + " of milk");
        System.out.println(currentCoffeeBeans + " of coffee beans");
        System.out.println(currentCups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void writeAction(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        action = scanner.next();
        chooseAction();
    }

    static void chooseAction() {
        Scanner scanner = new Scanner(System.in);

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                coffeeType = scanner.next();

                switch (coffeeType) {
                    case "1":
                        if ((currentWater >= 250) && (currentCoffeeBeans >= 16) && (currentCups >= 1)) {
                            currentWater -= 250;
                            currentCoffeeBeans -= 16;
                            currentCups -= 1;
                            money += 4;
                        } else {
                            System.out.println("I can't make a cup of coffee. Not enough resources");
                        }

                        break;
                    case "2":
                        if ((currentWater >= 350) && (currentMilk >= 75) && (currentCoffeeBeans >= 20) && (currentCups >= 1)) {
                            System.out.println("I have enough resources, making you a coffee!");
                            currentWater -= 350;
                            currentMilk -= 75;
                            currentCoffeeBeans -= 20;
                            currentCups -= 1;
                            money += 7;
                        } else {
                            System.out.println("I can't make a cup of coffee. Not enough resources");
                        }
                        break;
                    case "3":
                        if ((currentWater >= 200) && (currentMilk >= 100) && (currentCoffeeBeans >= 12) && (currentCups >= 1)) {
                            currentWater -= 200;
                            currentMilk -= 100;
                            currentCoffeeBeans -= 12;
                            currentCups -= 1;
                            money += 6;
                        } else {
                            System.out.println("I can't make a cup of coffee. Not enough resources");
                        }
                        break;
                    case "back":
                        //System.out.println();
                        break;
                    default:
                        System.out.println("Wrong coffee selection");
                        break;
                }
                writeAction();
                break;

            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                currentWater += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                currentMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                currentCoffeeBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                currentCups += scanner.nextInt();
                writeAction();
                break;

            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                writeAction();
                break;

            case "remaining":
                machineState();
                writeAction();
                break;

            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Wrong action selection");
                writeAction();
                break;
        }
    }
}