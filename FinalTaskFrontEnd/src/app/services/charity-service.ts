import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Charity } from '../models/Charity'
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class CharityService{

    static charities: Charity[] = [];
    static idCounter:number = 10;
    private url:string = "http://localhost:8080/charity";
    constructor(private http:HttpClient) {
        this.init();
    }

    init():void{
    }

    getAll(): Observable<Charity[]>
    {
        return this.http.get<Charity[]>("http://localhost:8080/charity/all");
    }

    getCharity(title: String): Observable<Charity>
    {
        return this.http.get<Charity>(this.url+"/get/"+title);
    }

    createCharity(charity:Charity): Observable<Charity>{
        return this.http.put<Charity>("http://localhost:8080/charity/create",charity);
    }

    searchCharity(key:string): Observable<Charity[]>{
        return this.http.get<Charity[]>(this.url + "/search/" + key);
    }

    donate(amount:number, id:number): Observable<Charity> {
        return this.http.post<Charity>("http://localhost:8080/donation/" + localStorage.getItem("username") + "/"+ 
        id + "/"+amount,Charity);
    }

    volunteer(id:number){
        return this.http.post<Charity>("http://localhost:8080/participate/" + localStorage.getItem("username")
                                        + "/" + id, Charity);
    }

    delete(id:number):Observable<Charity>{
       return this.http.delete<Charity>(this.url + "/delete/" + id);
    }



}