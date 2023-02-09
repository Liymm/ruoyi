import request from '@/utils/request'

// 查询设备详情列表列表
export function listProduct_info(query) {
  return request({
    url: '/system/product_info/list',
    method: 'get',
    params: query
  })
}

// 查询设备详情列表详细
export function getProduct_info(ppid) {
  return request({
    url: '/system/product_info/' + ppid,
    method: 'get'
  })
}

// 新增设备详情列表
export function addProduct_info(data) {
  return request({
    url: '/system/product_info',
    method: 'post',
    data: data
  })
}

// 修改设备详情列表
export function updateProduct_info(data) {
  return request({
    url: '/system/product_info',
    method: 'put',
    data: data
  })
}

// 删除设备详情列表
export function delProduct_info(ppid) {
  return request({
    url: '/system/product_info/' + ppid,
    method: 'delete'
  })
}
