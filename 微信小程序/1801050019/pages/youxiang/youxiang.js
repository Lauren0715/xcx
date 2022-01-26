// pages/shouji/shouji.js
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
    console.log(wx.getStorageSync('openid'))
    
    

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

    formsubmit: function(e) {
       var that = this;
       var num = e.detail.value.num;
       console.log(num);
       
         wx.request({
           method: "get",
           url: "http://localhost:8080/WEBPRO_18/th_editemail",
           data: {
             num: num,
             openid:wx.getStorageSync('openid'),
           },
           header: {
             'content-type': 'application/json'
           },
           success: function (res) {
            wx.showToast({
              title: '修改成功',//'保存成功',
              duration: 2000
              })
            wx.redirectTo({
              url: '/pages/ziliao/ziliao',
              })
            console.log(res.data);
          },
          fail: function (res) {
            wx.showToast({
              title: '出错，请重试',//'保存成功',
              duration: 2000
              })
            console.log("fail to connect");
          }
        })
                   
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