import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//Incluyo mis dos componentes
import { UserListComponent } from './components/user-list/user-list.component';
import { UserAddComponent } from './components/user-add/user-add.component';

//Construyo las rutas
const routes: Routes = [
  { 
    path: 'users', 
    component: UserListComponent 
  },
  { 
    path: 'add', 
    component: UserAddComponent 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
