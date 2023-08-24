import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

window.axios = require('axios')
import sw from 'sweetalert';
window.Sweet = sw;
createApp(App).use(router).mount('#app')
