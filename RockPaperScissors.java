/*
 * This is a program that calculates the total cook time based on
 * the lunch item and number of lunch items
 *
 * @author  Andi Cucka 
 * @version 1.0
 * @since   2024-02-22
 */

import java.util.Scanner;

/**
* This is the standard "LunchCookTime" program.
*/
final class LunchCookTime {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private LunchCookTime() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        // constants & variables
        final float subCookTime = 60.0f;
        final float pizzaCookTime = 45.0f;
        final float soupCookTime = 105.0f;
        final int oneMinute = 60;
        final int maxLunch = 3;
        float totalCookTime = 0.0f;
        boolean validInput = true;

        // input
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Are you heating sub, pizza, or soup? (lowercase): ");
        final String lunchType = scanner.nextLine();
        System.out.print("How many are you heating? (Max 3): ");
        final int lunchAmountInt = Integer.parseInt(scanner.nextLine());

        // error check
        if (lunchAmountInt < 0 || lunchAmountInt > maxLunch) {
            System.out.println("Invalid input.");
        } else {
            // process
            switch (lunchType) {
                case "sub":
                    totalCookTime =
                        (subCookTime / 2) + ((subCookTime / 2)
                        * lunchAmountInt);
                    break;
                case "pizza":
                    totalCookTime =
                        (pizzaCookTime / 2) + ((pizzaCookTime / 2)
                        * lunchAmountInt);
                    break;
                case "soup":
                    totalCookTime =
                        (soupCookTime / 2) + ((soupCookTime / 2)
                        * lunchAmountInt);
                    break;
                default:
                    System.out.println("Invalid input");
                    validInput = false;
                    break;
            }
            if (validInput) {
                // output
                final double cookTimeSeconds = totalCookTime % oneMinute;
                final double cookTimeMinutes =
                    Math.floor(totalCookTime / oneMinute);
                System.out.println(
                    "Total cook time:\n" + cookTimeMinutes + " minutes, "
                     + cookTimeSeconds + " seconds."
                );
            }
        }

        System.out.println("\nDone.");
    }
}
