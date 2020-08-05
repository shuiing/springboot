import axios from 'axios'
import Element from 'element-ui'
import router from './router'
import store from './store'

axios.defaults.baseURL = "http://localhost:8081";

// 前置拦截
axios.interceptors.request.use(config => {
  return config
});

axios.interceptors.response.use(response => {
    let res = response.data;
    if (res.code === 200) {
      return response
    } else {
     // 弹窗异常信息
      Element.Message.error('错了哦，这是一条错误消息', {duration: 3 * 1000});
     // 直接拒绝往下面返回结果信息
      return Promise.reject(response.data.msg)
    }
  },
  error => {
    if(error.response.data) {
      error.message = error.response.data.msg
    }

    if(error.response.status === 401) {
      store.commit("REMOVE_INFO");
      router.push("/login")
    }

    Element.Message.error(error.message, {duration: 3 * 1000});
    return Promise.reject(error)
  }
);