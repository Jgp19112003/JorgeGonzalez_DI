import { Component } from '@angular/core';

@Component({
  selector: 'miapp-directivaswitch',
  templateUrl: './directivaswitch.component.html',
  styleUrls: ['./directivaswitch.component.css']
})
export class DirectivaswitchComponent {
  opcion = 1

  capturaEvento(evento: any){
    this.opcion = evento.target.value;
  }
}
