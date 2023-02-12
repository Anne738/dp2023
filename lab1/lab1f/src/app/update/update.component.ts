import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Element } from '../interfaces/element';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  @Input() element?:Element
  @Output() updated:EventEmitter<null> = new EventEmitter();
  constructor(private service:Service1Service){}

  ngOnInit(): void {
    
  }

  updateData(){
    if(this.element) {
      //console.log(this.element);
      this.service.putdata(this.element).subscribe(
        ()=>{
          this.updated.emit();
        }
      );
    }
  }

}
