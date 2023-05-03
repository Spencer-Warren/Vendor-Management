import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
      this.file = event.target.files[0];
      console.log(this.file);
    }

    onSubmit() {
      let id: string =this.router.url.split('/')[3];
      let formData = new FormData();
      formData.append('file', this.file);
      this.restAPI.uploadLicense(formData, id).subscribe((data: any) => {
        this.router.navigate(['/vendor/home']);
      });
    }
}
