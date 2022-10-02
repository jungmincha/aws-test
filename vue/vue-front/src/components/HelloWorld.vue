<template>
  <div class="hello">
    <br>
    AllUsers {{ userCount }}
    JimmyCount {{ jimmyCount }}
    <el-form :model="ruleForm" ref="ruleForm" label-width="120px" class="demo-ruleForm">
    <el-input v-model = ruleForm.username></el-input>
      <el-input v-model = ruleForm.password></el-input>
      <el-button type="primary" @click="submitForm('ruleForm')">submit</el-button>
    </el-form>
    <router-link to="/board">
    <img src="https://pbs.twimg.com/media/E0rpfQ4UUAY1_ja.jpg"></img>
    </router-link>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { mapMutations } from 'vuex' //실행해주는 함수니까 method 내에 정의
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      ruleForm: {
        username: '',
        password: ''
      }
    }
  },
  computed: {
    ...mapGetters({
      userCount: "allUsersCount",
      jimmyCount: "findByJimmy",
      token: "getToken"
    })
  },
  created() {
    this.init()
  },
  methods: {
    // ...mapMutations(['addUser']),
    init() {
      console.log('success')
      console.log(this.token)
    },
    submitForm() {
      console.log('submitForm')
      const reqObj = this.ruleForm
      this.$store.commit('addUser', reqObj)
    }
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
