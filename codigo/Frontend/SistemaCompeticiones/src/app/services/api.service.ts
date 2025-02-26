import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class ApiService {
  private apiUrl = 'http://localhost:8080';  
  private token: string = '';
  private headers = new HttpHeaders ({'Authorization': 'Bearer ' + this.token});


  constructor(private httpClient: HttpClient) {}
  
  iniciarSesion(usuario: string, password: string): string {

    // "nombreUsuario": "jsobrino",
    // "password": "abc123."

    // "jsobrino",
    // "abc123."

    const datos = { "nombreUsuario": usuario,"password": password };
    this.httpClient.post<{ token: string }>(`${this.apiUrl}/auth/login`, datos).subscribe(data => {
      this.token = data.token;
    });
    return 'login Exitoso!!';
  }

  obtenerToken(): String | null {
    return this.token;
  }

  cerrarSesion() {
    this.token = '';
  }

  registroUsuario(usuario: string, password: string, email: string, nombreCompleto?: string): String {

    const datos = {  "nombreUsuario": usuario,"password": password, "email": email, "nombreCompleto": nombreCompleto };

    this.httpClient.post<string>(`${this.apiUrl}/auth/register`, datos).subscribe(data => {
      console.log(data);
    });

    return "Registro Exitoso!!";

  }



  
  getEquipos(): Observable<any> {
    
    return this.httpClient.get(`${this.apiUrl}/api/equipos`, {headers: this.headers});
  }

  getTorneos(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/api/torneos`, {headers: this.headers});
  }


}
