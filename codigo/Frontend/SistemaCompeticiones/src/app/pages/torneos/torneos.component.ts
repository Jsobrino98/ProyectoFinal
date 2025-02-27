import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-torneos',
  standalone: false,
  templateUrl: './torneos.component.html',
  styleUrl: './torneos.component.css'
})
export class TorneosComponent {
  torneos: any[] = [];

  constructor(private apiService: ApiService, private router:Router) { }

  ngOnInit(): void {
    this.apiService.getTorneos().subscribe(data => {
      this.torneos = data;
    });
  }
  verEquipos(torneo_id: number) {
    this.router.navigate(['/equipos', torneo_id]);
   }

}
