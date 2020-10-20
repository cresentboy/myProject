$(function () {
    $("#exzoom").exzoom({
        autoPlay: false,
    });//方法调用，务必在加载完后执行
    $(".tab_list li").click(function () {
        $(this).addClass("tab_current").siblings().removeClass("tab_current");
        //获取当前的下标
        var index = $(this).index();
        $(".tab_item").eq(index).show().siblings().hide();
    })
    //页面一旦被加载 2秒钟以后会执行function里面的代码
    var id = window.location.href;


    id = id.substr(id.lastIndexOf("/")+1);

    setTimeout(function () {
        $.ajax({
            type: "POST",
            url: "/item/queryItemDesc",
            data: "id=" + id,
            success: function (msg) {

                $("#itemDesc").append($(msg));
            }
        });
    },2000);

    $("#tab_param").click(function () {
        $.ajax({
            type: "POST",
            url: "/item/queryItemParam",
            data: "id=" + id,
            success: function (msg) {
                $("#paramTable tr").remove();
                $.each(msg,function (index,node) {
                    //得到了每一个json对象
                    var json = msg[index];
                    //根据key 取value 得到组名
                    var groupName = json["groupName"];
                    //根据key 取value 得到组里面的项数组对象
                    var paramArr = json["itemTermList"];
                    $.each(paramArr, function (i, n) {
                        //创建tr标签对象
                        var trObj = $("<tr></tr>");
                        if (i == 0) {
                            var td1 = $("<td rowspan='" + paramArr.length + "'>" + groupName + "</td>");
                            td1.appendTo(trObj);
                        }
                        var td2 = $("<td>" + n.termName + "</td>");
                        td2.appendTo(trObj);
                        var td2 = $("<td>"+n.termValue+"</td>");
                        td2.appendTo(trObj);
                        trObj.appendTo($("#paramTable"));
                    })
                })
            }
        });
    })
    //减号
    $(".btn-reduce").click(function () {
        var num = $(this).siblings("input").val();
        if(num==1){
            return;
        }
        var n = parseInt(num);
        $(this).siblings("input").val(n-1);
    })
    //加号
    $(".btn-add").click(function () {
        var num = $(this).siblings("input").val();
        if(num>=200){
            num = 200;
        }
        var n = parseInt(num);
        $(this).siblings("input").val(n+1);
    })
    //人为输入值
    $(".choose-amount>input").change(function () {
        var num = $(this).val();
        if(num<=1){
            num = 1;
        }
        if(num>=200){
            num = 200;
        }
        $(this).val(num);
    })
    $(".itemCart").click(function () {
        var num = $(".choose-amount>input").val();
        window.location.href = "http://localhost:8081/cart/showCart?id="+id+"&num="+num;
    })
})
