<script setup>
import { ref } from 'vue'

const message = ref('Hello Vue!')
const count = ref(0)
const user = ref({
  name: '张三',
  age: 20
})
</script>

<template>
  <div class="interpolation">
    <h2>双大括号插值</h2>
    <div class="example">
      <h3>基本插值</h3>
      <p>消息: {{ message }}</p>
      <input v-model="message" placeholder="修改消息">
    </div>

    <div class="example">
      <h3>表达式插值</h3>
      <p>计数: {{ count }}</p>
      <p>计数 + 1: {{ count + 1 }}</p>
      <p>计数的平方: {{ count * count }}</p>
      <button @click="count++">增加计数</button>
    </div>

    <div class="example">
      <h3>对象属性插值</h3>
      <p>姓名: {{ user.name }}</p>
      <p>年龄: {{ user.age }}</p>
    </div>
  </div>
</template>

<style scoped>
.interpolation {
  background: #f8f9fa;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 20px;
}

h2 {
  color: #333;
  margin-bottom: 15px;
  font-size: 1.2rem;
}

h3 {
  color: #667eea;
  margin-bottom: 10px;
  font-size: 1rem;
}

.example {
  margin-bottom: 15px;
  padding: 15px;
  background: white;
  border-radius: 6px;
  border: 1px solid #e0e0e0;
}

input {
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
  width: 100%;
  margin-top: 10px;
}

button {
  padding: 8px 16px;
  background: #667eea;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 0.9rem;
  cursor: pointer;
  margin-top: 10px;
  transition: background 0.3s;
}

button:hover {
  background: #5a6fd8;
}

p {
  margin: 5px 0;
  color: #555;
}
</style>
