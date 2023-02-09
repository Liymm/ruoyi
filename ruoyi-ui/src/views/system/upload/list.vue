<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目号" prop="projectNum">
        <el-input
          v-model="queryParams.projectNum"
          placeholder="请输入项目号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="版本号" prop="versionNum">
        <el-input
          v-model="queryParams.versionNum"
          placeholder="请输入版本号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      
      <el-form-item label="日期" prop="creatDate">
        <el-date-picker clearable
          v-model="queryParams.creatDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
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
          v-hasPermi="['system:inspackage:add']"
        >新增</el-button>
      </el-col> -->

      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="dialogFormVisibleAdd = true"
        >上传</el-button>
      </el-col>


      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:inspackage:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:inspackage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:inspackage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="inspackageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目号" align="center" prop="projectNum" />
      <el-table-column label="版本号" align="center" prop="versionNum" />
      <el-table-column min-width=“120” :show-overflow-tooltip="true" label="文件名称" align="center" prop="fileName" />
      <el-table-column min-width=“120” :show-overflow-tooltip="true" label="文件路径" align="center" prop="virtualPath" />
      <el-table-column min-width=“120” :show-overflow-tooltip="true" label="描述" align="center" prop="content" />
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="添加日期" align="center" prop="creatDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="条件" align="center" prop="conditionNum">

        <template slot-scope="scope">
            <!-- {{scope.row.mg_state}}  slot-scope 作用域插槽 scope.row 可以获取当前所在行的数据 -->
            <!-- 开关 0是开启、1是关闭  -->
            <el-switch 
            @change="change($event,scope.row)" 
            :active-value="0"
            :inactive-value="1" 
            v-model="scope.row.conditionNum">
            </el-switch>
          </template>

      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:inspackage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:inspackage:remove']"
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

    <el-dialog v-bind="$attrs" :visible.sync="dialogFormVisibleAdd" v-on="$listeners" @open="onOpen" @close="onClose" title="上传文件">
        <el-row :gutter="15">
          <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="190px">
            <el-col :span="13">
              <el-form-item label="项目号" prop="project_num">
                <el-input v-model="formData.project_num" placeholder="请输入项目号" clearable
                  :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="13">
              <el-form-item label="版本号" prop="version_num">
                <el-input v-model="formData.version_num" placeholder="请输入版本号" clearable
                  :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="13">
              <el-form-item label="下拉选择" prop="type">
                <el-select v-model="formData.type" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
                  <el-option v-for="(item, index) in typeOptions" :key="index" :label="item.label"
                    :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="15">
              <el-form-item label="描述" prop="content">
                <el-input v-model="formData.content" type="textarea" placeholder="请输入描述"
                  :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
              </el-form-item>
            </el-col>
            <!-- <el-col :span="13">
              <el-form-item label="日期选择" prop="creat_date">
                <el-date-picker v-model="formData.creat_date" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                  :style="{width: '100%'}" placeholder="请选择日期选择" clearable></el-date-picker>
              </el-form-item>
            </el-col> -->
            <el-col :span="24">
              <el-form-item label="上传" prop="file_name">

                <!-- <el-upload ref="file_name" :file-list="file_namefileList" :action="file_nameAction" multiple
                  :before-upload="file_nameBeforeUpload" list-type="picture" accept="image/*" name="file_name">
                  <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
                </el-upload> -->
                <!-- :file-list="file_namefileList" -->
                <el-upload
                  class="upload-demo"
                  ref="upload"
                  action=""
                  :on-preview="handlePreview"
                  :on-change="handleChange"
                  :on-remove="handleRemove"
                  
                  multiple
                  :auto-upload="false">
                  <el-button slot="trigger" size="small" type="primary">上传到服务器</el-button>
                </el-upload>
                <el-input v-if="!see" v-model="formData.fileName" />
                <el-input v-if="!see" v-model="formData.virtualPath" />

              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <div slot="footer">
          <el-button @click="close">取消</el-button>
          <el-button type="primary" @click="handleConfirm">确定</el-button>
        </div>
      </el-dialog>

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目号" prop="projectNum">
          <el-input v-model="form.projectNum" placeholder="请输入项目号" />
        </el-form-item>
        <el-form-item label="版本号" prop="versionNum">
          <el-input v-model="form.versionNum" placeholder="请输入版本号" />
        </el-form-item>
        <el-form-item label="文件名称" prop="fileName">
          <el-input v-model="form.fileName" placeholder="请输入文件名称" />
        </el-form-item>
        <el-form-item label="文件路径" prop="virtualPath">
          <el-input v-model="form.virtualPath" placeholder="请输入文件路径" />
        </el-form-item>
        <el-form-item label="描述">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="日期" prop="creatDate">
          <el-date-picker clearable
            v-model="form.creatDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="条件" prop="conditionNum">
          <el-input v-model="form.conditionNum" placeholder="请输入条件" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<style>
  .el-upload__tip {
    line-height: 1.2;
  }
  
  </style>
<script>
import { listInspackage, getInspackage, delInspackage, addInspackage, updateInspackage,uploadFile,saveInspackage } from "@/api/system/inspackage";
export default {
  name: "Inspackage",

  data() {
    return {
      see:true,
      formData: {
          project_num: '',
          version_num: undefined,
          type: 1,
          content: undefined,
          // creat_date: null,
          virtualPath:null,
          fileName:null
        },
        rules: {
          project_num: [{
            required: true,
            message: '请输入项目号',
            trigger: 'blur'
          }],
          version_num: [{
            required: true,
            message: '请输入版本号',
            trigger: 'blur'
          }],
          type: [{
            required: true,
            message: '请选择下拉选择',
            trigger: 'change'
          }],
          content: [{
            required: true,
            message: '请输入描述',
            trigger: 'blur'
          }],
          creat_date: [{
            required: true,
            message: '请选择日期选择',
            trigger: 'change'
          }],
        },
        file_namefileList: [],
        typeOptions: [{
          "label": "IOS",
          "value": 1
        }, {
          "label": "Android",
          "value": 2
        }, {
          "label": "固件",
          "value": 3
        }],
        dialogFormVisibleAdd: false,

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
      // 【请填写功能名称】表格数据
      inspackageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectNum: null,
        versionNum: null,
        fileName: null,
        virtualPath: null,
        content: null,
        type: null,
        creatDate: null,
        conditionNum: null,
        
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectNum: [
          { required: true, message: "不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    change(index,inspackage){
      console.log(index);
      console.log(inspackage);
      inspackage.conditionNum=index;
      updateInspackage(inspackage);
      // let text = index == "0" ? "启用" : "停用";
      // console.log(text)
      // this.$modal.confirm('确认要"'+text+ '""' +inspackage.versionNum+'"的版本吗？').then(function() {
      //   return updateInspackage(inspackage);
      // }).then(response=>{
      //   this.getList();
      // }).catch(function() {
      //   index = index === "0" ? "1" : "0";
      // });

      // console.log(inspackage);
    },

    handleChange(file) {
    console.log(file)
     if(file!=null){
        let formData = new FormData();
        formData.append('file', file.raw)
        uploadFile(formData).then(response => {
             console.log(response)
             this.formData.virtualPath=response.virtualPath
             this.formData.fileName=response.fileName
        });
     }
    },
    submitUpload() {
        this.$refs.upload.submit();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
    onOpen() {},
      onClose() {
        this.$refs['elForm'].resetFields()
      },
      close() {
        this.dialogFormVisibleAdd=false,
        this.$emit('update:visible', false)
      },
      handleConfirm() {

        // this.$refs['elForm'].validate(valid => {
        //   if (!valid) return
        //   this.close()
        // })
        saveInspackage(this.formData).then(response => {
          
              // this.$modal.msgSuccess("上传成功");
              this.dialogFormVisibleAdd=false,
              this.getList();
            });
      },
      file_nameBeforeUpload(file) {
        let isRightSize = file.size / 1024 / 1024 < 200
        if (!isRightSize) {
          this.$message.error('文件大小超过 200MB')
        }
        let isAccept = new RegExp('image/*').test(file.type)
        if (!isAccept) {
          this.$message.error('应该选择image/*类型的文件')
        }
        return isRightSize && isAccept
      },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listInspackage(this.queryParams).then(response => {
        this.inspackageList = response.rows;
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
        packageId: null,
        projectNum: null,
        versionNum: null,
        fileName: null,
        virtualPath: null,
        content: null,
        type: null,
        creatDate: null,
        conditionNum: null
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
      this.ids = selection.map(item => item.packageId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },


    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";

    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const packageId = row.packageId || this.ids
      getInspackage(packageId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.packageId != null) {
            updateInspackage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInspackage(this.form).then(response => {
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
      const packageIds = row.packageId || this.ids;
      this.$modal.confirm('是否确认删除版本号为"' + row.versionNum + '"的数据项？').then(function() {
        return delInspackage(packageIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/inspackage/export', {
        ...this.queryParams
      }, `inspackage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
