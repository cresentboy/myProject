$(function () {
    var userName = $("#userName");
    var passWord = $("#pwd");
    var pwd2 = $("#pwd2");
    var email = $("#email");
    var phone = $("#mobile");
    var ck = $("#ck");
var tbUser = {};
    userName.blur(function () {

    if(userName.val() ==null ||userName.val().trim() ===''){
        $('span:eq(0)').text("用户名不能为空");
        userName.focus();
    }else{
        $('span:eq(0)').text("");
    }
    });
    passWord.blur(function () {
        if (passWord.val()==null||passWord.val().trim()===''){
            $('span:eq(1)').text("密码不能为空");
            passWord.focus();
        }else{
            $('span:eq(1)').text("");
        }
    });
    pwd2.blur(function () {
        if (pwd2.val()==null||pwd2.val().trim()===''){
            $('span:eq(2)').text("确认密码不能为空");
            pwd2.focus();
        }else{
            $('span:eq(2)').text("");
        }
        if (pwd2.val().trim()!=passWord.val().trim()){
            $('span:eq(2)').text("两次密码不一致");
            passWord.focus();
        }else{
            $('span:eq(2)').text("");
        }
    });
    email.blur(function () {
        if (email.val()==null||email.val().trim()===''){
            $('span:eq(3)').text("邮箱不能为空");
            email.focus();
        }else{
            $('span:eq(3)').text("");
        }
    });
    phone.blur(function () {
        if (phone.val()==null||phone.val().trim()===''){
            $('span:eq(4)').text("手机号不能为空");
            phone.focus();
        }else{
            $('span:eq(4)').text("");
        }
    });
    $("#btn").click(function () {
        if(userName.val() ==null ||userName.val().trim() ===''){
            $('span:eq(0)').text("用户名不能为空");
            userName.focus();
        }
        else if (passWord.val()==null||passWord.val().trim()===''){
            $('span:eq(1)').text("密码不能为空");
            passWord.focus();
        }
        else if (pwd2.val()==null||pwd2.val().trim()===''){
            $('span:eq(2)').text("确认密码不能为空");
            pwd2.focus();
        }
        else if (email.val()==null||email.val().trim()===''){
            $('span:eq(3)').text("邮箱不能为空");
            email.focus();
        }
        else if (phone.val()==null||phone.val().trim()===''){
            $('span:eq(4)').text("手机号不能为空");
            phone.focus();
        }else if(!ck.is(":checked")){
            $('span:eq(5)').text("请勾选注册协议");
            phone.focus();
        }
        else{
            $('span:eq(5)').text("通过验证");
        }
        tbUser.userName = userName.val();
        tbUser.passWord = passWord.val();
        tbUser.email = email.val();
        tbUser.phone = phone.val();
        console.log(tbUser);

        $.ajax({
            type:"post",
            url:"/register",
            dataType:"json",
            contentType: "application/json;charset=utf-8",
            data:JSON.stringify(tbUser),
            success:function (msg) {
                console.log(msg);
                window.location.href = encodeURI("http://localhost:8081/login.html");
            }
        });

    })


})