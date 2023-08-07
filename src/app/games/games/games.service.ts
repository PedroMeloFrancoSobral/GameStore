import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Game } from '../model/game';
import { delay, take, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GamesService {

  private readonly API = '/assets/gsames.json';

    constructor(private httpClient: HttpClient) { }

    list(){
        return this.httpClient.get<Game[]>(this.API)
        .pipe(
          take(1),
          delay(1000),
          tap(games => console.log(games))
        );
       }
}
