import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElemlistComponent } from './elemlist.component';

describe('ElemlistComponent', () => {
  let component: ElemlistComponent;
  let fixture: ComponentFixture<ElemlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElemlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElemlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
