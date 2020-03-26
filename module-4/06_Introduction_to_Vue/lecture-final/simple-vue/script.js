console.log('Hello!');


const myVue = new Vue({
    data: {
        greeting: 'Howdy!',
        students: ['Angie', 'Zach', 'Matt'],
        newStudent: ''
    }
});
myVue.$mount('#myVueApp');