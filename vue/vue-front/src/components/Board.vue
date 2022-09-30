<template>
  <div>
    <br>
    <div style="margin-right:1400px ;">
      <router-link to="/board/write">글 작성</router-link>
    </div>
    <br/>
    <br/>
    <el-table
      :data="bbsList"
      style="width: auto;"
      border
    >
<!--      <el-table-column property="bid" label="번호">-->
<!--      </el-table-column>-->
      <el-table-column property="bname" label="이름">
      </el-table-column>
      <el-table-column property="bcontent" label="제목">
      </el-table-column>
      <el-table-column property="bcontent" label="내용">
      </el-table-column>
      <el-table-column property="bdate" label="작성시간">
      </el-table-column>
    </el-table>
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
        '/api/native-query/board',
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
