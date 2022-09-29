<template>
  <div>
    <h3>안녕하세요</h3>
      <div v-for="i in bbsList">
        {{ i.bname }}
        {{ i.btitle }}
        {{ i.bcontent }}
        {{ i.bdate }}
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "Board",

  data() {
    return {
      bbsList: {}
    }
  },
  async created() {
    console.log('success!')
    await this.init()
  },
  methods: {
    async init() {
      const { data: res } = await axios.post('/api/jpa/board', {
        page: 0,
        size: 10
      })

      console.log('res', res)

      this.bbsList = res.data.content
    }
  }
}
</script>

<style scoped>

</style>
