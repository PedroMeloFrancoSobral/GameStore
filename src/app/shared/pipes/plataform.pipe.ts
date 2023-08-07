import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'plataform'
})
export class PlataformPipe implements PipeTransform {

   transform(value:string, ...args: unknown[]): string {
        switch(value){
          case 'PS4': return 'eject'
        }
        return 'code';
      }

}
