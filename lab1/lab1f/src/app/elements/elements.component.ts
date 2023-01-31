import { Component } from '@angular/core';
import { Element } from '../interfaces/element';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-elements',
  templateUrl: './elements.component.html',
  styleUrls: ['./elements.component.scss']
})
export class ElementsComponent {

  elemList:Element[]=[];

  constructor(private service:Service1Service){}

  getElem():void{
    this.service.getElem().subscribe(
      (elements)=>{
        this.elemList=elements;
      }
    )
  }
}
