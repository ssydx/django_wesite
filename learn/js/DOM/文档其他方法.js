console.log(document.hasFocus());
const frag = document.createDocumentFragment('div');
for (let i = 0;i<10;i++) {
    const p = document.createElement('p');
    const attr = document.createAttribute('class');
    attr.value = 'p1';
    const text = document.createTextNode('新增段落');
    const comment = document.createComment('新增注释');
    p.appendChild(text);
    p.appendChild(comment);
    p.setAttributeNode(attr);
    frag.appendChild(p);
}
document.body.appendChild(frag);
document.write("<h1>Hello World</h1>");

