<template>
  <div id="leftBar">
    <el-tabs :tab-position="tabPosition" style="height: 300px" class="demo-tabs">
      <el-tab-pane label="图书馆信息设置">
        <div id="systemOption">
          <div id="libraryTable">
            <el-table style="width: 100%" border :data="tableData">
              <el-table-column prop="address" label="address" width="180" />
              <el-table-column prop="director" label="director" width="180" />
              <el-table-column prop="establishmentTime" label="establishmentTime" width="180" />
              <el-table-column prop="lname" label="lname" width="180" />
              <el-table-column prop="phoneNumber" label="phoneNumber" width="180" />
              <el-table-column align="right">
                <template #default="scope">
                  <el-button type="primary" size="small" @click="handleEdit1(scope.$index, scope.row)"
                  >修改</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="读者管理">
        <div id="readerManagement">
          <div id="readerTable">
            <el-table style="width: 100%" border :data="readerTableData">
              <el-table-column prop="rid" label="rId" width="180" />
              <el-table-column prop="account" label="director" width="180" />
              <el-table-column prop="password" label="establishmentTime" width="180" />
              <el-table-column prop="type" label="lname" width="180" />
              <el-table-column prop="borrowingTimes" label="borrowingTimes" width="180" />
              <el-table-column align="right">
                <template #default="scope">
                  <el-button type="primary" size="small" @click="handleEdit2(scope.$index, scope.row)"
                  >修改</el-button
                  >
                  <el-button
                      size="small"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)"
                  >删除</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="图书管理">
        <div id="BookManagement">
          <div id="bookTable">
            <el-table style="width: 100%" border :data="bookTableData">
              <el-table-column prop="bid" label="bId" width="180" />
              <el-table-column prop="bookName" label="bookName" width="180" />
              <el-table-column prop="isbn" label="ISBN" width="180" />
              <el-table-column prop="type" label="type" width="180" />
              <el-table-column prop="price" label="price" width="180" />
              <el-table-column prop="publisher" label="publisher" width="180" />
              <el-table-column align="right">
                <template #default="scope">
                  <el-button type="primary" size="small" @click="handleEdit3(scope.$index, scope.row)"
                  >修改</el-button
                  >
                  <el-button
                      size="small"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)"
                  >删除</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="图书借/还">
        <el-button type="success" size="small" @click="handleEdit4(scope.$index, scope.row)"
        >新增借阅</el-button
        >
        <div id="borrowReturnManagement">
          <div id="borrowReturnTable">
            <el-table style="width: 100%" border :data="borrowReturnTableData">
              <el-table-column prop="rbId" label="rbId" width="180" />
              <el-table-column prop="rid" label="rid" width="180" />
              <el-table-column prop="bid" label="bid" width="180" />
              <el-table-column align="right">
                <template #default="scope">
                  <el-button
                      size="small"
                      type="danger"
                      @click="handleDelete(scope.$index, scope.row)"
                  >还书</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="退出系统">
        <el-button type="danger" @click="logout()">
          登出
        </el-button>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";

axios.defaults.timeout = 5000;
axios.defaults.withCredentials = true;
axios.defaults.headers.post["Content-Type"] =
    "application/x-www-form-urlencoded;charset=UTF-8";
axios.defaults.baseURL = '/api';

export default {
  data(){
    return{
      tabPosition: 'left',
      tableData: [

      ],
      readerTableData: [

      ],
      bookTableData: [

      ],
      borrowReturnTableData: [

      ]
    };
  },
  methods:{
    logout(){
      router.push('home');
    },
    handleEdit2(index, row){
      console.log(index, row)
      axios.post('/reader?operate=updateReaderListById&rId=' + row.rid + "&account=" + row.account + "&password=" + row.password + "&type=" + row.type + "&borrowingTimes=" + row.borrowingTimes,{

      }).then(res=>{
        console.log(res.data.data.data)
        this.readerTableData = res.data.data.data
      }).finally(()=>{

      })
    },
    handleDelete(){

    }
  },
  mounted() {
    console.log("创建0")
    axios.get('/library?operate=getLibraryInfo',{

    }).then(res=>{
      console.log(res.data.data.data)
      this.tableData = res.data.data.data
    }).finally(()=>{

    })

    console.log("创建1")
    axios.get('/reader?operate=queryReaderList',{

    }).then(res=>{
      console.log(res.data.data.data)
      this.readerTableData = res.data.data.data
    }).finally(()=>{

    })

    console.log("创建2")
    axios.get('/book?operate=getBookList',{

    }).then(res=>{
      console.log(res.data.data.data)
      this.bookTableData = res.data.data.data
    }).finally(()=>{

    })

    console.log("创建3")
    axios.get('/rb?operate=getRBList',{

    }).then(res=>{
      console.log(res.data.data.data)
      this.borrowReturnTableData = res.data.data.data
    }).finally(()=>{

    })
  }
};

</script>

<style>
  .demo-tabs > .el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;
    height: 100%;
  }

  .el-tabs--right .el-tabs__content,
  .el-tabs--left .el-tabs__content {
    height: 1500px;
  }
  .el-table {
    height: 100%;
  }
</style>