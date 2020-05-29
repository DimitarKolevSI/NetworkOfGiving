import { Component, OnInit } from '@angular/core';
import { Charity } from '../models/Charity';
import { User } from '../models/User';
import { CharityService } from '../services/charity-service';
import { Router } from '@angular/router';
import { UserService } from '../services/user-service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


  public isInvalid:boolean = false;
  public errorMessage:string='';
  public input:String;
  form:User = ({
    username:"",
    password:"",
    firstName:"",
    lastName:"",
    age:0,
    gender:"",
    location:""
  })
  constructor(private service:UserService, public router:Router) { }

  ngOnInit(): void {
  }

  onClick():void
  {
    this.form.age = +this.form.age;
    if(this.isValid()){
      this.service.addUser(this.form).subscribe(
        ()=>this.router.navigate(['/login']),
        ()=>{
          this.errorMessage = "Username is taken!"
          this.isInvalid = true;
        }
      )
    }
  }

  isValid():boolean
  {
    var lettersAndNumbersCheck = '^[0-9a-zA-Z]+$';
    var lettersCheck='^[a-zA-Z]+$'
    this.form.age = +this.form.age;
    if(!this.form.username.match(lettersAndNumbersCheck))
    {
      this.errorMessage = "Invalid username! Should contain only letters and digits"
    }
    else if(!this.form.password.match(lettersAndNumbersCheck) || this.form.password.length <8){
      this.errorMessage = "Password should contain only letters and numbers and should be at least 8 symbols!";
    }
    else if(!this.form.firstName.match(lettersCheck) && !this.form.lastName.match(lettersCheck)){
      this.errorMessage = "First and last name should contain only letters!"
    }
    else if(this.form.age < 16){
      this.errorMessage = "You should be at least 16 years old to registrate!"
    }
    else if(this.form.gender !== 'Male' && this.form.gender !== 'Female' && this.form.gender !== 'Undefined'){
      this.errorMessage = "Pick a gender!";
    } 
    else{
      return true;
    }
    this.isInvalid=true;
    return false;
  }
}
