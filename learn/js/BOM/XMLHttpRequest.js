const xml1 = new XMLHttpRequest();
console.log(xml1);
xml1.open('GET','./另一文档.html',true);
xml1.onloadstart = function() {
    console.groupCollapsed();
    console.log(this.response);
    console.log(this.responseText);
    console.log(this.responseType);
    console.log(this.responseURL);
    console.log(this.responseXML);
    console.log('onloadstart的进度值：' + this.readyState);
    console.log('onloadstart的状态值：' + this.status + '-' + this.statusText);
    console.groupEnd();
}
xml1.onreadystatechange = function() {
    console.groupCollapsed();
    console.log(this.response);
    console.log(this.responseText);
    console.log(this.responseType);
    console.log(this.responseURL);
    console.log(this.responseXML);
    console.log('onreadystatechange的进度值：' + this.readyState);
    console.log('onreadystatechange的状态值：' + this.status + '-' + this.statusText);
    console.groupEnd();
}
xml1.onload = function() {
    console.groupCollapsed();
    console.log(this.response);
    console.log(this.responseText);
    console.log(this.responseType);
    console.log(this.responseURL);
    console.log(this.responseXML);
    console.log('onload的进度值：' + this.readyState);
    console.log('onload的状态值：' + this.status + '-' + this.statusText);
    console.groupEnd();
}
xml1.onloadend = function() {
    console.groupCollapsed();
    console.log(this.response);
    console.log(this.responseText);
    console.log(this.responseType);
    console.log(this.responseURL);
    console.log(this.responseXML);
    console.log('onloadend的进度值：' + this.readyState);
    console.log('onloadend的状态值：' + this.status + '-' + this.statusText);
    console.groupEnd();
}
xml1.onerror = function() {
    console.groupCollapsed();
    console.log(this.response);
    console.log(this.responseText);
    console.log(this.responseType);
    console.log(this.responseURL);
    console.log(this.responseXML);
    console.log('onerror的进度值：' + this.readyState);
    console.log('onerror的状态值：' + this.status + '-' + this.statusText);
    console.groupEnd();
}
xml1.send();


const xml2 = new XMLHttpRequest();
console.log(xml2);
xml2.open('GET','./另一文档.html',true);
xml2.onload = function() {
    console.log(this.getAllResponseHeaders());
    console.log(this.getResponseHeader('last-modified'));
}
xml2.send();

const xml3 = new XMLHttpRequest();
console.log(xml3);
xml3.open('GET','./另一文档.html',true);
xml3.onload = function() {
    console.log(this);
}
xml3.send();

const xml4 = new XMLHttpRequest();
console.log(xml4);
xml4.open('GET','./另一文档.txt',true);
xml4.onload = function() {
    console.log(this.responseText);
}
xml4.send();

const xml5 = new XMLHttpRequest();
console.log(xml5);
xml5.open('GET','./另一文档.xml',true);
xml5.onload = function() {
    console.log(this.responseXML);
}
xml5.send();

function loaddata() {
    const xml = new XMLHttpRequest();
    xml.open('GET','./另一文档.txt',true);
    xml.onload = function() {
        document.body.appendChild(document.createTextNode(this.responseText));
    }
    xml.send();
}
document.body.insertAdjacentHTML('afterbegin','<button onclick=loaddata()>加载</button>');


