var bmap = require('../../libs/bmap-wx.js'); 

Page({
  data:{
    city:"",
    latitude: "",
    longitude: "",
      indicatorDots:false,
      autoplay:true,
      interval:5000,
      duration:1000,
      imgUrls:[
         '/images/haibao/top1.jpg',
         '/images/haibao/top2.jpg',
         '/images/haibao/top3.jpg'
      ],
      currentTab:0
  },
  onLoad:function(options){
    var that=this;
    this.loadInfo();
    var BMap = new bmap.BMapWX({ 
      ak: 'EaVAbG1oy4ZUIdsvMcBuf8kjonDpisHY' 
  }); 
  BMap.regeocoding({ 
    fail: fail, 
    success: success, 
    iconPath: '../../img/marker_red.png', 
    iconTapPath: '../../img/marker_red.png' 
}); 
  
    // 页面初始化 options为页面跳转所带来的参数
  },
  
  
  
  loadInfo:function(){  
    var that=this; 
  wx.getLocation({  
    type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标  
    success: function(res){  
      // success  
      var longitude=res.longitude;  
      var latitude=res.latitude;
      console.log(longitude);
      console.log(latitude);
      page.loadCity(longitude,latitude)  
    },  
    fail: function() {  
      console.log('fail to get your location') 
    }
  })  
  },  
  loadCity:function(longitude,latitude){  
    var page =this  
    wx.request({  
      url: 'https://api.map.baidu.com/geocoder/v2/?ak=EaVAbG1oy4ZUIdsvMcBuf8kjonDpisHY&location='+latitude+','+longitude+'&output=json',  
      data: {},  
      header:{  
        'Content-Type':'application/json'  
      },  
      success: function(res){  
        // success  
        console.log(res);  
        var city=res.data.result.addressComponent.city;  
        page.setData({city:city});  
      },  
      fail: function() {  
        console.log('fail to get your city')  
      }
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
  console.log(num);
  
    wx.request({
      method: "get",
      url: "http://localhost:8080/WEBPRO_18/th_address",
      data: {
        address:address
        
       
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
         url: '/pages/fangyuan/fangyuan',
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


})