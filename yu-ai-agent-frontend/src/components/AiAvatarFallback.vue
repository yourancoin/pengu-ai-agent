<template>
  <div class="ai-avatar-fallback" :class="type">
    <span v-if="type === 'love'">🛡️</span>
    <span v-else>🤖</span>
  </div>
</template>

<script setup>
defineProps({
  type: {
    type: String,
    default: 'default'
  }
})
</script>

<style scoped>
.ai-avatar-fallback {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 18px;
  border-radius: 50%;
}

.love {
  background: linear-gradient(180deg, #ffb72d 0%, #fe6917 100%);
}

.default, .super {
  background: linear-gradient(180deg, #4a9cf0 0%, #1a6dd4 100%);
}
</style> 