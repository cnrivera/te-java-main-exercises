<template>
  <div id="app">
    <product-review />
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'

export default {
  name: 'App',
  components: {
    ProductReview
  }
}
</script>

<style>
#app {
  width: 800px;
  margin-left: auto;
  margin-right: auto;
}
</style>
