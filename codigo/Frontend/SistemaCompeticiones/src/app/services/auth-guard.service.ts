import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private auth: ApiService, private router: Router) { }


canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

  // Si el usuario ya esta logueado y quiere acceder al login, lo redirijo a home
  if(this.auth.obtenerToken() && state.url === '/auth/login'){
    this.router.navigate(['home']);
    return false;
  } 
  // Si el usuario no esta logueado y quiere acceder a una ruta protegida, lo redirijo al login
  if (this.auth.obtenerToken()) {
    return true;
  }
    this.router.navigate(['auth/login']);
    return false;

}

}


