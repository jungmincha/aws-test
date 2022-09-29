<template>
<h3>안녕하세요</h3>

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
      const { data: res } = await axios.get('/jpa/board')

      if (res.code !== 'S' || res.data === null) return

      console.log('res', res)

      this.bbsList = res.data.content
    }
  }
}
</script>

<style scoped>

</style>
