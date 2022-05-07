import { ProfilServiceService } from './../../SERVICE/profil-service.service';
import { Component, OnInit, Pipe } from '@angular/core';
import { NgxQrcodeElementTypes, NgxQrcodeErrorCorrectionLevels } from '@techiediaries/ngx-qrcode';
import { Router } from '@angular/router';
import Chart from 'chart.js';
 

import { async } from 'rxjs';
import { chartOptions, parseOptions } from '../../variables/charts';




@Component({
  selector: 'app-listeemployee',
  templateUrl: './listeemployee.component.html',
  styleUrls: ['./listeemployee.component.scss']
})


export class ListemployeeComponent implements OnInit {
  input2='';
  elementType = NgxQrcodeElementTypes.URL;
  correctionLevel = NgxQrcodeErrorCorrectionLevels.HIGH;
  value = 'https://www.techiediaries.com/';
  nbAge20 = 0
  nbAge30 = 0
  nbAge10 = 0
  nbAge40 = 0
  nbAge50 = 0
  nbAge60 = 0
  test  : any
  profil :any=[];
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  chart: any;

  public response;
  constructor(private profilservice:ProfilServiceService,private router:Router,) { }
   async ngOnInit() {
    this.response = await this.affiche();

   var  chartOrders = document.getElementById('chart-orders');

     parseOptions(Chart, chartOptions());
     
     console.log("1111111111111111");
     console.log( this.nbAge20);
     var ordersChart = new Chart(chartOrders, {
       type: 'bar',
       options: this.chartExample2.options,
       data: this.chartExample2.data
     });
     console.log("33333333");
     console.log( this.nbAge20);
  }


  

  
  async affiche(){
    this.profilservice.getAllProfil().subscribe(async data=>{
       
      
       this.base64Data = data[0].image.dataValue;
       this.retrievedImage = 'data:image/jpg;base64,' + this.base64Data;
       console.log(this.retrievedImage );
       this.profil=data;
       console.log(data)
       this.nbAge20 = await data.filter(age => age>20 && age<30 )
     
    },error=> console.log (error));

  }
  chartExample2 = {
    options: {
      scales: {
        yAxes: [
          {
            ticks: {
              callback: function(value) {
                if (!(value % 10)) {
                  //return '$' + value + 'k'
                  return value;
                }
              }
            }
          }
        ]
      },
      tooltips: {
        callbacks: {
          label: function(item, data) {
            var label = data.datasets[item.datasetIndex].label || "";
            var yLabel = item.yLabel;
            var content = "";
            if (data.datasets.length > 1) {
              content += label;
            }
            content += yLabel;
            return content;
          }
        }
      }
    },
  

    data: {
      labels: ["10ans", "20ans", "30ans", "40ans", "50ans", "60ans"],
      datasets: [
        {
          label: "Sales",
          data: [15,5, 30, 22, 10, 10],
          maxBarThickness: 100
        }
      ]
    }
    
  }
  
 delete(id){
   console.log("adaammm")
   console.
   log(id)
  this.profilservice.Deleteprofil(id).subscribe(data=>{
   console.log(data);
    this.affiche();
   })


  
 }

 GoToList(){
  this.router.navigate(['reservation']);
}

rechercher(){
  this.profilservice.getAllProfil().subscribe(data=>{
   
  
 },error=> console.log (error));
}


//  rechcategorie(){

//   if(!this.libelle){
//     this.toastr.warning('Champ recherche vide !!');
//     this.refresh();
//   }

// else{
//   //kan el libelle categorie fareg  en9oulou 
//   this.service.recherchecategorie(this.libelle).subscribe(data => {
//     console.log("recherche : "+this.libelle);
//     this.categorie=[];
//     this.categorie=(data);
//     console.log(data);
// var responserecherche = data[0].respo;

// if(responserecherche === "erreurcategorie"){
//   this.toastr.error('Catégorie ['+this.libelle+'] introuvable');

//   this.refresh();
//   console.log("retour liste");
// }
// this.libelle="";

//   }, error => console.log(error));
// }
}


