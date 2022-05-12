export default {
  install(Vue) {
    // 消息类型
    Vue.prototype.successMessage = 'success'
    Vue.prototype.errorMessage = 'error'
    Vue.prototype.warningMessage = 'warning'

    Vue.prototype.openMessage = function (message, type) {
      this.$message({
        message: message,
        type: type,
        duration: 2000
      })
    }
  }
}
