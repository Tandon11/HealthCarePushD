import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoodService {

  constructor(private http: HttpClient) { }

  moodUrl = 'http://localhost:8080';

  storeMood(mood: Number) : Observable<string>
  {
    // return this.http.post<any>(`${this.moodUrl}/token`,mood);
    console.log("mood is " + mood)
    let token = localStorage.getItem("token");
    let pat_id = localStorage.getItem("id");
    let temp = "";
    let header = new HttpHeaders(
      {
      Authorization : "Bearer " + token
      }
    )
    const options = {responseType :  'text'}
    // {headers: header}
    return this.http.post<string>(`${this.moodUrl}/patient/mood/${mood}/${pat_id}`,{responseType : 'text'});
  }
}
