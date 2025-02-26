import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  standalone: false,
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  nombreUsuario: string = '';
  password: string = '';

  constructor(private apiService: ApiService) {}

  iniciarSesion() {
    if (!this.nombreUsuario || !this.password) {
      alert('Por favor, completa todos los campos.');
      return;
    }

    this.apiService.iniciarSesion(this.nombreUsuario, this.password).subscribe({
      next: (response) => {
        console.log('Token recibido:', response.token);
        this.apiService.guardarToken(response.token);
        alert('¡Inicio de sesión exitoso!');
      },
      error: (error) => {
        console.error('Error en login:', error);
        alert('Error en inicio de sesión. Verifica tus credenciales.');
      }
    });
  }
}
