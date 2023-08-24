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

    <!---FORMULARIO DE REGISTRO DE ESTADOS-->

    <h4 class="text-primary my-4">Status Register</h4>
    <div class="container">
        <form action="" class="bg-light border border-primary rounded w-50 h-100 text-dark mx-auto">
            <div class="row">
                <div class="col">
                    <label for="state">Estado</label>
                    <input class="mx-2 my-4 border border-primary rounded" type="text" name="state" v-model="state"
                        required>
                </div>
            </div>
            <button class="btn btn-primary mx-auto my-3" type="button" @click="addState">Submit</button>
        </form>
    </div>
</template>

<script>
var axios = require('axios');
import sw from 'sweetalert'
export default {
    data() {
        return {
            estado: null,
        }
    },
    props: [],
    methods: {
        async addState() {
            const newState = {
                state: this.state,
            };

            const baseURL = 'http://localhost:8080';

            await axios({
                method: 'post',
                url: baseURL + '/state/save',
                data: JSON.stringify(newState),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(() => {
                    sw({
                        text: 'State register succesfully',
                        icon: 'success',
                        closeOnClickOutside: false,
                    })

                })
                .catch(err => console.log(err));
        }
    }
}
</script>

<style scoped>
h4 {
    font-family: 'Lato', sans-serif;
    font-weight: 700;
}
</style>