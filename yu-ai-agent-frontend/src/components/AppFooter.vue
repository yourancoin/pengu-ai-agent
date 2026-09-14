<template>
  <footer class="app-footer">
    <div class="footer-content">
      <div class="footer-section">
        <div class="footer-logo">
          <h3>彭古AI超级智能体应用平台</h3>
        </div>
        <div class="footer-links">
          <span>《用户协议》</span>
          <span>《隐私政策》</span>
        </div>
      </div>

      <div class="footer-section">
        <h4>友情链接</h4>
        <div class="footer-links">
          <a href="https://www.baidu.com" target="_blank">百度一下</a>
        </div>
      </div>

      <div class="footer-section">
        <h4>联系我们</h4>
        <div class="footer-links">
          <span>商务合作</span>
          <span>站长：彭古</span>
        </div>
      </div>
    </div>
    
    <div class="footer-bottom">
      <p>© {{ currentYear }} 彭古AI超级智能体应用平台 - 让AI为你服务</p>
    </div>
  </footer>
</template>

<script setup>
import { computed } from 'vue'

// 计算当前年份
const currentYear = computed(() => new Date().getFullYear())
</script>

<style scoped>
.app-footer {
  background-color: #333;
  padding: 48px 0 0;
  color: #ccc;
  width: 100%;
  margin-top: auto;
  position: relative;
  z-index: 2;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 0 20px;
}

.footer-section {
  flex: 1;
  min-width: 200px;
  margin-bottom: 30px;
  padding: 0 15px;
}

.footer-logo h3 {
  font-size: 1.125rem;
  margin-bottom: 16px;
  color: #fff;
  font-weight: 600;
}

.footer-section h4 {
  font-size: 0.95rem;
  margin-bottom: 16px;
  color: #fff;
  font-weight: 500;
  position: relative;
  padding-bottom: 8px;
}

.footer-section h4::after {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  width: 24px;
  height: 2px;
  background: linear-gradient(180deg, #ffb72d 0%, #fe6917 100%);
  border-radius: 1px;
}

.footer-links {
  display: flex;
  flex-direction: column;
}

.footer-links a,
.footer-links span {
  margin-bottom: 10px;
  color: #aaa;
  text-decoration: none;
  transition: color 0.2s;
  font-size: 0.9rem;
}

.footer-links a:hover {
  color: #fe6917;
}

.qrcode {
  display: flex;
  align-items: center;
}

.qrcode-container {
  text-align: center;
}

.qrcode-placeholder {
  width: 90px;
  height: 90px;
  background-color: #f5f5f5;
  margin: 0 auto 10px;
  border-radius: 4px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2rem;
}

.qrcode-placeholder:after {
  content: '🤖';
}

.footer-bottom {
  text-align: center;
  padding: 20px 0;
  margin-top: 12px;
  border-top: 1px solid #444;
  color: #888;
  font-size: 0.85rem;
  background-color: #2a2a2a;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .footer-content {
    flex-direction: column;
  }
  
  .footer-section {
    width: 100%;
    margin-bottom: 20px;
    padding: 0;
  }
}

@media (max-width: 480px) {
  .app-footer {
    padding: 30px 0 15px;
  }
  
  .footer-section h4 {
    font-size: 0.95rem;
  }
  
  .footer-links a {
    font-size: 0.9rem;
  }
  
  .qrcode-placeholder {
    width: 80px;
    height: 80px;
  }
}
</style> 