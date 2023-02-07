import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent {

  constructor(private service:Service1Service){}

  name: string = '';
  images: string = '';
  price: number = 0;


  getName(val: string) {
    console.warn(val)
    this.name = val
  }
  getImg(val: string) {
    console.warn(val)
    this.images = val
  }
  getPrice(f: NgForm) {
    this.price = parseInt(f.value.price)
  }

  OnClick(): void {
    console.log(this.name)
    console.log(this.images)
    console.log(this.price)
    this.service.postdata( this.images, this.price, this.name );
  }
}
