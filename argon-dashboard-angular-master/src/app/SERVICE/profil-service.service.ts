import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Domaines } from '../Constructor/Domaines';
import { Profils } from '../Constructor/Profils';

@Injectable({
  providedIn: 'root'
})
export class ProfilServiceService {
  urlapi:"http://localhost:8081/add-Domaine";
  urlapii="http://localhost:8081//retrieve-all-Domaine";
  baseUrl="http://localhost:8081/remove-domaine/";
  baseUrll="http://localhost:8081/profil/remove-profil";
  constructor(private http:HttpClient) { }


  create(domaine:Domaines):Observable<object>{
    console.log(domaine);
    return this.http.post("http://localhost:8081/add-Domaine",domaine);
  }
  getAll(): Observable<any> {
    return this.http.get("http://localhost:8081/retrieve-all-Domaine");
  }
  Delete(id): Observable<any> {
    console.log(id);
    return this.http.delete(`${this.baseUrl}/${id}`,{ responseType: 'text' });

  }
  getAllProfil(): Observable<any> {
    return this.http.get("http://localhost:8081/profil/retrieve-all-profil");
  }
  
  
  Deleteprofil(id): Observable<any> {
    console.log(id);
    return this.http.delete(`${this.baseUrll}/${id}`,{ responseType: 'text' });

  }
  createProfil(profil : Profils ):Observable<object>{
    console.log(profil);
    return this.http.post("http://localhost:8081/profil/add-profil/1",profil);
  }
}
