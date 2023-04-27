import { Vendor } from './vendor';

export class Restaurant {
    restaurantID: number;
    restaurantName: string;
    restaurantAddress: string;
    restaurantCategory: string;
    restaurantType: string;
    restaurantDescription: string;
    restaurantPhone: string;
    restaurantEmail: string;
    vendor: Vendor;


    constructor(restaurantID: number, restaurantName: string, restaurantAddress: string, restaurantCategory: string, restaurantType: string, restaurantDescription: string, restaurantPhone: string, restaurantEmail: string, vendor: Vendor) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantCategory = restaurantCategory;
        this.restaurantType = restaurantType;
        this.restaurantDescription = restaurantDescription;
        this.restaurantPhone = restaurantPhone;
        this.restaurantEmail = restaurantEmail;
        this.vendor = vendor;
    }
}