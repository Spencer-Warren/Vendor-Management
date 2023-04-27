
export class Vendor {
    vendorId: Number;
    vendorName: string;
    vendorEmail: string;
    vendorUsername: string;
    vendorPassword: string;

    constructor(vendorId: Number, vendorName: string, vendorEmail: string, vendorUsername: string, vendorPassword: string) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorUsername = vendorUsername;
        this.vendorPassword = vendorPassword;
    }

}