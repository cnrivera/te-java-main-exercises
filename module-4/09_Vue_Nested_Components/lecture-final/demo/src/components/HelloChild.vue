<template>
  <input type="text" v-model="inputValue" @input="sendText"/>
</template>

<script>
export default {
    data() {
        return {
            inputValue: ''
        }
    },
    methods: {
        sendText() {
            this.$emit('child-input', this.inputValue);
        }
    }

}
</script>

<style>

</style>