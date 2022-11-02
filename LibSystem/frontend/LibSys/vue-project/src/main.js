import { createApp } from 'vue'
import App from './App.vue';
import router from "@/router";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'

import './assets/main.css'

axios.defaults.baseURL = "/api";//api用于后面跨域前缀

createApp(App).use(ElementPlus).use(router).provide('$axios', axios).mount('#app')
