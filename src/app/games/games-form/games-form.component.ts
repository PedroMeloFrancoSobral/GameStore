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
            name: [''],
            plataform:[''],
            price:[0]
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

  }
