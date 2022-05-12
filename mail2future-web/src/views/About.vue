<template>
  <div style="text-align: left; padding: 0 20px">
    <h1>关于</h1>
    <el-descriptions title="网站说明" :column="1" :colon="false">
      <el-descriptions-item label="💌">该网站由个人开发者独立运营，我们会尽力在您指定的日期的上午 9 点将您的邮件送出。如同一日需发送的邮件较多时，您的邮件可能会稍有延迟
      </el-descriptions-item>
      <el-descriptions-item label="⚠️">请不要在邮件内容中包含证件号码、居住地址及其他个人敏感信息
      </el-descriptions-item>
      <el-descriptions-item label="📅">信件一旦提交将无法撤回，希望您也忘掉这件事，直到收到信的那一天</el-descriptions-item>
      <el-descriptions-item label="🙇‍♀️">为防止滥用，我们将在邮件投递后向您指定的邮箱发送一封确认邮件，只有在预定发送日期前点击确认邮件中的链接后，您才能在未来收到邮件
      </el-descriptions-item>
    </el-descriptions>
    <el-descriptions title="联系方式" :column="1" style="margin-top: 25px">
      <el-descriptions-item label="用户名">kooriookami</el-descriptions-item>
      <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
      <el-descriptions-item label="邮 箱">mail2future-feedback@yuki.im</el-descriptions-item>
      <el-descriptions-item label="居住地">苏州市</el-descriptions-item>
      <el-descriptions-item label="联系地址">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
      <el-descriptions-item label="备 注">
        <el-tag size="small">编程</el-tag>
        <el-tag size="small" style="margin-left: 8px">学生</el-tag>
        <el-tag size="small" style="margin-left: 8px">菜鸟</el-tag>
      </el-descriptions-item>
    </el-descriptions>
    <el-descriptions title="系统信息" :column="1" style="margin-top: 25px">
      <el-descriptions-item label="网 址">
        <el-link>mail2future.yuki.im</el-link>
      </el-descriptions-item>
      <el-descriptions-item label="起 始">2022 年 4 月 4 日</el-descriptions-item>
      <el-descriptions-item label="参 考">
        <el-link>https://www.timeletters.cn</el-link>
      </el-descriptions-item>
      <el-descriptions-item label="参 考">
        <el-link>https://timemail.net</el-link>
      </el-descriptions-item>
    </el-descriptions>
  </div>
</template>
<script>
export default {
  data() {
    return {
      imgUrl: 'https://bing.wilii.cn/OneDrive/bingimages/2022/03/26//YellowCrocuses_ZH-CN6617862337_1920x1080.jpg'
    }
  }
}
</script>
