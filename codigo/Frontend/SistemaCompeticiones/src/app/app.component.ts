import { Component } from '@angular/core';
import { ApiService } from './services/api.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'SistemaCompeticiones';

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit() {
    const token = this.apiService.obtenerToken();
    if (!token) {
      this.router.navigate(['/login']);  // Redirige al login si no hay token
    }
  }
  
}
