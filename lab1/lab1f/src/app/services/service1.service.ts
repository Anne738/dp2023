import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Element } from '../interfaces/element';


@Injectable({
  providedIn: 'root'
})
export class Service1Service { 
  url:string="http://localhost:8888/lab1/servlet"

  list = new BehaviorSubject<Element[]>([])

  constructor(private http:HttpClient) { }

  getElem():Observable<Element[]>{
    return this.http.get<Element[]>(this.url);
  }

  postdata(elem:Element):Observable<Element>{
    return this.http.post<Element>(this.url, elem);
  }

  putdata(elem:Element):Observable<Element[]>{
    return this.http.put<Element[]>(this.url+"/"+elem.id, elem);
  }

  deletedata(elem:Element):Observable<Element[]>{
    return this.http.delete<Element[]>(this.url+"/"+elem.id);
  }

  setList(list:Element[]){
    this.list.next(list);
  }

  
}
