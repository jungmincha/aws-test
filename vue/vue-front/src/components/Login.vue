<template>
  <div>
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
        <el-button type="primary" @click="login('ruleForm')">로그인</el-button>
        <el-button @click="resetForm('ruleForm')">회원가입</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
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
  created() {
    this.init()
  },
  methods: {
    init() {
      console.log(this.$store.state.allUsers)
    },
    login() {
      axios.post('/api/authenticate', {
        username: this.ruleForm.username,
        password: this.ruleForm.password
      })
        .then(res => {
          console.log(res)
          if(res !== null) {
            this.$store.commit('setToken', res)
            this.$router.push('/')
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>

</style>
