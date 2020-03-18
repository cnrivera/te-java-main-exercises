/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */


function returnOne() {
  return 1;
}



let returnTwo = function() {
  console.log('hello from return Two');
  return 2;
}

returnTwo();



/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} number1 the first parameter to multiply
 * @param {number} number2 the second parameter to multiply
 */

 function multiplyTogether(number1, number2) {
   return number1 * number2;
 }

 

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

 function multiplyNoUndefined (firstParameter = 0, secondParameter = 0){
    
  if (isNaN(firstParameter) || isNaN(secondParameter))
    return 0;
  else
    return firstParameter * secondParameter;
 }

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}


/**
 * 
 * JSDoc example
 * 
 * This method takes information about a person and creates a sentence.
 * 
 * @param {string} name the person's full name
 * @param {number} age 
 * @param {string[]} listOfQuirks 
 * @param {string} separator 
 * @returns {string}
 */

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}


function multiplyByTwo(x) {
  console.log(x * 2);
}

function imperativeForEach() {
  const myArray = [1, 2, 3, 4, 9];

  for (let n of myArray) {
    multiplyByTwo(n);
  }
}

function declarativeForEach() {
  const myArray = [1, 2, 3, 4, 9];

  myArray.forEach(multiplyByTwo);
  myArray.forEach(function(currentElement) {console.log(currentElement * 2)});
  myArray.forEach((currentElement) => {console.log(currentElement * 2)});
  myArray.forEach(x => console.log(x * 2));

}

function isEven(num) {
  return num % 2 === 0;
}

function filterDemo() {
  const myArray = [1, 2, 3, 4, 9];

  //return myArray.filter(n => n % 2 === 0);
  return myArray.filter((n, index) => index % 2 === 0);
  
}

function mapDemo() {
  const myArray = ['red', 'blue', 'green'];

  return myArray.map(str => str.substring(1));
}

function mapWithNumbers() {
  const myArray = [1, 2, 3, 4, 9];

  return myArray.map(x => x * 3);
}

function mapWithObjects() {
  const patients = [
      {name: 'Fred', hasCovid19: false},
      {name: 'Mary', hasCovid19: true},
      {name: 'Sally', hasCovid19: false}
  ];

  //return patients.map(p => p.name);

  return patients.filter(p => !p.hasCovid19).map(p => p.name);
}

function reduceDemo() {
  const myArray = [1, 2, 3, 4, 9];

  return myArray.reduce((total, n) => total + n, 0);

}

function reduceWithStrings() {
  const myArray = ['red', 'blue', 'green'];

  //return myArray.reduce((bigString, s) => bigString + s.toUpperCase(), '');
  return myArray.reduce((bigString, s) => {
    bigString = bigString + s.toUpperCase();
    bigString = bigString.substring(2);
    return bigString;
  }, '');
}



/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce((sum, n) => sum + n);
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(n => n % 3 === 0);
}

function allDivisibleByX(numbersToFilter, x) {
  return numbersToFilter.filter(n => n % x === 0);
}