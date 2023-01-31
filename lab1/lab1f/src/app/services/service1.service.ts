import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Element } from '../interfaces/element';


@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  url:string="http://localhost:8888/lab1/servlet"

  constructor(private http:HttpClient) { }

  getElem():Observable<Element[]>{
    return this.http.get<Element[]>(this.url);
  }
}
