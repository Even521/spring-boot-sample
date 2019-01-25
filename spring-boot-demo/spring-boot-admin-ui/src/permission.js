import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { Message } from 'element-ui'
import { getToken } from '@/utils/auth'
import {buildMenus} from './api/menu' // 验权
import { filterAsyncRouter } from './store/modules/permission'

const whiteList = ['/login'] // 不重定向白名单
router.beforeEach((to, from, next) => {
  NProgress.start()//开始进度条
  if (getToken()) {
    if (to.path === '/login') {
      next({ path: '/' })
      NProgress.done() // if current page is dashboard will not trigger	afterEach hook, so manually handle it
    } else {

      //判断当前用户是否获得用户信息
      console.log(store.dispatch('GetInfo'))
      //console.log(data.authorities.length)
      if (store.getters.roles.length === 0) {
        store.dispatch('GetInfo').then(res => { // 拉取用户信息
          //获取菜单树
          buildMenus().then(res=>{
            //异步请求
            const asyncRouter = filterAsyncRouter(res.data)
            asyncRouter.push({ path: '*', redirect: '/404', hidden: true })
            store.dispatch('GenerateRoutes', asyncRouter).then(() => { // 存储路由
              router.addRoutes(asyncRouter) // 动态添加可访问路由表
              next({ ...to, replace: true })// hack方法 确保addRoutes已完成
            })
          })
        }).catch((err) => {
          store.dispatch('FedLogOut').then(() => {
            Message.error(err || 'Verification failed, please login again')
            next({ path: '/' })
          })
        })
      } else {
        next()
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/login?redirect=${to.path}`) // 否则全部重定向到登录页
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done() // 结束Progress
})
