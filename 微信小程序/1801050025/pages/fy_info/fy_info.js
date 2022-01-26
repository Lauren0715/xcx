// pages/fy_info/fy_info.js
var id;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    icon_like: '../../images/shoucang/aixin-4.png',
    icon_unlike: '../../images/shoucang/aixin-3.png',
    like:false, //是否已点赞

    //gps
    addmissage: '选的位置',
    // markers	 Array	标记点
    stitle:'故宫',
    latitude: "",
    longitude: "",
    scale: 14,
    markers: [],
    //controls控件 是左下角圆圈小图标,用户无论放大多少,点这里可以立刻回到当前定位(控件（更新一下,即将废弃，建议使用 cover-view 代替）)
    controls: [{
      id: 1,
      iconPath: '../../pages/pingjia/pingjia',
      position: {
        left: 15,
        top: 260 - 50,
        width: 40,
        height: 40
      },
      clickable: true
    }],
    distanceArr: []


  },

  
  onLike(e) {

    wx.vibrateShort() //手机振动API


 this.animation = wx.createAnimation({
   duration: 300, // 动画持续时间，单位 ms
   timingFunction: 'linear', // 动画的效果
   delay: 10, // 动画延迟时间，单位 ms
   transformOrigin: '50% 50%' // 动画的中心点
 })


 let like = this.properties.like
 let count = this.properties.count

 count = like ? count - 1 : count + 1

 if (!like) {
   setTimeout(function () {

     this.animation.scale(1.5).step();
     this.animation.scale(1.0).step();

     this.setData({
       animation: this.animation.export()
     });

   }.bind(this), 50);
 }

 this.setData({
   count,
   like: !like
 })



},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('123'+options.FYMC);
    var that = this//不要漏了这句，很重要
   
    

    //获取当前的地理位置、速度
     wx.getLocation({

      
      type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
      success: function (res) {
        //赋值经纬度
        that.setData({
          latitude: res.latitude,
          longitude: res.longitude,
 
        })
      }
    })


    wx.request({
      url: 'http://localhost:8080/WEBPRO_18/xcx_fyinfo',  //先不写
      // url: 'http://localhost:8090/Tajax/XCXSP_info',//先不写
      data: {
        //message: 'ty is the The most handsome man in the ESTA',
        FYMC:options.FYMC,
        
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        
        that.setData({
          FYMC: res.data.FYMC,
          room:res.data.room,
          FYTP:res.data.FYTP,
          FYPF:res.data.FYPF,
          FYDZ:res.data.FYDZ,
          bb1:res.data.bb1,
          bb2:res.data.bb2,
          common:res.data.common,
          FJSL:res.data.FJSL,
          FKSL:res.data.FKSL,
          FYJS:res.data.FYJS,
          toilet:res.data.toilet,
          bed:res.data.bed,
          FKMC:res.data.FKMC,
          FKPJ:res.data.FKPJ,
          year:res.data.year,
          month:res.data.month,
          FKTP:res.data.FKTP,
          mrt1:res.data.mrt1,
          station1:res.data.station1,
          place1:res.data.place1,
          mrt2:res.data.mrt2,
          station2:res.data.station2,
          place2:res.data.place2,
          m1:res.data.m1,
          s1:res.data.s1,
          p1:res.data.p1,
          m2:res.data.m2,
          s2:res.data.s2,
          p2:res.data.p2,
          weizhi:res.data.weizhi,

    
        });
        
        console.log(res.data);//回调函数中的携带服务器响应数据
        
      },
      fail: function (res) {
        console.log("fail to connect");
      }
    })

    wx.request({
      url: 'http://localhost:8080/WEBPRO_18/xcx_fdjs',  //先不写
      // url: 'http://localhost:8090/Tajax/XCXSP_info',//先不写
      data: {
        //message: 'ty is the The most handsome man in the ESTA',
        FYMC:options.FYMC,
        
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        
        that.setData({
          FDMC: res.data.FDMC,
          FDTP:res.data.FDTP,
          FDPL:res.data.FDPL,
          FDPJ:res.data.FDPJ,
        });
        
        console.log(res.data);//回调函数中的携带服务器响应数据
        
      },
      fail: function (res) {
        console.log("fail to connect");
      }
    })
   
  },
 
  bindcontroltap(e) {
    var that = this;

    
    if (e.controlId == 1) {
      that.setData({
        latitude: this.data.latitude,
        longitude: this.data.longitude,
        scale: 14,
      })
    }
  },
  onGuideTap: function (event) {
    var lat = Number(event.currentTarget.dataset.latitude);
    var lon = Number(event.currentTarget.dataset.longitude);
    var bankName = event.currentTarget.dataset.bankname;
    console.log(lat);
    console.log(lon);
    wx.openLocation({
      type: 'gcj02',
      latitude: lat,
      longitude: lon,
      name: bankName,
      scale: 28
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