import Vue, {computed} from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Board from '@/components/Board'
import BoardWrite from '@/components/BoardWrite'
import Login from '@/components/Login'
import store from "../store";
import {mapGetters} from "vuex";

Vue.use(Router)

//경로 인증 유무 함수
const requireAuth = (to, from, next) => {
  //로그인 상태 mapGetter로 가져오기
  let isLogin = store.getters.isLogin
  if (isLogin === false) {
    console.log('Login Please!');
    console.log('isLogin', isLogin)
    //로그인이 되어 있지 않으면 /login 페이지로 강제 이동
    return next('/login');
  } else {
    console.log('isLogin', isLogin)
    console.log("routing success : '" + to.path + "'");
    // 로그인이 되어 있으면 화면 전환 성공...!
    next();
  }
}
//로그인이 되어 있으면 접근 불가 함수
const loginPage = (to, from, next) => {
  //로그인 상태 mapGetter로 가져오기
  console.log('안녕하세요...')
  let isLogin = store.getters.isLogin
  if (isLogin === true) {
    console.log('you are aleady login!');
    console.log('isLogin', isLogin)
    return next('/');
  } else {
    console.log('isLogin', isLogin)
    console.log("routing success : '" + to.path + "'");
    next();
  }
}

//경로 제어 중앙소
const router = new Router(

  {

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
      component: BoardWrite,
      beforeEnter: requireAuth
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      beforeEnter: loginPage
    }
  ]
})

export default router
