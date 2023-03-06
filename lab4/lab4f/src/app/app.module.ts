
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ElementsComponent } from './elements/elements.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
//import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';
import { ElemlistComponent } from './elemlist/elemlist.component';
import { UpdateComponent } from './update/update.component';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    ElementsComponent,
    HeaderComponent,
    HomeComponent,
    //FormComponent,
    UpdateComponent,
    ElemlistComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
