<template>
  <div style="padding: 0 20px">
    <el-row>
      <el-col :span="8" style="text-align: left">
        <div style="margin-top: 20px">
          <h1>给未来的自己写封信</h1>
        </div>
        <div>
          <h3 style="color: rgba(0, 0, 0, 0.5)">多年以后，愿你不负所望</h3>
        </div>
        <div style="margin-top: 80px">
          <p>
            <strong>{{ stat.sentCount }}</strong><br>
            <span>封信件已投递</span>
          </p>
        </div>
        <div class="stat-item">
          <p>
            <strong>{{ stat.toSendCount }}</strong><br>
            <span>封信件待投递</span>
          </p>
        </div>
        <div class="stat-item">
          <p>
            <strong style="">{{ stat.publicCount }}</strong><br>
            <span>封公开信</span>
          </p>
        </div>
        <div class="stat-item">
          <p>
            <strong>{{ stat.runningDays }}</strong><br>
            <span>天已运行</span>
          </p>
        </div>
      </el-col>
      <el-col :span="16">
        <el-form :model="mailForm" ref="mailForm" label-width="100px" class="demo-ruleForm" label-position="top"
                 style="text-align: left; margin-top: 25px; width: 730px">
          <el-form-item label="" prop="subject">
            <el-input v-model="mailForm.subject"></el-input>
          </el-form-item>
          <el-form-item label="" prop="mailContent">
            <el-input type="textarea" v-model="mailForm.mailContent" :autosize="{ minRows: 8, maxRows: 20}"
                      placeholder="致未来的自己...">
            </el-input>
          </el-form-item>
          <!--          <el-form-item label="" prop="mailContent">-->
          <!--            <el-tiptap lang="zh" :extensions="extensions" v-model="mailForm.mailContent" height="500px"-->
          <!--                       placeholder="致未来的自己...">-->
          <!--            </el-tiptap>-->
          <!--          </el-form-item>-->
          <el-form-item label="📅 投递时间" prop="planSendTime">
            <el-date-picker v-model="mailForm.planSendTime" type="date" value-format="yyyy-MM-dd" placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="让这封信" prop="publicScope">
            <el-radio-group v-model="mailForm.publicScope">
              <el-radio-button label="公开">🐵 公开</el-radio-button>
              <el-radio-button label="匿名公开">🙉 匿名公开</el-radio-button>
              <el-radio-button label="不公开">🙈 不公开</el-radio-button>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="收信邮箱" prop="receiver">
            <el-input type="email" v-model="mailForm.receiver" placeholder="📧 myself@163.com">
            </el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary" @click="postThisMail">投递</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mailForm: {
        subject: '',
        mailContent: '',
        publicScope: '',
        receiver: '',
        planSendTime: ''
      },
      stat: {
        sentCount: 0,
        toSendCount: 0,
        runningDays: 0,
        publicCount: 0
      },
      mailAddressFormatReg: /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/
    }
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      let planSendTime = this.addYears(new Date(), 2)
      let today = new Date()
      let subject = '来自' + today.getFullYear() + '年' + (today.getMonth() + 1) + '月' +
        today.getDate() + '日的一封信'
      Object.assign(this.mailForm, {
        subject: subject,
        mailContent: '',
        publicScope: '公开',
        receiver: '',
        planSendTime: planSendTime
      })

      // 获取网站统计信息
      this.axios.get('/api//mail/stat').then((res) => {
        let data = res.data.data
        this.stat.sentCount = data.sentCount
        this.stat.toSendCount = data.toSendCount
        this.stat.publicCount = data.publicCount
        this.stat.runningDays = data.runningDaysCount
      })
    },
    addYears(date, count) {
      let year = date.getFullYear() + count
      date.setFullYear(year)
      return date
    },
    postThisMail() {
      if (!this.mailForm.mailContent) {
        this.openMessage('邮件内容不能为空', 'warning')
        return false
      }
      if (this.mailForm.mailContent.length < 10) {
        this.openMessage('邮件内容不能少于 10 个字', 'warning')
        return false
      }
      if (!this.mailForm.receiver) {
        this.openMessage('收信地址不能为空', 'warning')
        return false
      }
      // 邮箱格式校验
      if (!this.mailAddressFormatReg.test(this.mailForm.receiver)) {
        this.openMessage('收信邮箱格式不正确', 'warning')
        return false
      }
      console.info('thisMailInfo: ', this.mailForm)
      this.axios.post('/api/mail', this.mailForm).then((res) => {
        this.openMessage('邮件已成功投递', this.successMessage)
        let _that = this
        setTimeout(() => {
          _that.init()
        }, 1500)
      })
    }
  }
}
</script>
<style scoped>
strong {
  font-size: 26px;
  color: rgba(0, 0, 0, 0.6);
}

.stat-item {
  margin-top: 45px;
}

span {
  display: block;
  font-size: 16px;
  color: rgba(0, 0, 0, 0.5);
  margin-top: 10px;
}
</style>
