function _reverse(number) {
    num = Math.abs(number).toString().split('').reverse().join().valueOf();
    console.assert(num);
    if (number >= 0){
        return num;
    } else {
        return 0-num;
    }
}