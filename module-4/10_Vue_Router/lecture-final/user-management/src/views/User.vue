<template>
  <div>
    <h1>User</h1>
    <div v-if="user === null">Loading...</div>
    <pre>{{ user }}</pre>
  </div>
</template>

<script>
import UserService from '@/service/UserService';

export default {
    data() {
        return {
            user: null
        }
    },
    created() {
        let userId = this.$route.params.id;
        UserService.get(userId)
            .then(apiUser => this.user = apiUser);
    }

};
</script>

<style>
</style>