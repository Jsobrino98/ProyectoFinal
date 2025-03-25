import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';  // Asegúrate de importar tu ApiService

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private apiService: ApiService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    
    // Si el token no está presente en el localStorage, redirige al login
    if (!this.apiService.obtenerToken()) {
      this.router.navigate(['/login']);  // Redirige a login si no hay token
      return false;
    }

    // Si hay token, permite el acceso
    return true;
  }
}
