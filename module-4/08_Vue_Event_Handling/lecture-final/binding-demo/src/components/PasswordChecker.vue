<template>
  <div>
      <input type="password" v-model="password"/>
      <div v-if="password.length > 0" class="red">
        <p v-if="password.length < 8">Must be at least 8 characters.</p>
        <p v-if="!password.match(/[0-9]/)">Must contain a number.</p>
        <p v-if="!password.match(/[$%#@]/)">Must contain a symbol.</p>
      </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            password: ''
        }
    }

}
</script>

<style>
.red {
    color: red;
}
</style>