import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private loginService : LoginService,private router : Router) { }

  public loggedIn = false;
  
  ngOnInit(): void 
  {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  public logOutUser()
  {
    this.loginService.logOut();
    window.location.href = "/"
    // this.router.navigate(['']);
    // location.reload();
  }

}
