import { Component, Input, OnInit } from '@angular/core';
import { CharityService } from './services/charity-service';
import { User } from './models/User';
import { UserService } from './services/user-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'FinalTaskFrontEnd';
  public currentUsername: String;
  public opened:boolean = false;
  constructor(public service:CharityService, public userService:UserService){
    if(localStorage.getItem("username")===null) {
      localStorage.setItem("username","");
    }
    this.currentUsername = localStorage.getItem("username");
  }

  ngOnInit(){
  }

  logOut():void{
    localStorage.setItem("username",'');
    this.opened = false;
  }

  onLogOut():void{
    event.preventDefault();
    this.opened = true;
  }
  
}
