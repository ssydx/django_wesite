

function createRenderer(options = {}) {
    const {
        createElement,
        insert,
        setElementText,
        patchProps,
    } = options;
    function mountElement(vnode, container) {
        const el = createElement(vnode.type);
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
    function patch(oldVnode, newVnode, container) {
        // 不存在旧节点，则直接挂载，否则打补丁
        if (!oldVnode) {
            mountElement(newVnode, container);
        } else {

        }
    }
    function render(newVnode, container) {
        // 新节点存在则更新，否则如果旧节点有内容则设置为空
        if (newVnode) {
            patch(container._oldVnode, newVnode, container);
        } else {
            if (container._oldVnode) {
                container.innerHTML = '';
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
        // 避开无法直接设置属性的属性类型
        if (shouldSetAsProp(el, key, nextValue)) {
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

const vnode = {
    type: 'h1',
    props: {
        id: 'foo',
    },
    children: [
        { type: 'p',children: 'world' },
        { type: 'input', props: { form: 'form1', disabled: '' } },
    ],
}
const container = document.querySelector('#div1');

renderer.render(vnode, container);


