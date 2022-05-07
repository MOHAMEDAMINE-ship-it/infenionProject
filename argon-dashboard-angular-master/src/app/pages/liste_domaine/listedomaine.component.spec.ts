import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {ListedomaineComponent } from './listedomaine.component';

describe('ListedomaineComponent', () => {
  let component: ListedomaineComponent;
  let fixture: ComponentFixture<ListedomaineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListedomaineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListedomaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
