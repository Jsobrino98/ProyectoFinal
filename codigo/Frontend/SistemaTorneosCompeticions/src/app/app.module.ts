import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';  // Asegúrate de importar el módulo de enrutamiento
import { AppComponent } from './app.component';



@NgModule({
  declarations: [
    AppComponent // Declara tu componente principal
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  // Asegúrate de que AppRoutingModule esté importado
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]  // Especifica el componente de inicio
})
export class AppModule { }