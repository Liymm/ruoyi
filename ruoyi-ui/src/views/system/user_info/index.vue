<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="uuid" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入uuid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="userPhone">
        <el-input
          v-model="queryParams.userPhone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="userEmail">
        <el-input
          v-model="queryParams.userEmail"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="序列号" prop="clientSn">
        <el-input
          v-model="queryParams.clientSn"
          placeholder="请输入手机序列号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="下拉选择" prop="whiteList">
                <el-select v-model="queryParams.whiteList" placeholder="测试人员" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in typeWhite" :key="index" :label="item.label"
                    :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>

      <el-form-item label="手机系统" prop="clientType">
                <el-select v-model="queryParams.clientType" placeholder="登录系统" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in typeSwitch" :key="index" :label="item.label"
                    :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
      
      <el-form-item label="用户状态" prop="deleteNum">
                <el-select v-model="queryParams.deleteNum" placeholder="用户封禁状态" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in typeOptions" :key="index" :label="item.label"
                    :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:user_info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:user_info:edit']"
        >修改</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:user_info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:user_info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="user_infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" :selectable='checkboxT' />
      <el-table-column label="用户唯一标识" align="center" prop="uuid" />
      <el-table-column label="手机号" align="center" :show-overflow-tooltip="true" prop="userPhone" />
      <el-table-column label="邮箱" min-width=“120” :show-overflow-tooltip="true" align="center" prop="userEmail" />
      <el-table-column label="当前用户的app版本" align="center" prop="appVersion" />
      <el-table-column label="当前登录的手机名字" :show-overflow-tooltip="true" align="center" prop="phoneName" />
      <el-table-column label="手机序列号" min-width=“120” :show-overflow-tooltip="true" align="center" prop="clientSn" />
      <el-table-column label="表示ios或android登录" align="center" prop="clientType" />
      <el-table-column label="手机型号+手机版本号" min-width=“120” :show-overflow-tooltip="true" align="center" prop="phoneModel" />
      <el-table-column label="注册来源" min-width=“120” :show-overflow-tooltip="true" align="center" prop="userSource" />
      <el-table-column label="登录时间" min-width=“120” :show-overflow-tooltip="true" align="center" prop="loginDatetime" />
      <!-- <el-table-column label="第三方登录来源" min-width=“120” :show-overflow-tooltip="true" align="center" prop="flag" />
      <el-table-column label="第三方登录的授权码" min-width=“120” :show-overflow-tooltip="true" align="center" prop="accessToken" /> -->
      <el-table-column label="国家" align="center" prop="country" />
      <el-table-column label="测试人员" align="center" prop="whiteList" >
        <template slot-scope="scope">
        <p v-if="scope.row.whiteList == 1">测试人员</p>
        <p v-else></p>
      </template>
      </el-table-column>
      <el-table-column label="医疗显示" min-width=“120” :show-overflow-tooltip="true" align="center" prop="switchDisplay">

         <template slot-scope="scope">
          <p v-if="scope.row.deleteNum == 2">已注销</p>
          <p v-else>
          <p v-if="scope.row.switchDisplay == null || scope.row.deleteNum == 2 "></p>
            <!-- {{scope.row.mg_state}}  slot-scope 作用域插槽 scope.row 可以获取当前所在行的数据 -->
            <!-- 开关 0是开启、1是关闭  -->
            <el-switch v-else
            @change="changeSwitch($event,scope.row)" 
            :active-value="1"
            :inactive-value="0" 
            v-model="scope.row.switchDisplay">
            </el-switch>
          </p>
          </template>
          
      </el-table-column>

      <el-table-column label="用户状态" align="center" prop="deleteNum" >
        
        <template slot-scope="scope">
          <p v-if="scope.row.deleteNum == 2">已注销</p>
            <!-- {{scope.row.mg_state}}  slot-scope 作用域插槽 scope.row 可以获取当前所在行的数据 -->
            <!-- 开关 0是开启、1是关闭  -->
            <el-switch v-else
            @change="change($event,scope.row)" 
            :active-value="0"
            :inactive-value="1" 
            v-model="scope.row.deleteNum">
            </el-switch>
          </template>

      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <p v-if="scope.row.deleteNum == 2"></p>
          <el-button v-else
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:user_info:edit']"
          >修改</el-button>

          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:user_info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户数据表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="白名单" prop="whiteList">
          <el-select v-model="form.whiteList" placeholder="非测试人员" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in typeWhite" :key="index" :label="item.label"
                    :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    
    <el-dialog append-to-body :visible.sync="onOpen" @close="onClose" title="验证身份">
      <template slot-scope="scope">
      <el-form ref="pwd" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-row type="flex" justify="center" align="middle">
          <el-col :span="10">
            <el-form-item label="密码" prop="password">
              <el-input v-model="formData.password" placeholder="请输入密码" clearable show-password
                :style="{width: '100%'}"></el-input>
                <p v-show='show'></p>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </template>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handleConfirm">确定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
import { listUser_info, getUser_info, delUser_info, addUser_info, updateUser_info } from "@/api/system/user_info";
import Bus from "@/Bus";
export default {
  inheritAttrs: false,
  
  components: {},
  props: [],
  name: "User_info",
  data() {
    return {
      typeWhite:[{
        "label": "非测试人员",
          "value": 0
      }, {
          "label": "测试人员",
          "value": 1
        }],
        typeSwitch:[{
        "label": "iOS",
          "value": "iOS"
      }, {
          "label": "android",
          "value": "android"
        }],
      typeOptions: [{
          "label": "启用",
          "value": 0
        }, {
          "label": "封号",
          "value": 1
        }, {
          "label": "已注销",
          "value": 2
        }],
      show:null,
      pwd:{},
      formData: {
        password: undefined,
      },
      rules: {
        password: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }],
      },
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户数据表表格数据
      user_infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,

      onOpen: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uuid: null,
        userPhone: null,
        userEmail: null,
        appVersion: null,
        phoneName: null,
        clientSn: null,
        clientType: null,
        phoneModel: null,
        userSource: null,
        loginDatetime: null,
        flag: null,
        accessToken: null,
        country: null,
        whiteList:null,
        switchDisplay:null,
        deleteNum: null
      },
      // 表单参数
      form: {},
      // 表单校验
    };
  },
  created() {
    this.getList();
  },
  methods: {
    //禁用复选框
    checkboxT(row){
      if(row.deleteNum===2){
        return false;
      }else{
        return true;
      }
    },
    onOpen() {},
    onClose() {
      this.onOpen = false;
      this.res();
    },
    close() {
      this.onOpen = false;
      this.res();
    },
    changeSwitch(index,usersInfo){
      usersInfo.switchDisplay=index;
      updateUser_info(usersInfo)
    },
    change(index,usersInfo){
      console.log(index);
      console.log(usersInfo);
      usersInfo.deleteNum=index;
      updateUser_info(usersInfo)
    },
    /** 查询用户数据表列表 */
    getList() {
      this.loading = true;
      listUser_info(this.queryParams).then(response => {
        this.user_infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        pid: null,
        uuid: null,
        userPhone: null,
        userEmail: null,
        userPwd: null,
        appVersion: null,
        phoneName: null,
        clientSn: null,
        clientType: null,
        phoneModel: null,
        userSource: null,
        loginDatetime: null,
        flag: null,
        accessToken: null,
        country: null,
        selectType: null,
        deleteNum: null
      };
      this.resetForm("form");
    },
    res(){
      this.formData={
        password:null
      };
      this.resetForm("pwd");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.pid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户数据表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pid = row.pid || this.ids
      getUser_info(pid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户数据表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.pid != null) {
            updateUser_info(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUser_info(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    handleConfirm() {
      // console.log(this.formData.password);
      this.$refs['pwd'].validate(valid => {
       
        // let pwd=this.formData.password;
        
        if (valid){
          if(this.formData.password==='123'){
          
          Bus.$on('handleDelete',(data)=>{this.show=data})
          // console.log(this.show)
          const pids =this.show;
          this.$modal.confirm('是否确认删除当前用户？').then(function() {
            return delUser_info(pids);
          }).then(() => {
            this.getList();
            this.$modal.msgSuccess("删除成功");
          }).catch(() => {});
          this.close();
          
          // console.log("111") 
        }else{
          this.$modal.confirm('密码错误,删除失败');
          return this.close();
        }
        }
        else {
          return this.close();
      } 
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.show=row.pid;
      Bus.$emit('handleDelete',this.show);
      this.onOpen = true;
      

      // const pids = row.pid || this.ids;
      // this.$modal.confirm('是否确认删除编号为"' + pids + '"的用户吗？').then(function() {
      //   return delUser_info(pids);
      // }).then(() => {
      //   this.getList();
      //   this.$modal.msgSuccess("删除成功");
      // }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/user_info/export', {
        ...this.queryParams
      }, `user_info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
