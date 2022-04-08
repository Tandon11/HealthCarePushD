import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Patient } from 'src/app/patient';
import { RegistrationService } from 'src/app/services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(public registrationService: RegistrationService) { }
  
  patient: Patient = new Patient();
  
  ngOnInit(): void {
  }

  public onSubmit(patientSignUp : NgForm)
  {
    console.log(this.patient);
    this.registrationService.enroll(this.patient)
    .subscribe(
      (data:any) => {

        console.log('Success!',data),alert("Registration Success! Check your email to confirm your account! ")
        window.location.href = "/"

      },
      error => {console.log('Success!',error),alert("Email error! ")
      window.location.href = "/"
    }
      
    )
    // this.registrationService.enroll(this.patient)
    // .subscribe(
    //   data => {console.log('Success!',data),alert("Registration Success! Check your email to confirm your account! ")},
    //   error => {console.log('Error!',error),alert("Invalid Email or Password.. Try again")}
    // )
  }

}
