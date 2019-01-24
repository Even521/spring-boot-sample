import request from '@/utils/request'

export function initData () {
  return request({
    url: url,
    method: 'get',
    params
  })
}
