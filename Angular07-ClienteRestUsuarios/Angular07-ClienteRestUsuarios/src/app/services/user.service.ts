import { Injectable } from '@angular/core';

//Nuevo
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';

//Nuevo
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //Todo lo de la clase es nuevo
  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8081/user-portal/users';

  //returns an Observable of User[]
  public getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  //http://localhost:8080/user-portal/users/5
  public deleteUser(user:User) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user:User) {
    return this.http.post<User>(this.userUrl, user);
  }
}
