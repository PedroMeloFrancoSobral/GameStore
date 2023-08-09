import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GamesComponent } from './games/games.component';
import { GamesFormComponent } from './games-form/games-form.component';
import { gameResolver } from './guards/game.resolver';

const routes: Routes = [
    {path: '', component: GamesComponent},
    {path: 'new', component: GamesFormComponent, resolve: {game: gameResolver}},
    {path: 'edit/:id', component: GamesFormComponent, resolve: {game: gameResolver}}
  ];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GamesRoutingModule { }
