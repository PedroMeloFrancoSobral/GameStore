import { Component, OnInit } from '@angular/core';
import { Game } from '../model/game';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit {

   games: Game[] = [{_id:'1',name:'Lord of the rings',plataform: 'PS4',price: 50.00}];
    displayedColumns = ['_id','name','plataform','price']

  constructor(){ }
  ngOnInit(): void {

  }
}
