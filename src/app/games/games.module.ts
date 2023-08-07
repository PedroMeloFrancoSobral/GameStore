import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GamesRoutingModule } from './games-routing.module';
import { GamesComponent } from './games/games.component';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from "../shared/shared.module";

@NgModule({
    declarations: [
        GamesComponent
    ],
    imports: [
        CommonModule,
        GamesRoutingModule,
        AppMaterialModule,
        SharedModule
    ]
})
export class GamesModule { }
