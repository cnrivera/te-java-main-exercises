<template>
  <div>
      <h1>Users</h1>
      <table>
          <tr v-for="user in allUsers" :key="user.id">
              <td>{{ user.id }}</td>
              <td>{{ user.name }}</td>
              <td><button @click="$router.push({name: 'UserDetails', params: {id: user.id}})">Details</button></td>
          </tr>
      </table>
  </div>
</template>

<script>
import UserService from '@/service/UserService';

export default {
    data() {
        return {
            allUsers: []
        }
    },
    created() {
        UserService.list()
            .then(users => this.allUsers = users);
    }

}
</script>

<style>

</style>