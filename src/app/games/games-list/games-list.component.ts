import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Game } from '../model/game';

@Component({
  selector: 'app-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.scss']
})
export class GamesListComponent implements OnInit {

  @Input() games: Game[] = [];

  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() delete = new EventEmitter(false);

  readonly displayedColumns = ['_id','name','plataform','price','actions'];

  constructor (private router:Router,private route: ActivatedRoute) {};

  ngOnInit(): void {

  }
  onEdit(game: Game){
    this.edit.emit(game);
  }
  onAdd(){
    this.add.emit(true);
  }
  onDelete(game: Game){
    this.delete.emit(game);
  }
}
