import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor() { }
   openNav() {
    document.getElementById("mySidenav").style.width = "250px";
   }
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  
   }

  ngOnInit() {
  }

 


}
