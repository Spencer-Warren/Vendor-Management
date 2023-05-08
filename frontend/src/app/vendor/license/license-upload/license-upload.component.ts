import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { RESTAPIService } from 'src/app/services/restapi.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-license-upload',
  templateUrl: './license-upload.component.html',
  styleUrls: ['./license-upload.component.css']
})
export class LicenseUploadComponent {
  file!: File;
  allowedTypes: string[] = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'];
  
    constructor(private restAPI: RESTAPIService, private router: Router, private restauarantService: RestaurantsService) { }

    onFileChange(event: any) {
      let temp: File = event.target.files[0];
      console.log(temp.type);
      if (this.allowedTypes.includes(temp.type)) {
        this.file = temp;
      } else {
        alert('Please choose a pdf or doc file');
        event.target.value = '';
      }
    }

    onSubmit() {
      if (!this.file) {
        alert('Please select a file');
        return;
      }
      // get restaurant id from service and send it to the api
      let id: string = this.restauarantService.getCurrentRestaurant().restaurantID.toString();
      let formData = new FormData();
      formData.append('file', this.file);
      this.restAPI.uploadLicense(formData, id).pipe(map((response: any) => {
        console.log(response);
        alert('License uploaded successfully');
        this.router.navigate(['/vendor/restaurants']);
      })).subscribe();
    }
}
