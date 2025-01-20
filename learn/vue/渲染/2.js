

function createRenderer(options = {}) {
    const {
        createElement,
        insert, 
        setElementText,
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

const renderer = createRenderer({
    createElement(tag) {
        console.log(`创建元素${tag}`);
        return { tag };
    },
    setElementText(el, text) {
        console.log(`设置 ${JSON.stringify(el)} 的文本内容：${text}`)
        el.textContent = text;
    },
    insert(el, parent, anchor = null) {
        console.log(JSON.stringify(parent));
        console.log(`将 ${JSON.stringify(el)} 添加到 ${JSON.stringify(parent)} 下`)
        parent.children = el;
    }
});
const vnode = {
    type: 'h1',
    children: 'hello',
}
const vnode2 = {
    type: 'h1',
    children: [
        { type: 'p',children: 'world' },
    ],
}
const container = {
    type: 'root',
}
// renderer.render(vnode, container);
renderer.render(vnode2, container);


