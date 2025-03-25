import { Component, OnInit, OnDestroy } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  isAuthenticated: boolean = false;
  private authStatusSubscription: Subscription | null = null;  // Inicializado en null

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit() {
    // Suscribirse al estado de autenticación
    this.authStatusSubscription = this.apiService.authStatus.subscribe((status: boolean) => {
      this.isAuthenticated = status;  // Actualiza el estado de autenticación
    });
  }

  ngOnDestroy() {
    // Cancelar la suscripción cuando el componente se destruya
    if (this.authStatusSubscription) {
      this.authStatusSubscription.unsubscribe();
    }
  }

  cerrarSesion() {
    this.apiService.cerrarSesion();  // Elimina el token del almacenamiento local
    this.router.navigate(['/login']);  // Redirige a la página de login
  }
}
