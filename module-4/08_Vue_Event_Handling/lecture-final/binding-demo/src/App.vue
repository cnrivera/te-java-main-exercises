<template>
  <div id="app">
    <dessert-menu></dessert-menu>
    <password-checker/>
  </div>
</template>

<script>
import DessertMenu from './components/DessertMenu.vue';
import PasswordChecker from './components/PasswordChecker.vue';

export default {
  name: 'app',
  components: {
    DessertMenu,
    PasswordChecker
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
