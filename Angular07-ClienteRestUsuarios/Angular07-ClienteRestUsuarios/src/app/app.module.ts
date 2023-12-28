import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserAddComponent } from './components/user-add/user-add.component';
import { UserListComponent } from './components/user-list/user-list.component';

//Nuevo
import { UserService } from './services/user.service';
// Before you can use HttpClient, you need to import the Angular HttpClientModule. 
// Most apps do so in the root AppModule.
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UserAddComponent,
    UserListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

   //Nuevo
   HttpClientModule,
   FormsModule      
  ],
  //Incluyo el servicio
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
