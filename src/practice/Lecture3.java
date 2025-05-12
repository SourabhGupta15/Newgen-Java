package practice;

class Lecture3 {
    public static void main(String[] args) {
        System.out.println(args[0] +" "+ args[1]); // to print this complile and run : 'java Lecture3 hello hi no bye' ->"hello hi no bye" are 4 different arguments.
        for(int i=0;i<args.length;i++) // Another way to print all arguments
        System.out.println(args[i]);  
    }
}


// two types of data types in JAVA : Primitive and Non-Primitve.

/* Primitve : boolean(1bit), char(2B), byte(1Byte), short(2B), int(4B), long(8B), float(4B), double(8B).
 *
 * boolean : True or False -> Default value - False
 * 
 * Numeric : Character, Integral.
 * 
 *      Character : char -> Default value - '\u0000' (in hexadecimal and also lowest range in Unicode System which is used by JAVA), Range = '\u0000' to '\uffff'
 * 
 *      Integral : Integer, Floating-point.
 * 
 *              Integer : byte, short, int, long.
 *                      byte -> Default value = 0, Range = -128 to 127
 *                      Short -> Default value = 0, Range = -32768 to 32767
 *                      int -> Default value = 0, Range = -2^31 to (2^31 - 1)
 *                      long -> Default value = 0L, Range = -2^63 to (2^63 - 1)
 * 
 *              Floating-point : float, double.
 *                      float -> Default value = 0.0f, Range = unlimited, 7 decimal digit precision
 *                      double -> Default value = 0.0d, Range = unlimited, 15-16 decimal digit precision
*/

/* Non-Primitive : Classes(String is an in-built class in JAVA), Interfaces, Arrays.
 * Non-primitive data types start with capital letter.
*/

/* Wrapper Classes are used to store null values also.
 * They start with Capital letter. Eg. Boolean is a wrapper class, boolean is a data type.
 * Wrapper classes are built on primitive data types.
*/

/* if, else, else if, Nested if
 * We have to write if statement inside a method, we cannot write it oustide of mehtod in a class.
*/

/* && - logical AND
 * || - logical OR
*/

/* Switch-Case
 *  Syntax : 
 *      switch (expression) {
 *      case value1 :
 *          statement;
 *          break;
 *
 *      default : 
 *          statement;
 *      }
 * 
 * 
 * If break is not added then it also executes statement from next case.
*/

/* String name; //declaration
 * name = "ABC" //initialization
*/

/* For Loop
 *  Syntax : 
 *      for(int i=1; i<=3; i++){
 *          statement;
 *      }
*/

// i += n   --->   i = i + n

/* Nested For-Loop
 *  Outer for loop indicates row (horizontal line *****)
 *  Ineer for loop indicates column (vertical line *)
 *                                  (              *)
 *                                  (              *)
*/

/* For-each or Enhanced For Loop
 *  It is used to traverse array or collection in java.
 *  It works on the basis of elements and not the index. It returns elements one by one in the defined variable.
 * 
 *  Syntax :
 *      for(data_type variable : array name) {
 *          statement;
 *      }
 * 
 *  e.g. :
 *      for(int i : temp) {
 *          System.out.print(i + " ");
 *      }
*/

/* Array
 *  int arr[] = {1, 34, 56, 2};
 *  int[] temp = {7, 36, 28, 72};
 *  char abc[] = {'A', 'B', 'C', 'D'};
 *  String xyz[] = {"Sourabh", "Ranjan", "Mayur"};
 *  
 *  Index starts from 0.
 *  i.e. temp[0] = 7 and arr[1] = 34
 * 
 *  Printing string array without knowing length
 *      for(int i = 0; i < xyz.length; i++) {
 *          System.out.print(xyz[i] + " ");
 *      }
*/

/* While Loop
 *  Syntax :
 *      while(condition) {
 *          statement;
 *          increment/decrement statement;
 *      }
*/

/* Do-While Loop
 *  Syntax :
 *      do {
 *          statement;
 *          increment/decrement statement;
 *      } while(condition);
 * 
 *  It is used when you need to execute statement atleast once.
*/

/* Jump Statements (break and continue)
 *  1. Break Statement :
 *      Exits the loop or switch prematurely in which it is declared. Not th outer loop.
 *      When a break statement is encountered in a loop, the loop is immediately terminated and the statement next to loop is executed.
 * 
 *  2. Continue Statement :
 *      It is used to skip the current iteration.
*/

// Return keyword : It exits the method. Also can be used to exit the nested loops or switch

/* Labelled Loops
 *  Syntax:
 *      public static void main (String[] args) {
 *          aa:   //label for outer for-loop
 *          for(condition) {
 *              bb:    //label for inner for-loop
 *              for(condition) {
 *                  if(condition) {
 *                      break aa;  //breaks outer for loop
 *                  }
 *              }
 *          }
 *      }
 * 
 *  It can be used for any type of loop.
*/

/* ARRAY
 *  Array is a collection of similar type of elements which has contiguous memory location.
 *  We can store only fixed set of elements in Java Array.
 * 
 *  - Syntax to declare Array:
 *      dataType[] arr; (or) dataType []arr; (or) dataType arr[];
 * 
 *  - Instantiation of an Array:
 *      arrName = new dataType[size];
*/

/* We need to initialize local variables whereas global variables are already initialized to default values.
 * If local variables are not initialized they give compile time errors.
*/