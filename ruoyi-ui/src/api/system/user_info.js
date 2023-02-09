import request from '@/utils/request'

// 查询用户数据表列表
export function listUser_info(query) {
  return request({
    url: '/system/user_info/list',
    method: 'get',
    params: query
  })
}

// 查询用户数据表详细
export function getUser_info(pid) {
  return request({
    url: '/system/user_info/' + pid,
    method: 'get'
  })
}

// 新增用户数据表
export function addUser_info(data) {
  return request({
    url: '/system/user_info',
    method: 'post',
    data: data
  })
}

// 修改用户数据表
export function updateUser_info(data) {
  return request({
    url: '/system/user_info',
    method: 'put',
    data: data
  })
}

// 删除用户数据表
export function delUser_info(pid) {
  return request({
    url: '/system/user_info/' + pid,
    method: 'delete'
  })
}
