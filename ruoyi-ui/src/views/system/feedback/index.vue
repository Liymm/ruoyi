<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="主键" prop="fid">
        <el-input
          v-model="queryParams.fid"
          placeholder="请输入主键"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="uuid号" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入uuid号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="app版本" prop="appVersion">
        <el-input
          v-model="queryParams.appVersion"
          placeholder="请输入app版本"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="反馈上传的图片路径" prop="filePath">
        <el-input
          v-model="queryParams.filePath"
          placeholder="请输入反馈上传的图片路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发表时间" prop="issueTime">
        <el-input
          v-model="queryParams.issueTime"
          placeholder="请输入发表时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作系统" prop="phoneModel">
        <el-input
          v-model="queryParams.phoneModel"
          placeholder="请输入操作系统"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['system:feedback:add']"
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
          v-hasPermi="['system:feedback:edit']"
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
          v-hasPermi="['system:feedback:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:feedback:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="feedbackList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="uuid" align="center" prop="uuid" />
      <el-table-column label="手机类型" align="center" prop="clientType" />
      <el-table-column label="操作系统" align="center" prop="phoneModel" />
      <el-table-column label="app版本" align="center" prop="appVersion" />
      <el-table-column label="反馈内容" align="center" :show-overflow-tooltip="true" prop="content" />
      <el-table-column label="图片路径" align="center" prop="filePaths" width="100">
        <template slot-scope="scope">
          <p v-if="scope.row.filePaths !=null"> 
          <!-- <span v-for="item in scope.row.filePaths.spilt(',')">
          {{item}}
        </span> -->
        <!-- <p v-for="item in scope.row.filePaths"></p> -->
        <image-preview  :src="'http://39.108.163.169:8080'+scope.row.filePaths" :width="50" :height="50"/>
        <!-- <image-preview :src="'http://39.108.163.169:8080'+scope.row.filePaths" :width="50" :height="50"/> -->
        </p>
        <p v-else></p>
        </template>
      </el-table-column>
      <el-table-column label="发表时间" align="center" prop="issueTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:feedback:edit']"
          >修改</el-button> -->
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:feedback:remove']"
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

    <!-- 添加或修改意见反馈对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFeedback, getFeedback, delFeedback, addFeedback, updateFeedback } from "@/api/system/feedback";

export default {
  name: "Feedback",
  data() {
    return {
      // photo: feedbackList.filePaths,
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
      // 意见反馈表格数据
      feedbackList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fid: null,
        uuid: null,
        clientType: null,
        appVersion: null,
        content: null,
        filePaths: null,
        issueTime: null,
        phoneModel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        uuid: [
          { required: true, message: "用户唯一标识不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询意见反馈列表 */
    getList() {
      this.loading = true;
      listFeedback(this.queryParams).then(response => {
        this.feedbackList = response.rows;
        var str=this.feedbackList
        // console.log("photo:"+photo)
        console.log("str:"+str)
        var sss='a.jpeg,b.jpeg,c.jpeg'
        var nstr=sss.split(',')
        console.log(nstr)
        // console.log(sss.spilt(','))
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
        fid: null,
        uuid: null,
        clientType: null,
        appVersion: null,
        content: null,
        filePaths: null,
        issueTime: null,
        phoneModel: null
      };
      this.resetForm("form");
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
      this.ids = selection.map(item => item.fid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加意见反馈";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const fid = row.fid || this.ids
      getFeedback(fid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改意见反馈";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.fid != null) {
            updateFeedback(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFeedback(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const fids = row.fid || this.ids;
      this.$modal.confirm('是否确认删除当前意见反馈？').then(function() {
        return delFeedback(fids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/feedback/export', {
        ...this.queryParams
      }, `feedback_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
