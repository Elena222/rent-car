/**
 * Created by 13002 on 2016/8/19.
 */
/**
 * Created by 13002 on 2016/8/19.
 */
$("#li1").mousemove(function(){
    $("#li1").css("background-color","#e1e1e1 ");
    $("#li1 a").css("color","red");
        
});

$("#li1").mouseleave(function(){
    $("#li1").css("background-color","white ");
    $("#li1 a").css("color","#585858");
});

$("#li2").mousemove(function(){
    $("#li2").css("background-color","#e1e1e1 ");
    $("#li2 a").css("color","red");
});

$("#li2").mouseleave(function(){
    $("#li2").css("background-color","white ");
    $("#li2 a").css("color","#585858");
});

$("#li3").mousemove(function(){
    $("#li3").css("background-color","#e1e1e1 ");
    $("#li3 a").css("color","red");
});

$("#li3").mouseleave(function(){
    $("#li3").css("background-color","white ");
    $("#li3 a").css("color","#585858");
});

$("#li4").mousemove(function(){
    $("#li4").css("background-color","#e1e1e1 ");
    $("#li4 a").css("color","red");
});

$("#li4").mouseleave(function(){
    $("#li4").css("background-color","white ");
    $("#li4 a").css("color","#585858");
});

$("#li5").mousemove(function(){
    $("#li5").css("background-color","#e1e1e1 ");
    $("#li5 a").css("color","red");
});

$("#li5").mouseleave(function(){
    $("#li5").css("background-color","white ");
    $("#li5 a").css("color","#585858");
});

$("#li6").mousemove(function(){
    $("#li6").css("background-color","#e1e1e1 ");
    $("#li6 a").css("color","red");
});

$("#li6").mouseleave(function(){
    $("#li6").css("background-color","white ");
    $("#li6 a").css("color","#585858");
});


$(function(){
    $("#li4").click(function(){
        if($.cookie('userId')!=null){
            location.url("../html/orderInquiry.html");
        }
        else{
            alert("请先登陆！");
        }
    })
});
