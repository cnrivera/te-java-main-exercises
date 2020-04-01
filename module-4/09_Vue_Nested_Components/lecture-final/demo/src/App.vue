<template>
  <div id="app">
    
    <hello-world :msg="textFromHelloChild" @child-input="textFromHelloChild = $event"/>
    <emoji-display word="beer" :count="beerCount"/>
    <simple-counter :value="beerCount" @input="beerCount = $event"/>
    <emoji-display word="pizza" :count="pizzaCount"/>
    <simple-counter v-model="pizzaCount"/>
    <color-box color="lavender">
      <simple-counter v-model="cakeCount"/>
      <emoji-display word="cake" :count="cakeCount"/>
    </color-box>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue';
import EmojiDisplay from '@/components/EmojiDisplay';
import SimpleCounter from '@/components/SimpleCounter';
import ColorBox from '@/components/ColorBox';

export default {
  name: 'App',
  components: {
    HelloWorld,
    EmojiDisplay,
    SimpleCounter,
    ColorBox
  },
  data() {
    return {
      textFromHelloChild: '',
      beerCount: 1,
      pizzaCount: 1,
      cakeCount: 0
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
