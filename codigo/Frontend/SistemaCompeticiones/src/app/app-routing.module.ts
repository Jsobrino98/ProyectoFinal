import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EquiposComponent } from './pages/equipos/equipos.component';


  const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'equipos', component: EquiposComponent },
    // Otras rutas...
  ];
  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
