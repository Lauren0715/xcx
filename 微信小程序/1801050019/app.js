//app.js
App({
  onLaunch: function () {
    //调用API从本地缓存中获取数据
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    var that = this
     var user=wx.getStorageSync('user') || {};  
     var userInfo=wx.getStorageSync('userInfo') || {}; 
     if((!user.openid || (user.expires_in || Date.now()) < (Date.now() + 600))&&(!userInfo.nickName)){ 
        wx.login({  
        success: function(res){ 
            if(res.code) {
                wx.getUserInfo({
                    success: function (res) {
                        var objz={};
                        objz.avatarUrl=res.userInfo.avatarUrl;
                        objz.nickName=res.userInfo.nickName;
                        console.log(objz);
                        wx.setStorageSync('userInfo', objz);//存储userInfo
                    }
                });
                var d=that.globalData;//这里存储了appid、secret、token串  
                var url='https://api.weixin.qq.com/sns/jscode2session?appid='+d.appid+'&secret='+d.secret+'&js_code='+res.code+'&grant_type=authorization_code';  
                wx.request({  
                    url: url,  
                    data: {},  
                    method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT  
                    // header: {}, // 设置请求的 header  
                    success: function(res){ 
                        var obj={};
                        obj.openid=res.data.openid;  
                        obj.expires_in=Date.now()+res.data.expires_in;  
                        obj.session_key=res.data.session_key;  
                        console.log(obj);
                        wx.setStorageSync('openid', res.data.openid);//存储openid  
                    }  
                });
            }else {
                console.log('获取用户登录态失败！' + res.errMsg)
            }          
        }  
      }); 
    } 
  },
  getUserInfo:function(cb){
    var that = this
    if(this.globalData.userInfo){
      typeof cb == "function" && cb(this.globalData.userInfo)
    }else{
      //调用登录接口
      wx.login({
        success: function () {
          wx.getUserInfo({
            success: function (res) {
              that.globalData.userInfo = res.userInfo
              typeof cb == "function" && cb(that.globalData.userInfo)
            }
          })
        }
      })
    }
  },
  globalData:{
    userInfo: null,
    appid:'wx7fd249b6b05b107b',//appid需自己提供，此处的appid我随机编写
    secret:'1067d61ebf6002c3c15f0eef2bbd88df',
  },
  
  
})