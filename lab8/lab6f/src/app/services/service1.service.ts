import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Element } from '../interfaces/element';
import { Http } from '../interfaces/rest.interfaces/http';


@Injectable({
  providedIn: 'root'
})
export class Service1Service { 
  url:string="http://localhost:2918/api/elements"

  list = new BehaviorSubject<Element[]>([])

  constructor(private http:HttpClient) { }

  getElem():Observable<Element[]>{
    return this.http.get<Element[]>(this.url + "/get");
  }

  postdata(elem:Element):Observable<Element[]>{
    return this.http.post<Element[]>(this.url + "/new", elem);
  }

  putdata(elem:Element):Observable<Element[]>{
    return this.http.put<Element[]>(this.url + "/update" + `/${elem.id}`, elem);
  }

  deletedata(elem:Element):Observable<Element[]>{
    return this.http.delete<Element[]>(this.url + "/delete" + `/${elem.id}`);
  }

  setList(list:Element[]){
    this.list.next(list);
  }

}
