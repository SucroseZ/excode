<template>
    <div class="header">
      <p class="title">待办事项</p>
      <input class="new-todo" type="text" placeholder="请填写任务" v-model.trim="name" @keyup.enter="enterName"/>
    </div>
</template>

<script setup>
import { ref } from 'vue'
const name=ref('')
const emit=defineEmits(['addTodo'])
const enterName=()=>{
  // 将待输入的待办事项传递给APP组件的list数组，之后将这一项渲染出来
  emit('addTodo',name.value)
  name.value=''
}
</script>

<style>
.header {
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
}

.title {
  margin: 0;
  font-size: 36px;
  font-weight: 400;
  text-align: center;
  color: #b83f45;
}

.new-todo {
  width: 93%;
  padding: 20px 10px 20px 50px;
  height: 20px;
  border: none;
  background: rgba(0, 0, 0, 0.003);
  box-shadow: inset 0 2px 1px rgba(0, 0, 0, 0.05);
}
</style>
