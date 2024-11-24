// 本章导航
function inpagenav() {
    return new Promise((resolve, reject) => {
        const toc_links = document.querySelectorAll('.main > h2');
        const toc_containers = document.querySelectorAll('.aside-right');
        toc_containers.forEach(toc_container => {
            let id = 0;
            toc_links.forEach(toc_link => {
                id += 1;
                toc_link.id = 'section-' + id;
                const link = document.createElement('a');
                link.innerHTML = toc_link.innerHTML;
                link.href = window.location.pathname + '#section-' + id;
                toc_container.appendChild(link);
            });
        })
        resolve(document);
    })
}
// 章节导航
function crosspagenav() {
    return new Promise((resolve, reject) => {
        const aside_left = document.querySelector('.leftAside-wrapper > .aside-left');
        document.querySelector('.aside-container > .aside-left').innerHTML = aside_left.innerHTML;
        document.querySelector('.menu-container > .aside-left').innerHTML = aside_left.innerHTML;
        resolve(document);
    })
}

// const nav_left = document.querySelector('.nav-left');
// var preNode;
// function nav_click() {
//     if (preNode != null) {
//         preNode.style.borderBottomColor = '';
//         preNode.style.borderBottomWidth = '';
//         preNode.style.borderBottomStyle = '';
//         preNode.style.fontWeight = '';
//     }
//     this.style.borderBottomColor = 'black';
//     this.style.borderBottomWidth = '0.25em';
//     this.style.borderBottomStyle = 'solid';
//     this.style.fontWeight = '300';
//     preNode = this;
// }
// nav_left.querySelectorAll('a').forEach(element => {
//     element.addEventListener('click', nav_click)
// })

document.addEventListener(
    'DOMContentLoaded',
    function() {
        inpagenav().then(doc => {
            const hash = window.location.hash;
            if (hash) {
                const targetElement = doc.querySelector(hash);
                if (targetElement) {
                    targetElement.scrollIntoView({ behavior: 'smooth' });
                }
            }
        });
        crosspagenav().then(doc => {
            const left_navs = doc.querySelectorAll(`a[href="${window.location.pathname}"]`);
            left_navs.forEach(left_nav => {
                left_nav.style.fontWeight = 900;
            });
            const aside_lefts = doc.querySelectorAll('.aside-left');
            aside_lefts.forEach(aside_left =>{
                const containerRect = aside_left.getBoundingClientRect();
                const rect = aside_left.querySelector(`a[href="${window.location.pathname}"]`).getBoundingClientRect();
                const middlePosition = (containerRect.height / 2) - (rect.height / 2);
                aside_left.scrollTop = rect.top - middlePosition;
            })
        })
})