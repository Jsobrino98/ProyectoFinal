import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {


  constructor(private api: ApiService) { }


  ngOnInit(): void {
    console.log('Iniciando login');
  }
  
  iniciarSesion(nomeUsuario: string, password: string) {
    console.log(this.api.iniciarSesion(nomeUsuario, password))

 }
 
  

}
