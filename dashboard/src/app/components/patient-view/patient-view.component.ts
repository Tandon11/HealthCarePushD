import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { DataServices } from 'src/app/services/data.services';
import { patientDetails } from '../models/patientDetail.model';
import * as $ from 'jquery'

@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.css']
})
export class PatientViewComponent implements OnInit {
  singlePatient: patientDetails | undefined;
  fullpatientDetails: any
  progressData: any
  constructor(
    private data: DataServices,
    private route:ActivatedRoute, private router: Router) { }
  id = ''
  
  ngOnInit(): void {
    // this.id = this.route.snapshot.params['pid']
    this.route.paramMap.subscribe(
      (param: any) => {
        this.data.getIndividualPatientData(param.get('pid'))
        .pipe(map(
            data => {
              this.fullpatientDetails = data
              this.data.setPatientSubjectBehaviour(data.id)
              console.log(data)
              return {'Email': data.email, 'First Name': data.fname, 'Last Name': data.lname, }
            }
        ))
        .subscribe(
          data => {
              this.singlePatient = data
              this.data.getPatientSubjectBehaviour().subscribe(data => console.log())
          },
          err => {
              console.log(err)
          }
        )
        this.data.getSectionProgress(param.get('pid')).subscribe(
          value => {
            this.progressData = value.section
                                  .filter((v:any) => v.id > 0)
                                  .map((d:any) => ({title: d.title, id: d.id}))
            // Pass in a number for the percent
            if(this.progressData?.length === 0) this.updateDonutChart('#specificChart', 0, true);
            if(this.progressData?.length === 1)  this.updateDonutChart('#specificChart', 33.34, true);
            if(this.progressData?.length === 2)  this.updateDonutChart('#specificChart', 66.67, true);
            if(this.progressData?.length === 3)  this.updateDonutChart('#specificChart', 100, true);
            console.log(this.progressData)
          },
          err => {
            console.log(err)
          }
        )
      }
    )
  }

  updateDonutChart (el: string, percent: number, donut: boolean) {
    percent = Math.round(percent);
    if (percent > 100) {
        percent = 100;
    } else if (percent < 0) {
        percent = 0;
    }
    var deg = Math.round(360 * (percent / 100));

    if (percent > 50) {
        $(el + ' .pie').css('clip', 'rect(auto, auto, auto, auto)');
        $(el + ' .right-side').css('transform', 'rotate(180deg)');
    } else {
        $(el + ' .pie').css('clip', 'rect(0, 1em, 1em, 0.5em)');
        $(el + ' .right-side').css('transform', 'rotate(0deg)');
    }
    if (donut) {
        $(el + ' .right-side').css('border-width', '0.1em');
        $(el + ' .left-side').css('border-width', '0.1em');
        $(el + ' .shadow').css('border-width', '0.1em');
    } else {
        $(el + ' .right-side').css('border-width', '0.5em');
        $(el + ' .left-side').css('border-width', '0.5em');
        $(el + ' .shadow').css('border-width', '0.5em');
    }
    $(el + ' .num').text(percent);
    $(el + ' .left-side').css('transform', 'rotate(' + deg + 'deg)');
}



}
