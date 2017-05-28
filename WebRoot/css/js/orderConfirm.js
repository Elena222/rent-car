/**
 * Created by 丽媛 on 2016/8/28.
 */

$(function(){
    var url = "../order/check";
    var sendData = {
        // 'carId':
        // 'serviceId':
        // 'driverName':
        // 'userName':
        // 'userTel':
        // 'driverBirthday':
        // 'driverCardType':
        // 'userMail':
        // 'appellation':
    };
   $.post(url,sendData,function(data){
       $("#m-order-msg").append(
       '<div class=\"container\" style=\"background-color:white;padding:20px 0 20px 0 \">'+
           '<div class=\"row m-order-top-title\">'+
           '<div class=\"col-xs-7 col-xs-offset-1 m-order-top-cleft\">'+
           '<p>订单预定成功，请尽快完成付款哦！！</p>'+
       '</div>'+
       '<div class=\"col-xs-4 pull-right m-order-top-cright\">'+
           '<p>需支付：￥1394</p>'+
       '</div>'+
       '</div>'+
       '<div class=\"row m-order-top-content\">'+
           '<div class=\"col-xs-10 col-xs-offset-1\">'+
           '<p>价格浮动频繁，<span style=\"color:red;font-size: 16px\">59分59秒</span>内完成支付，逾时订单将自动取消</p>'+
       '</div>'+
       '<div class=\"col-xs-10 col-xs-offset-1\">'+
           '<p>商品信息：美国洛杉矶租车订单</p>'+
       '</div>'+
       '<div class=\"col-xs-10 col-xs-offset-1\">'+
           '<p>订单编号：24637468939</p><br>'+
       '</div>'+
       '</div>'+
       '<div class=\"row m-order-middle\">'+
           '<div class=\"col-xs-10 col-xs-offset-1\">'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-12  m-order-middle-border\">'+
           '</div>'+
           '</div>'+
           '<br>'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-12 m-order-middle-carT\">'+
           '<p>车辆信息：</p>'+
       '</div>'+
       '</div>'+
       '<br>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-2 m-order-middle-image\">'+
           '<img src=\"../image/ordercar.png" alt="车辆图片\">'+
           '</div>'+
           '<div class=\"col-xs-5\">'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-12\">'+
           '<p>现代****或同组车型<span>手动挡/4门/5座</span></p>'+
       '</div>'+
       '</div>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-12\">取车：2016年01月03日澳大利亚墨尔airport</div>'+
       '<div class=\"col-xs-12\">还车：2016年02月05日澳大利亚墨尔airport</div>'+
       '</div>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-12\"></div>'+
           '</div>'+
           '</div>'+
           '<div class=\"col-xs-4\">'+
           '<p style=\"margin-left: 200px\">租期：7天</p>'+
       '</div>'+
       '</div>'+
       '<br>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-12\">'+
           '<div class=\"m-order-middle-border\"></div>'+
           '</div>'+
           '</div>'+
           '<br>'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-12 m-order-middlepP\">'+
           '<p>驾驶员信息：</p>'+
       '</div>'+
       '<br></div>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-12\">'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-5\">'+
           '<p>驾驶人：丽媛</p>'+
       '</div>'+
       '<div class=\"col-xs-5\">'+
           '<p>联系人：张明明</p>'+
       '</div>'+
       '</div>'+
       '<div class=\"row\">'+
           '<div class=\"col-xs-5\">'+
           '<p>年龄：20</p>'+
       '</div>'+
       '<div class=\"col-xs-5\">'+
           '<p>手机号：<span style=\"color: #0e2744\">+86</span>131-3938-3829</p>'+
           '</div>'+
           '</div>'+
           '<div class=\"row\">'+
           '<div class=\"col-xs-5\">'+
           '<p>驾照类型：中国驾照</p>'+
       '</div>'+
       '<div class=\"col-xs-5\">'+
           '<p>邮箱地址：82987387@qq.com</p>'+
       '</div>'+
       '</div>'+
       '</div>'+
       '</div>'+
       '</div>'+
       '</div>'+
       '</div>'
       )
   })
});