<template>
  <div class="hello">
    <br>
    <div v-if="isLogin">{{ userInfo.nickname }} 환영합니다.</div>
    사이트 버전 1.1
    <img src="https://pbs.twimg.com/media/E0rpfQ4UUAY1_ja.jpg"></img>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { mapMutations } from 'vuex' //실행해주는 함수니까 method 내에 정의

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  created() {
    console.log('isLogin', this.isLogin)
    console.log('userInfo', this.userInfo)
  },
  computed: {
    ...mapGetters({
      userInfo: 'getUserInfo',
      isLogin: 'isLogin'
    })
  },
  methods: {
    // ...mapMutations(['addUser']),
    // submitForm() {
    //   console.log('submitForm')
    //   const reqObj = this.ruleForm
    //   this.$store.commit('addUser', reqObj)
    // }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
