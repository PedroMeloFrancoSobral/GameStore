import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GamesRoutingModule } from './games-routing.module';
import { GamesComponent } from './games/games.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from "../shared/shared.module";
import { GamesFormComponent } from './games-form/games-form.component';
import { GamesListComponent } from './games-list/games-list.component';

@NgModule({
    declarations: [
        GamesComponent,
        GamesFormComponent,
        GamesListComponent
    ],
    imports: [
        CommonModule,
        GamesRoutingModule,
        AppMaterialModule,
        SharedModule,
        ReactiveFormsModule
    ]
})
export class GamesModule { }
