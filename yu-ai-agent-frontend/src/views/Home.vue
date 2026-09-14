<template>
  <div class="home-container">
    <div class="header">
      <div class="glitch-wrapper">
        <h1 class="glitch-title">彭古AI超级智能体</h1>
      </div>
      <p class="subtitle">/ 探索AI的无限可能 /</p>
      <div class="cyber-line"></div>
    </div>
    
    <div class="apps-container">
      <div class="app-card" @click="navigateTo('/love-master')">
        <div class="card-glow"></div>
        <div class="app-icon love-icon">🛡️</div>
        <div class="app-info">
          <div class="app-title">AI保险规划专家</div>
          <div class="app-desc">智能保险规划师，为你排查家庭与个人风险</div>
        </div>
        <div class="app-button">
          <span class="btn-text">立即体验</span>
          <span class="btn-icon">→</span>
        </div>
      </div>
      
      <div class="app-card" @click="navigateTo('/super-agent')">
        <div class="card-glow"></div>
        <div class="app-icon robot-icon">🤖</div>
        <div class="app-info">
          <div class="app-title">AI超级智能体</div>
          <div class="app-desc">全能型AI助手，解决各类专业问题</div>
        </div>
        <div class="app-button">
          <span class="btn-text">立即体验</span>
          <span class="btn-icon">→</span>
        </div>
      </div>
    </div>
    
    <div class="cyber-circles">
      <div class="circle circle-1"></div>
      <div class="circle circle-2"></div>
      <div class="circle circle-3"></div>
    </div>
    
    <AppFooter />
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { useHead } from '@vueuse/head'
import AppFooter from '../components/AppFooter.vue'

// 设置页面标题和元数据
useHead({
  title: '彭古AI超级智能体应用平台 - 首页',
  meta: [
    {
      name: 'description',
      content: '彭古AI超级智能体应用平台提供AI保险规划专家和AI超级智能体服务，满足您的各种AI对话需求'
    },
    {
      name: 'keywords',
      content: 'AI智能体,AI应用,AI保险规划专家,AI助手,智能对话,彭古,AI超级智能体,首页'
    }
  ]
})

const router = useRouter()

const navigateTo = (path) => {
  router.push(path)
}
</script>

<style scoped>
.home-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background-color: #f7f7f7;
  position: relative;
  overflow: hidden;
}

.header {
  padding: 60px 20px 40px;
  text-align: center;
  background: linear-gradient(180deg, #fff5ee 0%, #f7f7f7 100%);
  position: relative;
  z-index: 2;
}

.glitch-wrapper {
  position: relative;
  display: inline-block;
  margin-bottom: 16px;
}

.glitch-title {
  font-size: 2.4rem;
  font-weight: 600;
  color: #333;
  letter-spacing: 1px;
  position: relative;
}

.glitch-title::before,
.glitch-title::after {
  display: none;
}

.subtitle {
  font-size: 1rem;
  color: #666;
  max-width: 600px;
  margin: 0 auto 24px;
  letter-spacing: 2px;
}

.cyber-line {
  height: 3px;
  width: 60px;
  margin: 0 auto;
  background: linear-gradient(180deg, #ffb72d 0%, #fe6917 100%);
  border-radius: 2px;
  position: relative;
}

.cyber-line::before,
.cyber-line::after {
  display: none;
}

.apps-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 32px;
  max-width: 1200px;
  margin: 48px auto;
  padding: 0 20px;
  flex: 1;
  position: relative;
  z-index: 2;
}

.app-card {
  width: 360px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 16px rgba(0, 0, 0, 0.06);
  padding: 36px 32px;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
  overflow: hidden;
  border: 1px solid #eee;
}

.card-glow {
  display: none;
}

.app-card:hover {
  transform: translateY(-6px);
  box-shadow: 0 8px 28px rgba(254, 105, 23, 0.15);
  border-color: rgba(254, 105, 23, 0.3);
}

.app-icon {
  font-size: 2.8rem;
  margin-bottom: 24px;
  width: 80px;
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  position: relative;
  z-index: 1;
}

.love-icon {
  background: linear-gradient(180deg, #ffb72d 0%, #fe6917 100%);
  box-shadow: 0 4px 16px rgba(254, 105, 23, 0.25);
}

.robot-icon {
  background: linear-gradient(180deg, #4a9cf0 0%, #1a6dd4 100%);
  box-shadow: 0 4px 16px rgba(26, 109, 212, 0.25);
}

.app-info {
  text-align: center;
  margin-bottom: 28px;
  width: 100%;
}

.app-title {
  font-size: 1.25rem;
  font-weight: 600;
  color: #333;
  margin-bottom: 10px;
}

.app-desc {
  font-size: 0.95rem;
  color: #666;
  line-height: 1.7;
}

.app-button {
  background: linear-gradient(180deg, #ffb72d 0%, #fe6917 100%);
  color: #fff;
  padding: 10px 32px;
  border-radius: 22px;
  font-weight: 500;
  font-size: 0.95rem;
  transition: all 0.3s;
  margin-top: auto;
  display: flex;
  align-items: center;
  position: relative;
  overflow: hidden;
  border: none;
}

.app-button::before {
  display: none;
}

.app-button:hover {
  background: linear-gradient(180deg, #ffc44d 0%, #ee5400 100%);
  box-shadow: 0 4px 12px rgba(254, 105, 23, 0.35);
}

.btn-text {
  margin-right: 6px;
}

.btn-icon {
  font-size: 1rem;
  transition: transform 0.3s;
}

.app-button:hover .btn-icon {
  transform: translateX(3px);
}

.cyber-circles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  z-index: 1;
  pointer-events: none;
}

.circle {
  position: absolute;
  border-radius: 50%;
  opacity: 0.06;
}

.circle-1 {
  width: 400px;
  height: 400px;
  top: -120px;
  right: -80px;
  background: #fe6917;
}

.circle-2 {
  width: 300px;
  height: 300px;
  bottom: -100px;
  left: -80px;
  background: #1a6dd4;
}

.circle-3 {
  width: 200px;
  height: 200px;
  top: 50%;
  right: 10%;
  background: #ffb72d;
}

@media (max-width: 768px) {
  .glitch-title {
    font-size: 2rem;
  }

  .subtitle {
    font-size: 0.95rem;
  }

  .apps-container {
    gap: 24px;
    margin: 36px auto;
  }

  .app-card {
    width: 100%;
    max-width: 420px;
    padding: 28px 24px;
  }

  .app-icon {
    font-size: 2.4rem;
    width: 72px;
    height: 72px;
  }
}

@media (max-width: 480px) {
  .header {
    padding: 40px 15px 32px;
  }

  .glitch-title {
    font-size: 1.6rem;
  }

  .subtitle {
    font-size: 0.875rem;
    letter-spacing: 1px;
  }

  .apps-container {
    margin: 24px auto;
    padding: 0 15px;
  }

  .app-card {
    padding: 24px 20px;
  }

  .app-icon {
    font-size: 2rem;
    margin-bottom: 20px;
    width: 64px;
    height: 64px;
  }

  .app-title {
    font-size: 1.125rem;
  }

  .app-desc {
    font-size: 0.875rem;
  }
}
</style> 