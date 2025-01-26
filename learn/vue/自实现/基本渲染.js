function createRenderer(options = {}) {
    const {
        createElement,
        setElementText,
        insertElement,
        removeElement,
        setProps,
    } = options;
    function mountChildren(children, el) {
        if (typeof children === 'string') {
            setElementText(el, children);
        } else if (Array.isArray(children)) {
            children.forEach(child => mount(child, el))
        }
    };
    function mountProps(props, el) {
        for (const key in props) {
            setProps(el, key, props[key]);
        }
    };
    function mount(newVnode, container) {
        if (typeof newVnode.type === 'string') {
            console.log('将',newVnode,'挂载到',container);
            const el = newVnode.el = createElement(newVnode.type);
            mountChildren(newVnode.children, el);
            mountProps(newVnode.props, el);
            insertElement(el, container);
        }
        else if (typeof newVnode.type === 'object') {

        }
    };
    function unmount(oldVnode) {
        if (typeof oldVnode.type === 'string') {
            if (Array.isArray(oldVnode.children)) {
                oldVnode.children.forEach(child => unmount(child));
            };
            console.log('将',oldVnode,'从',oldVnode.el.parentNode,'卸载');
            removeElement(oldVnode.el);
        }
        else if (typeof newVnode.type === 'object') {

        }
    };
    function patchChildren(oldChildren, newChildren, el) {
        if (typeof newChildren === 'string') {
            if (Array.isArray(oldChildren)) {
                oldChildren.forEach(child => unmount(child));
            }
            setElementText(el, newChildren);
        }
        else if (Array.isArray(newChildren)) {
            if (Array.isArray(oldChildren)) {
                oldChildren.forEach(child => unmount(child));
                newChildren.forEach(child => mount(child, el));
            }
            else {
                setElementText(el, '');
                newChildren.forEach(child => mount(child, el));
            }
        }
        else {
            if (Array.isArray(oldChildren)) {
                oldChildren.forEach(child => unmount(child));
            }
            else if (typeof oldChildren === 'string') {
                setElementText(el, '');
            }
        }
    };
    function patchProps(oldProps, newProps, el) {
        for (const key in newProps) {
            if (newProps[key] !== oldProps[key]) {
                setProps(el, key, newProps[key]);
            }
        };
        for (const key in oldProps) {
            if (newProps[key] !== oldProps[key]) {
                setProps(el, key, null);
            }
        }
    };
    function patch(oldVnode,newVnode,container) {
        if (oldVnode.type !== newVnode.type) {
            unmount(oldVnode);
            mount(newVnode, container);
        } 
        else {
            if (typeof newVnode.type === 'string') {
                const el = newVnode.el = oldVnode.el;
                patchChildren(oldVnode.children, newVnode.children, el);
                patchProps((oldProps = oldVnode.props || {}), (newProps = newVnode.props || {}), el);
            }
        }
    };
    function render(newVnode, container) {
        if (newVnode) {
            if (container._oldVnode) {
                console.log('新旧节点都存在，需要打补丁');
                patch(container._oldVnode,newVnode,container);
            } 
            else {
                console.log('只存在新节点，直接挂载');
                mount(newVnode, container);
            }
        } 
        else {
            if (container._oldVnode) {
                console.log('只存在旧节点，直接卸载');
                unmount(container._oldVnode);
            }
            else {
                console.log('新旧节点都不存在，什么都不做');
            }
        }
        container._oldVnode = newVnode;
    };
    return {
        render,
    }
}

const renderer = createRenderer({
    createElement(tag) {
        return document.createElement(tag);
    },
    setElementText(el, text) {
        el.textContent = text;
    },
    insertElement(el, parent) {
        parent.insertBefore(el, null);
    },
    removeElement(el) {
        el.parentNode.removeChild(el);
    },
    setProps(el, propkey, propvalue) {
        function shouldSetAsProp(el, key, value) {
            return false;
        };
        if (/^on/.test(propkey)) {

        }
        else if (propkey === 'class') {
            function normalizeClass(cls) {
                if (cls == null) {
                    return '';
                }
                if (typeof cls === 'string') {
                    return cls.trim();
                }
                if (Object.prototype.toString.call(cls) === '[object Object]') {
                    return Object.entries(cls)
                        .filter(([key,value]) => value)
                        .map(([key]) => key)
                        .join(' ')
                        .trim();
                }
                if (Array.isArray(cls)) {
                    return cls
                    .flatMap(item => normalizeClass(item))
                    .filter(Boolean)
                    .join(' ')
                    .trim();
                }
            }
            propvalue = normalizeClass(propvalue);
            el.className = propvalue;
        }
        else if (shouldSetAsProp(el, propkey, propvalue)) {

        }
        else {
            el.setAttribute(propkey, propvalue);
        }
    },
});
const vnode1 = {
    type: 'h1',
    children: 'h1',
    props: {
        id: 'h1',
    }
}
const vnode2 = {
    type: 'h2',
    children: 'h2',
    props: {
        class: 'h2',
    }
}
const vnode3 = {
    type: 'h1',
    children: [
        { 
            type:'h2',
            children: [
                { type:'p',children:'p1',props:{id:'p1',class:'p1'} },
                { type:'p',children:'p2',props:{id:'p2',class:'p2'} },
            ], 
            props: {
                id: 'h2-1',
                class: 'h2-1',
            }
        },
        { 
            type:'h2',
            children:'h2',
            props: {
                id: 'h2-2',
                class: 'h2-2',
            },
        },
    ],
    props: {
        id: 'h1',
        class: 'h1',
    }
}
const vnode4 = {
    type: 'h1',
    children: [
        { type:'div',children:'div1',props:{ class:['c1','c2 c3',{ c4:false,c5:true }] } },
        { type:'div',children:'div2',props:{ class:'c1' } },
    ],
    // props: {
    //     class: 'h1',
    // }
}
const vnode5 = {
    type: 'h1',
    children: [
        { type:'div',children:'div1',props:{ class:['c1','c2 c3'] } },
        { type:'div',children:'div2',props:{ class:'c1 c2' } },
    ],
    props: {
        id: 'h1',
    }
}
// render测试
// renderer.render(null,document.querySelector('#div1'));
// renderer.render(vnode1,document.querySelector('#div1'));
// renderer.render(vnode2,document.querySelector('#div1'));
// renderer.render(null,document.querySelector('#div1'));

// mount unmount测试
// renderer.render(vnode3,document.querySelector('#div1'));
// renderer.render(null,document.querySelector('#div1'));

// 属性测试
renderer.render(vnode4,document.querySelector('#div1'));
renderer.render(vnode5,document.querySelector('#div1'));
