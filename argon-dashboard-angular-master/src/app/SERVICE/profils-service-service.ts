import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfilServiceService {
  urlapi = 'http://localhost:8081/profil/retrieve-all-profil';
  baseUrl = 'http://localhost:8081/profil/remove-profil/';
  constructor(private http: HttpClient) { }



  getAll(): Observable<any> {
    return this.http.get('http://localhost:8081/profil/retrieve-all-profil');
  }
  Delete(id): Observable<any> {
    console.log(id);
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });

  }
}
