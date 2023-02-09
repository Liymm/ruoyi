<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备id" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入设备id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="列表id" prop="pid">
        <el-input
          v-model="queryParams.pid"
          placeholder="请输入列表id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:product_info:add']"
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
          v-hasPermi="['system:product_info:edit']"
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
          v-hasPermi="['system:product_info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:product_info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="product_infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id"/>
      <el-table-column label="pid" align="center" prop="pid" />
      <el-table-column label="name" align="center" prop="name" />
      <el-table-column label="info" align="center" prop="info" />
      <el-table-column label="img" align="center" prop="img" width="100">
        <template slot-scope="scope">
          <image-preview :src="'http://39.108.163.169:8080'+scope.row.img" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="filterType" align="center" prop="filterType" />
      <el-table-column label="filterValue" align="center" prop="filterValue" />
      <el-table-column label="deviceAbility" align="center" prop="deviceAbility" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:product_info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:product_info:remove']"
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

    <!-- 添加或修改设备详情列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="id" prop="id">
          <el-input v-model="form.id" placeholder="请输入id" />
        </el-form-item>
        <el-form-item label="pid" prop="pid">
          <el-input v-model="form.pid" placeholder="请输入pid" />
        </el-form-item>
        <el-form-item label="name" prop="name">
          <el-input v-model="form.name" placeholder="请输入name" />
        </el-form-item>
        <el-form-item label="info" prop="info">
          <el-input v-model="form.info" placeholder="请输入info" />
        </el-form-item>
        <el-form-item label="url">
          <image-upload :src="'http://39.108.163.169:8080'+form.img" v-model="form.img"/>
        </el-form-item>
        <el-form-item label="filterType" prop="filterType">
          <el-input v-model="form.filterType" placeholder="请输入filterType" />
        </el-form-item>
        <el-form-item label="filterValue" prop="filterValue">
          <el-input v-model="form.filterValue" placeholder="请输入filterValue" />
        </el-form-item>
        <el-form-item label="deviceAbility" prop="deviceAbility">
          <el-input v-model="form.deviceAbility" placeholder="请输入deviceAbility" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProduct_info, getProduct_info, delProduct_info, addProduct_info, updateProduct_info } from "@/api/system/product_info";

export default {
  name: "Product_info",
  data() {
    return {
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
      // 设备详情列表表格数据
      product_infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        pid: null,
        name: null,
        info: null,
        img: null,
        filterType: null,
        filterValue: null,
        deviceAbility: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询设备详情列表列表 */
    getList() {
      this.loading = true;
      listProduct_info(this.queryParams).then(response => {
        this.product_infoList = response.rows;
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
        ppid: null,
        id: null,
        pid: null,
        name: null,
        info: null,
        img: null,
        filterType: null,
        filterValue: null,
        deviceAbility: null
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
      this.ids = selection.map(item => item.ppid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加设备详情列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ppid = row.ppid || this.ids
      getProduct_info(ppid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改设备详情列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ppid != null) {
            updateProduct_info(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProduct_info(this.form).then(response => {
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
      const ppids = row.ppid || this.ids;
      this.$modal.confirm('是否确认删除设备详情列表编号为"' + ppids + '"的数据项？').then(function() {
        return delProduct_info(ppids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/product_info/export', {
        ...this.queryParams
      }, `product_info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
