<template>
  <div :class="{red: isRed}">
      <input type="checkbox" v-model="isRed">
  </div>
</template>

<script>
export default {
    data() {
        return {
            isRed: false
        }
    }

}
</script>

<style scoped>

* {
    box-sizing: border-box;
}

div {
    width: 50px;
    height: 50px;
    background-color: skyblue;
    display: inline-block;
}

.red {
    background-color: firebrick;
}


</style>