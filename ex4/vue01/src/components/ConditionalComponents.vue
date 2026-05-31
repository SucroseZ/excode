<script setup>
import { ref } from 'vue'

const isVisible = ref(true)
const score = ref(85)
const userType = ref('student')
</script>

<template>
  <div class="conditional-component">
    <h2>条件渲染</h2>
    
    <div class="example">
      <h3>v-if / v-else</h3>
      <!-- 按钮实现切换显示和隐藏内容 -->
      <button @click="isVisible = !isVisible">
        {{ isVisible ? 'v-if' : 'v-else' }} 内容
      </button>
      <div v-if="isVisible" >
        <p>v-if内容已经显示了</p>
      </div>
      <div v-else>
        <p>v-else内容已经显示了</p>
      </div>
    </div>
    
    <div class="example">
      <h3>v-else-if 多条件</h3>
      <!-- 输入框实现输入分数 -->
      <input type="number" v-model="score"><br/>
      <!-- 显示当前分数 -->
      <p>当前分数: {{ score }}</p>
      <!-- 根据成绩显示成绩等级 -->
      <div v-if="score >= 90" class="grade A">优秀</div>
      <div v-else-if="score >= 80" class="grade B">良好</div>
      <div v-else-if="score >= 70" class="grade C">中等</div>
      <div v-else-if="score >= 60" class="grade D">及格</div>
      <div v-else class="grade E">不及格</div>
    </div>
    
    <div class="example">
      <h3>v-show</h3>
      <button @click="isVisible = !isVisible">
        {{ isVisible ? '隐藏' : '显示' }} 内容 (v-show)
      </button>
      <div v-show="isVisible">
        <p>这段内容使用 v-show 显示</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.conditional-component {
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

button {
  padding: 8px 16px;
  background: #667eea;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 0.9rem;
  cursor: pointer;
  margin-bottom: 10px;
  transition: background 0.3s;
}

button:hover {
  background: #5a6fd8;
}


.grade {
  display: inline-block;
  padding: 4px 12px;
  border-radius: 12px;
  font-weight: 600;
  margin-top: 10px;
}

.grade.A {
  background: #e8f5e9;
  color: #2e7d32;
  border: 1px solid #c8e6c9;
}

.grade.B {
  background: #e3f2fd;
  color: #1565c0;
  border: 1px solid #bbdefb;
}

.grade.C {
  background: #fff3e0;
  color: #ef6c00;
  border: 1px solid #ffcc80;
}

.grade.D {
  background: #fff3e0;
  color: #ef0060;
  border: 1px solid #ba740c;
}

.grade.E {
  background: #ffebee;
  color: #c62828;
  border: 1px solid #ffcdd2;
}

p {
  margin: 5px 0;
  color: #555;
}
</style>
