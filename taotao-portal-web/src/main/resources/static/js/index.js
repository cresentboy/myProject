$(function () {
    var arr = [
        ["家电馆&nbsp;>", "家电专卖店&nbsp;>", "家电服务&nbsp;>", "企业采购&nbsp;>", "商用电器&nbsp;>", "以旧换新&nbsp;>"],
        ["玩3c&nbsp;>", "手机频道&nbsp;>", "网上营业厅&nbsp;>", "配件频道&nbsp;>", "智能数码&nbsp;>", "影像Club&nbsp;>"],
        ["玩3c&nbsp;>", "电脑办公&nbsp;>", "企业采购&nbsp;>", "GAME+&nbsp;>", "装机大师&nbsp;>", "电脑租赁&nbsp;>"],
        ["家装城&nbsp;>", "居家日用&nbsp;>", "精品家具&nbsp;>", "家装建材&nbsp;>", "国际厨具&nbsp;>", "装修服务&nbsp;>"],
        ["男装&nbsp;>", "女装&nbsp;>", "内衣&nbsp;>", "童装"],
        ["清洁用品&nbsp;>", "美妆馆&nbsp;>", "个护馆&nbsp;>", "妆比社&nbsp;>", "京东国际美妆&nbsp;>", "宠物管&nbsp;>"],
        ["家电馆&nbsp;>", "家电专卖店&nbsp;>", "家电服务&nbsp;>", "企业采购&nbsp;>", "商用电器&nbsp;>", "以旧换新&nbsp;>"],
        ["玩3c&nbsp;>", "手机频道&nbsp;>", "网上营业厅&nbsp;>", "配件频道&nbsp;>", "智能数码&nbsp;>", "影像Club&nbsp;>"],
        ["玩3c&nbsp;>", "电脑办公&nbsp;>", "企业采购&nbsp;>", "GAME+&nbsp;>", "装机大师&nbsp;>", "电脑租赁&nbsp;>"],
        ["家装城&nbsp;>", "居家日用&nbsp;>", "精品家具&nbsp;>", "家装建材&nbsp;>", "国际厨具&nbsp;>", "装修服务&nbsp;>"],
        ["男装&nbsp;>", "女装&nbsp;>", "内衣&nbsp;>", "童装"],
        ["清洁用品&nbsp;>", "美妆馆&nbsp;>", "个护馆&nbsp;>", "妆比社&nbsp;>", "京东国际美妆&nbsp;>", "宠物管&nbsp;>"],
        ["家电馆&nbsp;>", "家电专卖店&nbsp;>", "家电服务&nbsp;>", "企业采购&nbsp;>", "商用电器&nbsp;>", "以旧换新&nbsp;>"],
        ["玩3c&nbsp;>", "手机频道&nbsp;>", "网上营业厅&nbsp;>", "配件频道&nbsp;>", "智能数码&nbsp;>", "影像Club&nbsp;>"],
        ["玩3c&nbsp;>", "电脑办公&nbsp;>", "企业采购&nbsp;>", "GAME+&nbsp;>", "装机大师&nbsp;>", "电脑租赁&nbsp;>"],
        ["家装城&nbsp;>", "居家日用&nbsp;>", "精品家具&nbsp;>", "家装建材&nbsp;>", "国际厨具&nbsp;>", "装修服务&nbsp;>"]
    ];
    $(".fs-col1 ul li").mouseenter(function () {
        var id = $(this).prop("id");
        var arrIndex = $(this).index();
        var aArr = arr[arrIndex];
        $(".cate_header").empty();
        $.each(aArr, function (j, a) {
            $(".cate_header").append("<a href='#'>" + a + "</a>&nbsp;");

        })
        $(".cate_list div").remove();
        $.ajax({
            type: "POST",
            url: "/itemCat/queryItemCat",
            dataType: "json",
            data: "id=" + id,
            success: function (msg) {
                $.each(msg, function (index, node) {
                    var $div1 = $("<div class='cate_list_fl'><a href='#'>" + node.name + "</a></div>");
                    $div1.appendTo($(".cate_list"));
                    var $div2 = $("<div class='cate_list_fr'></div>");
                    $.each(node["classThrees"], function (i, n) {
                        var $a = $("<a href='#'>" + n.name + "</a>");
                        $a.appendTo($div2);
                    })

                    $div2.appendTo($(".cate_list"));
                })
            }
        });
        $(".cate_pop").show();
    })
    $(".fs-col1 ul li").mouseleave(function () {
        $(".cate_pop").hide();
    })
    $(".cate_pop").mouseenter(function () {
        $(".cate_pop").show();
    })
    $(".cate_pop").mouseleave(function () {
        $(".cate_pop").hide();
    })

    $(".J_event a i").click(function () {
        $(this).parents(".J_event").remove();
    })
    layui.use(['carousel', 'form'], function () {
        var carousel = layui.carousel
            , form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1',
            arrow: 'hover',
            interval: 2000,
            width: '790px',
            height: '340px'
        });
    });
    //页面已加载就去后台请求内容展示在页面上面
    $.ajax({
        type: "POST",
        url: "/showContent",
        dataType: "json",
        success: function (res) {
            //问这个code == 200吗？ 如果不等于200 用静态数据来加载
            $.each(res.data, function (i, n) {
                $("#ad1").append("<div><img src='" + n.pic + "'/></div>");
            })
        }
    });
    //获取焦点事件
    $(".search>input").focus(function () {
        $(this).keydown(function (e) {
            if (e.keyCode == 13) {
                var q = $(this).val();
                window.location.href = encodeURI("http://localhost:8081/search.html?q=" + q);
            }
        })
    })
    $(".searchBtn").click(function () {
        var q = $(".search>input").val();
        window.location.href = encodeURI("http://localhost:8081/search.html?q=" + q);
    })

    $(".mycart>a").click(function () {
        window.location.href = "http://localhost:8081/cart/showCart";

    })

})