import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
import createPersistedState from 'vuex-persistedstate';
Vue.use(Vuex)

// 모듈은 나중에 분리
//import userStore from "./module/userStore";

const store = new Vuex.Store({
  //modules: userStore,
  //state를 localstorage에 저장
  plugins: [
    createPersistedState()
  ],
  state: {//data
    userInfo: null,
    accessToken: null,
    isLogin: false,
    isLoginError: false
  },
  mutations: { //state 값을 변화시켜 준다.
    //로그인이 성공 했을 때
    loginSuccess(state, payload) {
      let accessToken = payload.accessToken
      let userInfo = {
        username: payload.username,
        nickname: payload.nickname,
        authorityName: payload.authorityName
      }
      state.isLogin = true
      state.isLoginError = false
      state.accessToken = accessToken
      state.userInfo = userInfo
    },
    loginError(state) {
      state.isLogin = false
      state.isLoginError = true
    },
    logout(state) {
      console.log('logout')
      localStorage.removeItem('token')
      state.isLogin = false
      state.isLoginError = false
      state.userInfo = false
      state.accessToken= null
    }
  },
  actions: {
    //유저 정보 얻어오기
    getMemberInfo({ commit }) {
      let token = localStorage.getItem("token")
      let config = {
        token: token
      }
      axios
        .post('/api/authenticate/getUserInfo', config)
        .then(response => {
          let userInfo = {
            username: response.data.username,
            nickname: response.data.nickname,
            authorityName: response.data.authorityName,
            accessToken: token
          }
          //토큰 정보가 유효하면 state값을 변화시켜주는 mutations의 loginSuccess에 값을 넣어준다.
          commit('loginSuccess', userInfo)
        })
        .catch(error => {
          console.log(error)
          //토큰 정보가 유효하지 않으면 logout을 한다.
          commit('logout')
        })
    }
  },
  getters: { //computed 역할
    getToken: state => {
      return state.accessToken
    },
    isLogin: state => {
      return state.isLogin
    },
    getUserInfo: state => {
      return state.userInfo
    }
  }
});
export default store;
