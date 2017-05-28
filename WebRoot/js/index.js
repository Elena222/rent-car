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
//alert($.cookie("brpk"));



//滚动广告
$(function(){
    setInterval(function(){
        var newLi = $('.assess-right-content ul>:first').clone(true);
        $('.assess-right-content ul').append(newLi);
        $('.assess-right-content ul>:first').remove();
    },2000);
});