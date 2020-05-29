import { Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import { Charity } from '../models/Charity';
import { UserService } from '../services/user-service';
import { CharityService } from '../services/charity-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-charity',
  templateUrl: './create-charity.component.html',
  styleUrls: ['./create-charity.component.scss']
})
export class CreateCharityComponent implements OnInit {

  isInvalid:boolean = false;
  errorMessage:string;
  

  public form:Charity = ({
    title:'',
    description:'',
    volunteersNeeded:0,
    volunteers: 0,
    moneyNeeded: 0,
    moneyDonated: 0,
    creatorsUsername: this.userService.getCurrentUsername(),
    id:0
  })

  constructor(private elementRef: ElementRef, public userService:UserService,
              public charityService:CharityService, public router:Router) { }

  ngOnInit(): void {
  }

  onClick()
  {
    event.preventDefault();
    if(this.checkIfValid()){
      this.charityService.createCharity(this.form).subscribe(
        ()=>this.router.navigate(['/home'])
      );
    }
    
  }

  checkIfValid():boolean{
    if(this.form.volunteersNeeded<0){
      this.errorMessage = "The needed volunteers can't be negative number!";
    }
    else if(this.form.moneyNeeded < 0){
      this.errorMessage = "The needed money can't be negative number!";
    }
    else if(this.form.volunteersNeeded == 0 && this.form.moneyNeeded == 0){
      this.errorMessage = "You have to choose if you need volunteers or money for the charity!"
    }
    else{
      return true;
    }
    this.isInvalid=true;
    return false;
  }

}
