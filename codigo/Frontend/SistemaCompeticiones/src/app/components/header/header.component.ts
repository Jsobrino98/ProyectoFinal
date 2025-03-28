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
  username: string | null = null;
  private authStatusSubscription: Subscription | null = null;

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit() {
    this.authStatusSubscription = this.apiService.authStatus.subscribe((status: boolean) => {
      this.isAuthenticated = status;
      if (this.isAuthenticated) {
        this.username = this.apiService.obtenerUsername();  // Obtener el nombre de usuario del servicio
      }
    });
  }

  ngOnDestroy() {
    if (this.authStatusSubscription) {
      this.authStatusSubscription.unsubscribe();
    }
  }

  cerrarSesion() {
    this.apiService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}
