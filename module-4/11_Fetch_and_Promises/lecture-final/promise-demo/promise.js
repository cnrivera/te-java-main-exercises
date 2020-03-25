
function sayHello() {
    console.log('Hello');
}

function cheer() {
    console.log('Hooray!');
}

function cry() {
    console.log('Boo hoo...');
}

function resolveNow(resolve, reject) {
    resolve();
}

function rejectNow(resolve, reject) {
    reject();
}

function resolveSoon(resolve, reject) {
    setTimeout(resolve, Math.random() * 10000);
}

function resolveLater(resolve, reject) {
    setTimeout(resolve, 10000);
}

function fiftyFifty(resolve, reject) {
    let f = (Math.random() > 0.5)? resolve : reject;
    setTimeout(f, 5000);
}

//let p = new Promise(fiftyFifty);
//p.then(cheer).catch(cry);