import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GamesService } from '../games/games.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { Game } from '../model/game';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-games-form',
  templateUrl: './games-form.component.html',
  styleUrls: ['./games-form.component.scss']
})
export class GamesFormComponent implements OnInit {

     form :FormGroup;
    constructor(private formBuilder: FormBuilder,
        private service: GamesService,
        private snackBar: MatSnackBar,
        private location: Location,
        private route:ActivatedRoute){
         this.form = this.formBuilder.group({
            _id:[''],
            name: ['',[Validators.required,
              Validators.minLength(5),
              Validators.maxLength(100)]],
            plataform:['',[Validators.required]],
            price:[0,[Validators.required,Validators.min(1)]]
          });
    }

      ngOnInit(): void {
          const game: Game = this.route.snapshot.data['game'];
          this.form.setValue({
            _id:game._id,
            name: game.name,
            plataform: game.plataform,
            price:game.price
          })
        }

  onSubmit(){
    if(this.form.valid){
      this.service.save(this.form.value)
      .subscribe({next: (result) => {this.onSuccess();},error: () => {this.OnError();}});
    }else {
      alert("formulario invalido");
    }

  }
    onCancel(){
      this.location.back();
    }
    private onSuccess(){
      this.snackBar.open("Game salvo com sucesso! ",'', {duration:5000});
      this.location.back();
    }
      private OnError(){
          this.snackBar.open("Erro ao salvar game! ",'', {duration:5000});
        }
      public getErrorMessage(fieldName:string){
            const field = this.form.get(fieldName);
            if(field?.hasError('required')){
              return 'Campo obrigatório'
            }

            if(field?.hasError('minlength')){
              const requiredLength= field.errors? field.errors['minlength']['requiredLength']: 5
              return `Minimo de ${requiredLength} caracteres`;
            }

            if(field?.hasError('min')){
              const requiredMin= field.errors? field.errors['min'] ['min']: 1
              return `Minimo de valor tem que ser ${requiredMin}`;
            }
            return 'Campo invalido'
          }


  }
