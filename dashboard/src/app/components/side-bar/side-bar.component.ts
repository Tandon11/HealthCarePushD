import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DataServices } from 'src/app/services/data.services';
import { patient } from '../models/patient.model';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { DoctorLoginService } from 'src/app/services/doctor-login.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  patientData: patient[] | undefined;
  doctorid: string = '';
  constructor(private data: DataServices, private router: Router, private loginservice: DoctorLoginService) { }

  ngOnInit(): void {
    this.loginservice.getDoctor().subscribe(
      value => {
        this.doctorid = value.id
      },
      err => {
        console.log(err)
      }
    )
    this.data.getPatientData()
    .pipe(map(value => {
      let data = value.map((data:any) => {
        return { id: data.id, fname: data.fname, lname: data.lname ? data.lname : '' }
      })
      return data;
    }))
    .subscribe(
      data => {
          this.patientData = data
      },
      err => {
          console.log(err)
      }
    )
  }

  onGetingPatientDetails(id: string) {
    this.data.sendMessage(id)
    this.router.navigate(['/patient-view', id])
  }

}
