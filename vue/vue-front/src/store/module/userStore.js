// //유저 관리 스토어
// const userStore = {
//   state: {//data
//     userInfo: null,
//     accessToken: '',
//     isLogin: false,
//     isLoginError: false
//   },
//   mutations: { //state 값을 변화시켜 준다.
//     //로그인이 성공 했을 때
//     loginSuccess(state, payload, token) {
//       state.isLogin = true
//       state.isLoginError = false
//       state.accessToken = token
//       state.userInfo = payload
//       console.log('loginSuccess mutation')
//       console.log(state.isLogin)
//     },
//     loginError(state) {
//       state.isLogin = false
//       state.isLoginError = true
//     },
//     logout(state) {
//       console.log('logout')
//       localStorage.removeItem('token')
//       state.isLogin = false
//       state.isLoginError = false
//       state.userInfo = false
//     }
//   },
//   actions: {
//     //유저 정보 얻어오기
//     getMemberInfo({ commit }) {
//       let token = localStorage.getItem("token")
//       let config = {
//         token: token
//       }
//       axios
//         .post('/api/authenticate/getUserInfo', config)
//         .then(response => {
//           let userInfo = {
//             username: response.data.username,
//             nickname: response.data.nickname,
//             authorityName: response.data.authorityName
//           }
//           console.log('login 성공했을 때...')
//           console.log(userInfo)
//           commit('loginSuccess', userInfo, token)
//         })
//         .catch(error => {
//           console.log(error)
//         })
//     }
//   },
//   getters: { //computed 역할
//     getToken: state => {
//       return state.accessToken
//     },
//     isLogin: state => {
//       console.log('getters state', state.isLogin)
//       return state.isLogin
//     },
//     getUserInfo: state => {
//       return state.userInfo
//     }
//   }
// }
// export default userStore
