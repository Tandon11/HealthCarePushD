import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private router: Router,private http : HttpClient) { }

  url = "http://localhost:8080"

  generateToken(patient:Patient)
  {
    return this.http.post(`${this.url}/token`,patient);
  }

  //to check whether user is logged in or not..
  public isLoggedIn()
  {
    var token = localStorage.getItem("token");
    if(token == undefined || token == '' || token == null)
      return false;
    return true;
  }

    //for the user to logout..
    public logOut()
    {
      localStorage.removeItem("token");
      // location.reload()
      return true;
    }

}
