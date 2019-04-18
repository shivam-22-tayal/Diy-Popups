import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from "../advertisement.service";
import { Advertisement } from "../advertisement.model";
import { Router } from '@angular/router';

@Component({
  selector: 'app-owner-dashboard',
  templateUrl: './owner-dashboard.component.html',
  styleUrls: ['./owner-dashboard.component.css']
})
export class OwnerDashboardComponent implements OnInit {

  advts: Advertisement[];

  category;
  product;
  dop;
  desc;
  constructor(private service: AdvertisementService,
              private router : Router
    ) { }


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

  submitAdvt(){

    if(this.category!=undefined && this.product!=undefined && this.dop!=undefined && this.desc!=undefined)
    {
   let advtInfo ={
     categoryadd: this.category,
     product: this.product,
     dop: this.dop,
     description: this.desc
   }

      this.service.writeAdvt(advtInfo)
      .subscribe(
        response => {
          alert("Advertisement has been posted...!!");
          this.router.navigateByUrl("/showAdd");

      },
      error => {
        console.log(error);

      });

  }
    this.category="";
    this.product="";
    this.dop="";
    this.desc="";
  }

}


