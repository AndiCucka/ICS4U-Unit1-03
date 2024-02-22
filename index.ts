/*
 * This code calculates the time to reheat selected foods
 *
 * @author  Andi Cucka
 * @version 1.0
 * @since   2024-02-20
 */

import { createPrompt } from 'bun-promptx';

// Constants
const foodTimes: { [key: string]: number } = {
    "sub": 60,
    "pizza": 45,
    "soup": 105
};

try {
    // Input
    const foodSelections: string[] = [];
    for (let foodIndex = 0; foodIndex < 3; foodIndex++) {
        const food = createPrompt(`Enter food ${foodIndex + 1} (sub, pizza, soup), or leave empty to finish: `);
        if (food.value === "") break; // Break if input is empty
        foodSelections.push(food.value.toLowerCase());
    }

    // Calculate total time
    let totalTimeSeconds: number = 0;
    foodSelections.forEach(food => {
        if (food in foodTimes) {
            totalTimeSeconds += foodTimes[food];
        } else {
            throw new Error(`Invalid food choice: ${food}`);
        }
    });

    // Convert total time to minutes and seconds
    const totalTimeMinutes: number = Math.floor(totalTimeSeconds / 60);
    const remainingSeconds: number = totalTimeSeconds % 60;

    // Output
    console.log(`Total reheating time: ${totalTimeMinutes} minutes ${remainingSeconds} seconds`);

} catch (error) {
    console.error(error.message);
}
