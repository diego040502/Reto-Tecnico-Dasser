<template>
  <div id="app">
  </div>
  
  <div>

  </div>

  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>
  const axios = require("axios");

  export default {
    data(){
      return {
        baseURL: 'http//localhost:8080',
        users: null,
        states: null
      }
    },
    components: {},
    methods: {
      async fetchData(){
        //Get users
        await axios.get(this.baseURL + '/users/')
          .then(res => this.users = res.data)
          .catch(err => console.log(err))

        //Get States
        await axios.get(this.baseURL + '/states/')
          .then(res => this.states = res.data)
          .catch(err => console.log(err))
      }
      
    },
    mounted(){
      this.fetchData();
    }
  }
</script>
