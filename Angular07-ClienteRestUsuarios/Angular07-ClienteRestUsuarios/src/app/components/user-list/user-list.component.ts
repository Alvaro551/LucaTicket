import { Component, OnInit } from '@angular/core';

//Nuevo
import { Router } from '@angular/router';

import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  //Todo la clase es nueva
  //Desde Typescript 2.7 es necesario inicializar
  users: User[] = [];

  constructor(private router: Router, private userService: UserService) {

  }

  ngOnInit(): void {
    this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
      });
  };

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe(data => {
        
        this.users = this.users.filter(u => u !== user);
      })
  };

}
