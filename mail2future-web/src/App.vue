<template>
  <div id="app">
    <Topbar></Topbar>
    <div style="width: 1100px; margin: 20px auto;">
      <router-view/>
    </div>
  </div>
</template>

<script>
import Topbar from './components/Topbar'

export default {
  name: 'App',
  components: {
    Topbar
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  height: 100%;
  width: 100%;
  padding: 0 0;
  margin: 0 0;
  /*background: url("https://bing.wilii.cn/OneDrive/bingimages/2022/03/26//YellowCrocuses_ZH-CN6617862337_1920x1080.jpg");*/
}
</style>
