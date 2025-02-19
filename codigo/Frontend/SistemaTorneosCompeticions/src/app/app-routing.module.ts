import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component'; // Importa tu componente principal (puedes cambiarlo por otro componente si es necesario)

const routes: Routes = [
  { path: '', component: AppComponent },  // Puedes agregar más rutas aquí
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Configura las rutas
  exports: [RouterModule]  // Exporta el RouterModule para que se pueda usar en otros módulos
})
export class AppRoutingModule { }
