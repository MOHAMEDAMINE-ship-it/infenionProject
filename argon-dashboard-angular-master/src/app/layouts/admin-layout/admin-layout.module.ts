

import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ClipboardModule } from 'ngx-clipboard';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../pages/dashboard/dashboard.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ListemployeeComponent } from '../../pages/Liste_Employées/listeemployee.component';

import { DomaineComponent } from 'src/app/pages/Domaine/domaine.component';
import { ListedomaineComponent } from '../../pages/liste_domaine/listedomaine.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FilterPipe } from './search.pipe';
import { QRCodeModule } from 'angular2-qrcode';
import { NgxQRCodeModule } from '@techiediaries/ngx-qrcode';

// import { ToastrModule } from 'ngx-toastr';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
    ClipboardModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    QRCodeModule,
    NgxQRCodeModule,
  ],
  declarations: [
    DashboardComponent,
  
    ListedomaineComponent,
    ListemployeeComponent,
    FilterPipe,

    DomaineComponent,
    
  ]
})

export class AdminLayoutModule {}
