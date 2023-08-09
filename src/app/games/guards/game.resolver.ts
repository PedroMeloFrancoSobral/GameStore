import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from '@angular/router';
import { GamesService } from '../games/games.service';
import { inject } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Game } from '../model/game';

export function gameResolver(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Game> {
    if (route.params && route.params['id']) {
      return inject(GamesService).loadById(route.params['id']);
    }
    return of({_id: '', name: '', plataform:'',price: 0});
  }
