function greet(name: string): string{
    return `Hello, ${name}!`;
}

console.log(greet("Sourabh"));

let num: number = 12;
let str: string = "abc";
let boo: boolean = true;

let num1 = 12;
let str1 = "abc";

console.log(greet(str));
console.log(greet(str1));
console.log(boo);
console.log(num);

let v: any = true;
console.log(v);

v = "xyz";
console.log(v);

v = 156;
console.log(v);

const names: string[] = [];     //const has scope within the block
names.push("Dylan");
console.log(names);

const arr: number[] =[1, 2, 3, 4, 5];
console.log(arr);

names.push("Rushikesh");
names.push("Praful");
names.push("Karan");

console.log(names);

arr.push(12);
console.log(arr);

console.log("Length of arr : " + arr.length);
console.log("arr[2] : " + arr[2]);
console.log("Length of names : " + names.length);
console.log("names[0] : " + names[0]);
console.log("names[4] : " + names[4]);

for (let i = 0; i < arr.length; i++) {
    console.log("element : " + arr[i]);
}

console.log("Using forEach loop");
names.forEach((element) => {
    console.log("element : " + element);
});

arr.pop();
console.log("After arr.pop()");
arr.forEach((num) => {
    console.log("element : " + num);
})

let tuple1: [number, boolean, string];
tuple1 = [5, false, "hello"];
console.log("tuple1 : " + tuple1);
tuple1.push(10);
tuple1.push(20);
tuple1.push(true);
tuple1.push(30);
tuple1.push('hi');
console.log("tuple1 : " + tuple1);

let tuple2: readonly [boolean, string, number];     //it is a read-only tuple i.e. immutable. You cannot add, remove or change elements in it.
tuple2 = [true, 'well', 3];
console.log("tuple2 : " + tuple2);

const arr2: readonly number[] = [1, 2, 3, 4];       //it is a read-only array.
console.log("arr2 : " + arr2);

//Typescript Object
const car: {type: string, model: string, year: number} = {      //TSC and JS can create object without defining a class
    type : 'Toyota',
    model : 'Corolla',
    year : 2009
};
console.log(car);
console.log(car.type + " " + car.model + " " + car.year);

const car1 = {type: 12, model: "Fortuner", year: 2018};         //implicit defining
console.log(car1);

//Functions
function getTime(): number {
    return new Date().getTime();
}
console.log(getTime());

function print(): void {
    console.log("Hello");
}
print();

function add(a: number, b: number): number {
    return a + b;
}
console.log(add(5, 7));

function printString(str1: string, str2: string): void {
    console.log(str1 + " " + str2);
}
printString('Hello', 'Welcome');

//Typescript Classes
class Person {
    private name: string;       //private members accessed only inside the class and by class methods/functions.
    age: number;                //public member by default
                                //protected members accessed by class members from itself and any classes that inherit it

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    greet() {
        console.log("Name from greet : " + person.name);
        console.log(`Hello, ${this.name}`);
    }
}

const person = new Person("Yogesh", 25);
console.log(person);
// console.log(person.name);    //cannot be accessed outside the class
console.log(person.age);
person.greet();