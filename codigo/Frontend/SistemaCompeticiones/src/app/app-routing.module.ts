import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EquiposComponent } from './pages/equipos/equipos.component';
import { JugadoresComponent } from './pages/jugadores/jugadores.component';
import { TorneosComponent } from './pages/torneos/torneos.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { TorneosDetalleComponent } from './pages/torneos-detalle/torneos-detalle.component';


  const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'equipos', component: EquiposComponent },
    { path: 'jugadores', component: JugadoresComponent },
    { path: 'torneos', component: TorneosComponent },
    { path: 'torneos/:id', component: TorneosDetalleComponent },
    { path: 'login', component: LoginComponent },
    { path: 'registro', component: RegistroComponent },
  ];
  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
