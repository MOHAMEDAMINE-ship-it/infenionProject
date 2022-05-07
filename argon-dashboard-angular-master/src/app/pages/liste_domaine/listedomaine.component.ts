import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfilServiceService } from 'src/app/SERVICE/profil-service.service';

@Component({
  selector: 'app-listdomaine',
  templateUrl: './listedomaine.component.html',
  styleUrls: ['./listedomaine.component.scss']
})
export class ListedomaineComponent implements OnInit {
  domaine :any=[];
  constructor(private router:Router,private profilservice:ProfilServiceService) { }

  ngOnInit() {
    this.affiche();

  }
affiche(){
    this.profilservice.getAll().subscribe(data=>{
      console.log(data);
      this.domaine=data;
   },error=> console.log (error));

  }
 delete(id){
   this.profilservice.Delete(id).subscribe(data=>{
    console.log(data);
    this.affiche();
   },error=> console.log (error));
  }

GoToList(){
   this.router.navigate(['domaine']);
 }

 print(imprimer){
  var printContents = document.getElementById(imprimer).innerHTML;    
 var originalContents = document.body.innerHTML;      
 document.body.innerHTML = printContents;     
 window.print();     
 document.body.innerHTML = originalContents;
 }

}

