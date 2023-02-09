(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-c6547666"],{"33d0":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[a("el-form-item",{attrs:{label:"项目号",prop:"projectNum"}},[a("el-input",{attrs:{placeholder:"请输入项目号",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.projectNum,callback:function(t){e.$set(e.queryParams,"projectNum",t)},expression:"queryParams.projectNum"}})],1),a("el-form-item",{attrs:{label:"版本号",prop:"versionNum"}},[a("el-input",{attrs:{placeholder:"请输入版本号",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.versionNum,callback:function(t){e.$set(e.queryParams,"versionNum",t)},expression:"queryParams.versionNum"}})],1),a("el-form-item",{attrs:{label:"日期",prop:"creatDate"}},[a("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择日期"},model:{value:e.queryParams.creatDate,callback:function(t){e.$set(e.queryParams,"creatDate",t)},expression:"queryParams.creatDate"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),a("el-row",{staticClass:"mb8",attrs:{gutter:10}},[a("el-col",{attrs:{span:1.5}},[a("el-button",{attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:function(t){e.dialogFormVisibleAdd=!0}}},[e._v("上传")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["system:inspackage:edit"],expression:"['system:inspackage:edit']"}],attrs:{type:"success",plain:"",icon:"el-icon-edit",size:"mini",disabled:e.single},on:{click:e.handleUpdate}},[e._v("修改")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["system:inspackage:remove"],expression:"['system:inspackage:remove']"}],attrs:{type:"danger",plain:"",icon:"el-icon-delete",size:"mini",disabled:e.multiple},on:{click:e.handleDelete}},[e._v("删除")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["system:inspackage:export"],expression:"['system:inspackage:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),a("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.inspackageList},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{label:"项目号",align:"center",prop:"projectNum"}}),a("el-table-column",{attrs:{label:"版本号",align:"center",prop:"versionNum"}}),a("el-table-column",{attrs:{"min-width":"“120”","show-overflow-tooltip":!0,label:"文件名称",align:"center",prop:"fileName"}}),a("el-table-column",{attrs:{"min-width":"“120”","show-overflow-tooltip":!0,label:"文件路径",align:"center",prop:"virtualPath"}}),a("el-table-column",{attrs:{"min-width":"“120”","show-overflow-tooltip":!0,label:"描述",align:"center",prop:"content"}}),a("el-table-column",{attrs:{label:"类型",align:"center",prop:"type"}}),a("el-table-column",{attrs:{label:"添加日期",align:"center",prop:"creatDate",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e.parseTime(t.row.creatDate,"{y}-{m}-{d}")))])]}}])}),a("el-table-column",{attrs:{label:"条件",align:"center",prop:"conditionNum"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-switch",{attrs:{"active-value":0,"inactive-value":1},on:{change:function(a){return e.change(a,t.row)}},model:{value:t.row.conditionNum,callback:function(a){e.$set(t.row,"conditionNum",a)},expression:"scope.row.conditionNum"}})]}}])}),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["system:inspackage:edit"],expression:"['system:inspackage:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.handleUpdate(t.row)}}},[e._v("修改")]),a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["system:inspackage:remove"],expression:"['system:inspackage:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),a("el-dialog",e._g(e._b({attrs:{visible:e.dialogFormVisibleAdd,title:"上传文件"},on:{"update:visible":function(t){e.dialogFormVisibleAdd=t},open:e.onOpen,close:e.onClose}},"el-dialog",e.$attrs,!1),e.$listeners),[a("el-row",{attrs:{gutter:15}},[a("el-form",{ref:"elForm",attrs:{model:e.formData,rules:e.rules,size:"medium","label-width":"190px"}},[a("el-col",{attrs:{span:13}},[a("el-form-item",{attrs:{label:"项目号",prop:"project_num"}},[a("el-input",{style:{width:"100%"},attrs:{placeholder:"请输入项目号",clearable:""},model:{value:e.formData.project_num,callback:function(t){e.$set(e.formData,"project_num",t)},expression:"formData.project_num"}})],1)],1),a("el-col",{attrs:{span:13}},[a("el-form-item",{attrs:{label:"版本号",prop:"version_num"}},[a("el-input",{style:{width:"100%"},attrs:{placeholder:"请输入版本号",clearable:""},model:{value:e.formData.version_num,callback:function(t){e.$set(e.formData,"version_num",t)},expression:"formData.version_num"}})],1)],1),a("el-col",{attrs:{span:13}},[a("el-form-item",{attrs:{label:"下拉选择",prop:"type"}},[a("el-select",{style:{width:"100%"},attrs:{placeholder:"请选择下拉选择",clearable:""},model:{value:e.formData.type,callback:function(t){e.$set(e.formData,"type",t)},expression:"formData.type"}},e._l(e.typeOptions,(function(e,t){return a("el-option",{key:t,attrs:{label:e.label,value:e.value,disabled:e.disabled}})})),1)],1)],1),a("el-col",{attrs:{span:15}},[a("el-form-item",{attrs:{label:"描述",prop:"content"}},[a("el-input",{style:{width:"100%"},attrs:{type:"textarea",placeholder:"请输入描述",autosize:{minRows:4,maxRows:4}},model:{value:e.formData.content,callback:function(t){e.$set(e.formData,"content",t)},expression:"formData.content"}})],1)],1),a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"上传",prop:"file_name"}},[a("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{action:"","on-preview":e.handlePreview,"on-change":e.handleChange,"on-remove":e.handleRemove,multiple:"","auto-upload":!1}},[a("el-button",{attrs:{slot:"trigger",size:"small",type:"primary"},slot:"trigger"},[e._v("上传到服务器")])],1),e.see?e._e():a("el-input",{model:{value:e.formData.fileName,callback:function(t){e.$set(e.formData,"fileName",t)},expression:"formData.fileName"}}),e.see?e._e():a("el-input",{model:{value:e.formData.virtualPath,callback:function(t){e.$set(e.formData,"virtualPath",t)},expression:"formData.virtualPath"}})],1)],1)],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.close}},[e._v("取消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.handleConfirm}},[e._v("确定")])],1)],1),a("el-dialog",{attrs:{title:e.title,visible:e.open,width:"500px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"项目号",prop:"projectNum"}},[a("el-input",{attrs:{placeholder:"请输入项目号"},model:{value:e.form.projectNum,callback:function(t){e.$set(e.form,"projectNum",t)},expression:"form.projectNum"}})],1),a("el-form-item",{attrs:{label:"版本号",prop:"versionNum"}},[a("el-input",{attrs:{placeholder:"请输入版本号"},model:{value:e.form.versionNum,callback:function(t){e.$set(e.form,"versionNum",t)},expression:"form.versionNum"}})],1),a("el-form-item",{attrs:{label:"文件名称",prop:"fileName"}},[a("el-input",{attrs:{placeholder:"请输入文件名称"},model:{value:e.form.fileName,callback:function(t){e.$set(e.form,"fileName",t)},expression:"form.fileName"}})],1),a("el-form-item",{attrs:{label:"文件路径",prop:"virtualPath"}},[a("el-input",{attrs:{placeholder:"请输入文件路径"},model:{value:e.form.virtualPath,callback:function(t){e.$set(e.form,"virtualPath",t)},expression:"form.virtualPath"}})],1),a("el-form-item",{attrs:{label:"描述"}},[a("editor",{attrs:{"min-height":192},model:{value:e.form.content,callback:function(t){e.$set(e.form,"content",t)},expression:"form.content"}})],1),a("el-form-item",{attrs:{label:"日期",prop:"creatDate"}},[a("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择日期"},model:{value:e.form.creatDate,callback:function(t){e.$set(e.form,"creatDate",t)},expression:"form.creatDate"}})],1),a("el-form-item",{attrs:{label:"条件",prop:"conditionNum"}},[a("el-input",{attrs:{placeholder:"请输入条件"},model:{value:e.form.conditionNum,callback:function(t){e.$set(e.form,"conditionNum",t)},expression:"form.conditionNum"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),a("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},n=[],o=a("5530"),r=a("ade3"),i=(a("ac1f"),a("00b4"),a("4d63"),a("c607"),a("2c3e"),a("25f0"),a("d81d"),a("b775"));function s(e){return Object(i["a"])({url:"/system/inspackage/list",method:"get",params:e})}function c(e){return Object(i["a"])({url:"/system/inspackage/"+e,method:"get"})}function u(e){return Object(i["a"])({url:"/system/inspackage/upload",method:"post",data:e})}function m(e){return console.log(e),Object(i["a"])({url:"/system/inspackage/Fileadd",method:"post",data:e})}function p(e){return Object(i["a"])({url:"/system/inspackage",method:"post",data:e})}function d(e){return Object(i["a"])({url:"/system/inspackage",method:"put",data:e})}function f(e){return Object(i["a"])({url:"/system/inspackage/"+e,method:"delete"})}var h={name:"Inspackage",data:function(){return Object(r["a"])({see:!0,formData:{project_num:"",version_num:void 0,type:1,content:void 0,virtualPath:null,fileName:null},rules:{project_num:[{required:!0,message:"请输入项目号",trigger:"blur"}],version_num:[{required:!0,message:"请输入版本号",trigger:"blur"}],type:[{required:!0,message:"请选择下拉选择",trigger:"change"}],content:[{required:!0,message:"请输入描述",trigger:"blur"}],creat_date:[{required:!0,message:"请选择日期选择",trigger:"change"}]},file_namefileList:[],typeOptions:[{label:"IOS",value:1},{label:"Android",value:2},{label:"固件",value:3}],dialogFormVisibleAdd:!1,loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,inspackageList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,projectNum:null,versionNum:null,fileName:null,virtualPath:null,content:null,type:null,creatDate:null,conditionNum:null},form:{}},"rules",{projectNum:[{required:!0,message:"不能为空",trigger:"blur"}]})},created:function(){this.getList()},methods:{change:function(e,t){console.log(e),console.log(t),t.conditionNum=e,d(t)},handleChange:function(e){var t=this;if(console.log(e),null!=e){var a=new FormData;a.append("file",e.raw),u(a).then((function(e){console.log(e),t.formData.virtualPath=e.virtualPath,t.formData.fileName=e.fileName}))}},submitUpload:function(){this.$refs.upload.submit()},handleRemove:function(e,t){console.log(e,t)},handlePreview:function(e){console.log(e)},onOpen:function(){},onClose:function(){this.$refs["elForm"].resetFields()},close:function(){this.dialogFormVisibleAdd=!1,this.$emit("update:visible",!1)},handleConfirm:function(){var e=this;m(this.formData).then((function(t){e.dialogFormVisibleAdd=!1,e.getList()}))},file_nameBeforeUpload:function(e){var t=e.size/1024/1024<200;t||this.$message.error("文件大小超过 200MB");var a=new RegExp("image/*").test(e.type);return a||this.$message.error("应该选择image/*类型的文件"),t&&a},getList:function(){var e=this;this.loading=!0,s(this.queryParams).then((function(t){e.inspackageList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={packageId:null,projectNum:null,versionNum:null,fileName:null,virtualPath:null,content:null,type:null,creatDate:null,conditionNum:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.packageId})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加【请填写功能名称】"},handleUpdate:function(e){var t=this;this.reset();var a=e.packageId||this.ids;c(a).then((function(e){t.form=e.data,t.open=!0,t.title="修改【请填写功能名称】"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.packageId?d(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):p(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,a=e.packageId||this.ids;this.$modal.confirm('是否确认删除版本号为"'+e.versionNum+'"的数据项？').then((function(){return f(a)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("system/inspackage/export",Object(o["a"])({},this.queryParams),"inspackage_".concat((new Date).getTime(),".xlsx"))}}},g=h,v=(a("e59f"),a("2877")),b=Object(v["a"])(g,l,n,!1,null,null,null);t["default"]=b.exports},"7d66":function(e,t,a){},e59f:function(e,t,a){"use strict";a("7d66")}}]);