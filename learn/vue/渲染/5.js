

function createRenderer(options = {}) {
    const {
        createElement,
        insert,
        setElementText,
        patchProps,
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
        setElementText(oldVnode.el, newVnode.children);
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
        // 新节点为组件
        } else if (typeof type === 'object') {

        // 新节点为xxx
        } else if (typeof type === 'xxx') {

        }
    }
    function unmount(vnode) {
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
        if (key === 'class') {
            el.className = nextValue || '';
        }
        // 避开无法直接设置属性的属性类型
        else if (shouldSetAsProp(el, key, nextValue)) {
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
    }
});

const vnode1 = {
    type: 'h1',
    props: {
        id: 'foo',
        class: normalizeClass(['cls1 cls2','cls3',{ cls4: false,cls5: true }]),
    },
    children: [
        { type: 'p',children: 'world' },
        { type: 'input', props: { form: 'form1', disabled: '' } },
    ],
}
const container1 = document.querySelector('#div1');

renderer.render(vnode1, container1);

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
const container2 = document.querySelector('#div2');
const vnode2 = {
    type: 'p',
    children: 'vue3',
}
renderer.render(vnode2, container2);
const vnode3 = {
    type: 'p',
    children: 'vue2',
}
renderer.render(vnode3, container2);
