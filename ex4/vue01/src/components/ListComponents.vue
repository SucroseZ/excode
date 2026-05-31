<script setup>
import { reactive, ref} from 'vue'

const items = reactive([
  { id: 1, text: '学习Vue基础' },
  { id: 2, text: '掌握组件化开发' },
  { id: 3, text: '学习响应式原理' },
  { id: 4, text: '构建完整应用' }
])

const newItem = ref('')

function addItem() {  
  if (newItem.value.trim() === '') 
    return
  
  items.push({
    // 生成唯一ID
    id: Date.now(),
    text: newItem.value.trim()
  })
  // 清空输入框
  newItem.value = ''
}

function removeItem(id) {
  // 过滤出不包含指定ID的项
  // 并将结果赋值给 items
  const index = items.findIndex(item => item.id === id);
  if (index !== -1) {
    items.splice(index, 1);
  }
}
</script>

<template>
  <div class="list-component">
    <h2>列表渲染</h2>
    
    <div class="example">
      <h3>任务列表</h3>
      <ul>
        <li v-for="item in items" :key="item.id">
          {{ item.text }}
          <button @click="removeItem(item.id)" class="remove-btn">删除</button>
        </li>
      </ul>
    </div>
    
    <div class="example">
      <h3>添加新任务</h3>
      <div class="add-form">
        <!-- 输入新任务 -->
        <!-- 按钮实现添加新任务 -->
        <input type="text"
          v-model="newItem"
          placeholder="输入新任务..."
          @keyup.enter="addItem"
        />
        <button @click="addItem">添加</button>
      </div>
    </div>
    
    <div class="example">
      <h3>列表信息</h3>
      <p>当前任务数量: {{ items.length }}</p>
      <p v-show="items.length === 0">暂无任务</p>
    </div>
  </div>
</template>

<style scoped>
.list-component {
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

ul {
  list-style: none;
}

li {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border-bottom: 1px solid #e0e0e0;
  transition: background 0.2s;
}

li:hover {
  background: #f5f5f5;
}

li:last-child {
  border-bottom: none;
}

.remove-btn {
  padding: 4px 8px;
  background: #f44336;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 0.8rem;
  cursor: pointer;
  transition: background 0.3s;
}

.remove-btn:hover {
  background: #d32f2f;
}

.add-form {
  display: flex;
  gap: 10px;
}

input {
  flex: 1;
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
  outline: none;
  transition: border-color 0.3s;
}

input:focus {
  border-color: #667eea;
}

button {
  padding: 8px 16px;
  background: #667eea;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 0.9rem;
  cursor: pointer;
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
