const root = document.getRootNode();
console.log(root);

const inputs1 = document.getElementsByTagName('input');
const inputs2 = document.getElementsByClassName('searchbox1');
const inputs3 = document.getElementsByName('searchbox1');
const input1 = document.getElementById('searchbox1');
console.log(inputs1);
console.log(inputs2);
console.log(inputs3);
console.log(input1);

const input2 = document.querySelector('input');
const input3 = document.querySelector('.searchbox1');
const input4 = document.querySelector("[name='searchbox1']");
const input5 = document.querySelector('#searchbox1');
const inputs4 = document.querySelectorAll('input');
const inputs5 = document.querySelectorAll('.searchbox1');
const inputs6 = document.querySelectorAll("[name='searchbox1']");
const inputs7 = document.querySelectorAll('#searchbox1');
console.log(input2);
console.log(input3);
console.log(input4);
console.log(input5);
console.log(inputs4);
console.log(inputs5);
console.log(inputs6);
console.log(inputs7);


