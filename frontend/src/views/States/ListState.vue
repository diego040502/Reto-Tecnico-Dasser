<template>
    <!---BARRA DE NAVEGACION-->

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

    <!--LISTA DE USUARIOS-->
    <h4 class="text-primary my-4">Status List</h4>
    <table class="table table-bordered table-light my-4 mx-auto w-75">
        <thead class="table-primary">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">State</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="state in states" :key="state.id">
                <td>{{ state.id }}</td>
                <td>{{ state.state }}</td>
                <td>
                    <button class="btn btn-primary btn-sm mx-1">Update</button>
                    <button class="btn btn-danger btn-sm mx-1">Delete</button>
                </td>
            </tr>
        </tbody>
    </table>

</template>

<script>
const axios = require('axios');
const baseURL = 'http://localhost:8080';
    export default {
        data(){
            return{
                states: []
            };
        },
        mounted(){
            axios.get(baseURL + '/state/states')
            .then(res => {
                this.states = res.data;
            })
            .catch(error => {
                console.error("Error al obtener los estados", error);
            });
        }
    }
</script>