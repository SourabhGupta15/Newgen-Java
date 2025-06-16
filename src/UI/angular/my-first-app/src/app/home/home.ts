import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  headline = 'message from Home';   //Normal Variable
  signalMessage = signal('Signal Message from HomeComponent');    //Signal Variable

  message = signal('Another Message');
  changeMessage() {
    console.log("changeMessage called");
    this.message.update(() => 'You clicked the button');
  }
}
