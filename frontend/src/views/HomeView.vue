<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container-fluid">
      <a class="navbar-brand text-white" href="#">Reto Técnico Dasser</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link class="text-white mx-4" to="/">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white mx-4" to="/admin/user/add">Users</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white mx-4" to="/admin/user/list">Users List</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white mx-4" to="/admin/state/add">States</router-link>
          </li>
          <li class="nav-item">
            <router-link class="text-white mx-4" to="/admin/state/list">Status List</router-link>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>

  <!--WELCOME PAGE-->
  
</template>

<script>

export default {
  name: 'HomeView',
  components: {
  }
}
</script>
