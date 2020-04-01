<template>
  <button @click="incrementCounter">{{ counterValue }}</button>
</template>

<script>
export default {
    props: {
        value: Number
    },
    data() {
        return {
            counterValue: this.value
        }
    },
    methods: {
        incrementCounter() {
            this.$emit('input', ++this.counterValue);
        }
    }
}
</script>

<style>

</style>