import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JugadoresService {


  // Método para obtener todos los jugadores
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
  guardarToken(token: string) {
    localStorage.setItem('token', token);
    this.authStatusSubject.next(true);  // Actualiza el estado de autenticación a 'true'
  }

  obtenerToken(): string | null {
    return localStorage.getItem('token');
  }
  private obtenerHeaders(): HttpHeaders {
    const token = this.obtenerToken();
    return new HttpHeaders({
      'Authorization': token ? `Bearer ${token}` : '',
      'Content-Type': 'application/json'
    });
  }
  getJugadores(): Observable<any> {
    const headers = this.obtenerHeaders();
    console.log("Headers enviados: ", headers); // Verifica que el token esté presente
    return this.httpClient.get(`${this.apiUrl}/api/jugador`, { headers });
  }
  
}
