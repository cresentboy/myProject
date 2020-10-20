$(function () {
    function getQueryVariable(variable)
    {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){return pair[1];}
        }
        return(false);
    }

  var to =  getQueryVariable("email");


    $.ajax({
        type:"get",
        url:"/activateMail",
        dataType:"json",
        data:"to="+to,
        success:function (msg) {
            console.log(msg);
        }
    });
})