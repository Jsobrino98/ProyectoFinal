import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro',
  standalone: false,
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent implements OnInit {

  ngOnInit(): void {
    console.log('Iniciando Registro');
  }
  onSubmit(): void {
    console.log('Registrando...');
  }

}
