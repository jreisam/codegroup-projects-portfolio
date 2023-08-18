import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from '../model/person';
import { Observable } from 'rxjs';

@Injectable()
export class PersonService {

  
  private personsUrl: string;
  private personsToProjectUrl: string;
  

  constructor(private http: HttpClient) {
    this.personsToProjectUrl = 'http://localhost:8080/message/portfolio/membro';
    this.personsUrl = 'http://localhost:8080/person';
  }

  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personsUrl);
  }

  public save(person: Person) {
    return this.http.post<Person>(this.personsToProjectUrl, person);
  }
}
