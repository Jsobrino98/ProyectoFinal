import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080';
  private authStatusSubject = new BehaviorSubject<boolean>(false);  // Estado de autenticación
  authStatus = this.authStatusSubject.asObservable();  // Observable público

  constructor(private httpClient: HttpClient) {
    this.checkAuthStatus();  // Verificar si el token existe al iniciar el servicio
  }

  // Verifica si hay un token en localStorage y actualiza el estado de autenticación
  private checkAuthStatus() {
    const token = this.obtenerToken();
    this.authStatusSubject.next(!!token);  // Cambia el estado de autenticación dependiendo del token
  }

  iniciarSesion(usuario: string, password: string): Observable<{ token: string }> {
    const datos = { nombreUsuario: usuario, password: password };
    return this.httpClient.post<{ token: string }>(`${this.apiUrl}/auth/login`, datos);
  }

  guardarToken(token: string) {
    localStorage.setItem('token', token);
    this.authStatusSubject.next(true);  // Actualiza el estado de autenticación a 'true'
  }

  obtenerToken(): string | null {
    return localStorage.getItem('token');
  }

  cerrarSesion() {
    localStorage.removeItem('token');
    this.authStatusSubject.next(false);  // Actualiza el estado de autenticación a 'false'
  }

  private obtenerHeaders(): HttpHeaders {
    const token = this.obtenerToken();
    return new HttpHeaders({
      'Authorization': token ? `Bearer ${token}` : '',
      'Content-Type': 'application/json'
    });
  }

  // Métodos para obtener datos de la API (equipos, torneos, etc.)
  getEquipos(): Observable<any> {
    const headers = this.obtenerHeaders();
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
