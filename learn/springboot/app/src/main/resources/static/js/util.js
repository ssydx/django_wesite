function getParam(key) {
    let paraEntries = new URLSearchParams(window.location.search.slice(1));
    return paraEntries.get(key);
}

function g_secs2hour(secs) {
	let hours = Math.floor(secs / 3600);
	let mins = Math.floor((secs % 3600) / 60);
	let left = secs % 60;
	return hours + "小时" + mins + "分" + left + "秒";
}