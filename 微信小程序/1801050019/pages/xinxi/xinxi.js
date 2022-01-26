// pages/xinxi/xinxi.js
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
    var that=this
    console.log(options.id)
    that.setData({
      id:options.id
    })

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
       var name=e.detail.value.name;
       var id=that.data.id;
       console.log(that.data.id)
         wx.request({
           method: "get",
           url: "http://localhost:10011/WEBPRO_18/th_xinxi",
           data: {
             name:name,
             num: num,
             id:id,
           },
           header: {
             'content-type': 'application/json'
           },
           success: function (res) {
            wx.showToast({
              title: '添加成功',//'保存成功',
              duration: 2000
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