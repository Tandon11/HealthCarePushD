import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PatientResponses } from '../patient-responses';



@Injectable({
  providedIn: 'root'
})
export class StoreResponsesService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8080"

  saveResponses(patientRespones:PatientResponses ,sec_id:number)
  {
    const pat_id = localStorage.getItem("id");
    console.log(JSON.stringify(patientRespones))
    return this.http.post(`${this.baseUrl}/patient/responses/${pat_id}/${sec_id}`,patientRespones);
  }

}
