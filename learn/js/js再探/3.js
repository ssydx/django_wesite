const arr1 = new Array('abc');
console.log(arr1);
const arr2 = new Array(3);
console.log(arr2);
const arr3 = new Array(3,2,1);
console.log(arr3);
const arr4 = [3,2,1];
console.log(arr4);

// array.from
console.log(Array.from('abc'));
console.log(Array.from(new Map().set(1,2).set(3,4)));
console.log(Array.from(new Set().add(1).add(2)));
console.log(Array.from(arr4)); // 浅拷贝
function arrfrom() {
    return Array.from(arguments);
}
console.log(arrfrom(1,2,3));

console.log(arr4[-1]);
const arr5 = [1,,3];
console.log(arr5);
arr5.length = 2;
console.log(arr5);
arr5.length = 5;
console.log(arr5);

const arr6 = [1,2,3,4,5];
arr6.fill('a');
console.log(arr6);
const arr7 = [1,2,3,4,5];
arr7.copyWithin(3,2,4);
console.log(arr7);














