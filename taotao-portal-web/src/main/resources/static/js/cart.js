$(function () {
    //全选
    $(".checkall").change(function () {
        //1.我要获取当前是否选中 选中为checked 没有选中为 没有这个checked
        //

        var checked = $(this).prop("checked");
        if (checked) {
            $(".cart-item").addClass("check-cart-item");
        } else {
            $(".cart-item").removeClass("check-cart-item");
        }

        //得到所有的项 设置属性 为  全选按钮属性等于 每项属性
        $(".j-checkbox,.checkall").prop("checked", checked);
    })
    //每一项被改变了 都会走到这里来
    $(".j-checkbox").change(function () {
        var isChecked = $(this).prop("checked");
        if (isChecked) {
            $(this).parents(".cart-item").addClass("check-cart-item");
        } else {
            $(this).parents(".cart-item").removeClass("check-cart-item");
        }
        // .j-checkbox:checked 找到所有class为 j-checkbox的input输入框 并且为checked选中状态
        if ($(".j-checkbox:checked").length == $(".j-checkbox").length) {
            $(".checkall").prop("checked", true);
        } else {
            $(".checkall").prop("checked", false);
        }
    })
    //为每一个加号设置点击事件 从而修改我们的数量
    $(".increment").click(function () {
        //当前被点击的加号
        /**
         * 给一个标签设置值 有三种方案
         *  1.html
         *      可以获取一个标签里面的内容也可以设置内容
         *      他获取的是整个标签      <span>xxx</span>
         *  2.text
         *      可以获取一个标签里面的内容也可以设置内容
         *      他获取的是<>这里的内容<>
         *  3.val
         *      可以获取一个标签里面的内容也可以设置内容
         *      他只能获取input里面的value
         */
        var num = $(this).siblings(".itxt").val();
        num++;
        $(this).siblings(".itxt").val(num);

        var price = $(this).parents(".p-num").siblings(".p-price").html();
        price = price.substr(1);
        //数量乘以单价
        $(this).parents(".p-num").siblings(".p-sum").html("￥" + num * price);
        //重新计算总金额和总数量
        getSum();


    })
    //为每一个减号设置点击事件 从而修改我们的数量
    $(".decrement").click(function () {
        var num = $(this).siblings(".itxt").val();
        if (num == 1) {
            return false;
        }
        num--;
        $(this).siblings(".itxt").val(num);

        var price = $(this).parents(".p-num").siblings(".p-price").html();
        price = price.substr(1);
        //数量乘以单价
        $(this).parents(".p-num").siblings(".p-sum").html("￥" + num * price);
        //重新计算总金额和总数量
        getSum();
    })
    getSum();
    //计算总数量和总金额的函数
    function getSum() {
        //总数量
        var totalNum = 0;
        //总金额
        var totalMoney = 0;

        $(".itxt").each(function (i, n) {
            totalNum += parseInt($(n).val());
        })

        //使用jQuery修改 总数量
        $(".amount-sum em").text(totalNum);

        $(".p-sum").each(function (i, n) {
            totalMoney += parseFloat($(n).text().substr(1));
        })
        //使用jQuery修改 总金额
        $(".price-sum em").text("￥" + totalMoney);
    }

    //每一项的删除按钮
    $(".p-action a").click(function () {
        $(this).parents(".cart-item").remove();
        //重新计算总金额和总数量
        getSum();
    })
    //选中的删除
    $(".remove-batch").click(function () {
        $(".j-checkbox:checked").parents(".cart-item").remove();
        //重新计算总金额和总数量
        getSum();
    })
    //清空购物车
    $(".clear-all").click(function () {
        $(".cart-item").remove();
        //重新计算总金额和总数量
        getSum();
    })
    $(".car-logo>img").click(function () {
        window.location.href = "http://localhost:8081";
    })
})