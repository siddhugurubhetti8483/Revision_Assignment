function Raise(n) {
  console.log(n ** 4);
}
// Raise(2)

function Motu(n) {
  let res = Math.ceil(n / 5);
  console.log(res);

  //! OR

  let steps = Math.floor(n / 5);
  if (n % 5 !== 0) {
    steps++;
  }
  console.log(steps);
}
// Motu(32);

function secondMax(a, b, c) {
  if ((a > b && a < c) || (a > c && a < b)) {
    console.log(a);
  } else if ((b > c && b < a) || (b > a && b < c)) {
    console.log(b);
  } else {
    console.log(c);
  }
}
// secondMax(3,2,1);

function fun(n) {
  let sum = 0;
  while (n > 0) {
    sum += n % 10;
    n = Math.floor(n / 10);
    console.log(n);
    // n--;
  }
  console.log(sum);
}
// fun(78)

function decompressTheString(str) {
  let output = "";
  for (let i = 0; i < str.length; i++) {
    let char = str[i];
    if (char >= "0" && char <= "9") {
      let num = char;
      let pre = str[i - 1];
      for (let j = 1; j <= num; j++) {
        output += pre;
      }
    }
  }
  console.log(output);
}
// decompressTheString("a0b2c0");

function countingValleys(steps, path) {
  //8 uddduduu
  let altitude = 0;
  let valleys = 0;

  for (let i = 0; i < steps; i++) {
    let step = path[i]; //u d d

    if (step === "U") {
      altitude++; //-1
      if (altitude === 0) {
        valleys++;
      }
    } else {
      altitude--;
    }
  }

  return valleys;
}

let steps = 8;
let path = "UDDDUDUU";

// console.log(countingValleys(steps, path));

function isVowel(ch) {
  return ["a", "e", "i", "o", "u"].includes(ch);
}

function countConsonantsInV(matrix, N, M) {
  let path = [];

  // 🔹 First half: (1,M), (2,M-1), (3,M-2) ...
  let row = 0,
    col = M - 1; // 0-based indexing
  while (row < N && col >= 0) {
    path.push(matrix[row][col]);
    row++;
    col--;
  }

  // 🔹 Second half: continue (row,col+2), (row+1,col+3) ...
  col = 1; // because last col became -1, so restart from col=1
  while (row < N && col < M) {
    path.push(matrix[row][col]);
    row++;
    col++;
  }

  // Check if we ended at bottom-right (N-1, M-1)
  if (!(row === N && col === M)) {
    return -1;
  }

  // 🔹 Count consonants
  let consonants = 0;
  for (let ch of path) {
    if (!isVowel(ch)) {
      consonants++;
    }
  }
  return consonants;
}

// 🔹 Driver code
function main(input) {
  let lines = input.trim().split("\n");
  let T = parseInt(lines[0]);
  let idx = 1;
  let results = [];

  for (let t = 0; t < T; t++) {
    let [N, M] = lines[idx++].split(" ").map(Number);
    let matrix = [];
    for (let i = 0; i < N; i++) {
      matrix.push(lines[idx++].trim().split(" "));
    }
    results.push(countConsonantsInV(matrix, N, M));
  }

  console.log(results.join("\n"));
}

// 🔹 Sample Input
let input = `2
3 2
a a
b b
c c
2 2
a a
b b`;

main(input);

/*
Expected Output:
2
-1
*/

function runProgram(input) {
  let lines = input.trim().split("\n");
  let s1 = lines[0].trim();
  let s2 = lines[1].trim();

  let found = false;

  for (let i = 0; i <= s1.length - s2.length; i++) {
    let match = true;
    for (let j = 0; j < s2.length; j++) {
      if (s1[i + j] !== s2[j]) {
        match = false;
        break;
      }
    }
    if (match) {
      found = true;
      break;
    }
  }

  if (found) {
    console.log("Yes");
  } else {
    console.log("No");
  }
}
