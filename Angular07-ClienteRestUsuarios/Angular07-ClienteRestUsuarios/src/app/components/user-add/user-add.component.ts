import { Component, OnInit  } from '@angular/core';

//Nuevo
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.scss']
})
export class UserAddComponent implements OnInit {

  //Toda la clase es nueva. Por eso no puedo usar interfaces
  user: User = new User();

  constructor(private router: Router, private userService: UserService) {

  }

  createUser(): void {
    this.userService.createUser(this.user)
      .subscribe(data => {
        alert("Usuario generado de forma correcta.");
      });

  };

  ngOnInit(): void {
  }

}
