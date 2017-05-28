/**
 * Created by 丽媛 on 2016/8/28.
 */


// function setSelectChecked(selectId, cookieValue){
//     var select = document.getElementById(selectId);
//     for(var i=0; i<select.options.length; i++){
//         if(select.options[i].innerHTML == checkValue){
//             select.options[i].selected = true;
//             break;
//         }
//     }
// }


function setSelectValue(selectId,k){
    $(selectId+" option").each(function () {
        if($(this).html() === k){
            $(selectId).val($(this).val());
        }
    });
}

$(setSelectValue("#bring-pk",$.cookie("brpk")));
$(setSelectValue("#bring-tk",$.cookie("brtk")));
$(setSelectValue("#back-pk",$.cookie("bapk")));
$(setSelectValue("#back-tk",$.cookie("batk")));

// alert($("#selectBringPlace1").text());
//显示已选条件
function setPlaceValue(){
    $(".sel").on("click","a",function(){
        // alert($(this).text());
        $("#selected").append($(this).text());
    });

}
$(setPlaceValue());


//向服务器发送取还车位置、车型组、车辆座位、租车公司的信息
$(function(){
    //车型组
    var url1 = '../car/select';
    var sendData = {
        'takeCarCity':$.cookie("brpk"),
        'backCarCity':$.cookie("bapk"),
        'takeCarDateStart':$.cookie("brtk"),
        'backCarDateStart':$.cookie("batk"),
        'seatNum':$(".car-seat").attr("checked"),
        'carCompany':$(".car-com").attr("checked")
    };
   $.post(url1,sendData,function(data){
       $('.type').on('click','.car-img',function(){
          alert(data);
          for(var i = 0;i<data.length;i++){
              $('#carResults').append(
                  '<div class=\"row car-massage\">'+
                  '<div class=\"col-xs-2\">'+
                  '<img src=\"../image/car-detail.png\"/>'+
                  '</div>'+
                  '<div class=\"col-xs-7\">'+
                  '<p><b><span>data[i].content.carName</span> 或同组车型 <span style=\"font-size: 14px\">（类似大众POLO、本田飞度）</span></b></p>'+
                  '<ul>'+
                  '<li>data[i].content.gear</li>'+
                  '<li>'+data[i].content.doorNum+'门'+'</li>'+
                  '<li>'+data[i].content,seatNum+'座'+'</li>'+
                  '<li>data[i].content.carDes</li>'+
                  '</ul>'+
                  '<p style=\"font-size: 14px;clear: both;\">'+'空间：'+data[i].content.spaceDes+'</p>'+
                  '</div>'+
                  '<div class=\"price-none col-xs-2 pull-right\">'+
                  '<h2><span style=\"color:#df4a43 \">'+￥data[i].content.carPrice+'</span><span style=\"font-size: 14px\">/天起</span></h2>'+
                  '</div>'+
                  '</div>'+


                  '<div class="row car-meal ">'+
                  '<table class="col-xs-12">'+
                  '<tr class="pant-com">'+
                  '<td class="col-xs-2">'+
                  '<img src="../image/hertz.png">'+
                  '</td>'+
                  '<td class="col-xs-1" >'+
                  '<p>Hertz</p>'+
                  '</td>'+
                  '<td class="col-xs-3 assess" align="right" >'+
                  '<p class="assess-p" >非常好'+
                  '<span class="small">4.6分</span>'+
              '</p>'+
              '</td>'+
              '<td class="col-xs-7">'+
                  '<table class="row">'+
                  '<tr class="taocan">'+
                  '<td class="col-xs-5">无线下中介服务</td>'+
                  '<td class="col-xs-3">￥234/天</td>'+
                  '<td class="col-xs-2" >'+
                  '<a href="../html/carInfor.html" target="_blank" class="btn btn-danger">详情</a>'+
                  '</td>'+
                  '</tr>'+
                  '</table>'+
                  '<table class="row">'+
                  '<tr class="taocan">'+
                  '<td class="col-xs-5">司导</td>'+
                  '<td class="col-xs-3">￥456/天</td>'+
                  '<td class="col-xs-2" >'+
                  '<a href="../html/carInfor.html" target="_blank" class="btn btn-danger">详情</a>'+
                  '</td>'+
                  '</tr>'+
                  '</table>'+
                  '<table class="row">'+
                  '<tr class="taocan">'+
                  '<td class="col-xs-5">司导+线路规划</td>'+
                  '<td class="col-xs-3">￥678/天</td>'+
                  '<td class="col-xs-2" >'+
                  '<a href="../html/carInfor.html" target="_blank" class="btn btn-danger">详情</a>'+
                  '</td>'+
                  '</tr>'+
                  '</table>'+
                  '<table class="row">'+
                  '<tr class="taocan">'+
                  '<td class="col-xs-5">私人定制</td>'+
                  '<td class="col-xs-3">￥1678/天</td>'+
                  '<td class="col-xs-2" >'+
                  '<a href="../html/carInfor.html" target="_blank" class="btn btn-danger">详情</a>'+
                  '</td>'+
                  '</tr>'+
                  '</table>'+
                  '</td>'+
                  '</tr>'+
                  '</table>'+
                  '</div>'
              )
          }
       });
   });

    $(".taocan").on("click",".btn",function () {
        $.cookie("carId",$(".car-message p b span").val());
    })
});




