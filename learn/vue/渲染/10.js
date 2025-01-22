

function createRenderer(options = {}) {
    const {
        createElement,
        insert,
        setElementText,
        patchProps,
        createText,
        setText,
        createComment,
        setComment,
    } = options;
    function mountElement(vnode, container) {
        const el = vnode.el = createElement(vnode.type);
        // 子节点是文本节点则直接设置，是数组的话说明有子元素，依次更新，注意旧节点为null
        // 本质就是递归挂载
        if (typeof vnode.children === 'string') {
            setElementText(el, vnode.children);
        } else if (Array.isArray(vnode.children)) {
            vnode.children.forEach(child => {
                patch(null, child, el);
            })
        };
        // 属性设置
        if (vnode.props) {
            for (const key in vnode.props) {
                patchProps(el, key, null, vnode.props[key]);
            }
        }
        insert(el, container);
    }
    function patchElement(oldVnode, newVnode) {
        const el = newVnode.el = oldVnode.el;
        const oldProps = oldVnode.props;
        const newProps = newVnode.props;
        for (const key in newProps) {
            if (newProps[key] !== oldProps[key]) {
                patchProps(el, key, oldProps[key], newProps[key]);
            }
        }
        for (const key in oldProps) {
            patchProps(el, key, oldProps[key], null);
        }
        patchChildren(oldVnode, newVnode, el);
    }
    function patch(oldVnode, newVnode, container) {
        if (oldVnode && oldVnode.type !== newVnode.type) {
            unmount(oldVnode);
            oldVnode = null;
        }
        const { type } = newVnode;
        // 新节点没有子节点
        if (typeof type === 'string') {
            if (!oldVnode) {
                mountElement(newVnode, container);
            } else {
                patchElement(oldVnode,newVnode);
            }
        // 新节点为文本节点
        } else if (type === Text) {
            if (!oldVnode) {
                const el = newVnode.el = createText(newVnode.children);
                insert(el, container);
            } else {
                const el = newVnode.el = oldVnode.el;
                if (newVnode.children !== oldVnode.children) {
                    setText(el, newVnode.children);
                }
            }
        // 新节点为注释节点
        } else if (type === Comment) {
            if (!oldVnode) {
                const el = newVnode.el = createComment(newVnode.children);
                insert(el, container);
            } else {
                const el = newVnode.el = oldVnode.el;
                if (newVnode.children !== oldVnode.children) {
                    setComment(el, newVnode.children);
                } 
            }
        // 新节点为片段
        } else if (type === Fragment) {
            if (!oldVnode) {
                newVnode.children.forEach(child => patch(null, child, container))
            } else {
                patchChildren(oldVnode, newVnode, container);
            }
        // 新节点为组件
        } else if (typeof type === 'object') {

        // 新节点为xxx
        } else if (typeof type === 'xxx') {

        }
    }
    function unmount(vnode) {
        if (vnode.type === Fragment) {
            vnode.children.forEach(child => unmount(child));
            return;
        }
        const parent = vnode.el.parentNode;
        if (parent) {
            parent.removeChild(vnode.el);
        }
    }
    function render(newVnode, container) {
        // 新节点存在则更新，否则如果旧节点有内容则设置为空
        if (newVnode) {
            patch(container._oldVnode, newVnode, container);
        } else {
            if (container._oldVnode) {
                unmount(container._oldVnode);
            }
        }
        // 让旧值等于当前新节点的值
        container._oldVnode = newVnode;
    }
    return {
        render,
    };
}
function shouldSetAsProp(el, key, value) {
    if (key === 'form' && el.tagName === 'INPUT') {
        return false;
    }
    return key in el;
}
const renderer = createRenderer({
    createElement(tag) {
        return document.createElement(tag);
    },
    setElementText(el, text) {
        el.textContent = text;
    },
    insert(el, parent, anchor = null) {
        parent.insertBefore(el, anchor);
    },
    patchProps(el, key, prevValue, nextValue) {
        // 事件
        if (/^on/.test(key)) {
            const evtName = key.slice(2).toLowerCase();
            const invokers = el._vei || (el._vei = {});
            let invoker = invokers[key]; 
            if (nextValue) {
                if (!invoker) {
                    invoker = el._vei[key] = (e) => {
                        if (e.timeStamp < invoker.attached) {
                            return;
                        }
                        if (Array.isArray(invoker.value)) {
                            invoker.value.forEach(fn => fn(e))
                        } else {
                            invoker.value(e);
                        }
                    }
                    invoker.value = nextValue;
                    invoker.attached = performance.now();
                    el.addEventListener(evtName, invoker);
                } else {
                    invoker.value = nextValue;
                }
            } else if (invoker) {
                el.removeEventListener(evtName, invoker);
            }
        // 类
        } else if (key === 'class') {
            el.className = nextValue || '';
        // 避开无法直接设置属性的属性类型
        } else if (shouldSetAsProp(el, key, nextValue)) {
            const type = typeof el[key];
            // 如果是布尔类型且值为空则特殊处理，否则直接设置
            if (type === 'boolean' && nextValue === '') {
                el[key] = true;
            } else {
                el[key] = nextValue;
            }
        } else {
            el.setAttribute(key, nextValue);
        }
    },
    patchChildren(oldVnode, newVnode, container) {
        // 新节点是文本
        if (typeof newVnode.children === 'string') {
            if (Array.isArray(oldVnode.children)) {
                oldVnode.children.forEach(node => unmount(node));
            }
            setElementText(container, newVnode.children);
        // 新节点是多个子节点
        } else if (Array.isArray(newVnode.children)) {
            if (Array.isArray(oldVnode.children)) {
                // 核心DIFF算法
                const oldChildren = oldVnode.children;
                const newChildren = newVnode.children;
                const oldLen = oldChildren.length;
                const newLen = newChildren.length;
                const minLen = Math.min(oldLen,newLen);
                for (let i=0; i<minLen; i++) {
                    patch(oldChildren[i],newChildren[i], container);
                }
                if (newLen > oldLen) {
                    for (let i = minLen; i < newLen; i++) {
                        patch(null, newChildren[i], container);
                    }
                } else if (newLen < oldLen) {
                    for (let i = minLen; i < oldLen; i++) {
                        unmount(oldChildren[i]);
                    }
                } else {

                }
                oldVnode.children.forEach(child => unmount(child))
                newVnode.children.forEach(child => patch(null, child, container))
            } else {
                setElementText(container, '');
                newVnode.children.forEach(child => patch(null, child, container))
            }
        // 新节点为空
        } else {
            if (Array.isArray(oldVnode.children)) {
                oldVnode.children.forEach(child => unmount(child));
            } else if (typeof oldVnode.children === 'string') {
                setElementText(container, '');
            }
        }
    },
    createText(text) {
        return document.createTextNode(text);
    },
    createComment(text) {
        return document.createComment(text);
    },
    setText(el, text) {
        el.nodeValue = text;
    },
    setComment(el, text) {
        el.nodeValue = text;
    }
});


function normalizeClass(cls) {
    if (cls == null) return ''; // 处理 null 和 undefined

    if (typeof cls === 'string') {
        return cls.trim(); // 移除首尾空格
    }

    if (Array.isArray(cls)) {
        // 递归处理数组中的每个元素，并过滤掉空字符串
        return cls
            .flatMap(item => normalizeClass(item))
            .filter(Boolean) // 过滤掉空字符串或假值
            .join(' ')
            .trim();
    }

    if (Object.prototype.toString.call(cls) === '[object Object]') {
        // 遍历对象的键值对，只保留值为 true 的键
        return Object.entries(cls)
            .filter(([key, value]) => value)
            .map(([key]) => key)
            .join(' ')
            .trim();
    }

    return '';
}

const Text = Symbol();
const Comment = Symbol();
const Fragment = Symbol();
const vnode1 = {
    type: Text,
    children: '我是文本内容',
}
const vnode2 = {
    type: Comment,
    children: '我是注释内容',
}
const vnode3 = {
    type: Comment,
    children: '我是注释内容1',
}
const vnode = {
    type: Fragment,
    children: [
        { type: 'li', children: 'text 1' },
        { type: 'li', children: 'text 2' },
        { type: 'li', children: 'text 3' },
    ]
};
const container1 = document.querySelector('#div1');

renderer.render(vnode, container1);
