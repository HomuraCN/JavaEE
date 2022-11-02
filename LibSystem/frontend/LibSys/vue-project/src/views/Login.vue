<template>
  <el-card>
    <div id="formDiv">
      <el-form :model="loginFormInfo" :rules="loginFormRules" ref="loginForm">
        <el-form-item label="账号" prop="account">
          <el-input
            v-model="loginFormInfo.account"
            placeholder="Please input account"
          />
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="loginFormInfo.password"
            placeholder="Please input password"
          />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit('loginForm')"
            >登录</el-button
          >
          <el-button type="info" @click="test()">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>
<script>

import axios from "axios";
import router from "@/router";

axios.defaults.timeout = 5000;
// 允许跨域
axios.defaults.withCredentials = true;
// Content-Type 响应头
axios.defaults.headers.post["Content-Type"] =
    "application/x-www-form-urlencoded;charset=UTF-8";
// 基础url
axios.defaults.baseURL = '/api'; //注意此处一定要和vite设置的请求名一致

export default {
  data() {
    return {
      loginFormInfo: {
        account: "",
        password: "",
      },
      loginFormRules: {
        account: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  methods: {
    onSubmit(loginForm) {
      this.$refs[loginForm].validate((valid) => {
        if (valid) {
          axios.post('/login?operate=login&account=' + this.loginFormInfo.account + "&password=" + this.loginFormInfo.password,{

          }).then(res=>{
            console.log(res.data.data.code)
            if(res.data.data.code === 200){
              console.log("此时应跳转")
              router.push('management');
            }
          }).finally(()=>{
            console.log(this.loginFormInfo.account + " " + this.loginFormInfo.password)
          })
        } else {
          this.$message({
            message: "",
            type: "",
          });
          return false;
        }
      });
    },
    test(){

    }
  },
};
</script>
<style>
  #formDiv {
    width: 400px;
    border-radius: 30px;
    margin: 0 auto;
    padding: 15px 35px 15px 35px;
  }
</style>
