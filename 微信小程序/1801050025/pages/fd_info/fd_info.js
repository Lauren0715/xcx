// pages/SP_info/SP_info.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentIndex: 0,

  },

  pagechange: function (e) {
    if ("touch" === e.detail.source) {
      let currentPageIndex = this.data.currentIndex
      currentPageIndex = (currentPageIndex + 1) % 2
      this.setData({
        currentIndex: currentPageIndex
      })
    }
  },
  //用户点击tab时调用
  titleClick: function (e) {
    let currentPageIndex =
      this.setData({
        //拿到当前索引并动态改变
        currentIndex: e.currentTarget.dataset.idx
      })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('123'+options.FDMC);
    var that = this//不要漏了这句，很重要
    
    wx.request({
      url: 'http://localhost:8080/WEBPRO_18/xcx_fdinfo',  //先不写
      // url: 'http://localhost:8090/Tajax/XCXSP_info',//先不写
      data: {
        //message: 'ty is the The most handsome man in the ESTA',
        FDMC:options.FDMC,
        
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        
        that.setData({
          FDMC: res.data.FDMC,
          FDDZ:res.data.FDDZ,
          FDTP:res.data.FDTP,
          FDPF:res.data.FDPF,
          FDPL:res.data.FDPL,
          FYSL:res.data.FYSL,
          FDPJ:res.data.FDPJ,
          FDHFL:res.data.FDHFL,
    
        });
        
        console.log(res.data);//回调函数中的携带服务器响应数据
        
      },
      fail: function (res) {
        console.log("fail to connect");
      }
    })

    wx.request({
      url: 'http://localhost:8080/WEBPRO_18/xcx_fdfylist',  //先不写

      data: {
      
        FDMC:options.FDMC,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        
        that.setData({
          list_data: res.data,
        });
        
        console.log(res.data);//回调函数中的携带服务器响应数据
        
      },
      fail: function (res) {
        console.log("fail to connect");
      }
    })

    wx.request({
      url: 'http://localhost:8080/WEBPRO_18/xcx_fklist',  //先不写

      data: {
      
        FDMC:options.FDMC,
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        
        that.setData({
          list_data2: res.data,
        });
        
        console.log(res.data);//回调函数中的携带服务器响应数据
        
      },
      fail: function (res) {
        console.log("fail to connect");
      }
    })
  },
  // menuTap:function(e){
  //   var current=e.currentTarget.dataset.current;//获取到绑定的数据
  //   //改变menuTapCurrent的值为当前选中的menu所绑定的数据
  //   this.setData({
  //   menuTapCurrent:current
  //   });
     
     
  //   },

  
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