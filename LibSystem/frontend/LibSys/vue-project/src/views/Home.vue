<template>
  <div id="searchBar">
    <p id="homeTitle">Search</p>
  </div>
  <div id="form">
    <el-form :model="searchFormInfo" :rules="searchFormRules" ref="searchForm">
      <el-select v-model="value" class="m-2" placeholder="searchBy" size="small">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
        />
      </el-select>

      <el-form-item label="" prop="info">
        <el-input
            v-model="searchFormInfo.info"
            placeholder="Please input info"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit('searchForm')">search</el-button>
      </el-form-item>
    </el-form>
  </div>
  <br>
  <div id="bookTable">
    <el-table style="width: 100%" border :data="tableData">
      <el-table-column prop="bid" label="bId" width="180" />
      <el-table-column prop="isbn" label="ISBN" width="180" />
      <el-table-column prop="type" label="type" width="180" />
      <el-table-column prop="price" label="price" width="180" />
      <el-table-column prop="publisher" label="publisher" width="180" />
      <el-table-column prop="bookName" label="bookName" width="180" />
    </el-table>
  </div>

</template>
<script>
import axios from "axios";

axios.defaults.timeout = 5000;
axios.defaults.withCredentials = true;
axios.defaults.headers.post["Content-Type"] =
    "application/x-www-form-urlencoded;charset=UTF-8";
axios.defaults.baseURL = '/api';

export default {
  data() {
    return {
      value: '',
      options: [
        {
          value: 'bookName',
          label: 'bookName',
        },
        {
          value: 'ISBN',
          label: 'ISBN',
        },
        {
          value: 'publisher',
          label: 'publisher',
        },
        {
          value: 'type',
          label: 'type',
        },
      ],
      searchFormInfo: {
        info: "",
      },
      searchFormRules: {
        account: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
// 表格数据
      tableData: [

      ]
    };
  },
  methods: {
    onSubmit(searchForm) {
      this.$refs[searchForm].validate((valid) => {
        if (valid) {
          axios.get('/book?operate=getBookByBookName&searchBy=' + this.value + "&info=" + this.searchFormInfo.info,{

          }).then(res=>{
            console.log("这是res.data.data.data")
            console.log(res.data.data.data)
            this.tableData = res.data.data.data
          }).finally(()=>{
            console.log("完成")
            console.log(this.value + " " + this.searchFormInfo.info)
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
  },
};
</script>
<style>
  #searchBar{
    margin-top: -250px;
    color: #00aeff;
  }
  #homeTitle{
    font-size: 25px;
  }
</style>
