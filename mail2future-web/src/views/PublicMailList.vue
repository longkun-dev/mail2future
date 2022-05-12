<template>
  <div style="text-align: left; padding: 0 20px">
    <div v-for="(item, index) in publicMailList" :key="index">
      <el-link href="javascript:;" :underline="false" @click.native.prevent.stop="queryPublicMailDetail(item.id)">
        <div class="subject">{{ item.subject }}</div>
        <div class="summary">{{ item.summary }}</div>
      </el-link>
      <el-divider></el-divider>
    </div>
    <el-pagination layout="prev, pager, next" :total="3" :hide-on-single-page="true"
                   style="margin-top: 10px; text-align: right">
    </el-pagination>

    <el-drawer title="邮件详情" :visible.sync="showMailDetail" :direction="direction" size="45%">
      <el-form ref="mailDetail" :model="mailDetail" label-width="100px"
               style="padding: 0 10px">
        <el-form-item label="邮件主题">
          <el-input v-model="mailDetail.subject" style="width: 100%;" readonly></el-input>
        </el-form-item>
        <el-form-item label="收信地址">
          <el-input v-model="mailDetail.receiver" style="width: 100%;" readonly></el-input>
        </el-form-item>
        <el-form-item label="邮件内容">
          <el-input type="textarea" v-model="mailDetail.mailContent" :autosize="{ minRows: 15, maxRows: 20}"
                    readonly>
          </el-input>
        </el-form-item>
        <el-form-item label="预定发送日期">
          <el-date-picker type="date" v-model="mailDetail.planSendTime" placeholder="选择日期" style="width: 100%;"
                          readonly>
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发送状态">
          <el-input v-model="mailDetail.mailStatus" readonly></el-input>
        </el-form-item>
        <el-form-item label="创建时间">
          <el-date-picker v-model="mailDetail.createdTime" type="datetime" placeholder="创建时间" style="width: 100%;"
                          readonly>
          </el-date-picker>
        </el-form-item>
      </el-form>
    </el-drawer>
  </div>
</template>
<script>
export default {
  data() {
    return {
      direction: 'rtl',
      showMailDetail: false,
      publicMailList: [],
      mailDetail: {
        subject: '',
        receiverAddress: '',
        mailContent: '',
        planSendDate: '',
        createdTime: '',
        status: '待发送'
      }
    }
  },
  created() {
    this.queryPublicMailList()
  },
  methods: {
    queryPublicMailList() {
      this.axios({
        url: '/api/mail/publicMailList',
        method: 'GET',
        params: {
          'pageNum': 1,
          'pageSize': 10
        }
      }).then((res) => {
        let data = res.data
        this.publicMailList = data.data
      })
    },
    queryPublicMailDetail(id) {
      if (!id) {
        this.openMessage('参数错误，请刷新页面重试', 'warning')
      }
      this.showMailDetail = true
      this.axios({
        url: '/api/mail/' + id,
        method: 'GET',
        params: {}
      }).then((res) => {
        console.log('res: ', res)
        this.mailDetail = res.data.data
      })
    }
  }
}
</script>
<style>
.subject {
  font-size: 17px;
  color: rgba(0, 0, 0, 0.8);
  /*font-weight: bold;*/
  margin-top: 8px;
}

.summary {
  color: rgba(0, 0, 0, 0.5);
  margin-top: 10px;
}
</style>
