<template>
  <div id="header">
    <strong id="title">BookLibrary</strong>
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--the place for your starting and relaxing!</h3>
    <router-link to="/home">home&nbsp;|</router-link>
    <router-link to="/login">&nbsp;login&nbsp;|</router-link>
    <router-link to="/register">&nbsp;register&nbsp;|</router-link>
    <router-link to="/library">&nbsp;aboutUs</router-link>
  </div>
  <br>
  <router-view></router-view>
</template>
<script>

</script>
<style>
  #header{
    margin-top: -400px;
  }
  #title{
    color: #00aeff;
    font-size: 50px;
  }
</style>
