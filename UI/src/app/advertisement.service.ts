import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Advertisement } from './advertisement.model';
import { map } from "rxjs/operators";

@Injectable({ providedIn: 'root'})
export class AdvertisementService{

    constructor(private http: HttpClient) { }

    writeAdvt(advtInfo) {
      return this.http.post('http://localhost:8080/advertisements', advtInfo);
    }

    getAllAdvt(): Observable<Advertisement[]>{
      return this.http
      .get<Advertisement[]>('http://localhost:8080/advertisements')
      .pipe(map(response => response));
    }

    clickify(vID: number) {

      return this.http.get(`http://localhost:8080/advertisements/${vID}/clicks`)
      .pipe(map(response => response));
    }

    getAdId(Ad){
      return this.http.get(`http://localhost:8080/advertisements/AdId`).pipe
      (map(response => response));
    }
}
