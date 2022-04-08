import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Patient } from 'src/app/patient';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,private loginService : LoginService) { }

  patient: Patient = new Patient();

  ngOnInit(): void {
  }

  public onLogin(patientLogin : NgForm)
  {
    console.log(this.patient.email,this.patient.password)

    this.loginService.generateToken(this.patient).subscribe(
      (response:any)=>{

        console.log(response.token);
        console.log("patient_id is " + response.id);
        console.log("patient email  is " + response.email);
        console.log("patient first name is " + response.fname);
        console.log("patient last name is " + response.lname);
        localStorage.setItem("id",response.id);
        localStorage.setItem("email",response.email);
        localStorage.setItem("fname",response.fname);
        localStorage.setItem("lname",response.lname);
        
        this.loginUser(response.token)
        window.location.href = "/mood"
        // this.router.navigate(['mood']) // this works like crazy
        
      },
      error=>{ console.log(error)}
    );
  }

  public loginUser(token : string)
  {
    localStorage.setItem("token" ,token);
    return true;
  }



  // to retrieve the token from the storage i.e. from client browser and not troubling the server again..
  public getToken()
  {
    return localStorage.getItem("token");
  }

}
