import { Vendor } from './vendor';

export class Restaurant {
    restaurantId: number;
    restaurantName: string;
    restaurantLocation: string;
    restaurantCategory: string;
    restaurantType: string;
    vendor: Vendor;

    constructor(restaurantId: number, restaurantName: string, restaurantLocation: string, restaurantCategory: string, restaurantType: string, vendor: Vendor) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantCategory = restaurantCategory;
        this.restaurantType = restaurantType;
        this.vendor = vendor;
    }
}