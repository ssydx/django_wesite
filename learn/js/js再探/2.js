const arr = ['a','b','c'];
console.log(arr.entries());
for (const [index,value] of arr.entries()) {
    console.log(index,value);
}