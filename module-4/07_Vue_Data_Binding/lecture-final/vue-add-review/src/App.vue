<template>
  <div id="app">
    <add-review/>
    <grow-box v-for="i in 10" :key="'gb' + i"/>
    <br/>
    <switch-box v-for="n in 500" :key="'sb' + n"/>
  </div>
</template>

<script>
import AddReview from './components/AddReview.vue';
import SwitchBox from './components/SwitchBox.vue';
import GrowBox from './components/GrowBox.vue';


export default {
  name: 'app',
  components: {
    AddReview,
    SwitchBox,
    GrowBox
  }
}
</script>

<style>
</style>
