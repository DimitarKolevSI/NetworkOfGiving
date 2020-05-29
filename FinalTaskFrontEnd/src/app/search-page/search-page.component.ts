import { Component, OnInit } from '@angular/core';
import { CharityService } from '../services/charity-service';
import { ActivatedRoute } from '@angular/router';
import { Charity } from '../models/Charity';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {

  public result: Charity[] = [];
  private key:string;
  constructor(public charityService: CharityService, public activatedRouter: ActivatedRoute) {
    this.key = activatedRouter.snapshot.params.key;
    charityService.searchCharity(this.key).subscribe(
      (data:Charity[]) => this.result = data
    )     
   }

  ngOnInit(): void {
  }

}
