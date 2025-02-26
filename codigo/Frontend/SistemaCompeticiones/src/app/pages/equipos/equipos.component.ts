import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-equipos',
  standalone: false,
  templateUrl: './equipos.component.html',
  styleUrl: './equipos.component.css'
})
export class EquiposComponent {
  equipos: any[] = [];

  constructor(private equiposService: ApiService) {}

  ngOnInit(): void {
    this.equiposService.getEquipos().subscribe(data => {this.equipos = data; console.log(data)});
    console.log("traballando en equipos");
  }
}
