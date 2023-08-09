import { Component, OnInit } from '@angular/core';
import { Game } from '../model/game';
import { GamesService } from './games.service';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.scss'],
})
export class GamesComponent implements OnInit {
  games$: Observable<Game[]>;
  displayedColumns = ['_id', 'name', 'plataform', 'price', 'actions'];

  constructor(
    private gamesService: GamesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
    this.games$ = this.gamesService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar games');
        return of([]);
      })
    );
    this.refresh();
  }

  ngOnInit(): void {}

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }
  onEdit(game: Game) {
    this.router.navigate(['edit', game._id], { relativeTo: this.route });
  }
  onDelete(game: Game) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'tem certeza que quer deletar esse game? ',
    });

    dialogRef.afterClosed().subscribe({
      next: (result: boolean) => {
        if (result) {
          this.gamesService.delete(game._id).subscribe({
            next: () => {
              this.refresh();
              this.snackBar.open('Game removido com sucesso! ', 'X', {
                duration: 5000,
                verticalPosition: 'top',
                horizontalPosition: 'center',
              });
            },
            error: () => this.onError('Erro ao tentar remover game'),
          });
        }
      },
    });
  }

  refresh() {
    this.games$ = this.gamesService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar games');
        return of([]);
      })
    );
  }

  onError(errorMesage: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMesage,
    });
  }
}
