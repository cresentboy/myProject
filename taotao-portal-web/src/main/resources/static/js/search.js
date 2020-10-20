$(function () {
    var q = decodeURI(window.location.href.split('=')[1]);
    $(".content_crumbs-bar span").text(q);
    $(".search input").val(q);
    var count;
    $.ajax({
        type: "POST",
        url: "/search/query",
        dataType: "json",
        data: "q=" + q,
        success: function (msg) {
            count = msg.count;
            $.each(msg.tbItemList, function (i, n) {
                var $li = $("<li></li>");
                var $div = $("<div id='" + n.id + "' class='item'></div>");
                var $img = $("<img src='" + n.image + "'/>");
                var $span = $("<span class='price'>" + n.barcode + "</span>");
                var $p = $("<p class='sellPoint'><a href='http://localhost:8081/search/showItem/"+n.id+"'>"+n.sellPoint+"</a></p>");
                var $div_cart = $("<div class='search_cart'><i class='iconfont'>&#xf0179;</i><a href='http://localhost:8081/search/showItem/"+n.id+"'>加入购物车</a></div>");
                $div.append($img);
                $div.append($span);
                $div.append($p);
                $div.append($div_cart);
                $li.append($div);
                $(".gl-warp").append($li);
                //
            })
        }
    });
    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'J_bottomPage' //注意，这里的 test1 是 ID，不用加 # 号
            , count: count //数据总数，从服务端得到
            , limit: 60
            , jump: function (obj, first) {
                //首次不执行
                if (!first) {
                    //因为 用户搜索内容永远显示第一页
                    //但是由于第二次用户点击搜索按钮或者点击 下一页他会执行
                    $("html,body").animate({scrollTop:$(".J_filter").offset().top},1);
                    $.ajax({
                        type: "POST",
                        url: "/search/query",
                        dataType: "json",
                        data: "page=" + obj.curr + "&q=" + q,
                        success: function (msg) {
                            //他会删除样式
                            $(".gl-warp").empty();
                            $.each(msg.tbItemList, function (i, n) {
                                    var $li = $("<li></li>");
                                    var $div = $("<div id='" + n.id + "' class='item'></div>");
                                    var $img = $("<img src='" + n.image + "'/>");
                                    var $span = $("<span class='price'>" + n.barcode + "</span>");
                                    var $p = $("<p class='sellPoint'><a href='http://localhost:8081/search/showItem/"+n.id+"'>"+n.sellPoint+"</a></p>");
                                    var $div_cart = $("<div class='search_cart'><i class='iconfont'>&#xf0179;</i><a href='http://localhost:8081/search/showItem/"+n.id+"'>加入购物车</a></div>");
                                    $div.append($img);
                                    $div.append($span);
                                    $div.append($p);
                                    $div.append($div_cart);
                                    $li.append($div);
                                    $(".gl-warp").append($li);

                                }
                            )
                        }
                    });
                }
            }
        });
    });


    $(".search>input").focus(function () {
        $(this).keydown(function (e) {
            if (e.keyCode == 13) {
                var q = $(this).val();
                window.location.href = "http://localhost:8081/search/query?q=" + q;
            }
        })
    })
    $(".searchBtn").click(function () {
        var q = $(".search>input").val();
        window.location.href = "http://localhost:8081/search/query?q=" + q;
    })
    $(".item").click(function () {
        //发起请求 来到controller controller根据id查询数据库得到商品基本信息 商品描述信息 商品规格参数信息
        console.log($(this).attr("id"));
    })
    //对搜索页面整个div设置点击事件
    $(".gl-warp").on("click",".item",function () {
        var id = $(this).attr("id");
        window.location.href = "http://localhost:8081/item/"+id;
    })


})