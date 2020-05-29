import { Injectable, APP_INITIALIZER } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class UserService
{
    private url = "http://localhost:8080/registered"


    constructor(private http: HttpClient){ }

    getUser(username:String): Observable<User>{
        let request = this.url + "/get/" + username;
        return this.http.get<User>(request);
    }

    addUser(registered: User):Observable<User>
    {
        console.log("Adding...")
        return this.http.post<User>(this.url + "/add",registered);
    }

    getCurrentUsername():string
    {
        return localStorage.getItem("username");
    }
}
