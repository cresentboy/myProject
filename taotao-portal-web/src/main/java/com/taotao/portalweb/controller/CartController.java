package com.taotao.portalweb.controller;

import com.taotao.portalweb.bean.TbItem;
import com.taotao.portalweb.constant.ContentConstant;
import com.taotao.portalweb.service.TbItemService;
import com.taotao.portalweb.utils.JsonUtils;
import com.taotao.portalweb.utils.TaotaoResult;
import com.taotao.portalweb.vo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private TbItemService tbItemService;

    @RequestMapping("/addCart")
    public String addCart(Long id, Integer num, HttpServletRequest request, HttpServletResponse response) {
        List<Cart> carts = new ArrayList<Cart>();
        Cookie[] cookies = request.getCookies();
        if (cookies == null && id == null) {
            return "cart";
        }
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                //意味着浏览器里面有一个cookie 的key叫做 cart value是map集合
                if (c.getName().equals("cart") && c.getValue().length() > 10) {
                    cookie = c;
                    break;
                }
            }
        }
        //及没有传入id 也在浏览器上面没有cookie 为cart的cookie
        if (id == null && cookie == null) {
            //意味着  没有购物车 用户又点击跳转购物车
            return "cart";
        }

        //走到这里意味着 id一定不为kong cookie 可能为空
        Cart cart = new Cart();
        cart.setId(id);
        cart.setNum(num);
        //想办法吧对象变成json字符串，
        //从cookie里面取出来的时候 在吧json字符串变成java对象
        boolean isFlag = false;
        if (cookie != null) {
            //现在的客户端里面 有一个cookie key叫做cart value是商品json字符串集合对象
            String value = cookie.getValue();
            value = URLDecoder.decode(value);
            carts = JsonUtils.jsonToList(value, Cart.class);
            for (Cart c : carts) {
                if (c.getId().longValue() == cart.getId().longValue()) {
                    c.setNum(c.getNum() + num);
                    isFlag = true;
                    break;
                }
            }
        }
        //如果cookie里面有商品
        if (!isFlag) {
            carts.add(cart);
        }
        String json = JsonUtils.objectToJson(carts);
        json = URLEncoder.encode(json);
        cookie = new Cookie(ContentConstant.CART, json);
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
        //吧页面跳转改为重定向了 因为改为了重定向 所以在此刷新页面 他不会有请求
        //因为是重定向 所以model 传递不过去
        return "redirect:/cart.html";
    }

    @RequestMapping("/showCart")
    @ResponseBody
    public TaotaoResult showCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(ContentConstant.CART)) {
                    cookie = c;
                    break;
                }
            }
        }

        if (cookie == null) {
            return TaotaoResult.build(500,"购物车没有商品");
        }
        List<Cart> carts = JsonUtils.jsonToList(URLDecoder.decode(cookie.getValue()), Cart.class);
        List<TbItem> tbItems = tbItemService.findTbItems(carts);

        return TaotaoResult.ok(tbItems);
    }

    @RequestMapping("/delCart")
    public String delCart(Long id, HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals(ContentConstant.CART)) {
                cookie = c;
                break;
            }
        }
        List<Cart> carts = JsonUtils.jsonToList(URLDecoder.decode(cookie.getValue()), Cart.class);
        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            if(cart.getId().longValue()==id.longValue()){
                carts.remove(i);
                break;
            }
        }
        if(carts.size()==0){
            //0就是立刻消失 -1 就是关闭浏览器消失
            cookie.setMaxAge(0);
        }
        cookie.setValue(URLEncoder.encode(JsonUtils.objectToJson(carts)));
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
        return "redirect:/cart.html";
    }
}
