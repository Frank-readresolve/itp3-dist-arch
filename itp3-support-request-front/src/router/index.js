import { createRouter, createWebHistory } from 'vue-router'
import RequestForm from '../components/RequestForm.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
        path: '/',
        name: 'RequestForm',
        component: RequestForm
    },
  ]
})

export default router
