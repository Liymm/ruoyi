import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listInspackage(query) {
  return request({
    url: '/system/inspackage/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getInspackage(packageId) {
  return request({
    url: '/system/inspackage/' + packageId,
    method: 'get'
  })
}

//文件上传功能
export function uploadFile(data) {
  return request({
    url: '/system/inspackage/upload',
    method: 'post',
    data: data
  })
}

export function saveInspackage(data) {
  console.log(data)
  return request({
    url: '/system/inspackage/Fileadd',
    method: 'post',
    data: data
  })
}

// 新增【请填写功能名称】
export function addInspackage(data) {
  return request({
    url: '/system/inspackage',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateInspackage(data) {
  return request({
    url: '/system/inspackage',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delInspackage(packageId) {
  return request({
    url: '/system/inspackage/' + packageId,
    method: 'delete'
  })
}
