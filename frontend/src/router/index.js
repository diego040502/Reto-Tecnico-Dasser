import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddUser from '../views/Users/AddUser.vue'
import AddState from '../views/States/AddState.vue'
import ListUser from '../views/Users/ListUser.vue'
import ListState from '../views/States/ListState.vue'
import EditUser from '../views/Users/EditUser.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/admin/user/add',
    name: 'AddUser',
    component: AddUser
  },
  {
    path: '/admin/state/add',
    name: 'AddState',
    component: AddState
  },
  {
    path: '/admin/user/list',
    name: 'ListUser',
    component: ListUser
  },
  {
    path: '/admin/state/list',
    name: 'ListState',
    component: ListState
  },
  {
    path: '/admin/user/:id',
    name: 'EditUser',
    component: EditUser,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
