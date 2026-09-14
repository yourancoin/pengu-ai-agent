import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue'),
    meta: {
      title: '首页 - 彭古AI超级智能体应用平台',
      description: '彭古AI超级智能体应用平台提供AI保险规划专家和AI超级智能体服务，满足您的各种AI对话需求'
    }
  },
  {
    path: '/love-master',
    name: 'LoveMaster',
    component: () => import('../views/LoveMaster.vue'),
    meta: {
      title: 'AI保险规划专家 - 彭古AI超级智能体应用平台',
      description: 'AI保险规划专家是彭古AI超级智能体应用平台的专业保险规划师，为你排查家庭与个人风险，提供保险建议'
    }
  },
  {
    path: '/super-agent',
    name: 'SuperAgent',
    component: () => import('../views/SuperAgent.vue'),
    meta: {
      title: 'AI超级智能体 - 彭古AI超级智能体应用平台',
      description: 'AI超级智能体是彭古AI超级智能体应用平台的全能助手，能解答各类专业问题，提供精准建议和解决方案'
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 全局导航守卫，设置文档标题
router.beforeEach((to, from, next) => {
  // 设置页面标题
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

export default router 