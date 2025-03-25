import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EquiposComponent } from './pages/equipos/equipos.component';
import { JugadoresComponent } from './pages/jugadores/jugadores.component';
import { TorneosComponent } from './pages/torneos/torneos.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistroComponent } from './pages/registro/registro.component';
import { TorneosDetalleComponent } from './pages/torneos-detalle/torneos-detalle.component';
import { BalonOroComponent } from './pages/balon-oro/balon-oro.component';
import { AuthGuard } from './services/auth-guard.service';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirige automáticamente al Login
  { path: 'login', component: LoginComponent }, 
  { path: 'equipos', component: EquiposComponent, canActivate: [AuthGuard]},
  { path: 'jugadores', component: JugadoresComponent , canActivate: [AuthGuard]},
  { path: 'balonOro', component: BalonOroComponent , canActivate: [AuthGuard]},
  { path: 'torneos', component: TorneosComponent , canActivate: [AuthGuard]},
  { path: 'torneos/:id', component: TorneosDetalleComponent , canActivate: [AuthGuard]},
  { path: 'home', component: HomeComponent },
  { path: 'registro', component: RegistroComponent },
  { path: '**', redirectTo: '/home', pathMatch: 'full' } // Redirige cualquier ruta no encontrada al Home
];

  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
