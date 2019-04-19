import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from '../advertisement.service';
import { Advertisement } from '../advertisement.model';
import { Router } from '@angular/router';
import { EndUserLinkService } from '../end-user-link.service';
import { StoreUidService } from '../store-uid.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  advts: Advertisement[];
  credits;
  ide;
  constructor(
    private service: AdvertisementService,
    private router: Router, private eul: EndUserLinkService,
    private euid: StoreUidService
  ) { }
  openNav() {
    document.getElementById('mySidenav').style.width = '250px';
  }
  closeNav() {
    document.getElementById('mySidenav').style.width = '0';

  }

  ngOnInit() {
    this.ide = this.euid.uId;
    this.getAllAdsById(this.ide);
  }


  getAllAdsById(id: number) {

    this.eul.getAllAdsByEid(id).subscribe(
      data => {
        this.advts = data;
      },
      error => {
        console.log(error);
      }
    );
  }



  clickCount(id: number) {

    this.service.clickify(id).subscribe(data => { console.log(data); },

      err => { console.log(err); });
  }

  creditCount(eid: number, vid: number) {
    // this.credits=0;
    console.log(eid + '' + vid);

    this.clickCount(vid);

    this.eul.creditFlow(eid, vid).subscribe(data => this.credits = data,
      err => { console.log(err); });
    // this.creditShow(eid);
    // console.log(this.credits);

  }

  creditShow(eid: number) {
    this.eul.showCredits(eid).subscribe(data => { this.credits = data; console.log(data); },
      err => { console.log(err); });

    // console.log(this.credits)
    // return this.credits;
  }

}
