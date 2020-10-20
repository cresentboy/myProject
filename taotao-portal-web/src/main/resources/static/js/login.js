$(function () {
    $(".form_login").click(function () {
    var username = $('.username');
    var password = $(".password");
    var span1 = $("#span1");
var denglu1 = $(".fr>li:eq(1)>a");
var denglu2 = $(".fr>li:eq(1)");
        $.ajax({
            type:"get",
            url:"/login",
            dataType:"json",
            data:"username="+username.val()+"&password="+password.val(),
            success:function (obj) {

                span1.html(obj.msg);
                if (obj.status==200){
                    window.setTimeout("window.location='http://localhost:8081/index.html'",1000);

                /* denglu2.empty();
                 console.log(username.val());
                 denglu2.append("<a>欢迎你，"+username.val()+"</a>");*/
                    //$(".welcome").text("欢迎你，"+username.val());
                }

                //window.location.href = "http://localhost:8081/index.html";

            },


        });

    });





});