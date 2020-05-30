import { Component, OnInit } from '@angular/core';
import { Charity } from '../models/Charity';
import { CharityService } from '../services/charity-service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user-service';

@Component({
  selector: 'app-detail-charity-view',
  templateUrl: './detail-charity-view.component.html',
  styleUrls: ['./detail-charity-view.component.scss']
})
export class DetailCharityViewComponent implements OnInit {

  currentCharity:Charity = new Charity("","",0,0,0,0,"",0);
  title: string
  opened:boolean = false;
  vOpened:boolean = false;
  deletion:boolean = false;
  amountToDonate:number = 0;
  constructor(private service:CharityService, private activatedRouter: ActivatedRoute,
              private router:Router, public userService:UserService) { }

  ngOnInit(): void {
    this.title = this.activatedRouter.snapshot.params.title;
    console.log(this.title)
    this.refreshCharity();
    if(this.currentCharity === null){
      this.router.navigate(['/error'])
    }
  }

  onClick():void{
    console.log('Something');
  }

  donation():void{
    this.opened=false;
    if(this.amountToDonate > 0){
      this.amountToDonate = +this.amountToDonate;
      if(this.amountToDonate + this.currentCharity.moneyDonated > this.currentCharity.moneyNeeded){
        this.amountToDonate = this.currentCharity.moneyNeeded - this.currentCharity.moneyDonated;
      }
      this.service.donate(this.amountToDonate, this.currentCharity.id)
      .subscribe(
        ()=>this.refreshCharity()
      );
    }
  }

  volunteer():void{
    
    this.service.volunteer(this.currentCharity.id)
      .subscribe(
        ()=>{
          this.refreshCharity();
          this.vOpened = false;
        },
        (error)=>{
          this.vOpened = false;
          setTimeout(()=>alert("You have already participated!"),10);
        }
      )
  }

  checkForLogin(window:string):void{
    if(this.userService.getCurrentUsername() === ''){
      alert("You need to login first!")
    }
    else{
      if(window==='opened'){
        this.opened=true;
      }
      else{
        this.vOpened = true;
      }
      
    }
  }

  refreshCharity():void{
      this.service.getCharity(this.title).subscribe(
      (data:Charity) => this.currentCharity = data
    )

  }

  delete():void{
    console.log("Deleting...")
    this.service.delete(this.currentCharity.id).subscribe(
      ()=>this.router.navigate(['/home'])
    )
  }

  edit(){
    console.log("TODO");
  }
}
