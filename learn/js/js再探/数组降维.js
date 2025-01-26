const arr1 = [[1,2,3],4,[[[5]]],[6,7],[],8,[[9]]];

function toOneArr1(arr) {
    let OneArr = [];
    for (const item of arr) {
        if (Array.isArray(item)) {
            OneArr = OneArr.concat(toOneArr1(item));
        } else {
            OneArr.push(item);
        }
    }
    return OneArr;
}
function toOneArr2(arr) {
    return arr.reduce((OneArr,item) => 
        OneArr.concat(Array.isArray(item) ? toOneArr2(item) : item)
    ,[])
}
function toOneArr3(arr) {
    let stack = [...arr];
    const res = [];
    while (stack.length) {
        const val = stack.pop();
        if (Array.isArray(val)) {
            stack = stack.concat(val);
        } else {
            res.push(val);
        }
    }
    return res.reverse();
}



console.log(arr1);
console.log(toOneArr1(arr1));
console.log(arr1.flat(Infinity));
console.log(toOneArr2(arr1));
console.log(toOneArr3(arr1));