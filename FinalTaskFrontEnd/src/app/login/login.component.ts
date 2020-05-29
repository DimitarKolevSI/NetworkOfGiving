import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms' 
import { CharityService } from '../services/charity-service';
import { User } from '../models/User'
import { Router } from '@angular/router'
import { stringify } from 'querystring';
import { UserService } from '../services/user-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model = new User('','', '','',10,'','')

  @ViewChild('login') d1:ElementRef;
  @ViewChild('username') d2:ElementRef;

  @Input()
  public test:string;
  public username:string;
  public password:string;
  isError:boolean = false;
  errorMessage:String;
  private user:User = null;
  constructor(public charityService: CharityService, public router: Router,
              public userService: UserService) { }

  ngOnInit(): void {

  }

  onLogin():void{
    event.preventDefault();
    this.username = this.model.username;
    this.password = this.model.password;
    this.userService.getUser(this.username).subscribe(
      (data:User)=>{
        this.user = data;
        console.log(this.user.username);
        console.log(this.user.password);
        console.log(this.user);
      }
    )
    setTimeout(()=>this.checkForValidation(),10);
    
  }
  checkForValidation():void{
    if(this.user === null)
    {
      this.isError = true;
        this.errorMessage="Wrong username!"
    }
    else
    {
      if(this.user.password === this.password)
      {
        localStorage.setItem("username",this.username)
        this.isError=false;
        this.router.navigate(['/home'])
      }
      else
      {
        this.isError = true;
        this.errorMessage="Wrong password!"
      }
    }
  }
}
