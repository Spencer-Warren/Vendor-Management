import { Restaurant } from "./restaurant";

export class Dish {
    dishID: number;
    dishName: string;
    dishDescription: string;
    dishPrice: number;
    dishCategory: string;
    restaurant: Restaurant;

    constructor(dishID: number, dishName: string, dishDescription: string, dishPrice: number, dishCategory: string, restaurant: Restaurant) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.dishDescription = dishDescription;
        this.dishPrice = dishPrice;
        this.dishCategory = dishCategory;
        this.restaurant = restaurant;
    }
}