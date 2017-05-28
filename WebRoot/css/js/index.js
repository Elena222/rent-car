/**
 * Created by Administrator on 2016/8/21/021.
 */

$(function(){
    $(".sale-right").on('mouseover','.sale-right-r',function(){
        $(this).find('img').css('margin-left','-10px');
    })
    $(".sale-right").on('mouseout','.sale-right-r',function(){
        $(this).find('img').css('margin-left','0');
    })
});
function cok() {
    var brpk = $('#bring-pk').val();
    var brtk = $('#bring-tk').val();
    var bapk = $('#back-pk').val();
    var batk = $('#back-tk').val();
    $.cookie('brpk', brpk);
    $.cookie('brtk', brtk);
    $.cookie('bapk', bapk);
    $.cookie('batk', batk);
}


$(function(){
    var url="../car/select";
//选择取车地点取车时间
    $.get(url,null,function(data){
        var data=JSON.parse(data);
        for(var i=0;i<data.where.length;i++){
            $('#bring-pk').append(
                '<option value=i>data.where[i]</option>') ;
        }
        for(var j=0;j<data.time.length;j++){
            $('#bring-tk').append(
                '<option value=i>data.time[i]</option>') ;
        }
    });
//选择还车地点还车时间
    $.get(url,null,function(data){
        var data=JSON.parse(data);
        for(var i=0;i<data.where.length;i++){
            $('#back-pk').append(
                '<option value=i>data.where[i]</option>') ;
        }
        for(var j=0;j<data.time.length;j++){
            $('#back-tk').append(
                '<option value=i>data.time[i]</option>') ;
        }
    });
});

//滚动广告
$(function(){
    setInterval(function(){
        var newLi = $('.assess-right-content ul>:first').clone(true);
        $('.assess-right-content ul').append(newLi);
        $('.assess-right-content ul>:first').remove();
    },2000);
});