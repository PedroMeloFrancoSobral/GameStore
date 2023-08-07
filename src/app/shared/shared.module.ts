import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { AppMaterialModule } from './app-material/app-material.module';
import { PlataformPipe } from './pipes/plataform.pipe';



@NgModule({
  declarations: [
    ErrorDialogComponent,
    PlataformPipe
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [
    ErrorDialogComponent,
    PlataformPipe
  ]
})
export class SharedModule { }
