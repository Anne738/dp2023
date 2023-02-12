import { Component, OnInit } from '@angular/core';
import { Element } from '../interfaces/element';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-elements',
  templateUrl: './elements.component.html',
  styleUrls: ['./elements.component.scss']
})
export class ElemlistComponent implements OnInit {

  elemList:Element[]=[];
  showAddForm:boolean=false;
  selectedElem?:Element;


  constructor(private service:Service1Service){}

  ngOnInit(): void {
    this.updateElem();
    this.service.list.subscribe(
      (list:Element[])=>{
        this.elemList=list;
      }
    );
  }
  updateElem() {
    this.service.getElem().subscribe(
      (elements)=>{
        this.service.setList(elements);
      }
    );
  }
  addElem(elem:Element){
    this.service.postdata(elem).subscribe(
      (elements)=>{
        this.updateElem();
      }
    );
  }
  onSelect(elem:Element){
    if (this.selectedElem && elem.name==this.selectedElem.name){
      this.selectedElem=undefined;
    }
    else{
      this.selectedElem=elem;
    }
  }
  deleteElem(elem:Element){
    this.service.deletedata(elem).subscribe(
      ()=>{
        this.updateElem();
      }
    );
  }
}