import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from '../model/game';

@Component({
  selector: 'app-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.scss']
})
export class GamesListComponent implements OnInit {

  @Input()
  games: Game[] = [];
  @Output()
  add = new EventEmitter(false);
  readonly displayedColumns = ['_id','name','plataform','price','actions'];

  constructor (private router:Router,private route: ActivatedRoute) {};

  ngOnInit(): void {

  }

  onAdd(){
    this.add.emit(true);
  }
}
