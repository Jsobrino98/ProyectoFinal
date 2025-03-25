import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ApiService {
  private apiUrl = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {}

  iniciarSesion(usuario: string, password: string): Observable<{ token: string }> {
    const datos = { nombreUsuario: usuario, password: password };
    
    return this.httpClient.post<{ token: string }>(`${this.apiUrl}/auth/login`, datos);
  }

  guardarToken(token: string) {
    localStorage.setItem('token', token);
  }

  obtenerToken(): string | null {
    return localStorage.getItem('token');
  }

  cerrarSesion() {
    localStorage.removeItem('token');
  }

  private obtenerHeaders(): HttpHeaders {
    const token = this.obtenerToken();
    console.log(token);
    return new HttpHeaders({
      'Authorization': token ? `Bearer ${token}` : '',
      'Content-Type': 'application/json'
    });
  }

  getEquipos(): Observable<any> {
    const headers = this.obtenerHeaders();
    console.log('Token enviado en la solicitud:', headers.get('Authorization'));
  
    return this.httpClient.get(`${this.apiUrl}/api/equipo`, { headers });
  }
  
  

  getTorneos(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/api/torneo`, { headers: this.obtenerHeaders() });
  }

  getTorneo(id: number): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/api/torneo/${id}`);
  }

  getJugadores(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/api/jugador`, { headers: this.obtenerHeaders() });
  }
  getBalonesOro(): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/api/balon_oro`, { headers: this.obtenerHeaders() });
  }

}
