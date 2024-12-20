function myfetch(url, options = {}) {
    return new Promise(function(resolve,reject) {
        const request = new XMLHttpRequest();
        request.open(options.method || 'GET', url, true);
        if (options.headers) {
            Object.keys(options.headers).forEach(function(key) {
                request.setRequestHeader(key, options.headers[key]);
            })
        }
        request.onload = function() {
            if (this.status >= 200 && this.status <300) {
                resolve({
                    ok:true,
                    status: this.status,
                    statusText: this.statusText,
                    text: () => this.responseText
                })
            } else {
                reject(new Error(`Network response was not ok (status: ${request.status})`));
            }
        }
        request.onerror = function() {
            reject(new Error('Network error'));
        }
        request.send(options.body || null);
    })
};

myfetch('./另一文档.html')
.then(function(res) {
    console.log(res);
    console.log(res.text());
})

















