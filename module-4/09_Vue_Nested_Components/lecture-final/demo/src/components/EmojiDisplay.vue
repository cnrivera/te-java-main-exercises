<template>
  <div v-show="visible">
      <span v-for="n in count" :key="n">{{ emojifiedWord }}</span>
  </div>
</template>

<script>
import emoji from 'node-emoji';

export default {
    props: {
        word: String,
        visible: {
          type: Boolean,
          default: true
        },
        count: {
          type: Number,
          default: 1
        }
    },
    computed: {
        emojifiedWord() {
            return emoji.get(this.word);
        }
    }

}
</script>

<style scoped>

div {
    font-size: 3em;
}

</style>