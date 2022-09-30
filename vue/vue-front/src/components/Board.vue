<template>
  <div>
    <h3 style="text-align:center; padding-top:100px;">{{ projectVersion }}</h3>
    <br>
    <br>
    <div style="margin-right:1400px ;">
      <router-link to="/board/write">글 작성</router-link>
    </div>
    <br/>
    <br/>
    <table class="table" style="text-align:center; width: 60%; margin-left:auto; margin-right:auto;">
      <thead>
      <tr>
        <th class="col-sm-1">번호</th>
        <th class="col-sm-2">이름</th>
        <th class="col-sm-3">제목</th>
        <th class="col-sm-4">내용</th>
        <th class="col-sm-3">작성시간</th>
      </tr>
      </thead>
      <tr v-for="i in bbsList">
        <th>{{ i.bid }}</th>
        <th>{{ i.bname }}</th>
        <th>
          <a>{{ i.bcontent }}</a>
        </th>
        <th>{{ i.bcontent }}</th>
        <th>{{ i.bdate }}</th>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "Board",

  data() {
    return {
      projectVersion: '게시판 목록v.12',
      bbsList: {}
    }
  },
  async created() {
    console.log('success!')
    await this.init()
  },
  methods: {
    async init() {
      await axios.post(
        '/api/jpa/board',
        {
                page: 0,
                size: 10
            }
      ).then(res => {
        console.log('res', res)
        this.bbsList = res.data.data.content
        }
      ).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>

</style>
