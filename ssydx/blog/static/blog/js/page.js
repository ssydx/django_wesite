document.addEventListener(
    'DOMContentLoaded',
    function() {
        const toc_links = document.querySelectorAll('.main > h2');
        const tocs = document.querySelectorAll('.aside-right');
        tocs.forEach(toc => {
            var id=0;
            toc_links.forEach(toc_link => {
                id += 1;
                toc_link.id = id;
                var link = document.createElement('a');
                link.innerHTML = toc_link.innerHTML;
                link.href = this.location.href + '#' + id;
                toc.appendChild(link);
            })
        })
        const nav_left = document.querySelector('.nav-left');
        var preNode;
        function nav_click() {
            if (preNode != null) {
                preNode.style.borderBottomColor = '';
                preNode.style.borderBottomWidth = '';
                preNode.style.borderBottomStyle = '';
                preNode.style.fontWeight = '';
            }
            this.style.borderBottomColor = 'black';
            this.style.borderBottomWidth = '0.25em';
            this.style.borderBottomStyle = 'solid';
            this.style.fontWeight = '300';
            preNode = this;
        }
        nav_left.querySelectorAll('a').forEach(element => {
            element.addEventListener('click', nav_click)
        })
        const hash = window.location.hash;
        if (hash) {
            const targetElement = document.querySelector(hash);
            if (targetElement) {
                targetElement.scrollIntoView({ behavior: 'smooth' });
            }
        }
    }
)