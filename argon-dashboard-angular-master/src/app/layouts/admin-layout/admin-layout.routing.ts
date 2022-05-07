import { ListedomaineComponent } from './../../pages/liste_domaine/listedomaine.component';
import { DomaineComponent } from './../../pages/Domaine/domaine.component';

import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';

import { ListemployeeComponent } from 'src/app/pages/Liste_Employées/listeemployee.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },

{path:'domaine',component:DomaineComponent},

{path:'listeEmp',component:ListemployeeComponent},

{path:'listedom',component:ListedomaineComponent},
 ];
