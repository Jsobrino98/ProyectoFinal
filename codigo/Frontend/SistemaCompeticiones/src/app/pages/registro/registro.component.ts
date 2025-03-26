import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';  // Asegúrate de importar el servicio
import { Observable } from 'rxjs';  // Necesario para usar tipos de RxJS
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  standalone: false,
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  // Variables para almacenar los valores del formulario
  nombreUsuario: string = '';
  contrasena: string = '';
  email: string = '';
  nombreCompleto: string = '';

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
    console.log('Iniciando Registro');
  }

  // Llamada al servicio para registrar un usuario
  onSubmit(): void {
    const usuario = {
      nombreUsuario: this.nombreUsuario,
      contrasena: this.contrasena,
      email: this.email,
      nombreCompleto: this.nombreCompleto
    };
    
    this.apiService.registrarUsuario(usuario).subscribe(
      (response: any) => {
        console.log('Usuario registrado con éxito', response);
        this.router.navigate(['/login']);
      },
      (error: any) => {
        console.error('Error al registrar el usuario', error);
        // Mostrar mensaje de error en UI
        alert('Hubo un error al registrar al usuario. Por favor intente nuevamente.');
      }
    );
  }
}
