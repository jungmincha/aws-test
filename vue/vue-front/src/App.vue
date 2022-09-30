<template>
  <div id="app">
    <el-container>
      <el-header
        style="
        line-height: 50px;
        text-align: center;
        border-radius: 4px;
        background-color: white;
        position: relative; z-index: 2;
        position:fixed;
        width:100%;
        top:0px;
        left:0;
        ">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">

            <el-menu-item index="1">
            <router-link to="/">
           아쿠아마린 🐳
            </router-link>
            </el-menu-item>

          <el-menu-item index="2">클래스 🏄‍♀️</el-menu-item>
<!--          <el-submenu index="3">-->
<!--            <template slot="title">상품</template>-->
<!--            <el-menu-item index="3-1">item one</el-menu-item>-->
<!--            <el-menu-item index="3-2">item two</el-menu-item>-->
<!--            <el-menu-item index="3-3">item three</el-menu-item>-->
<!--            <el-submenu index="3-4">-->
<!--              <template slot="title">item four</template>-->
<!--              <el-menu-item index="3-4-1">item one</el-menu-item>-->
<!--              <el-menu-item index="3-4-2">item two</el-menu-item>-->
<!--              <el-menu-item index="3-4-3">item three</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--          <el-menu-item index="4" disabled>Info</el-menu-item>-->
          <el-menu-item index="5"><router-link to="/board">자유 게시판 👨‍👨‍👧‍👧</router-link></el-menu-item>
          <el-menu-item index="6">로그인</el-menu-item>
        </el-menu>
        <div class="line"></div>

      </el-header>
      <el-main>
        <br>
        <br>
        <router-view/>
      </el-main>
      <el-footer>
        <div class='wrapCopyrightText'>
          <span class='copyrightText'>
            Copyright ©2022 AquaMarine Co., 대표자: 차정민
          </span>
        </div>
      </el-footer>
    </el-container>
<!--    <img src="./assets/logo.png">-->
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      activeIndex: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style>

/*el-header {*/
/*  !* background-color: #B3C0D1; *!*/
/*  !* color: #333; *!*/
/*  line-height: 20px;*/
/*  text-align: left;*/
/*  border-radius: 4px;*/
/*  background-color: white;*/
/*  position: relative; z-index: 2;*/
/*  position:fixed;*/
/*  width:100%;*/
/*  top:0;*/
/*  left:0;*/
/*}*/

/*router-link는 a라고 인식한다*/
a {
  text-decoration: none;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.copyrightText{
  position: center;
  font-size: 0.7rem;
  color: white;
}


.wrapCopyrightText{
  background-color: paleturquoise;
  height: 5rem;
  display: flex;
  justify-content: center;
  align-items: center;

}


#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
