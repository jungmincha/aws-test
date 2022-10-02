import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Board from '@/components/Board'
import BoardWrite from '@/components/BoardWrite'
import Login from '@/components/Login'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/board',
      name: 'Board',
      component: Board
    },
    {
      path: '/board/write',
      name: 'BoardWrite',
      component: BoardWrite
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
export default router
