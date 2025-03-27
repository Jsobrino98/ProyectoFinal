import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-torneos',
  standalone: false,
  templateUrl: './torneos.component.html',
  styleUrls: ['./torneos.component.css']
})
export class TorneosComponent implements OnInit {
  torneos: any[] = [];

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
    this.apiService.getTorneos().subscribe(data => {
      this.torneos = data;
    });
  }

  verEquipos(torneoId: number) {
    this.router.navigate(['/equipos', torneoId]);
  }
}
