<template>
  <div id="libraryTable">
    <el-table style="width: 100%" border :data="tableData">
      <el-table-column prop="address" label="address" width="180" />
      <el-table-column prop="director" label="director" width="180" />
      <el-table-column prop="establishmentTime" label="establishmentTime" width="180" />
      <el-table-column prop="lname" label="lname" width="180" />
      <el-table-column prop="phoneNumber" label="phoneNumber" width="180" />
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
  data(){
    return{
      tableData: [

      ]
    };
  },
  methods:{

  },
  mounted() {
    console.log("创建了")
    axios.get('/library?operate=getLibraryInfo',{

    }).then(res=>{
      console.log(res.data.data.data)
      this.tableData = res.data.data.data
    }).finally(()=>{

    })
  }
};
</script>

<style>

</style>