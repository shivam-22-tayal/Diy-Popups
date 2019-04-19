import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from '../advertisement.service';
import { Advertisement } from '../advertisement.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-owner-dashboard',
  templateUrl: './owner-dashboard.component.html',
  styleUrls: ['./owner-dashboard.component.css']
})
export class OwnerDashboardComponent implements OnInit {

  advts: Advertisement[];
  advtInfo: Advertisement;
  idA: any;
  category;
  product;
  dop;
  desc;
  aid;
  constructor(private service: AdvertisementService,
    private router: Router
  ) { 

    this.service.getAllAdvt().subscribe(
      data => {
        this.advts = data;
      },
      error => {
        console.log(error);
      }
    );
  }


  ngOnInit() {
    //this.getAllAdvt();
  }

  getAllAdvt() {
    this.service.getAllAdvt().subscribe(
      data => {
        this.advts = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  submitAdvt() {


    if (this.category !== undefined && this.product !== undefined && this.dop !== undefined && this.desc !== undefined) {
      this.advtInfo = new Advertisement(
        this.category,
        this.product,
        this.dop,
        this.desc);
    }

    this.service.writeAdvt(this.advtInfo)
      .subscribe(
        response => {
          alert('Advertisement has been posted...!!');
          this.router.navigateByUrl('/showAdd');

        },
        error => {
          console.log(error);

        });
    this.service.getAdId(this.advtInfo).subscribe(
      response => {
        this.idA = response;

      },
      error => {
        console.log(error);

      });

    this.advtInfo.id = this.idA;


    this.category = '';
    this.product = '';
    this.dop = '';
    this.desc = '';
  }


  clickCount(id: number) {

    this.service.clickify(id).subscribe(data => { console.log(data); },

      err => { console.log(err); });
  }


}


