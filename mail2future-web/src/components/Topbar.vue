<template>
  <div>
    <div id="nav">
      <el-menu :default-active="this.$router.path" class="el-menu-demo" mode="horizontal" router>
        <el-menu-item v-for="(item, index) in navList" :key="index" :index="item.path">
          {{ item.name }}
        </el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Topbar',
  data() {
    return {
      activeIndex: '1',
      navList: [
        {
          name: '📝 首页',
          path: '/'
        },
        {
          name: '💌 公开信',
          path: '/publicMailList'
        },  {
          name: '✅ 更新日志',
          path: '/updateLog'
        },
        {
          name: '🐣 关于',
          path: '/about'
        }
      ]
    }
  },
  created() {
    console.log('网站访问次数➕1')
  }
}
</script>

<style>
#nav {
  height: 80px;
  width: 1100px;
  margin: auto;
}

.el-menu-item {
  font-size: 16px;
}
</style>
