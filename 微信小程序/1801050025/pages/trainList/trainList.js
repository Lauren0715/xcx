Page({
  data:{
    date:'',
    trainList:[],
    winHeight:600,
    currentTab:'1'
  },
  onLoad:function(e){
     var startStation = e.startStation;//始发站
     var endStation = e.endStation;//终点站
     var date = e.date;//日期
     console.log("startStation="+startStation+"---endStation="+endStation+"---date="+date);
     wx.setNavigationBarTitle({
       title: startStation+'→'+endStation
     });
     this.setData({date:date});
     this.loadTrainsList(startStation,endStation);
  },
  loadTrainsList:function(startStation,endStation){
    var page = this;
    wx.request({
      url: 'https://apis.juhe.cn/train/s2swithprice',
      data: {
        start:startStation,//起发站
        end:endStation,//重点站
        date:'',//日期，如果不填，默认查询明天火车信息
        dtype:'',//火车类型
        key:'5a54c3ff25d0b336ff7dad3d4e889c65'
      },
      method: 'GET', 
      success: function(res){
        console.log(res);
        var trainList = res.data.result.list;
        var size = trainList.length;
        var winHeight = size * 100 + 30;
        page.setData({trainList:trainList});
        page.setData({winHeight:winHeight});
      }
    });    
  },
  switchNav:function (e) {
    var id = e.currentTarget.id;
    console.log(id);
    this.setData({ currentTab: id });
  }
})