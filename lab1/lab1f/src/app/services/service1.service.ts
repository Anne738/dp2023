import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Element } from '../interfaces/element';


@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  url:string="http://localhost:8080/lab1b/servise"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Element[]>{
    return this.http.get<Element[]>(this.url);
  }
}
