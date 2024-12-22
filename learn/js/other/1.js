
const _getParams = (str) => {
    // 补全代码
    return str.slice(str.indexOf('?')+1).split('&').join('=').split('=').map(
        (dict, elem, index, arr) => {
            if ((index + 1) % 2 == 1) {
                dict.set(elem) = arr[index]
            }
    }, {})
}
