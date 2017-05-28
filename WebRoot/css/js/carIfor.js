/**
 * Created by 13002 on 2016/8/18.
 */
$(function(){
    var url='../car/info';
    var sendData = {'carId':$.cookie("carId")};
    $.post(url,sendData,function(data){
        var data = JSON.parse(data);
        $(".m-carInfor-top").append(
        '<div class=\"col-xs-3 m-carInfor-c-left\">'+
           '<div class=\"row\">'+
            '<div class=\"col-xs-10 col-xs-offset-1\">'+
            '<div class=\"row\">'+
            '<div class=\"col-xs-12 m-carInfor-c-left-bigImage\">'+
            '<img src=\"../image/car-detail.png\\" alt=\"汽车大图\">'+
            '</div>'+
            '</div>'+
            '<div class=\"row m-carInfor-c-left-smallImage\">'+
            '<div class=\"col-xs-3 m-carInfor-c-left-scar\"><img src=\"../image/car-detail.png\" alt=\"汽车小图\"></div>'+
            '<div class=\"col-xs-3 m-carInfor-c-left-scar\"><img src=\"../image/car-detail.png\" alt=\"汽车小图\"></div>'+
            '<div class=\"col-xs-3 m-carInfor-c-left-scar\"><img src=\"../image/car-detail.png\" alt=\"汽车小图\"></div>'+
            '<div class=\"col-xs-3 m-carInfor-c-left-scar\"><img src=\"../image/car-detail.png\" alt=\"汽车小图\"></div>'+
            '</div>'+
            '<div class=\"row m-carInfor-c-left-info\">'+
            '<br>'+
            '<p>data.content.gear+data.content.seatNum+data.content.doorNum</p>'+
        '<p>建议乘坐4人+2行李箱</p>'+
        '<p>小巧灵活，适合都市代步</p>'+
        '<br>'+
        '<p>取车：' +data.content.takeCarDate+
        '</p>'+
        '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+ data.content.takeCarPlace+
        '</p>'+
        '<p>还车：'+data.content.backCarDate+
        '</p>'+
        '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.content.backCarPlace+'</p>'+
        '<br>'+
        '<p><a href="#">查看门店地址营业时间等信息</a></p>'+
            '<p>**取还车时间均为当地时间**</p><br><br>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class=\"col-xs-6 m-carInfor-c-middle\" id=\"middle\">'+
            '<div class=\"row m-carInfor-c-middle-carPrice\">'+
            '<div class=\"col-xs-12\">'+
            '<p>'+
            '<h2>车辆名称：'+data.content.carName +
        '<a href=\"#\" style=\"font-size: 20px\"> 或同 组车型 </a><span style=\"font-size: 20px\">（类似大众POLO、本田飞度）</span></h2></p>'+
        '<p>现在预订，到店支付！总价已包含异地还车费！含全额险！</p>'+
        '<p>车辆总价：<span style=\"font-size: 24px;color:red\">￥'+data.content.totalPrice+'</span>（7天租期，日均￥537）</p>'+
        '<p>套餐注意事项:</p>'+
        '<p style=\"text-indent:25px\">预付订单通常享受最优惠的价格，您提交订单时需要在线支付人民币 '+data.content.totalPrice+' 元.本套餐不包含加强型第三者险，而在美国造成第三者伤亡的赔付金额非常高，因此取车时需在门店购买（门店价约¥537/天）</p>'+
        '</div>'+
        '</div>'+
        '<div class=\"row car-service\">'+
            '<div class=\"m-carInfor-c-middle-carService\">'+
            '<p>'+
            '<h3>可选服务及简单介绍：</h3></p>'+
        '<div class="row">'+
            '<div class=\"col-xs-3\" ><p><input type=\"checkbox\" checked=\"checked\">服务一：</p></div>'+
        '<div class=\"col-xs-9\" style=\"padding-left:0\">'+
            '<p>服务一的简单介绍：*****************************************</p>'+
        '</div>'+
        '</div>'+
        '<div class=\"row\">'+
            '<div class=\"col-xs-3\" ><p><input type=\"checkbox\" checked=\"checked\">服务二：</p></div>'+
        '<div class=\"col-xs-9\" style=\"padding-left:0\">'+
            '<p>服务二的简单介绍：*******************************</p>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '<div class=\"row m-carInfor-c-middle-carPay\">'+
            '<div class=\"col-xs-4\">'+
            '<h3>燃油说明:</h3>'+
        '</div>'+
        '<div class=\"col-xs-3 \" style=\"margin-top: 23px\">'+
            '<input type=\"radio\" value=\"100\" name=\"manyou\">&nbsp;&nbsp;&nbsp;满油取还</div>'+
        '<div class=\"col-xs-3\" style=\"margin-top: 23px\">'+
            '<input type=\"radio\" value=\"101\" name=\"manyou\">&nbsp;&nbsp;&nbsp;满油取还</div>'+
        '</div>'+
        '<div class=\"row m-carInfor-c-middle-carPay\">'+
             '<div class=\"row\">'+
            '<div class=\"col-xs-4\">'+
            '<h3>&nbsp;&nbsp;支付方式:</h3>'+
        '</div>'+
        '<div class=\"col-xs-3\ " style=\"margin-top: 23px\">'+
            '<input type=\"radio\" value=\"103\" name=\"zhifu\">&nbsp;&nbsp;&nbsp;线上支付</div>'+
        '<div class=\"col-xs-3\" style=\"margin-top: 23px\">'+
            '<input type=\"radio\" value=\"104\" name=\"zhifu\">&nbsp;&nbsp;&nbsp;线下支付</div>'+
        '</div>'+
        '<br><br>'+
            '<div class=\"col-xs-6 col-xs-offset-4 m-carInfor-middle-carPay-inp\" >'+
            '<a href=\"../html/memu.html\" class=\"btn btn-danger\" style=\"display:block;width:160px\">立即预订</a>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class=\"col-xs-3 m-carInfor-c-right\">'+
            '<div class=\"row\">'+
            '<div class=\"col-xs-10 col-xs-offset-1\">'+
            '<div class=\"row m-carInfor-c-right-ico\">'+
            '<div class=\"col-xs-10 col-xs-offset-2\">'+
            '<img src=\"../image/hertz.png\" alt=\"租车公司图标\">'+
            '</div>'+
            '</div>'+
            '</div>'+
            '<div class=\"row\">'+
            '<div class=\"col-xs-9  col-xs-offset-3 m-carInfor-c-right-info\">'+
            '<p style=\" width: 50%;\">公司简单介绍：************</p>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'
        );
    })
});