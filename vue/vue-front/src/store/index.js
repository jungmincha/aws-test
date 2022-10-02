import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({

  state: {//data
    allUsers: [
      {username: 'tommy', password: '1q2w3e4r'},
      {username: 'jimmy', password: '1q2w3e4r'}
    ],
    getToken: ''
  },
  getters: { //computed 역할
    allUsersCount: state => { //allUsers의 숫자
      return state.allUsers.length
    },
    findByJimmy: state => { //allUsers 중 이름이 jimmy인 숫자
      let count = 0;
      state.allUsers.forEach(arr => {
        if(arr.username === 'jimmy') {
          count ++
        }
      })
      return count
    },
    getToken: state => {
      return state.getToken
    }
  },
  mutations: { //state 값을 변화시켜 준다.
    addUser: (state, payload) => {
      state.allUsers.push(payload)//payload를 넣어준다.
    },
    setToken: (state, payload) => {
      state.getToken = payload
    }
  },
  actions: {

  }
});
