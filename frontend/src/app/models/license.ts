export class License {
    file: File;
    restauratId: number;
    
    constructor(file: File, restauratId: number) {
        this.file = file;
        this.restauratId = restauratId;
    }
}