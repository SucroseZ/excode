<template>
  <ToDoHeader @addTodo="addTodo" />
  <ToDoMain :list="showList" @delTodo="delTodo"/>
  <ToDoFooter :lastLength="lastLength"  :status="status" @updateStatus="updateStatus" />
</template>

<script setup>
import ToDoHeader from './components/ToDoHeader.vue'
import ToDoFooter from './components/ToDoFooter.vue'
import ToDoMain from './components/ToDoMain.vue'

import { ref,computed} from 'vue'
const list = ref([
{ id: 1, name: '晨练', done: false, },
{ id: 2, name: '练书法', done: true, }, 
])
const addTodo=(name)=>{
  // 将待输入的待办事项添加到list数组中
  list.value.push({name,done:false,id:~~(Math.random()*1000)})
}

const delTodo=(id)=>{
  // 删除list数组中id为id的项
  list.value=list.value.filter(item=>item.id!==id)
}

// 计算未完成任务的数量
const lastLength=computed(()=>{
  return list.value.filter(item => !item.done).length
})

const status = ref('all')
const showList = computed(()=>{
  if(status.value==='all'){
    return list.value
  }else if(status.value==='active'){
    return list.value.filter(item=>!item.done)
  }else if(status.value==='completed'){
    return list.value.filter(item=>item.done)
  }
})

const updateStatus = (status1) => {
  status.value = status1   // 将子组件的状态赋值给父组件
}

</script>