import { Component, OnInit } from '@angular/core';
import { Service1Service } from '../services/service1.service';
import { Element } from '../interfaces/element';
 
@Component({
  selector: 'app-elemlist',
  templateUrl: './elemlist.component.html',
  styleUrls: ['./elemlist.component.scss']
})
export class ElemlistComponent implements OnInit {

  elemList:Element[]=[];
  showAddForm:boolean=false;
  selectedElem?:Element;


  constructor(private service:Service1Service){}

  ngOnInit(): void{
    this.updateElem();
    this.service.list.subscribe(
      (list:Element[])=>{this.elemList=list}
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
    console.log(elem, "xxxxx");
    this.service.postdata(elem).subscribe(
      (elements)=>{
        this.updateElem();
      }
    );
    this.refreshPage();
  }
  onSelect(elem:Element){
    if (this.selectedElem && elem.id==this.selectedElem.id){
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
    this.refreshPage();
  }


  refreshPage(): void{
    window.location.reload();
  }


}
