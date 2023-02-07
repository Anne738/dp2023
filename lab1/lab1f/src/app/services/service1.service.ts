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

  public postdata( Img: Object, Price: Object, Name: Object) {
    this.http.put(this.url + "?images="+Img+"&price="+Price+"&name="+Name, Name).subscribe(data => {
      console.log(data);
    });
  }
}
