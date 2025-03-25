import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  nombreUsuario: string = '';
  password: string = '';
  errorMessage: string | null = null; 
 

  constructor(private apiService: ApiService, private router: Router) {}

  // Método para iniciar sesión
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
        this.router.navigate(['/home']);  // Redirige al home si el login es exitoso
      },
      error: (error) => {
        console.error('Error en login:', error);
        this.errorMessage = 'Error en inicio de sesión. Usuario o contraseña incorrecto.';
      }
    });
  }
}