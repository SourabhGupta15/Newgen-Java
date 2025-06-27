import { Component, Input, signal } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  headline = 'message from Home';   //Normal Variable
  signalMessage = signal('Signal Message from HomeComponent');    //Signal Variable

  anotherMessage = signal('Another Message');
  changeMessage() {
    console.log("changeMessage called");
    this.anotherMessage.update(() => 'You clicked the button');
  }

  @Input() message: string = 'Hello from child Home component';
}
