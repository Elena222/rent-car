/**
 * Created by CC on 2016/9/11.
 */

//注册
$(function(){
    $('#register-button').click(function(){

        var url='../user/register';

        var sendData = {'userTel':$('#mobile-input').val(),
                        'userMail':$('#email-input').val()};

        $.post(url,sendData,function(data){
            var data = JSON.parse(data);
            if(data){
                alert("注册成功！请登录");
                location.href = ("../html/enter.html");
            }
            else{
                alert("该用户已经存在，请重新输入");
            }
        });
    });

});

//登陆
$(function(){
   $('#enter-button').click(function(){
       var url='../user/login';
       var sendData = {'userName':$('#loginTel').val(),
                       'passWord':$('#loginPsw').val()};
       $.post(url,sendData,function(data){
           var data = JSON.parse(data);
           if(data===false){
               $('.message-box').attr('padding-top','10px');
               $('.password-input').append('<p>账号或者密码错误</p>');
           }
           else{
               alert("登陆成功！");
               location.href = ("../html/index.html");
           }
       });
   })
});

var userId = $('#mobile-input').val();
$.cookie('userId',userId);

//查询订单
$(function(){
    var url='../order/select';
    var sendData={
        'userId':$.cookie('userId')
    };
   $.post(url,sendData,function(data){
      for(var i = 0;i<data.length;i++){
          var data=JSON.parse(data);
          $('#inquiry-main').append(
              '<div class=\"row order-date\">'+
              '<div class=\"col-xs-3\">'+
              '<p>下单时间：'+data[i].content.takeCarDate+'</p>'+
              '</div>'+
              '<div class=\"col-xs-9\">'+
              '<p>订单编号：27364568234234</p>'+
              '</div>'+
              '</div>'+
              '<div class=\"row order-main\">'+
              '<div class=\"col-xs-2\" style=\"text-align: left\">'+
              '<img src=\"../image/car-detail.png\">'+
              '</div>'+
              '<div class=\"col-xs-4\" style=\"text-align: left\">'+
              '<p style="font-size:20px\">'+data[i].content.carName+'或同组车型'+'</p>'+
              '<p>'+'取车位置：'+data[i].content.takeCarPlace+'&nbsp;&nbsp;&nbsp;'+data[i].content+'还车位置：'+data[i].content.backCarPlace+'</p>'+
              '<p>'+'取车时间：'+data[i].content.takeCarDate+'&nbsp;&nbsp;&nbsp;还车时间：'+data[i].content.backCarDate+'</p>'+
              '<p>服务：司导服务，儿童座椅</p>'+
              '</div>'+
              '<div class=\"col-xs-3 mon\"><P>￥data[i].content.totalPrice</P></div>'+
              '<div class=\"col-xs-3\" style=\"text-align: left\">'+
              '<p style=\"float: left;\">交易成功</p>'+
              '<!--<a class="c-but btn btn-danger">确认订单</a>-->'+
              '<a class=\"c-comfirm\">确认订单</a>'+
              '</div>'+
              '</div>'
          )
      }
   });
});
