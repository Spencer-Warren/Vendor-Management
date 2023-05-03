import { HttpResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { RESTAPIService } from 'src/app/services/restapi.service';

@Component({
  selector: 'app-license-view',
  templateUrl: './license-view.component.html',
  styleUrls: ['./license-view.component.css']
})
export class LicenseViewComponent {  
  
  license!: any;
  type!: any;
  fileName!: any;

  constructor(private restAPI: RESTAPIService, private router: Router, private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    let id = this.router.url.split("/")[3];

    this.restAPI.getLicense(id)
    .subscribe((res: HttpResponse<any>) => {

      var contentDisposition = res.headers.get('Content-Disposition');

      if (contentDisposition != null) {
        var filename = contentDisposition.split('filename')[1].split('=')[1].trim();
        filename = filename.replace(/"/g, '');
      }
      else {
        var filename = "license";
      }
      
      var blob: File = new File([res.body], filename, { type: res.body.type });
      this.type = res.body.type;
      this.fileName = filename;
      var url = window.URL.createObjectURL(blob);
      this.license = this.sanitizer.bypassSecurityTrustResourceUrl(url);
    });
  }

  isImage(): boolean {
    return this.type == "image/jpeg" || this.type == "image/png" 
  }

  isPDF(): boolean {
    return this.type == "application/pdf"
  }

  onEdit() {
    this.router.navigate(['/vendor/license-upload/' + this.router.url.split("/")[3]]);
  }

  onBack() {
    this.router.navigate(['/vendor/restaurants']);
  }
  
  onDownload() {
    var a = document.createElement("a");
    document.body.appendChild(a);
    a.style.display = "none";
    a.href = this.license.changingThisBreaksApplicationSecurity;  
    a.download = this.fileName;
    a.click();
    a.remove();
  }
  

  ngOnDestroy(): void {
    window.URL.revokeObjectURL(this.license);
  }
}
