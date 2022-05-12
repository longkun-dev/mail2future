import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import PublicMailList from '@/views/PublicMailList'
import UpdateLog from '@/views/UpdateLog'
import About from '@/views/About'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '首页',
      component: Index
    },
    {
      path: '/publicMailList',
      name: '/公开信',
      component: PublicMailList
    },    {
      path: '/updateLog',
      name: '/更新日志',
      component: UpdateLog
    },
    {
      path: '/about',
      name: '/关于',
      component: About
    }
  ]
})
