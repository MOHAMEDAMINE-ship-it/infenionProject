import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProfilServiceService } from '../SERVICE/profil-service.service';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css',
 './reservation.component.scss',]
})
export class ReservationComponent implements OnInit {
  @ViewChild('send') send: NgForm;
  nom : any
  domainForm:FormGroup;
  submitted = false;
  

  
  // public menuItems: any[];
  // public isCollapsed = true;
domaine:any=[];
  constructor(public formBuilder:FormBuilder,private profilservice:ProfilServiceService) { }

  ngOnInit() {
    this.domainForm = this.formBuilder.group({
      nom:['', [Validators.required, Validators.minLength(4)]],
      prenom:['', [Validators.required, Validators.minLength(4)]],
      cin:['', [Validators.required, Validators.minLength(4)]],
      age:['', [Validators.required, Validators.minLength(4)]],
      domaine:['', [Validators.required, Validators.minLength(4)]],
     })
 this.affiche();
  }
  affiche(){
    this.profilservice.getAll().subscribe(data=>{
      console.log(data);
      this.domaine=data;
   },error=> console.log (error));
  }

  get getControl(){
    return this.domainForm.controls;
  }
 onSubmit(){


     this.addEmployee();

 }
  addEmployee(){
    console.log("this.domainForm.value");
    console.log(this.domainForm.value);

    this.profilservice.createProfil(this.domainForm.value).subscribe(data=>{
      console.log(data);
   },error=>console.log(error));
  }
  

}
