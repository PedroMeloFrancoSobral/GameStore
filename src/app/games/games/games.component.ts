import { Component, OnInit } from '@angular/core';
import { Game } from '../model/game';
import { GamesService } from './games.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit {

  games$: Observable<Game[]>;
   displayedColumns = ['_id','name','plataform','price']

  constructor (private gamesService: GamesService){
      this.games$=this.gamesService.list();
    }
  ngOnInit(): void {

  }
}
