/*
 * This code solves the time to reheat a certain food
 *
 * @author  Andi Cucka
 * @version 1.0
 * @since   2024-02-20
 */

import { createPrompt } from 'bun-promptx';

// constants
const soupTime: number = 105;
const pizzaTime: number = 45;
const subTime: number = 60;

try {
    // input
    const food = createPrompt("Enter a food(sub, pizza, soup): ");
    let foodString: string = food.value.toLowerCase();

    // error checking
    switch (foodString) {
        case "sub":
            console.log(`Time to reheat ${foodString}: ${subTime} seconds`);
            break;
        case "pizza":
            console.log(`Time to reheat ${foodString}: ${pizzaTime} seconds`);
            break;
        case "soup":
            console.log(`Time to reheat ${foodString}: ${soupTime} seconds`);
            break;
        default:
            throw new Error("Invalid food choice");
    }
} catch (error) {
    console.error(error.message);
}
