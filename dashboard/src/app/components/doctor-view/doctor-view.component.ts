import { Component, OnInit } from '@angular/core';
import { DoctorLoginService } from 'src/app/services/doctor-login.service';
import { doctorInitial } from '../models/doctorInitial.model';
import * as CryptoJS from 'crypto-js';
import { environment } from 'src/environments/environment';
import { DataServices } from 'src/app/services/data.services';

@Component({
  selector: 'app-doctor-view',
  templateUrl: './doctor-view.component.html',
  styleUrls: ['./doctor-view.component.css']
})
export class DoctorViewComponent implements OnInit {
  doctorDetils: any;
  doctorDetailsForPrint : any;
  isAvail : any;
  tokenFromUI: string = "0123456789123456";
  encrypted: any = "";
  decrypted: string = "";
  generatedStringLink: string = ""
  generatedencLink: string = ""
  encodedUrl: string = ""
  linkCredentials ={
    doctorId:"",
    patEmail:"",
    patFname:""
  }
  linkGenerationMessage : string =""
  linkGenerationError : string=""
  constructor(private loginService: DoctorLoginService,
              private dataService : DataServices) { }

  ngOnInit(): void {
    this.loginService.getDoctor().subscribe(
      (value: any) => {
        this.doctorDetils = {username: value.username, id: value.id, fname: value.fname, lname: value.lname, isAvail: value.isAvail}
        this.doctorDetailsForPrint = {Username: value.username, Id: value.id, "First Name": value.fname, "Last Name": value.lname}
        this.isAvail = (this.doctorDetils.isAvail==="true")?true:false
      }, 
      (err:any) => {
        console.log(err)
      }
    )
  }

  generateLink(fname: HTMLInputElement, email: HTMLInputElement) {
    console.log(fname.value, email.value)
    this.linkCredentials.doctorId = this.doctorDetils.id
    this.linkCredentials.patEmail = email.value
    this.linkCredentials.patFname = fname.value
    this.dataService.generateLinkService(this.linkCredentials).subscribe(
      (data:any) => {
        console.log('success', data)
        this.linkGenerationMessage = data.patEmail
        console.log(this.linkGenerationMessage)
        setTimeout(()=>{                           //<<<---using ()=> syntax
          this.linkGenerationMessage = "";
     }, 5000);
    },
      error => {
        console.log('oops', error.error)
        this.linkGenerationError = error.error.patEmail
        console.log(this.linkGenerationError)
        setTimeout(()=>{                           //<<<---using ()=> syntax
          this.linkGenerationError = "";
     }, 5000);
    }
      // (response:any)=>{
      //   console.log("Response")
      //   console.log(response)
      //   this.linkGenerationMessage = response
      // },
      // error=>{
      //     console.log("Error here")
      //     // console.log(error)
      //     this.linkGenerationError = error
      // }
    )

    // this.generatedStringLink = fname.value + ':' + email.value + ':' + this.doctorDetils.id + ':' + (Date.now() + (20 * 60 * 1000))
    // this.encodedUrl = environment.url + '/abc?val=' + this.encryptUsingAES256()
  }

  encryptUsingAES256() {
    let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    let _iv = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    let encrypted = CryptoJS.AES.encrypt(
      JSON.stringify(this.generatedStringLink), _key, {
        keySize: 16,
        iv: _iv,
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
      });
    return encrypted.toString();
  }

  decryptUsingAES256() {
    let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    let _iv = CryptoJS.enc.Utf8.parse(this.tokenFromUI);

    this.decrypted = CryptoJS.AES.decrypt(
      this.encrypted, _key, {
        keySize: 16,
        iv: _iv,
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
      }).toString(CryptoJS.enc.Utf8);
  }

}
