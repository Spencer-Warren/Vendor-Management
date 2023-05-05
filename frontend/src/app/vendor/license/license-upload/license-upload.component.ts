import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-license-upload',
  templateUrl: './license-upload.component.html',
  styleUrls: ['./license-upload.component.css']
})
export class LicenseUploadComponent {
  file!: File;
  
    constructor(private restAPI: RESTAPIService, private router: Router) { }

    onFileChange(event: any) {
      let temp: File = event.target.files[0];
      if (temp.type == 'application/pdf' || temp.type == 'application/msword') {
        this.file = temp;
      } else {
        alert('Please upload a pdf or doc file');
        event.target.value = '';
      }
    }

    onSubmit() {
      if (!this.file) {
        alert('Please select a file');
        return;
      }
      let id: string = this.router.url.split('/')[3];
      let formData = new FormData();
      formData.append('file', this.file);
      this.restAPI.uploadLicense(formData, id).pipe(map((response: any) => {
        console.log(response);
        alert('License uploaded successfully');
        this.router.navigate(['/vendor/restaurants']);
      })).subscribe();
    }
}
