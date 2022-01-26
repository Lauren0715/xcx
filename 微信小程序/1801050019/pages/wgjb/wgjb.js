// pages/fankuiye/fankuiye.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  accountInput:function(e){
    var content = e.detail.value;
    console.log(content);
    if(content != ''){
       this.setData({disabled:false,btnstate:"primary",account:content});
    }else{
       this.setData({disabled:true,btnstate:"default"});
    }
},
formSubmit: function(e) {
  console.log(e.detail.value.detail)
  console.log(e.detail.value.phone)
   var that = this;
   var detail = e.detail.value.detail;
   var phone = e.detail.value.phone;
   if (detail.length < 10) {
     wx.showToast({
       title: '请用10个字以上描述问题',
       duration: 2000
     })
   } 
   if (phone.length != 11) {
    wx.showToast({
      title: '输入手机号码格式有误',
      duration: 2000
    })
  } 
   else {
   
     wx.request({
       method: "get",
       url: "http://localhost:8080/WEBPRO_18/fk_wgjb",
       data: {
         'detail': detail,
         'phone': phone,
       },
       header: {
         'content-type': 'application/json'
       },
       success: function(res) {
                
                     wx.showToast({
                       title: '感谢你的反馈',//'保存成功',
                       duration: 5000
                       })
                       wx.switchTab({
                       url: '/pages/account/account',
                        })
  
                 }
     })
  }
},

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})