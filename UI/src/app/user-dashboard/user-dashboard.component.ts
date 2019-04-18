import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from "../advertisement.service";
import { Advertisement } from "../advertisement.model";
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  advts: Advertisement[];

  constructor(
    private service: AdvertisementService,
              private router : Router
  ) { }
   openNav() {
    document.getElementById("mySidenav").style.width = "250px";
   }
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";

   }

  ngOnInit() {
    this.getAllAdvt();
  }

  getAllAdvt(){
    this.service.getAllAdvt().subscribe(
      data =>{
        this.advts = data;
      },
      error =>{
        console.log(error);
      }
    );
  }


}
