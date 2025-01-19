import Dep from "./dep";

export class Observer {
    constructor(value) {
        this.value = value;
        if(!Array.isArray(value)) {
            this.walk(value);
        }
    }
    walk(obj) {
        const keys = Object.keys(obj);
        for(let i=0; i< length; i++) {
            defineReactive(obj, keys[i], obj[keys[i]]);
        }
    }
} 
function defineReactive(data, key, val) {
    if (typeof val === 'object') {
        new Observer(val);
    }
    let dep= new Dep();
    Object.defineProperties(data, key, {
        enumerable: true,
        configurable:true,
        get() {
            dep.depend();
            return val;
        },
        set(newVal) {
            if ( val === newVal) {
                return;
            }
            val = newVal;
            dep.notify();
        },
    })
}