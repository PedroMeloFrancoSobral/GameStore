import { Component, OnInit } from '@angular/core';
import { Game } from '../model/game';
import { GamesService } from './games.service';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss']
})
export class GamesComponent implements OnInit {

  games$: Observable<Game[]>;
   displayedColumns = ['_id','name','plataform','price','actions']
   
    constructor(private gamesService: GamesService,
        public dialog: MatDialog,
        private router:Router,
        private route: ActivatedRoute){
        this.games$=this.gamesService.list().pipe(
          catchError(error => {
            this.onError('Erro ao carregar games')
            return of([])
          })
        );
      }
      ngOnInit(): void {

    }

    onAdd(){
      this.router.navigate(['new'], { relativeTo: this.route})
    }
    onEdit(game:Game){
      this.router.navigate(['edit',game._id], { relativeTo: this.route})
    }
    
      onError(errorMesage :string) {
        this.dialog.open(ErrorDialogComponent, {
          data: errorMesage
        });
      }
}
