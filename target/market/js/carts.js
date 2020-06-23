window.onload = function() {
    function cart() {
        this.abtn = document.querySelectorAll('input');
        this.ogood_num = document.querySelector('.allgoods_num');
        this.opricetal = document.querySelector('.pricetal');
        this.opricest = document.querySelector('.pricest');
        this.totalnum = 0;
    };
    //小计:  商品数量 * 商品单价
    cart.prototype.getsubtotal = function(goodsnum, unitprice) {
        return parseInt(goodsnum) * parseFloat(unitprice);
    };
    // 计算商品的总计花费
    cart.prototype.gettotal = function() {
        var asubtotal = document.querySelectorAll('.subtal');
        var res = 0;
        for (var i = 0, len = asubtotal.length; i < len; i++) {
            res += parseFloat(asubtotal[i].innerHTML);
        };
        return res;
    };

    // 点击“+”号按钮触发的购物车商品数量，花费，最大价格的变动
    cart.prototype.plus = function(obtn) {
        var onum = obtn.parentNode.querySelector('.num');
        var n = parseInt(onum.innerHTML);
        var sn = parseInt(this.ogood_num.innerHTML);
        this.totalnum=sn;
        onum.innerHTML = ++n;
        this.totalnum+=1;
        var oUnit = obtn.parentNode.parentNode.parentNode.querySelector('.unit');
        var osubtotal = obtn.parentNode.parentNode.parentNode.querySelector('.subtal');
        osubtotal.innerHTML = this.getsubtotal(onum.innerHTML, oUnit.innerHTML);
        this.ogood_num.innerHTML = this.totalnum;
        this.opricetal.innerHTML = this.gettotal();
    };
    // 点击“-”号按钮触发的购物车商品数量，花费，最大价格的变动
    cart.prototype.minus = function(obtn) {
        var onum = obtn.parentNode.querySelector('.num');
        if (parseInt(onum.innerHTML) > 0) {
            var n = parseInt(onum.innerHTML);
            var sn = parseInt(this.ogood_num.innerHTML);
            this.totalnum=sn;
            onum.innerHTML = --n;
            this.totalnum--;
            var oUnit = obtn.parentNode.parentNode.parentNode.querySelector('.unit');
            var osubtotal = obtn.parentNode.parentNode.parentNode.querySelector('.subtal');
            osubtotal.innerHTML = this.getsubtotal(onum.innerHTML, oUnit.innerHTML);
            this.ogood_num.innerHTML = this.totalnum;
            this.opricetal.innerHTML = this.gettotal();
        }
    };
    // 获取已买商品的总计数量
    cart.prototype.getNumbertal = function() {
        var anum = document.querySelectorAll('.num');
        var res_num = 0;
        for (var i = 0; i < anum.length; i++) {
            res_num += parseInt(anum[i].innerHTML);
        }
        return res_num;
    }
    // 删除按钮触发的购物车商品数量，花费，最大价格的变动
    cart.prototype.del = function(obtn) {
        var odel = obtn.parentNode.parentNode;
        var oparent = odel.parentNode;
        oparent.removeChild(odel);
        this.ogood_num.innerHTML = this.getNumbertal();
        this.opricetal.innerHTML = this.gettotal();
        this.opricest.innerHTML = this.compareMaxunit();
        this.xuhaosort();
    }
    // 购物车序号重新排序
    cart.prototype.xuhaosort = function() {
        var axuhao = document.querySelectorAll('.xuhao');
        for (var i = 0, len = axuhao.length; i < len; i++) {
            axuhao[i].innerHTML = i + 1;
        }
    }
    // 绑定“+”，“-”，删除按钮的点击事件
    cart.prototype.bind = function() {
        var that = this;
        for (var i = 0; i < this.abtn.length; i++) {
            if (i % 2 != 0) {
                this.abtn[i].onclick = function() {
                    that.plus(this);
                }
            } else {
                this.abtn[i].onclick = function() {
                    that.minus(this);
                }
            }
        };
        var delbtn = document.querySelectorAll('.del');
        for (var i = 0; i < delbtn.length; i++) {
            delbtn[i].onclick = function() {
                that.del(this);
            }
        }
    };
    var oCart = new cart();
    oCart.bind();
}
function deleteCarts() {
    var href = "../carts/deleteCarts?user_id="+document.getElementById("user_id").value+"&carts_name="+document.getElementById("carts_name").innerHTML;
    window.location.href = href;
}
function buyall() {
    var href = "../carts/buyAll";
    window.location.href = href;
}