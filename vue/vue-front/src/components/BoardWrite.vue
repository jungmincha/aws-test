<template>
  <div>
    <table class="table" style="text-align:center; margin-left:auto; margin-right:auto;">
      <tr>
        <th>이름</th>
        <th><input class="col-sm-10" type="text" name="bname"value="" style="width: 700px;"/>
        </th>
      </tr>
      <tr>
        <th>제목</th>
        <th><input class="col-sm-10" type="text" name="btitle"value="" style="width: 700px;"/>
        </th>
      </tr>
      <tr>
        <th>내용</th>
        <th><textarea class="col-sm-10" name="bcontent"style="height:300px; width: 700px;"></textarea>
        </th>
      </tr>
      <tr>
        <th>
          <input type="submit" value="작성 완료"/>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardWrite"
}
</script>

<style scoped>

</style>
