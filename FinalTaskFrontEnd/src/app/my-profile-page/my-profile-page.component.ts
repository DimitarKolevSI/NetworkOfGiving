import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user-service';

@Component({
  selector: 'app-my-profile-page',
  templateUrl: './my-profile-page.component.html',
  styleUrls: ['./my-profile-page.component.scss']
})
export class MyProfilePageComponent implements OnInit {

  public user:User;
  public currentUsername:String;
  constructor(private router:Router, private userService: UserService, 
              private activatedRouter:ActivatedRoute) {
      this.currentUsername = this.activatedRouter.snapshot.params.username;
      console.log(this.currentUsername)
      //this.user = userService.getUser(this.currentUsername);
      if(this.user === null){
        router.navigate(['/error']);
      }
   }

  ngOnInit(): void {
  }

}
