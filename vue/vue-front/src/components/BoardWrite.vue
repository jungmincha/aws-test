<template>
  <div>
    <br>
    <br>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="이름" prop="bname">
        <el-input v-model="ruleForm.bname"></el-input>
      </el-form-item>
      <el-form-item label="제목" prop="btitle">
        <el-input v-model="ruleForm.btitle"></el-input>
      </el-form-item>
      <el-form-item label="내용" prop="bcontent">
        <el-input type="textarea" v-model="ruleForm.bcontent"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">작성</el-button>
        <el-button @click="resetForm('ruleForm')">초기화</el-button>
        <el-button @click="gotoList">목록으로</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "BoardWrite",
  data() {
    return {
      userInfo: {
        loginStat: false
      },
      ruleForm: {
        btitle: '',
        bname: '',
        bcontent: ''
      },
      rules: {
        btitle: [
          { required: true, message: 'Please input Activity name', trigger: 'blur' },
        ],
        bname: [
          { required: true, message: 'Please input Activity name', trigger: 'blur' }
        ],
        bcontent: [
          { required: true, message: 'Please input activity name', trigger: 'blur' }
        ]
      }
    };
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      console.log(this.$store.state.allUsers)
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //alert('submit!')
          axios.post('/api/board/write', {
            btitle: this.ruleForm.btitle,
            bname: this.ruleForm.bname,
            bcontent: this.ruleForm.bcontent
          }).then(res => {
            alert('작성 되었어요 :)')
            console.log(res)
            this.$router.push('/board')
          }).catch(err => {
            console.log('error' + err)
          })
        } else {
          console.log('error submit!!')
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    gotoList() {
      this.$router.push('/board')
    },
  }
}
</script>

<style scoped>

</style>
