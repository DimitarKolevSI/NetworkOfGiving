import { Component, OnInit } from '@angular/core';
import { Charity } from '../models/Charity';
import { CharityService } from '../services/charity-service'

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor(private service: CharityService) { }

  charities: Charity[] = [];
  key:string='';

  ngOnInit(): void {
    //this.charities = this.service.getAll();
    this.service.getAll().subscribe(
      (data:Charity[]) => this.charities = data
    )
  }

}
