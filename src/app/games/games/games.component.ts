import { Component, OnInit } from '@angular/core';
import { Game } from '../model/game';
import { GamesService } from './games.service';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit {

  games$: Observable<Game[]>;
   displayedColumns = ['_id','name','plataform','price']
   
  constructor(private gamesService: GamesService,
        public dialog: MatDialog){
        this.games$=this.gamesService.list().pipe(
          catchError(error => {
            this.onError('Erro on loading games')
            return of([])
          })
        );
      }
      ngOnInit(): void {

    }
      onError(errorMesage :string) {
        this.dialog.open(ErrorDialogComponent, {
          data: errorMesage
        });
      }
}
