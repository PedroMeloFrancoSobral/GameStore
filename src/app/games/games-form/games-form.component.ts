import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { GamesService } from '../games/games.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-games-form',
  templateUrl: './games-form.component.html',
  styleUrls: ['./games-form.component.scss']
})
export class GamesFormComponent implements OnInit {

   form!: FormGroup;
   constructor(private formBuilder: FormBuilder,
        private service: GamesService,
        private snackBar: MatSnackBar){
    }
  ngOnInit(): void {
  }
      onSubmit(){
        this.service.save(this.form.value)
        .subscribe(
         {
          next: (result) => {
            console.log(result)
          },
          error: () => {
          this.OnError();
    }
         }
        );
      }
      onCancel(){
      }
      private OnError(){
          this.snackBar.open("Erro ao salvar game! ",'', {duration:5000});
        }

  }
