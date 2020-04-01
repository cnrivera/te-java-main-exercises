<template>
  <div class="colorBox" :style="{backgroundColor: color}">
      <slot>No Content Provided</slot>
  </div>
</template>

<script>
export default {
    props: {
        color: String
    }

}
</script>

<style scoped>

div.colorBox {
    width: 300px;
    height: 300px;
}

</style>