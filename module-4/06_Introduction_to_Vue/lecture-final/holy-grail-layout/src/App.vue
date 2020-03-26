<template>
  <div id="app">
    <the-header class="my-header"/>
    <left-sidebar/>
    <article>Article</article>
    <aside class="sidebar-right">Right Sidebar</aside>
    <the-footer/>
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';
import LeftSidebar from './components/LeftSidebar.vue';

export default {
  name: "app",
  components: {
    TheHeader,
    TheFooter,
    LeftSidebar
  }
};
</script>

<style>
body {
  margin: 0px;
  padding: 0px;
}
#app {
  display: grid;
  grid-template-columns: 150px auto 150px;
  grid-template-rows: 60px 1fr 100px;
  grid-gap: 1em;
  height: 100vh;
}

header,
aside,
article,
footer {
  background: #eaeaea;
  padding: 1em;
  color: #949494;
}

.my-header,
footer {
  grid-column: 1 / 4;
}
</style>