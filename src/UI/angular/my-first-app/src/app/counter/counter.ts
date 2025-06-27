import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  imports: [],
  templateUrl: './counter.html',
  styleUrl: './counter.css'
})
export class Counter {
  counter: number = 0;

  increment() {
    console.log("increment called");
    this.counter++;
  }

  decrement() {
    console.log("decrement called");
    this.counter--;
  }

  reset() {
    console.log("reset called");
    this.counter = 0;
  }
}
