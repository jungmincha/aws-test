<template>
  <div>
    <br>
    <br>
    <div>
    <h2>로그인 / 회원가입 {{ isLogin }} </h2>
    </div>
    <br>
    <br>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="이메일" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="비밀번호" prop="password">
        <el-input type="password" v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login(ruleForm)">로그인</el-button>
        <el-button @click="resetForm('ruleForm')">회원가입</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions, mapGetters } from 'vuex'
import router from "../router";
export default {
  name: "Login",
  data(){
    return {
      ruleForm: {
        username: '',
        password: ''
      }
    }
  },
  computed: {
    ...mapGetters({
      isLogin: "isLogin"
    })
  },
  created() {
    console.log('로그인 페이지...')
    console.log(this.isLogin)
    this.init()
  },
  methods: {
    //...mapActions(['login'])
    init() {
      // if (this.isLogin === true) {
      //   console.log('you are aleady login!');
      //   console.log('isLogin', this.isLogin)
      //   return this.$router.push('/');
      // } else {
      //   console.log('isLogin', this.isLogin)
      // }
    },
    login() {
      axios
        .post('/api/authenticate', this.ruleForm)
        .then(res => {
          let token = res.data.token
          localStorage.setItem('token', token)
          this.$store.dispatch('getMemberInfo')
        }).then(() => {
        router.push('/')
      })
        .catch(err => {
          alert('이메일과 비밀번호를 확인하세요.')
          console.log(err)
        })

    },
  }
}
</script>

<style scoped>

</style>
