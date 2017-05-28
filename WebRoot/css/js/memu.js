/**
 * Created by 丽媛 on 2016/8/28.
 */
$(function(){
    var driverCardType;
    var input = $("#controls input");
    for(var i = 0;i<input.length;i++){
        if(input[i].attr('checked')){
            driverCardType = input[i].value;
        }
    }
    var url = '../order/add';
    var sendData = {
        'driverBirthday':$("#birthday").val(),
        'driverCardType':driverCardType,
        'appellation':$('#sirOrMadam').val(),
        'driverName':$("#name").val(),
        'userTel':$('#tel').val(),
        'userMail':$('#mail').val(),

    };
    $("#pay").click(function(){

        $.post(url,sendData,function(data){
            if(data){
                alert("提交成功！");
            }
            else{
                alert("提交失败！");
            }
        })
    });
});





























/**
 * Created by 丽媛 on 2016/8/28.
 */
