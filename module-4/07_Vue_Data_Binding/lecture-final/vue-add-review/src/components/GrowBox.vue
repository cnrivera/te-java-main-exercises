<template>
  <div :style="divStyle">
      <input type="text" v-model.lazy="size">
  </div>
</template>

<script>
export default {
    data() {
        return {
            size: 100
        }
    },
    computed: {
        divStyle() {
            return {
                width: this.size + 'px',
                height: this.size + 'px'
            }
        }
    }

}
</script>

<style scoped>

* {
    box-sizing: border-box;
}

div {
    background-color: gold;
    border: 1px solid black;
    display: inline-block;
}

input {
    margin-top: 40px;
    width: 100%;
}

</style>