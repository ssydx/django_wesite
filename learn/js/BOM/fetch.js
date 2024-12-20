fetch('./另一文档.html')
.then(function(res) {
    console.log(res);
    console.log(res.type);
    console.log(res.url);
    console.log(res.redirected);
    console.log(res.status);
    console.log(res.statusText);
    console.log(res.ok);
    console.log(res.headers);
    console.log(res.body);
    console.log(res.bodyUsed);
    console.log(res.clone().blob());
    console.log(res.clone().text());
    return res.text();
})
.then(function(res) {
    console.groupCollapsed();
    console.log(res);
    console.groupEnd();
});


 

