import Vue from 'vue'
import Router from 'vue-router';
import Users from '@/views/Users';
import User from '@/views/User';

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/users',
      name: 'UserList',
      component: Users
    },
    {
      path: '/user/:id',
      name: 'UserDetails',
      component: User
    },
    {
      path: '*',
      redirect: {name: 'UserList'}
    }

  ]
})
