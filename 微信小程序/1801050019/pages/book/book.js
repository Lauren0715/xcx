// pages/zhifu/zhifu.js
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
var that = this
    console.log(options.id)
that.setData({
  id:options.id
})
wx.request({
  url: "http://localhost:10011/WEBPRO_18/th_book",
  data: {
    id:options.id,
  },
  method: 'GET',
  header: {
    'content-type': 'application/json' // 默认值
  },
  success: function (res) {
    console.log(res.data);
    that.setData({
      list:res.data,
      
    });
    //回调函数中的携带服务器响应数据
  },
  fail: function (res) {
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
  wxshow:function(e){
    var that = this;
    wx.showToast({
      title: '未添加房客信息',//'保存成功',
      icon:'loading',
      duration: 2000
      })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})