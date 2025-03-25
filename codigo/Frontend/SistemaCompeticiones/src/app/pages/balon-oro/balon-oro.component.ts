import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';

declare var bootstrap: any; // Permite usar Bootstrap en Angular

@Component({
  selector: 'app-balon-oro',
  standalone: false,
  templateUrl: './balon-oro.component.html',
  styleUrls: ['./balon-oro.component.css']
})
export class BalonOroComponent implements OnInit {
  balonOro: any[] = [];
  currentSlide = 0;

  constructor(private jugadoresService: ApiService) {}

  ngOnInit(): void {
    this.jugadoresService.getBalonesOro().subscribe(data => {
      this.balonOro = data;
      console.log(data);
    });
  }

  ngAfterViewInit(): void {
    const carouselElement = document.getElementById('carouselExampleIndicators');

    if (carouselElement) {
      const carousel = new bootstrap.Carousel(carouselElement, {
        interval: false // Desactivar el autoplay
      });

      // Escuchar el evento cuando el carrusel cambie de slide
      carouselElement.addEventListener('slid.bs.carousel', (event: any) => {
        this.currentSlide = event.to; // Actualizar el índice activo
      });
    }
  }

  moverCarrusel(index: number, event: Event) {
    event.preventDefault(); // Evita el scroll al hacer clic

    const carouselElement = document.getElementById('carouselExampleIndicators');
    if (carouselElement) {
      const carousel = new bootstrap.Carousel(carouselElement);
      carousel.to(index); // Mueve el carrusel al slide seleccionado
    }
  }
}
