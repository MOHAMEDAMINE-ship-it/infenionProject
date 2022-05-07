import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


import { Domaines } from 'src/app/Constructor/Domaines';
import { ProfilServiceService } from 'src/app/SERVICE/profil-service.service';

@Component({
  selector: 'app-domaine',
  templateUrl: './domaine.component.html',
  styleUrls: ['./domaine.component.scss']
})
export class DomaineComponent implements OnInit {
  domaine :Domaines=new Domaines()
  domainForm:FormGroup;
  constructor(public formBuilder:FormBuilder,private router:Router,private profilservice:ProfilServiceService) { }

  ngOnInit() {
     this.domainForm = this.formBuilder.group({
      nom:['', [Validators.required, Validators.minLength(4)]],

     })
  }
   get getControl(){
     return this.domainForm.controls;
   }
  onSubmit(){


      this.save();

  }
   save() {
     console.log(this.domainForm.value);

    this.profilservice.create(this.domainForm.value).subscribe(data=>{
      this.router.navigate(['listedom']);
      console.log(data);
   },error=>console.log(error));
}
  GoToListe(){
     this.router.navigate(['listedom']);
  }
}
 