import request from '@/utils/request'

// 查询设备列表
export function listProduct(query) {
  return request({
    url: '/system/product/list',
    method: 'get',
    params: query
  })
}

// 查询设备详细
export function getProduct(id) {
  return request({
    url: '/system/product/' + id,
    method: 'get'
  })
}

// 新增设备
export function addProduct(data) {
  return request({
    url: '/system/product',
    method: 'post',
    data: data
  })
}

// 修改设备
export function updateProduct(data) {
  return request({
    url: '/system/product',
    method: 'put',
    data: data
  })
}

// 删除设备
export function delProduct(id) {
  return request({
    url: '/system/product/' + id,
    method: 'delete'
  })
}
