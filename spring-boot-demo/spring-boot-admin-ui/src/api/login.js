import request from '@/utils/request'

/**
 * 登录
 * @param username
 * @param password
 */
export function login (username, password) {
  return request({
    url: '/auth/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

/**
 * 获取用户信息
 */
export function getInfo () {
  return request({
    url: '/auth/info',
    method: 'get'
  })
}

/**
 * 注销
 */
export function logout () {
  return request({
    url: '/system/logout',
    method: 'post'
  })
}
