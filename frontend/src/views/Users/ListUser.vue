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
    <h4 class="text-primary my-4">Users List</h4>
    <hr>
    <h6 class="text-dark py-2 mx-auto">Search:</h6>
    <input class="mx-2 py-1 border border-primary rounded" type="text" name="filter-by-name" placeholder="Search...." v-model="searchUser">
    <button class="btn btn-primary mx-4" @click="searchGeneral">Search</button>
    <table class="table table-bordered table-light my-4 mx-auto">
        <thead class="table-primary">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Email</th>
                <th scope="col">Created</th>
                <th scope="col">Login</th>
                <th scope="col">Last Update</th>
                <th scope="col">Status</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <!--MUESTRA LOS USUARIOS EN LA TABLA-->
            <tr v-for="user in users" :key="user.id">
                <td>{{ user.id }}</td>
                <td>{{ user.nombres }}</td>
                <td>{{ user.apellidos }}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.created }}</td>
                <td>{{ user.login }}</td>
                <td>{{ user.lastUpdate }}</td>
                <td>{{ user.state_id.state }}</td>
                <td>
                    <button class="btn btn-primary btn-sm mx-1"><router-link 
                        :to="{name: 'EditUser', params: {id: user.id}}"
                        :users="users"
                    class="text-white text-decoration-none">Update</router-link></button>
                    <button class="btn btn-danger btn-sm mx-1" @click="deleteUser(user.id)">Delete</button>
                </td>
            </tr>
        </tbody>
    </table>
</template>

<script>
const axios = require('axios');
const baseURL = 'http://localhost:8080';
import sw from 'sweetalert';
    export default{
        data(){
            return{
                users:[],
                searchUsers: ''
            };
        },
        methods: {

            //Elimina un usuario
            deleteUser(userId){
                axios.delete(baseURL + `/user/delete/${userId}`)
                .then(() => {
                    this.users = this.users.filter(user => user.id !== userId);
                    sw({
                        text: 'User deleted succesfully',
                        icon: 'success',
                        closeOnClickOutside: false
                    });
                }).catch(err => console.error(err));
            },

            //Filtra por nombre de usuario
            searchUserByName() {
                axios.get(baseURL + `/user/findByName/${this.searchUser}`)
                .then(res => {
                    if (res.data) {
                    this.users = [res.data];
                    } else {
                    this.users = [];
                    }
                })
            .catch(error => {
                console.error("Error al filtrar el usuario", error);
            });
            },

            //Filtra por estado del usuario
            searchUserByStatus(){
                axios.get(baseURL + `/user/findByStatus/${this.searchUser}`)
                .then(res => {
                    if(res.data){
                        this.users = [res.data];
                    }else{
                        this.users = [];
                    }
                })
                .catch(error => {
                    console.error("Error al filtrar usuario", error);
                });
            },

            //Filtra por login
            searchUserByLogin(){
                axios.get(baseURL + `/user/findByLogin/${this.searchUser}`)
                .then(res => {
                    if(res.data){
                        this.users = [res.data];
                    }else{
                        this.users = [];
                    }
                })
                .catch(error => {
                    console.error("Error al filtrar usuario", error);
                });
            },

            //Funcion contenedora de búsqueda
              searchGeneral(){
                this.searchUserByName();
                this.searchUserByStatus();
                this.searchUserByLogin();
            }



        },

        //Solicitud get para obtener los usuarios
        mounted(){
            axios.get(baseURL + '/user/users')
            .then(res => {
                this.users = res.data;
            })
            .catch(error => {
                console.error("Error al obtener los usuarios", error);
            });
        }
    }
</script>

<style scoped>
    td{
        font-size: 12px;
    }
</style>