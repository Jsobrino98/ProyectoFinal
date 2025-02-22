import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api';  

  constructor(private httpClient: HttpClient) {}
  
  getEquipos(): Observable<any> {
    // Obtener el token almacenado en el almacenamiento local
    const token = localStorage.getItem('token');

    // Configurar el encabezado de autorización
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + token);

    // Realizar la solicitud GET con los encabezados
    return this.httpClient.get(this.apiUrl, { headers });
  }



  
getTorneos(): Observable<any> {
  return this.httpClient.get(`${this.apiUrl}/torneos`);
}
}
