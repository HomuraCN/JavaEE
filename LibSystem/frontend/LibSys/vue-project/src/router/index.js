import {createRouter, createWebHashHistory} from 'vue-router';

import Login from '../views/Login.vue';
import Home from '../views/Home.vue';
import Library from "@/views/Library.vue";
import Management from "@/views/Management.vue";

const routes = [
    {path: '/', redirect: '/login'},
    {path: '/login', component: Login},
    {path: '/home', name: 'home', component: Home},
    {path: '/library', name: 'library', component: Library},
    {path: '/management', name: 'management', component: Management},
];

const router = new createRouter({
    history: createWebHashHistory(),
    routes
});

export default router;