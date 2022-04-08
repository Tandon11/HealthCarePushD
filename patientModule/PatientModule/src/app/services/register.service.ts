import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../patient';

@Injectable({
  providedIn: 'root'
})

export class RegistrationService {
  registrationUrl = 'http://localhost:8080/register';

  isAuthenticated = false;

  constructor(private http: HttpClient) { }

  enroll(patient: Patient)
  {
    return this.http.post<any>(this.registrationUrl,patient);
  }
}