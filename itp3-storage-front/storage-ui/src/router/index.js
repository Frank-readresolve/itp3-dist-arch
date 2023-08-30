import { createRouter, createWebHistory } from 'vue-router'
import StorageForm from '../components/StorageForm.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
        path: '/',
        name: 'StorageForm',
        component: StorageForm
    },
  ]
})

export default router
