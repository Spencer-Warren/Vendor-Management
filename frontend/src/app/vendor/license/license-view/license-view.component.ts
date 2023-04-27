import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-license-view',
  templateUrl: './license-view.component.html',
  styleUrls: ['./license-view.component.css']
})
export class LicenseViewComponent {  
  
  license!: any;
  type!: any;

  constructor(private restAPI: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
    let id = this.router.url.split("/")[3];
    this.restAPI.getLicense(id).pipe(map((res: any) => {

      var blob = new Blob([res], { type: res.type});
      var url = window.URL.createObjectURL(blob);
      this.license = url;
    })).subscribe();
  }

  isImage(): boolean {
    return this.type == "image/jpeg" || this.type == "image/png" 
  }

  isPDF(): boolean {
    return this.type == "application/pdf"
  }

onEdit() {
  this.router.navigate(['/vendor/license-edit']);
}
onBack() {
  this.router.navigate(['/vendor/restaurants']);
}
onDownload() {
  // let id = this.router.url.split("/")[3];
  // this.restAPI.getLicense(id).pipe(map((res: any) => {
  //   console.log(res);
  //   var blob = new Blob([res], { type: 'image/jpeg' });
  //   var url = window.URL.createObjectURL(blob);
  //   window.open(url);
  // })).subscribe();
}




}
