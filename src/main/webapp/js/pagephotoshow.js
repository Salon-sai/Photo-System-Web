(function() {
    window.define = function(g, e, i) {
        i()
    }
})();
define("{lib}base/global.js", [],
function() {
    var g = {},
    e = function() {
        this._$super.apply(this, arguments)
    },
    i = function(b, a) {
        if (b && U._$isType(b, "function") && U._$isType(this, "function")) {
            if (a) for (var d in b) U._$isType(b[d], "function") && (this[d] = b[d]);
            this._$super = b;
            this._$supro = b.prototype;
            this.prototype = new b(g);
            this.prototype.constructor = this;
            this.prototype._$initialize = e;
            var c = b;
            this.prototype._$super = function() {
                var a = c.prototype._$initialize;
                c = c._$super || b;
                return !! a && a.apply(this, arguments)
            };
            return this.prototype
        }
    },
    k = function() {
        for (var b = this.prototype,
        a = 0,
        d = arguments.length,
        c; a < d; a++) if (c = arguments[a], U._$isType(c, "function")) {
            c = c.prototype;
            for (var h in c) U._$isType(c[h], "function") && (b[h] = c[h])
        }
        return b
    },
    f = function() {
        var b = this,
        a = arguments,
        d = Array.prototype.shift.call(arguments);
        return function() {
            Array.prototype.push.apply(arguments, a);
            return b.apply(d || window, arguments)
        }
    };
    window.O = {};
    window.F = function() {
        return ! 1
    };
    window.P = function(b) {
        if (!b || !b.length) return null;
        for (var a = window,
        b = b.split("."), d = b.length, c = "window" == b[0] ? 1 : 0; c < d; a = a[b[c]] = a[b[c]] || {},
        c++);
        return a
    };
    window.C = function() {
        var b = function() {
            if (arguments[0] != g && this._$initialize) return this._$initialize.apply(this, arguments)
        };
        b._$extend = i;
        b._$implement = k;
        return b
    };
    Function.prototype._$bind = function() {
        var b = arguments,
        a = arguments[0],
        d = this;
        return function() {
            var c = [].slice.call(b, 1); [].push.apply(c, arguments);
            return d.apply(a || window, c)
        }
    };
    Function.prototype._$bind2 = f;
    Function.prototype._$bindAsEventListener = f;
    f = P("N");
    f.rc = f.rc || {};
    f.xd = f.xd || [];
    f.tm = f.tm || O;
    f.ui = f.ui || "ntes.ui";
    f.ut = f.ut || "ntes.util";
    f.gb = f.gb || "ntes.global";
    f.gw = f.gw || "ntes.widget";
    f.fw = f.fw || "ntes.framework";
    f.rc.r = f.rc.r || "http://b.bst.126.net/common/";
    f.rc.s = f.rc.s || "/common/storage.swf";
    f.rc.u = f.rc.u || "/common/upload.swf";
    0 > f.rc.s.indexOf("?") && (f.rc.s += "?t=" + (new Date).getTime())
});
define("{lib}base/browser.js", ["{lib}base/global.js"],
function() {
    var g = window.navigator.userAgent;
    P("B");
    B.__destroy = F;
    B._$ISMB = 0 <= g.indexOf("Mobile");
    B._$ISIE = !B._$ISMB && /msie\s+(.*?)\;/i.test(g);
    B._$ISFF = !B._$ISMB && !B._$ISIE && /rv\:(.*?)\)\s+gecko\//i.test(g);
    B._$ISOP = !B._$ISMB && !B._$ISIE && !B._$ISFF && /opera\/(.*?)\s/i.test(g);
    B._$ISSF = !B._$ISMB && !B._$ISIE && !B._$ISFF && !B._$ISOP && /applewebkit\/(.*?)\s/i.test(g);
    B._$ISKQ = !B._$ISMB && !B._$ISIE && !B._$ISFF && !B._$ISOP && !B._$ISSF && /konqueror\/(.*?)\;/i.test(g);
    B._$VERSION = RegExp.$1 || "";
    B._$ISOLDIE = B._$ISIE && "7.0" > B._$VERSION;
    B._$ISMT = B._$ISIE && 0 <= g.indexOf("Maxthon");
    B._$ISTT = B._$ISIE && 0 <= g.indexOf("TencentTraveler");
    if (B._$ISIE) try {
        document.execCommand("BackgroundImageCache", !1, !0)
    } catch(e) {}
});
define("{lib}base/util.js", ["{lib}base/global.js"],
function() {
    var g = /(?:^\s+)|(?:\s+$)/g,
    e = /^\s*$/,
    i = {
        r: /\<|\>|\&|\r|\n|\s|\'|\"/g,
        "<": "&lt;",
        ">": "&gt;",
        "&": "&amp;",
        " ": "&nbsp;",
        '"': "&quot;",
        "'": "&#39;",
        "\n": "<br/>",
        "\r": ""
    },
    k = {
        r: /\&(?:lt|gt|amp|nbsp|#39|quot)\;|\<br\/\>/gi,
        "&lt;": "<",
        "&gt;": ">",
        "&amp;": "&",
        "&nbsp;": " ",
        "&#39;": "'",
        "&quot;": '"',
        "<br/>": "\n"
    },
    f = {
        i: !0,
        r: /\byyyy|yy|MM|M|dd|d|HH|H|mm|ms|ss|m|s\b/g
    },
    b = {
        r: /\'|\"/g,
        "'": "\\'",
        '"': '\\"'
    };
    P("U");
    U.__destroy = F;
    U._$number = function(a) {
        a = parseInt(a) || 0;
        return (10 > a ? "0": "") + a
    };
    U._$trim = function(a) {
        return !! a && !!a.replace && a.replace(g, "") || ""
    };
    U._$subString = function(a, d) {
        a = a || "";
        if (!d) return a;
        for (var c = 0,
        b = 0,
        f = a.length; c < f; c++) if (b += 255 < a.charCodeAt(c) ? 2 : 1, b >= d) return a.substr(0, c + (b == d ? 1 : 0));
        return a
    };
    U._$isEmpty = function(a) {
        return e.test(a || "")
    };
    U._$rand = function(a, b) {
        return Math.floor(Math.random() * (b - a) + a)
    };
    U._$randNumberString = function(a) {
        a = Math.max(0, Math.min(a || 10, 100));
        a = Math.pow(10, a - 1);
        return U._$rand(a, 10 * a).toString()
    };
    U._$isType = function(a, b) {
        return Object.prototype.toString.call(a).toLowerCase() == "[object " + b.toLowerCase() + "]"
    };
    U._$indexOf = function(a, b) {
        var c = U._$isType(b, "function");
        if (a && 0 < a.length) for (var h = 0,
        f = a.length; h < f; h++) if (c ? b(a[h]) : a[h] == b) return h;
        return - 1
    };
    U._$encode = function(a, b) {
        return ! a || !b || !b.replace ? b || "": b.replace(a.r,
        function(c) {
            var b = a[!a.i ? c.toLowerCase() : c];
            return null != b ? b: c
        })
    };
    U._$escape = function(a) {
        return U._$encode(i, a)
    };
    U._$unescape = function(a) {
        return U._$encode(k, a)
    };
    U._$string = function(a) {
        return U._$encode(b, a)
    };
    U._$format = function(a, b) {
        if (!a || !b) return "";
        U._$isType(a, "string") && (a = new Date(Date.parse(a)));
        U._$isType(a, "date") || (a = new Date(a));
        f.yyyy = a.getFullYear();
        f.yy = ("" + f.yyyy).substr(2);
        f.M = a.getMonth() + 1;
        f.MM = U._$number(f.M);
        f.d = a.getDate();
        f.dd = U._$number(f.d);
        f.H = a.getHours();
        f.HH = U._$number(f.H);
        f.m = a.getMinutes();
        f.mm = U._$number(f.m);
        f.s = a.getSeconds();
        f.ss = U._$number(f.s);
        f.ms = a.getMilliseconds();
        return U._$encode(f, b)
    };
    U._$serialize = function(a) {
        if (U._$isType(a, "number")) return a;
        if (U._$isType(a, "date")) return a.getTime();
        if (U._$isType(a, "boolean")) return a ? "true": "false";
        if (U._$isType(a, "string")) return "'" + U._$string(a) + "'";
        if (!a) return "null";
        if (U._$isType(a, "array")) {
            for (var b = [], c = 0, h = a.length; c < h; b.push(U._$serialize(a[c])), c++);
            return "[" + b.join(",") + "]"
        }
        if (U._$isType(a, "object")) {
            b = [];
            for (c in a) b.push(U._$serialize(c) + ":" + U._$serialize(a[c]));
            return "{" + b.join(",") + "}"
        }
        return "null"
    };
    U._$deserialize = function(a) {
        try {
            return ! a ? null: (new Function("return " + a))()
        } catch(b) {
            return null
        }
    };
    U._$parseJSON = window.JSON ? JSON.parse: U._$deserialize;
    U._$toJSONString = window.JSON ? JSON.stringify: U._$serialize;
    U._$getGValue = function(a) {
        var b = window[a];
        try {
            if (!delete window[a]) throw "";
        } catch(c) {
            window[a] = void 0
        }
        return b
    }
});
define("{lib}base/element.js", ["{lib}base/browser.js", "{lib}base/util.js"],
function() {
    var g, e = {},
    i = /\s+/g,
    k = document.createDocumentFragment(),
    f = function(a) {
        if (a) {
            switch (a.tagName.toLowerCase()) {
            case "a":
                a.href = "#";
                a.hideFocus = !0;
                break;
            case "iframe":
                a.frameBorder = 0;
                a.src = "about:blank";
                return;
            case "script":
                a.defer = "defer";
                a.type = "text/javascript";
                return;
            case "style":
                a.type = "text/css";
                return;
            case "link":
                a.type = "text/css";
                a.rel = "stylesheet";
                return
            }
            k.appendChild(a)
        }
    },
    b = function(a) {
        a = U._$trim(a);
        return ! a ? "": "(\\s|^)(?:" + a.replace(i, "|") + ")(?=\\s|$)"
    },
    a = function(a, c) {
        if (a = E._$getElement(a)) if (c = !!c, a.__hatkey__ != c) {
            var b = a.__hvrkey__;
            b && ((a.__hatkey__ = c) ? E._$addClassName(a, b) : E._$delClassName(a, b))
        }
    },
    d = function(a) {
        if (a = E._$getElement(a)) {
            var c = a.mt,
            b = a.mv;
            a.style[c] = a["width" == c ? "scrollWidth": "scrollHeight"] < b ? "auto": b + "px"
        }
    },
    c = function(a) {
        if (a = E._$getElement(a)) {
            var c = a.mt,
            b = a.mv,
            d = a.mr,
            h = a.style,
            r = a.scrollWidth / a.scrollHeight || 1,
            f = "width" == c ? b: Math.floor(b * d),
            c = "width" == c ? Math.floor(b / d) : b;
            r >= d && a.scrollWidth > f ? (h.width = f + "px", h.height = "auto") : r <= d && a.scrollHeight > c ? (h.width = "auto", h.height = c + "px") : (h.width = "auto", h.height = "auto")
        }
    },
    h = function(a, c, b) {
        a = E._$getElement(a);
        if (!a) return 0;
        for (var b = b || F,
        d = 0; a && !b(a);) d += a[c],
        a = a.offsetParent;
        return d
    },
    j;
    j = document.defaultView && document.defaultView.getComputedStyle ?
    function(a, c) {
        var b = document.defaultView.getComputedStyle(a, null);
        return ! b ? "": b[c]
    }: function(a, c) {
        return a.currentStyle[c]
    };
    P("E");
    E.__destroy = function() {
        var a = document.createElement("div");
        a.style.display = "none";
        document.body.appendChild(a);
        a.appendChild(k)
    };
    E._$getElement = function(a) {
        if (1 >= arguments.length) return U._$isType(a, "string") || U._$isType(a, "number") ? document.getElementById(a) : a;
        for (var c = [], b = 0, d = arguments.length; b < d; c.push(E._$getElement(arguments[b])), b++);
        return c
    };
    E._$getChildElements = function(a, c) {
        a = E._$getElement(a);
        if (!a) return null;
        for (var b = [], d = a.children || a.childNodes, h = 0, r = d.length; h < r; h++) d[h].nodeType != Node.ELEMENT_NODE || c && !E._$hasClassName(d[h], c) || b.push(d[h]);
        return b
    };
    E._$getElementsByClassName = function(a, c) {
        c = U._$trim(c);
        a = E._$getElement(a);
        if (!a || !c) return null;
        if (a.getElementsByClassName) return Array.prototype.slice.call(a.getElementsByClassName(c), 0);
        if (document.evaluate) {
            for (var d = [], h = document.evaluate(".//*" + n(c), a, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null), f = 0, r = h.snapshotLength; f < r; d.push(h.snapshotItem(f)), f++);
            return d
        }
        for (var d = [], e = RegExp(b(c), "g"), h = a.getElementsByTagName("*"), f = 0, r = h.length; f < r; f++) E._$hasClassName(h[f], e) && d.push(h[f]);
        return d
    };
    E._$hasClassName = function(a, c) {
        a = E._$getElement(a);
        if (!a || !c) return ! 1;
        c = U._$isType(c, "string") ? b(c) : c;
        return 0 <= (a.className || "").search(c)
    };
    E._$replaceClassName = function(a, c, d) {
        if ((a = E._$getElement(a)) && (c || d)) {
            var h = a.className || "",
            d = " " + (d || ""); (c = b(c + d)) && (h = h.replace(RegExp(c, "g"), "$1"));
            a.className = U._$trim(h + d).replace(i, " ")
        }
    };
    E._$addClassName = function(a, c) {
        E._$replaceClassName(a, "", c)
    };
    E._$delClassName = function(a, c) {
        E._$replaceClassName(a, c, "")
    };
    E._$addNodeTemplate = function(a, c) {
        var b = E._$getElement(a),
        d = c || "tp_" + U._$randNumberString(6);
        b ? (e[d] = b, k.appendChild(b)) : U._$isType(a, "string") && (e[d] = a);
        return d
    };
    E._$getNodeTemplate = function(a) {
        var c = e[a];
        c && U._$isType(c, "string") && E._$addNodeTemplate(E._$parseElement(c), a);
        return ! e[a] ? null: e[a].cloneNode(!0)
    };
    E._$parseElement = function(a) {
        if (!U._$isType(a, "string")) return a;
        a = U._$trim(a);
        if (!a) return null;
        var c = document.cloneElement("div");
        c.innerHTML = a;
        return 1 == c.childNodes.length ? c.childNodes[0] : c
    };
    E._$parseStyle = function(a, c) {
        if (!a) return null;
        if (!B._$ISIE || 30 > document.getElementsByTagName("style").length) return c || (c = document.cloneElement("style"), document.head.appendChild(c)),
        !B._$ISIE ? c.innerText = a: c.styleSheet.cssText = a,
        c;
        g.styleSheet.cssText += a;
        return g
    };
    E._$getStyle = function(a, c) {
        a = E._$getElement(a);
        return ! a ? "": a.style[c] || j(a, c)
    };
    E._$offsetX = function(a, c) {
        return h(a, "offsetLeft", c)
    };
    E._$offsetY = function(a, c) {
        return h(a, "offsetTop", c)
    };
    E._$removeElement = function(a) {
        if ((a = E._$getElement(a)) && a.parentNode) a.parentNode.removeChild(a),
        B._$ISIE && a.outerHTML && (a.outerHTML = "")
    };
    E._$removeElementByEC = function() {
        for (var a = 0,
        c = arguments.length,
        b; a < c; a++)(b = E._$getElement(arguments[a])) && k.appendChild(b)
    };
    E._$noSelect = function(a, c) {
        if (B._$ISIE && (a = E._$getElement(a))) a.onselectstart = !c ? F: null
    };
    E._$hoverElement = function(c, b, d) {
        if (B._$ISOLDIE || d) if ((c = E._$getElement(c)) && b && !c.__hvrkey__) c.__hvrkey__ = b,
        b = c.id = c.id || "xnd_" + U._$randNumberString(10),
        V._$addEvent(c, B._$ISIE ? "mouseleave": "mouseout", a._$bind(E, b, !1)),
        V._$addEvent(c, B._$ISIE ? "mouseenter": "mouseover", a._$bind(E, b, !0))
    };
    E._$maxBoxElement = function(a, b, h, f) {
        if (B._$ISOLDIE && (a = E._$getElement(a))) {
            var e = a.id || "mnd_" + U._$randNumberString(10);
            a.id = e;
            a.mt = b;
            a.mv = h;
            a.mr = f;
            a.maxkey || (a.maxkey = !0, b = "img" == a.tagName.toLowerCase() ? "load": "resize", f ? V._$addEvent(a, b, c._$bind(E, e)) : V._$addEvent(a, b, d._$bind(E, e)))
        }
    };
    E._$maxWidthElement = function(a, c, b) {
        E._$maxBoxElement(a, "width", c, b)
    };
    E._$maxHeightElement = function(a, c, b) {
        E._$maxBoxElement(a, "height", c, b)
    };
    E._$getFlashObject = function(a) {
        return B._$ISIE ? window[a] : document[a]
    };
    var n;
    document.evaluate && (n = function(a) {
        if (!a) return null;
        if (!i.test(a)) return "[contains(concat(' ',@class,' '),' " + a + " ')]";
        for (var a = a.split(i), c = "", b = 0, d = a.length, h; b < d; b++) h = n(a[b]),
        c += !h ? "": h;
        return c
    });
    window.Node || (window.Node = {
        ELEMENT_NODE: 1
    });
    B._$ISFF && (HTMLElement.prototype.__defineGetter__("innerText",
    function() {
        return this.textContent
    }), HTMLElement.prototype.__defineSetter__("innerText",
    function(a) {
        this.textContent = a
    }), HTMLElement.prototype.insertAdjacentElement = function(a, c) {
        if (a && c) switch (a) {
        case "beforeEnd":
            this.appendChild(c);
            break;
        case "beforeBegin":
            this.parentNode.insertBefore(c, this);
            break;
        case "afterBegin":
            !this.firstChild ? this.appendChild(c) : this.insertBefore(c, this.firstChild);
            break;
        case "afterEnd":
            !this.nextSibling ? this.parentNode.appendChild(c) : this.parentNode.insertBefore(c, this.nextSibling)
        }
    },
    HTMLElement.prototype.insertAdjacentHTML = function(a, c) {
        a && c && this.insertAdjacentElement(a, document.createRange().createContextualFragment(c))
    });
    document.head = document.getElementsByTagName("head")[0] || document.body;
    document.cloneElement = function(a, c) {
        var b = document.createElement(a);
        f(b);
        c && (b.className = c);
        return b
    };
    B._$ISIE && (g = document.cloneElement("style"), document.head.appendChild(g))
});
define("{lib}base/event.js", ["{lib}base/global.js", "{lib}base/browser.js", "{lib}base/element.js"],
function() {
    var g = "__" + (new Date).getTime() + "__",
    e = {},
    i = function(a, b) {
        try {
            var d = e[a];
            if (d) if (b) {
                var f = d.evn[b];
                if (f) {
                    if (U._$isType(f, "array")) for (var i; i = f.pop(); V._$delEvent(d.elm, b, i));
                    else V._$delEvent(d.elm, b, f);
                    delete d.evn[b]
                }
            } else k(a)
        } catch(g) {}
    },
    k = function(a) {
        var b = e[a];
        if (b) {
            for (var d in b.evn) d && i(a, d);
            b.elm[g] = "";
            delete b.elm;
            delete b.evn;
            delete e[a]
        }
    },
    f = function(a, b) {
        var d = V._$getElement(b) || document;
        d && !("loaded" != d.readyState && "complete" != d.readyState) && a(b)
    },
    b = function(a, b) {
        var d = (a.tagName || "").toLowerCase();
        return B._$ISIE && (a == document && "DOMContentLoaded" == b || ("iframe" == d || "script" == d) && "load" == b)
    },
    a,
    d;
    document.addEventListener ? (a = function(a, b, d, f) {
        a.addEventListener(b, d, !!f)
    },
    d = function(a, b, d, f) {
        a.removeEventListener(b, d, !!f)
    }) : (a = function(a, b, d) {
        a.attachEvent("on" + b, d)
    },
    d = function(a, b, d) {
        a.detachEvent("on" + b, d)
    });
    P("V");
    V.__destroy = function() {
        for (var a in e) try {
            k(a)
        } catch(b) {}
    };
    V._$getElement = function(a) {
        if (!a) return null;
        var b = a.target || a.srcElement;
        if (!arguments[1] || !U._$isType(arguments[1], "function")) return b;
        for (; b;) {
            if (arguments[1](b)) return b;
            b = b.parentNode
        }
        return null
    };
    V._$addEvent = function(c, d, i, k) {
        if ((c = E._$getElement(c)) && d && i) {
            if (b(c, d)) {
                d = "readystatechange";
                i = f._$bind(null, i)
            }
            B._$ISIE && d == "input" && (d = "propertychange");
            a(c, d, i, k);
            if (! (c == window || c == document || c == top || c == parent)) if (k = c[g]) {
                c = e[k].evn; (k = c[d]) ? U._$isType(k, "array") ? k.push(i) : c[d] = [k, i] : c[d] = i
            } else {
                var k = "ev_" + U._$randNumberString(),
                l = {
                    evn: {}
                };
                l.evn[d] = i;
                l.elm = c;
                e[k] = l;
                c[g] = k
            }
        }
    };
    V._$delEvent = function(a, b, f, e) { (a = E._$getElement(a)) && (b && f) && d(a, b, f, e)
    };
    V._$clearEvent = function(a, d) {
        if (a = E._$getElement(a)) {
            b(a, d) && (d = "readystatechange");
            B._$ISIE && d == "input" && (d = "propertychange");
            i(a[g], d)
        }
    };
    V._$dispatchEvent = function(a, b, d) {
        if (a = E._$getElement(a)) if (document.createEvent) {
            d = document.createEvent("MouseEvent");
            d.initEvent(b, false, false);
            a.dispatchEvent(d)
        } else document.createEventObject && a.fireEvent("on" + b, d || window.event || document.createEventObject())
    };
    V._$stop = function(a) {
        V._$stopBubble(a);
        V._$stopDefault(a)
    };
    V._$stopBubble = function(a) {
        if (a) a.stopPropagation ? a.stopPropagation() : a.cancelBubble = true
    };
    V._$stopDefault = function(a) {
        if (a) a.preventDefault ? a.preventDefault() : a.returnValue = false
    };
    V._$pointerX = function(a) {
        return ! a ? 0 : a.pageX || a.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft)
    };
    V._$pointerY = function(a) {
        return ! a ? 0 : a.pageY || a.clientY + (document.documentElement.scrollTop || document.body.scrollTop)
    }
});
define("{lib}base/destroy.js", ["{lib}base/event.js"],
function() {
    V._$addEvent(window, "unload",
    function() {
        try {
            V.__destroy(),
            E.__destroy(),
            U.__destroy(),
            B.__destroy()
        } catch(g) {}
    })
});
define("{lib}util/event.js", ["{lib}base/base.js"],
function() {
    var g = P(N.ut);
    g._$$Event = C();
    g = g._$$Event.prototype;
    g._$initialize = function() {
        this.__events = {}
    };
    g._$addEvent = function(e, i) {
        e && (i && U._$isType(i, "Function")) && (this.__events[e.toLowerCase()] = i)
    };
    g._$batEvent = function(e) {
        if (e) for (var i in e) this._$addEvent(i, e[i])
    };
    g._$delEvent = function(e) {
        e && delete this.__events[e.toLowerCase()]
    };
    g._$getEvent = function(e) {
        return this.__events[e.toLowerCase()] || null
    };
    g._$dispatchEvent = function() {
        if (arguments.length) {
            var e = this.__events[Array.prototype.shift.apply(arguments).toLowerCase()];
            if (e) return e.apply(window, arguments)
        }
    }
});
define("{lib}util/item.js", ["{lib}util/event.js", "{lib}util/extend/jst.js"],
function() {
    var g = P(N.ut),
    e;
    g._$$Item = C();
    e = g._$$Item._$extend(g._$$Event);
    g._$$Item._$allocate = function(e, g, f) {
        if (!e) return null;
        f = f || {};
        if (f._single_ || !U._$isType(e, "array")) {
            var b = !!this.__pool && this.__pool.shift() || new this;
            b._used_ = !0;
            b._$reset(f);
            b._$appendToParent(g);
            b._$setData(e);
            return b
        }
        if (!e.length) return null;
        for (var b = [], a = Math.max(0, f._start_ || 0), d = 0, c = Math.min(null != f._end_ ? f._end_: e.length, e.length); a < c; d++, a++) f._index_ = d,
        b.push(this._$allocate(e[a], g, f));
        return b
    };
    g._$$Item._$recycle = function(e) {
        if (!e) return null;
        if (e._used_ && e instanceof this) return e._used_ = !1,
        e._$destroy(),
        this.__pool && this.__pool.push(e),
        null;
        if (U._$isType(e, "array")) for (var g; g = e.pop(); this._$recycle(g));
        return null
    };
    e._$initialize = function(e) {
        this._$super();
        this.__body = E._$getNodeTemplate(e);
        this.constructor.__pool = this.constructor.__pool || []
    };
    e._$appendToParent = function(e, g) { (this.__parent = E._$getElement(e)) && this.__body && (!g ? this.__parent.appendChild(this.__body) : this.__parent.insertAdjacentElement("afterBegin", this.__body))
    };
    e._$destroy = function() {
        delete this.__data;
        E._$removeElementByEC(this.__body)
    };
    e._$getData = function() {
        return this.__data || null
    };
    e._$setData = function(e) {
        this.__data = e || O
    };
    e._$reset = F
});
define("{lib}util/extend/md5.js", ["{lib}base/base.js"],
function() {
    P("U");
    var g = function(b, a) {
        var d = (b & 65535) + (a & 65535);
        return (b >> 16) + (a >> 16) + (d >> 16) << 16 | d & 65535
    },
    e = function(b, a, d, c, f, e) {
        b = g(g(a, b), g(c, e));
        return g(b << f | b >>> 32 - f, d)
    },
    i = function(b, a, d, c, f, i, g) {
        return e(a & d | ~a & c, b, a, f, i, g)
    },
    k = function(b, a, d, c, f, i, g) {
        return e(a & c | d & ~c, b, a, f, i, g)
    },
    f = function(b, a, d, c, f, i, g) {
        return e(d ^ (a | ~c), b, a, f, i, g)
    };
    U._$md5 = function(b) {
        for (var a = [], d = 0, c = 8 * b.length; d < c; a[d >> 5] |= (b.charCodeAt(d / 8) & 255) << d % 32, d += 8);
        b = 8 * b.length;
        a[b >> 5] |= 128 << b % 32;
        a[(b + 64 >>> 9 << 4) + 14] = b;
        for (var b = 1732584193,
        d = -271733879,
        c = -1732584194,
        h = 271733878,
        j = 0,
        n = a.length,
        l, o, q, m; j < n; j += 16) l = b,
        o = d,
        q = c,
        m = h,
        b = i(b, d, c, h, a[j + 0], 7, -680876936),
        h = i(h, b, d, c, a[j + 1], 12, -389564586),
        c = i(c, h, b, d, a[j + 2], 17, 606105819),
        d = i(d, c, h, b, a[j + 3], 22, -1044525330),
        b = i(b, d, c, h, a[j + 4], 7, -176418897),
        h = i(h, b, d, c, a[j + 5], 12, 1200080426),
        c = i(c, h, b, d, a[j + 6], 17, -1473231341),
        d = i(d, c, h, b, a[j + 7], 22, -45705983),
        b = i(b, d, c, h, a[j + 8], 7, 1770035416),
        h = i(h, b, d, c, a[j + 9], 12, -1958414417),
        c = i(c, h, b, d, a[j + 10], 17, -42063),
        d = i(d, c, h, b, a[j + 11], 22, -1990404162),
        b = i(b, d, c, h, a[j + 12], 7, 1804603682),
        h = i(h, b, d, c, a[j + 13], 12, -40341101),
        c = i(c, h, b, d, a[j + 14], 17, -1502002290),
        d = i(d, c, h, b, a[j + 15], 22, 1236535329),
        b = k(b, d, c, h, a[j + 1], 5, -165796510),
        h = k(h, b, d, c, a[j + 6], 9, -1069501632),
        c = k(c, h, b, d, a[j + 11], 14, 643717713),
        d = k(d, c, h, b, a[j + 0], 20, -373897302),
        b = k(b, d, c, h, a[j + 5], 5, -701558691),
        h = k(h, b, d, c, a[j + 10], 9, 38016083),
        c = k(c, h, b, d, a[j + 15], 14, -660478335),
        d = k(d, c, h, b, a[j + 4], 20, -405537848),
        b = k(b, d, c, h, a[j + 9], 5, 568446438),
        h = k(h, b, d, c, a[j + 14], 9, -1019803690),
        c = k(c, h, b, d, a[j + 3], 14, -187363961),
        d = k(d, c, h, b, a[j + 8], 20, 1163531501),
        b = k(b, d, c, h, a[j + 13], 5, -1444681467),
        h = k(h, b, d, c, a[j + 2], 9, -51403784),
        c = k(c, h, b, d, a[j + 7], 14, 1735328473),
        d = k(d, c, h, b, a[j + 12], 20, -1926607734),
        b = e(d ^ c ^ h, b, d, a[j + 5], 4, -378558),
        h = e(b ^ d ^ c, h, b, a[j + 8], 11, -2022574463),
        c = e(h ^ b ^ d, c, h, a[j + 11], 16, 1839030562),
        d = e(c ^ h ^ b, d, c, a[j + 14], 23, -35309556),
        b = e(d ^ c ^ h, b, d, a[j + 1], 4, -1530992060),
        h = e(b ^ d ^ c, h, b, a[j + 4], 11, 1272893353),
        c = e(h ^ b ^ d, c, h, a[j + 7], 16, -155497632),
        d = e(c ^ h ^ b, d, c, a[j + 10], 23, -1094730640),
        b = e(d ^ c ^ h, b, d, a[j + 13], 4, 681279174),
        h = e(b ^ d ^ c, h, b, a[j + 0], 11, -358537222),
        c = e(h ^ b ^ d, c, h, a[j + 3], 16, -722521979),
        d = e(c ^ h ^ b, d, c, a[j + 6], 23, 76029189),
        b = e(d ^ c ^ h, b, d, a[j + 9], 4, -640364487),
        h = e(b ^ d ^ c, h, b, a[j + 12], 11, -421815835),
        c = e(h ^ b ^ d, c, h, a[j + 15], 16, 530742520),
        d = e(c ^ h ^ b, d, c, a[j + 2], 23, -995338651),
        b = f(b, d, c, h, a[j + 0], 6, -198630844),
        h = f(h, b, d, c, a[j + 7], 10, 1126891415),
        c = f(c, h, b, d, a[j + 14], 15, -1416354905),
        d = f(d, c, h, b, a[j + 5], 21, -57434055),
        b = f(b, d, c, h, a[j + 12], 6, 1700485571),
        h = f(h, b, d, c, a[j + 3], 10, -1894986606),
        c = f(c, h, b, d, a[j + 10], 15, -1051523),
        d = f(d, c, h, b, a[j + 1], 21, -2054922799),
        b = f(b, d, c, h, a[j + 8], 6, 1873313359),
        h = f(h, b, d, c, a[j + 15], 10, -30611744),
        c = f(c, h, b, d, a[j + 6], 15, -1560198380),
        d = f(d, c, h, b, a[j + 13], 21, 1309151649),
        b = f(b, d, c, h, a[j + 4], 6, -145523070),
        h = f(h, b, d, c, a[j + 11], 10, -1120210379),
        c = f(c, h, b, d, a[j + 2], 15, 718787259),
        d = f(d, c, h, b, a[j + 9], 21, -343485551),
        b = g(b, l),
        d = g(d, o),
        c = g(c, q),
        h = g(h, m);
        a = [b, d, c, h];
        b = [];
        d = 0;
        for (c = 4 * a.length; d < c; b.push("0123456789abcdef".charAt(a[d >> 2] >> 8 * (d % 4) + 4 & 15) + "0123456789abcdef".charAt(a[d >> 2] >> 8 * (d % 4) & 15)), d++);
        return b.join("")
    }
});
define("{lib}util/extend/jst.js", ["{lib}base/base.js"],
function() {
    var g = {},
    e = {},
    i = [],
    k = /\t/g,
    f = /\s+/g,
    b = /\n/g,
    a = /\r\n?/g,
    d = /\|\|/g,
    c = /#@@#/g,
    h = {
        r: /\n|\\|\'/g,
        "\n": "\\n",
        "\\": "\\\\",
        "'": "\\'"
    },
    j = /^\{(cdata|minify|eval)/i,
    n = {
        "if": {
            pfix: "if(",
            sfix: "){",
            pmin: 1
        },
        "else": {
            pfix: "}else{"
        },
        elseif: {
            pfix: "}else if(",
            sfix: "){",
            pdft: "true"
        },
        "/if": {
            pfix: "}"
        },
        "for": {
            pfix: function(a) {
                if ("in" != a[2]) throw "bad for loop statement: " + a.join(" ");
                i.push(a[1]);
                return "var __HASH__" + a[1] + " = " + a[3] + "," + a[1] + "," + a[1] + "_count=0;if (!!__HASH__" + a[1] + ")for(var " + a[1] + "_key in __HASH__" + a[1] + "){" + a[1] + " = __HASH__" + a[1] + "[" + a[1] + "_key];if (!" + a[1] + "||typeof(" + a[1] + ')=="function") continue;' + a[1] + "_count++;"
            },
            pmin: 3
        },
        forelse: {
            pfix: function() {
                var a = i[i.length - 1];
                return "}; if(!__HASH__" + a + "||!" + a + "_count){"
            }
        },
        "/for": {
            pfix: function() {
                i.pop();
                return "};"
            }
        },
        list: {
            pfix: function(a) {
                if ("as" != a[2]) throw "bad for list loop statement: " + a.join(" ");
                var b = a[1].split("..");
                return 1 < b.length ? "for(var " + a[3] + "," + a[3] + "_index=0,_beg=" + b[0] + ",_end=" + b[1] + "," + a[3] + "_length=parseInt(_end-_beg+1);" + a[3] + "_index<" + a[3] + "_length;" + a[3] + "_index++){" + a[3] + " = _beg+" + a[3] + "_index;": "for(var __LIST__" + a[3] + " = " + a[1] + "," + a[3] + "," + a[3] + "_index=0," + a[3] + "_length=__LIST__" + a[3] + ".length;" + a[3] + "_index<" + a[3] + "_length;" + a[3] + "_index++){" + a[3] + " = __LIST__" + a[3] + "[" + a[3] + "_index];"
            },
            pmin: 3
        },
        "/list": {
            pfix: "};"
        },
        "break": {
            pfix: "break;"
        },
        "var": {
            pfix: "var ",
            sfix: ";"
        },
        macro: {
            pfix: function(a) {
                if (a && a.length) {
                    a.shift();
                    var b = a[0].split("(")[0];
                    return "var " + b + " = function" + a.join("").replace(b, "") + "{var __OUT=[];"
                }
            }
        },
        "/macro": {
            pfix: "return __OUT.join(''); };"
        }
    },
    l = {
        trim: U._$trim,
        rand: U._$randNumberString,
        escape: U._$escape,
        format: U._$format,
        string: U._$string,
        substr: U._$subString,
        "default": function(a, b) {
            return a || b
        }
    },
    o = function(a, b) {
        if (a) {
            var f = a.split("\n");
            if (f && f.length) for (var e = 0,
            h = f.length; e < h; e++) {
                for (var i = f[e], p = b, g = "}", j = -1, k = i.length, n = void 0, l = void 0, o = void 0, s = void 0, n = void 0; j + g.length < k;) {
                    n = "${";
                    l = "}";
                    o = i.indexOf(n, j + g.length);
                    if (0 > o) break;
                    "%" == i.charAt(o + 2) && (n = "${%", l = "%}");
                    s = i.indexOf(l, o + n.length);
                    if (0 > s) break;
                    q(i.substring(j + g.length, o), p);
                    n = i.substring(o + n.length, s).replace(d, "#@@#").split("|");
                    g = 0;
                    for (j = n.length; g < j; n[g] = n[g].replace(c, "||"), g++);
                    p.push("__OUT.push(");
                    m(n, p);
                    p.push(");");
                    g = l;
                    j = s
                }
                q(i.substring(j + g.length), p)
            }
        }
    },
    q = function(a, b) {
        a && b.push("__OUT.push('" + U._$encode(h, a) + "');")
    },
    m = function(a, b) {
        if (a && a.length) if (1 == a.length) b.push(a.pop());
        else {
            var c = a.pop().split(":");
            b.push("__MDF['" + c.shift() + "'](");
            m(a, b);
            0 < c.length && b.push("," + c.join(":"));
            b.push(")")
        }
    },
    p = function(c) {
        for (var c = U._$trim(c).replace(a, "\n").replace(k, "    "), d = ["if(!__CTX) return '';var __OUT=[];with(__CTX){"], e = -1, h = c.length, g, i, p, m, l; e + 1 < h;) {
            g = e;
            for (g = c.indexOf("{", g + 1); 0 <= g;) {
                i = c.indexOf("}", g + 1);
                p = c.substring(g, i);
                if (i = p.match(j)) {
                    if (m = i[1].length + 1, l = c.indexOf("}", g + m), 0 <= l && (p = 0 >= l - g - m ? "{/" + i[1] + "}": p.substr(m + 1), m = c.indexOf(p, l + 1), 0 <= m)) {
                        o(c.substring(e + 1, g), d);
                        e = c.substring(l + 1, m);
                        switch (i[1]) {
                        case "cdata":
                            q(e, d);
                            break;
                        case "minify":
                            q(e.replace(b, " ").replace(f, " "), d);
                            break;
                        case "eval":
                            e && d.push("__OUT.push((function(){" + e + "})());")
                        }
                        g = e = m + p.length - 1
                    }
                } else if ("$" != c.charAt(g - 1) && "\\" != c.charAt(g - 1) && 0 == p.substr("/" == p.charAt(1) ? 2 : 1).search("forelse|for|list|if|elseif|else|var|macro|break")) break;
                g = c.indexOf("{", g + 1)
            }
            if (0 > g) break;
            i = c.indexOf("}", g + 1);
            if (0 > i) break;
            o(c.substring(e + 1, g), d);
            l = c.substring(g, i + 1);
            e = d;
            g = l.slice(1, -1).split(f);
            if (m = n[g[0]]) {
                if (m.pmin && m.pmin >= g.length) throw "Statement needs more parameters:" + l;
                e.push(m.pfix && "string" != typeof m.pfix ? m.pfix(g) : m.pfix || "");
                if (m.sfix) {
                    if (1 >= g.length) m.pdft && e.push(m.pdft);
                    else {
                        l = 1;
                        for (p = g.length; l < p; l++) 1 < l && e.push(" "),
                        e.push(g[l])
                    }
                    e.push(m.sfix)
                }
            } else o(l, e);
            e = i
        }
        o(c.substring(e + 1), d);
        d.push("};return __OUT.join('');");
        return new Function("__CTX", "__MDF", d.join(""))
    };
    E._$getHtmlTemplate = function(a, b, c) {
        try {
            b = b || {};
            if (!g[a] && !e[a]) return "";
            g[a] || (g[a] = p(e[a]), delete e[a]);
            b.defined = function(a) {
                return b[a] != null
            };
            if (c) for (var d in l) c[d] = l[d];
            return g[a](b, c || l)
        } catch(f) {
            return f.message || ""
        }
    };
    E._$addHtmlTemplate = function(a) {
        if (!a) return "";
        var b, c = this._$getElement(a);
        c && (b = c.id, a = c.value || c.innerText);
        b = b || "ck_" + U._$randNumberString();
        e[b] = a;
        return b
    }
});
define("{lib}util/ajax/tag.js", ["{lib}base/base.js"],
function() {
    P("J");
    var g = {},
    e = function(f, b, a) {
        if (g[f]) {
            var d = g[f].cb;
            var c = g[f];
            c && (delete g[f], delete c.cb, f = c.rpc, delete c.rpc, c.timer = window.clearTimeout(c.timer), V._$clearEvent(f), E._$removeElement(f));
            if (d && d.length) {
                c = 0;
                for (f = d.length; c < f; c++) try { (d[c][b] || F)(a)
                } catch(e) {}
            }
        }
    },
    i = function(f) {
        e(f, "onload")
    },
    k = function(f, b) {
        e(f, "onerror", b || "\u811a\u672c\u52a0\u8f7d\u51fa\u9519\uff01")
    };
    J._$loadStyle = function(f) {
        if (f) {
            var b = document.cloneElement("link");
            document.head.appendChild(b);
            b.href = f;
            return b
        }
    };
    J._$loadScript = function(f, b, a) {
        return J._$loadScriptWithOpt(f, {
            onload: b,
            onerror: a
        })
    };
    J._$loadScriptWithOpt = function(f, b) {
        if (f) {
            var b = b || O,
            a = g[f],
            d = !a,
            c,
            e = {
                onload: b.onload || F,
                onerror: b.onerror || b.onload || F
            };
            d ? (c = document.cloneElement("script"), a = {
                cb: [e],
                rpc: c
            },
            g[f] = a, b.charset && (c.charset = b.charset), V._$addEvent(c, "load", i._$bind(window, f)), V._$addEvent(c, "error", k._$bind(window, f, "\u65e0\u6cd5\u52a0\u8f7d\u6307\u5b9a\u7684\u811a\u672c\u6587\u4ef6\uff01"))) : (c = a.rpc, a.cb.unshift(e), a.timer = window.clearTimeout(a.timer));
            0 != b.timeout && (a.timer = window.setTimeout(k._$bind(window, f, "\u8bf7\u6c42\u8d85\u65f6\uff01"), b.timeout || 6E4));
            d && (c.src = f, document.head.appendChild(c));
            return c
        }
    }
});
define("{lib}util/ajax/xdr.js", ["{lib}base/base.js", "{lib}util/event.js"],
function() {
    P("J");
    var g, e = {},
    i = [location.host, location.host, document.domain],
    k = /^(?:[\w]+\:\/\/)?(.*?\.([\w]+\.[\w]+)(?:\:[\d]+)?)(?:\/|$)/i,
    f = /^(?:[\w]+\:\/\/)?(.*?\.?([\w]+\.[\w]+)(?:\:[\d]+)?)(?:\/|$)/i,
    b = function(a) {
        if (/^\s*\//.test(a)) return i;
        var b = a.match(k);
        b && (0 < b.length && b[0] == a) && (b = a.match(f));
        return ! b || 3 > b.length ? [] : b
    },
    a = function(a) {
        try {
            if (!a) return null;
            if (a.gx) return a.gx();
            if (a.XMLHttpRequest) return new a.XMLHttpRequest;
            if (g) return new a.ActiveXObject(g);
            for (var b = "Msxml2.XMLHTTP.6.0 Msxml2.XMLHTTP.3.0 Msxml2.XMLHTTP.4.0 Msxml2.XMLHTTP.5.0 MSXML2.XMLHTTP Microsoft.XMLHTTP".split(" "), c = 0, d = b.length, f; c < d; c++) try {
                return f = new a.ActiveXObject(b[c]),
                g = b[c],
                f
            } catch(e) {}
            return null
        } catch(h) {
            return null
        }
    },
    d = function(a) {
        var b = e[a];
        if (b) try {
            b.w = E._$getElement(a).contentWindow
        } catch(c) {}
    };
    J.a = d;
    null == document.readyState && V._$addEvent(document, "DOMContentLoaded",
    function() {
        try {
            document.readyState = "complete"
        } catch(a) {}
    });
    J._$allocateXDR = function(c) {
        var c = b(c)[1] || location.host,
        d = e[c];
        return ! d ? (this._$registXDomain(c, !0), null) : d.p.shift() || a(d.w)
    };
    J._$recycleXDR = function(a, b) {
        b && (delete b.onreadystatechange, b.abort())
    };
    J._$getXWindow = function(a) {
        a = b(a)[1] || location.host;
        return (a = e[a]) && a.w || null
    };
    J._$isXDomain = function(a) {
        a = b(a);
        return !! a[1] && a[1] != location.host
    };
    J._$registXDomain = function(a, c) {
        if (a == location.host) e[a] = {
            w: window,
            p: []
        };
        else {
            var f = b(a);
            if (f[2] == document.domain && f[1] && !e[f[1]]) {
                var h = 0 <= a.toLowerCase().indexOf("http://") ? a: "http://" + f[1] + "/crossdomain.html?t=20100205";
                e[f[1]] = {
                    w: null,
                    p: []
                };
                if ("complete" != document.readyState && !c) document.write('<iframe width="0" height="0" src="' + h + '" id="' + f[1] + '" name="' + f[1] + '" onload="J.a(\'' + f[1] + '\');" style="display:none;"></iframe>');
                else {
                    var g = document.cloneElement("iframe");
                    g.width = 0;
                    g.height = 0;
                    g.id = f[1];
                    g.style.display = "none";
                    V._$addEvent(g, "load", d._$bind(null, f[1]));
                    document.body.appendChild(g);
                    g.src = h
                }
            }
        }
    };
    J._$registXDomain(location.host);
    if (N.xd && 0 < N.xd.length) {
        for (var c = 0,
        h = N.xd.length; c < h; J._$registXDomain(N.xd[c]), c++);
        delete N.xd
    }
    V._$addEvent(document, "keypress",
    function(a) {
        27 == a.keyCode && V._$stop(a)
    });
    var c = P(N.ut),
    j = [];
    c._$$XDR = C();
    h = c._$$XDR._$extend(c._$$Event);
    c._$$XDR._$allocate = function(a) {
        var b = j.shift() || new this;
        b._$reset(a);
        return b
    };
    c._$$XDR._$recycle = function(a) {
        a instanceof this && a._$used() && (a._$destroy(), j.push(a))
    };
    h._$used = function() {
        return this.__used
    };
    h._$reset = function(a) {
        this.__used = !0;
        a = a || O;
        this.__rty = 100;
        this.__url = a.url || "";
        this.__async = !a.sync;
        this.__rtype = a.rtype || "text";
        this.__ctype = a.ctype || "text/plain";
        this.__method = a.method || "POST";
        this.__headers = a.headers || null;
        this.__interval = a.interval || 4E4;
        this.__notimeout = a.notimeout || !1;
        this._$addEvent("onload", a.onload || F);
        this._$addEvent("onerror", a.onerror || F);
        this._$addEvent("ontimeout", a.ontimeout || a.onerror || F)
    };
    h._$send = function(a) {
        this.__url ? (!this.__notimeout && !this.__rtimer && (this.__timer = window.setTimeout(this.__onTimeout._$bind(this), this.__interval)), this.__xdr = J._$allocateXDR(this.__url)) ? B._$ISOP && J._$isXDomain(this.__url) ? this.__sendInOP(a) : B._$ISIE ? this.__sendInIE(a) : this.__send(a) : (this.__rtimer = window.setTimeout(this._$send._$bind(this, a), this.__rty), this.__rty += 200) : this._$dispatchEvent("onerror", "\u8bf7\u63d0\u4f9b\u8bf7\u6c42\u7684\u5730\u5740!")
    };
    h._$destroy = function() {
        this.__used = !1;
        this._$delEvent("onload");
        this._$delEvent("onerror");
        this._$delEvent("ontimeout");
        J._$recycleXDR(this.__url, this.__xdr);
        delete this.__xdr;
        this.__timer && (this.__timer = window.clearTimeout(this.__timer));
        this.__rtimer && (this.__rtimer = window.clearTimeout(this.__rtimer))
    };
    h.__send = function(a) {
        try {
            this.__xdr.open(this.__method, this.__url, this.__async);
            this.__xdr.setRequestHeader("Content-Type", this.__ctype);
            if (this.__headers) for (var b in this.__headers)"limit" != b && this.__xdr.setRequestHeader(b, this.__headers[b]);
            this.__async && (this.__xdr.onreadystatechange = this.__onStateChange._$bind(this));
            this.__xdr.send(a);
            this.__async || this.__onStateChange()
        } catch(c) {
            this._$dispatchEvent("onerror", "\u65e0\u6cd5\u53d1\u9001\u8bf7\u6c42," + c.message)
        }
    };
    h.__sendInIE = function(a) { ! this.__async ? this.__send(a) : window.setTimeout(this.__send._$bind(this, a), 100)
    };
    h.__sendInOP = function(a) {
        try {
            var b = J._$getXWindow(this.__url);
            b.b || (b.b = b.document.createElement("input"), b.b.type = "button", b.document.body.appendChild(b.b));
            b.b.onclick = this.__send._$bind(this, a);
            b.b.click()
        } catch(c) {}
    };
    h.__getResponseBody = function() {
        switch (this.__rtype.toLowerCase()) {
        case "xml":
            return this.__xdr.responseXML;
        case "text":
            return this.__xdr.responseText;
        case "json":
            try {
                return eval("(" + this.__xdr.responseText + ")")
            } catch(a) {}
        }
        return null
    };
    h.__onStateChange = function() {
        try {
            this.__xdr && 4 == this.__xdr.readyState && (this.__timer && (this.__timer = window.clearTimeout(this.__timer)), 200 != this.__xdr.status ? this._$dispatchEvent("onerror", "\u670d\u52a1\u5668\u8fd4\u56de\u5f02\u5e38[" + this.__xdr.status + "]!") : this._$dispatchEvent("onload", this.__getResponseBody()))
        } catch(a) {
            this._$dispatchEvent("onerror", "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u72b6\u51b5!")
        }
    };
    h.__onTimeout = function() {
        this.__rtimer && (this.__rtimer = window.clearTimeout(this.__rtimer));
        this.__timer && (this.__timer = window.clearTimeout(this.__timer), this._$dispatchEvent("ontimeout", "\u8bf7\u6c42\u8d85\u65f6\uff01"))
    };
    var e = {},
    n = function(a) {
        var b = e[a];
        b && (P(N.ut)._$$XDR._$recycle(b.req), delete b.req, delete b.onload, delete b.onerror, delete e[a])
    },
    l = function(a, b) {
        var c = e[a];
        if (c) {
            try {
                c.onload(b)
            } catch(d) {}
            n(a)
        }
    },
    o = function(a, b) {
        var c = e[a];
        if (c) {
            try {
                c.onerror(b)
            } catch(d) {}
            n(a)
        }
    };
    J._$request = function(a, b) {
        if (a) {
            var b = b || O,
            c;
            if (c = b.data) {
                var d = [],
                f;
                for (f in c) d.push(encodeURIComponent(f) + "=" + encodeURIComponent(c[f]));
                c = d.join("&")
            } else c = null; (d = "GET" == (b.method || "").toUpperCase()) && c && (a += (0 > a.indexOf("?") ? "?": "&") + c);
            f = U._$randNumberString();
            var h = {
                url: a,
                sync: !!b.sync,
                rtype: b.type,
                ctype: b.ctype || "application/x-www-form-urlencoded",
                method: b.method,
                headers: b.header,
                interval: b.timeout,
                notimeout: 0 == b.timeout,
                onload: l._$bind(null, f),
                onerror: o._$bind(null, f)
            };
            e[f] = {
                req: P(N.ut)._$$XDR._$allocate(h),
                onload: b.onload || F,
                onerror: b.onerror || b.onload || F
            };
            e[f].req._$send(d ? null: c);
            return f
        }
    }
});
define("{lib}util/ajax/dwr.js", ["{lib}util/ajax/tag.js", "{lib}util/ajax/xdr.js"],
function() {
    P("J");
    var g = F,
    e = F,
    i = 0,
    k = 0,
    f = null;
    J._$registDWRLogger = function(a) {
        g = a || F
    };
    J._$registDWRErrorFilter = function(a) {
        e = a || F
    };
    J._$setTimeout = function(a) {
        i = Math.max(0, parseInt(a) || 0)
    };
    J._$setBatchId = function(a) {
        k = a
    };
    J._$setHeaders = function(a) {
        f = a || null
    };
    var b = {},
    a, d = function(b, c) {
        if (void 0 == b) return "null:null";
        if (U._$isType(b, "boolean")) return "boolean:" + (b ? "true": "false");
        if (U._$isType(b, "number")) return "number:" + b;
        if (U._$isType(b, "string")) return "string:" + encodeURIComponent(b);
        if (U._$isType(b, "date")) return "Date:" + b.getTime();
        if (U._$isType(b, "array")) {
            for (var f = [], e = 0, h = b.length, g, i; e < h; e++) if (a.p++, g = c + "-e" + a.p, i = d(b[e], c)) a.m[g] = i,
            f.push("reference:" + g);
            return "Array:[" + f.join(",") + "]"
        }
        if (U._$isType(b, "object")) {
            f = [];
            for (g in b) if (a.p++, e = c + "-e" + a.p, h = d(b[g], c)) a.m[e] = h,
            f.push(encodeURIComponent(g) + ":reference:" + e);
            return "Object_Object:{" + f.join(",") + "}"
        }
        return U._$isType(b, "function") ? "": "default:" + b
    },
    c = function(a, b) {
        if (!a) return null;
        var c = [],
        d = "&" == b,
        f;
        for (f in a) c.push(d ? encodeURIComponent(f) + "=" + encodeURIComponent(a[f]) : f + "=" + a[f]);
        return c.join(b || "\n")
    },
    h = function(b, c, f, e) {
        var h = !1;
        a || (this._$beginBatch(), h = !0);
        var g = Array.prototype.slice.call(arguments, 0);
        a.t = g.shift() || 0;
        a.u = g.shift();
        var i = "c" + a.m.callCount;
        a.m[i + "-scriptName"] = g.shift();
        a.m[i + "-methodName"] = g.shift();
        a.m[i + "-id"] = a.m.callCount;
        var j = {
            c: F,
            e: null
        };
        0 < g.length && (g[g.length - 1] && U._$isType(g[g.length - 1], "function")) && (j.c = g.pop());
        0 < g.length && (g[g.length - 1] && U._$isType(g[g.length - 1], "function")) && (j.e = j.c, j.c = g.pop());
        a.h[a.m.callCount] = j;
        if (a) for (var j = 0,
        k = g.length,
        l; j < k; j++)(l = d(g[j], i)) && (a.m[i + "-param" + j] = l);
        a.m.callCount++;
        h && this._$endBatch()
    },
    j = function(a, b) {
        try { ! b || 0 > b.search("//#DWR") ? n(a, "\u8fd4\u56de\u6570\u636e\u4e0d\u5408\u6cd5!") : (new Function(b))()
        } catch(c) {
            n(a, c.message)
        } finally {
            m(a)
        }
    },
    n = function(a, c) {
        g(c);
        var d = b[a];
        if (d) {
            var d = d.h,
            f;
            for (f in d) q(d[f], c)
        }
    },
    l = function(a, b) {
        n(a, b);
        m(a)
    },
    o = function(a, c, d) {
        g(d); (a = b[a]) && q(a.h[c], d)
    },
    q = function(a, b) {
        a && !e(b) && (!a.e ? a.c(null) : a.e(b))
    },
    m = function(a) {
        var c = b[a];
        c && (P(N.ut)._$$XDR._$recycle(c.r), delete c.r, delete c.h, delete b[a])
    };
    J._$beginBatch = function() {
        a || (a = {
            h: {},
            p: 0,
            m: {
                callCount: 0,
                scriptSessionId: "${scriptSessionId}187"
            }
        })
    };
    J._$endBatch = function() {
        if (!a || !a.u) a = null;
        else {
            var d = k || U._$randNumberString(6);
            k = 0;
            a.m.batchId = d;
            b[d] = a;
            a = null;
            var e = b[d];
            if (e) {
                var g = "";
                0 <= e.u.indexOf("?") && (g = e.u.split("?"), e.u = g.shift(), g = "?" + g.join("?"));
                e.u += "/call/plaincall/";
                e.u += 1 < e.m.callCount ? "Multiple." + e.m.callCount + ".dwr": e.m["c0-scriptName"] + "." + e.m["c0-methodName"] + ".dwr";
                e.u += g;
                g = e.t % 10;
                if (1 == g || 2 == g) e.u = e.u + (0 <= e.u.indexOf("?") ? "&": "?") + c(e.m, "&");
                2 == e.t ? J._$loadScript(e.u, null, n._$bind(window, d)) : (d = {
                    url: e.u,
                    sync: 10 <= e.t,
                    interval: i,
                    headers: f,
                    onload: j._$bind(window, d),
                    onerror: l._$bind(window, d)
                },
                i = 0, f && -1 != f.limit && (f = null), 1 == g ? (d.method = "GET", e.r = P(N.ut)._$$XDR._$allocate(d), e.r._$send(null)) : (d.method = "POST", e.r = P(N.ut)._$$XDR._$allocate(d), e.r._$send(c(e.m, "\n"))))
            }
        }
    };
    J._$postDataByDWR = function(a, b, c) {
        Array.prototype.unshift.call(arguments, 0);
        h.apply(J, arguments)
    };
    J._$postDataByDWRWithSync = function(a, b, c) {
        Array.prototype.unshift.call(arguments, 10);
        h.apply(J, arguments)
    };
    J._$loadDataByDWR = function(a, b, c) {
        Array.prototype.unshift.call(arguments, 1);
        h.apply(J, arguments)
    };
    J._$loadDataByDWRWithSync = function(a, b, c) {
        Array.prototype.unshift.call(arguments, 11);
        h.apply(J, arguments)
    };
    J._$loadDataByTAG = function(a, b, c) {
        Array.prototype.unshift.call(arguments, 2);
        h.apply(J, arguments)
    };
    P("dwr.engine");
    dwr.engine._remoteHandleCallback = function(a, c, d) {
        var f = b[a];
        if (f) try {
            f.h[c].c(d)
        } catch(e) {
            o(a, c, e)
        }
    };
    dwr.engine._remoteHandleException = o;
    dwr.engine._remoteHandleBatchException = function(a, c) {
        var d = b[a];
        if (d) for (var f = 0,
        d = d.m.callCount; f < d; o(a, f, c, !0), f++);
    }
});
define("{lib}ui/abstract.js", ["{lib}base/base.js", "{lib}util/event.js"],
function() {
    var g = P(N.ui),
    e,
    i,
    k = /\#\<.*?\>/gi;
    g._$pushStyle = function(f, b) {
        f && f.replace && (i || (i = []), b && (f = f.replace(k, "." + b)), i.push(f))
    };
    g._$dumpStyle = function() {
        i && (E._$parseStyle(i.join("")), i = null)
    };
    g._$$UIAbstract = C();
    e = g._$$UIAbstract._$extend(P(N.ut)._$$Event);
    g._$$UIAbstract._$allocate = function(f, b) {
        b = b || {};
        b.group = !!b.singleton && "__singleton__" || b.group;
        var a;
        b.group && (this.__group = this.__group || {},
        a = this.__group[b.group]);
        a || (this.__pool = this.__pool || [], a = this.__pool.shift());
        a ? (a._$destroy(!0), a._$reset(f, b)) : a = new this(f, b);
        b.group && (this.__group[b.group] = a);
        return a
    };
    g._$$UIAbstract._$recycle = function(f) {
        if (! (f instanceof this) || f._$destroyed()) return null;
        var b = f._$group();
        if (b && !this.__group[b]) return null;
        f._$destroy();
        b && delete this.__group[b];
        this.__pool = this.__pool || [];
        this.__pool.push(f);
        return null
    };
    e._$initialize = function(f, b) {
        this._$super();
        g._$dumpStyle();
        this.__body = document.cloneElement("div", this.__getSpace());
        this.__body.innerHTML = this.__getXhtml() || "";
        this.__intXnode();
        this._$reset(f, b)
    };
    e._$destroy = function() {
        this._$getEvent("onbeforedestroy") && (this._$dispatchEvent("onbeforedestroy"), this._$delEvent("onbeforedestroy"), this.__recycleBody(), E._$delClassName(this.__body, this.__class), delete this.__class)
    };
    e._$reset = function(f, b) {
        b = b || O;
        this.__group = b.group;
        this._$resetOption(b);
        this._$appendToParent(f, !!b.before)
    };
    e._$resetOption = function(f) {
        f = f || O;
        this.__class = f["class"] || "";
        E._$addClassName(this.__body, this.__class);
        this.__hhack = B._$ISIE && !!f.hackhover;
        this._$addEvent("onbeforedestroy", f.onbeforedestroy || F)
    };
    e._$getBody = function() {
        return this.__body
    };
    e._$appendToParent = function(f, b) {
        if (this.__body && (f = E._$getElement(f))) this.__parent = f == document.documentElement ? document.body: f,
        this.__revertBody(b)
    };
    e._$group = function() {
        return this.__group || null
    };
    e._$destroyed = function() {
        return ! this.__used
    };
    e.__recycleBody = function() {
        this.__used = !1;
        this.__hhack ? this.__body.style.display = "none": E._$removeElementByEC(this.__body)
    };
    e.__revertBody = function(f) {
        this.__parent && this.__body && (!f ? this.__parent.appendChild(this.__body) : this.__parent.insertAdjacentElement("afterBegin", this.__body), this.__hhack && (this.__body.style.display = ""), this.__used = !0)
    };
    e.__getSpace = F;
    e.__getXhtml = F;
    e.__intXnode = F
});
define("{pro}widget/photo/photoshow.js", ["{pro}system.js", "{lib}ui/abstract.js", "{lib}util/item.js", "{lib}util/extend/md5.js"],
function() {
    var g = P("loft.w"),
    e,
    i = !1,
    k = {};
    g._$$PhotoShow = C();
    e = g._$$PhotoShow._$extend(P(N.ui)._$$UIAbstract, !0);
    e._$initialize = function() {
        this._$super.apply(this, arguments);
        P("loft.g").stopBubble = V._$stopBubble
    };
    e._$resetOption = function(a) {
        a = a || O;
        g._$$PhotoShow._$supro._$resetOption.call(this, a);
        window.__photo_showing_lock__ = !0;
        V._$addEvent(document, "keydown", this.__onShortcutPressBind);
        window.addEventListener && window.addEventListener("DOMMouseScroll", this.__onMouseWheelBind, !1);
        V._$addEvent(document, "mousewheel", this.__onMouseWheelBind);
        this.__scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
        a = document.documentElement || document.body;
        this.__bodyOverflowY = a.style.overflowY;
        this.__bodyOverflowX = a.style.overflowX;
        a.style.overflowY = "hidden";
        a.style.overflowX = "hidden";
        this.__scrollTopNow = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0
    };
    e._$reset = function(a, b) {
        g._$$PhotoShow._$supro._$reset.call(this, a, b);
        this.__photos = b.photos || [];
        this.__index = b.index || 0;
        window.Theme = window.Theme || O;
        this.__pOption = {
            cctype: b.cctype || window.Theme.CcType || 0,
            imageProtected: !!b.contextValue || !!window.Theme.ImageProtected,
            contextValue: b.contextValue || window.Theme.ContextValue || "",
            firstShowPhoto: this.__photos[this.__index]
        };
        this.__resetPhoto()
    };
    e.__resetPhoto = function() {
        var a = document.documentElement || document.body;
        B._$ISOLDIE && (this.__cover.style.width = a.scrollWidth + "px", this.__cover.style.height = a.scrollHeight + "px");
        window.setTimeout(function() {
            this.__cover.style.opacity = 0.9
        }._$bind(this), 1);
        this.__table.style.top = this.__scrollTopNow + "px";
        this.__prior.style.display = this.__next.style.display = 1 >= this.__photos.length ? "none": "";
        this.__showPhotoAtCurrentIndex();
        this.__photosCT.style.display = "";
        i = !1;
        this.__photoItems = g._$$PhotoItem._$allocate(this.__photos, this.__photosCT, this.__pOption);
        this.__resize();
        this.__sizeTimer = window.setInterval(this.__resize._$bind(this), 280)
    };
    e.__resize = function() {
        var a = document.documentElement || document.body,
        b = a.clientWidth,
        a = a.clientHeight;
        this.__photoItems[this.__index]._$resize();
        this.__photosCT.style.width = b * this.__photos.length + "px";
        this.__table.style.height = a + "px";
        this.__next.style.left = b - 60 + "px"
    };
    e.__getSpace = function() {
        return "widgetcommon photoshow"
    };
    e.__getXhtml = function() {
        return '<div class="a-show-mask m-mask wtag" style="opacity:0;"></div>\t\t\t<table class="m-bphoto wtag"><tbody><tr><td>\t\t\t\t<div class="photos wtag" style="position:absolute;_position:relative;left:0;top:0;width:1000000px;height:100%;"></div>\t\t\t\t<a title="\u4e0a\u4e00\u5f20" class="wtag w-pctrl w-pctrl-pre" href="#">\u4e0a\u4e00\u5f20</a>\t\t\t\t<a title="\u4e0b\u4e00\u5f20" class="wtag w-pctrl w-pctrl-nxt" href="#" style="right:auto;">\u4e0b\u4e00\u5f20</a>\t\t\t</td></tr></tbody></table>'
    };
    e._$destroy = function() {
        g._$$PhotoShow._$supro._$destroy.call(this);
        this.__sizeTimer && window.clearInterval(this.__sizeTimer);
        this.__photoItems = g._$$PhotoItem._$recycle(this.__photoItems);
        this.__photosCT.style.display = "none";
        this.__cover.style.opacity = 0;
        V._$delEvent(document, "keydown", this.__onShortcutPressBind);
        window.__photo_showing_lock__ = !1;
        window.removeEventListener && window.removeEventListener("DOMMouseScroll", this.__onMouseWheelBind, !1);
        V._$delEvent(document, "mousewheel", this.__onMouseWheelBind)
    };
    e.__intXnode = function() {
        var a = E._$getElementsByClassName(this.__body, "wtag"),
        b = 0;
        this.__cover = a[b++];
        this.__table = a[b++];
        this.__photosCT = a[b++];
        this.__prior = a[b++];
        this.__next = a[b++];
        V._$addEvent(this.__body, "click", this.__onBodyClick._$bind(this));
        V._$addEvent(this.__prior, "click", this.__onNext._$bind(this, -1));
        V._$addEvent(this.__next, "click", this.__onNext._$bind(this, 1));
        this.__onShortcutPressBind = this.__onShortcutPress._$bind(this);
        this.__onMouseWheelBind = this.__onMouseWheel._$bind(this)
    };
    e.__onBodyClick = function(a) {
        V._$getElement(a) == this.__photoItems[this.__index].__img ? this.__index + 1 == this.__photos.length ? this.__onExit(a) : this.__onNext(1, a) : this.__onExit(a)
    };
    e.__onNext = function(a, b) {
        V._$stop(b);
        if (this.__photos && !(1 >= this.__photos.length)) {
            var c = this.__index,
            f = (this.__index + a + this.__photos.length) % this.__photos.length;
            this.__index = f;
            this.__photoItems[c]._$dispear();
            this.__photoItems[f]._$appear();
            this.__showPhotoAtCurrentIndex()
        }
    };
    e.__showPhotoAtCurrentIndex = function() {
        this.__photosCT.style.left = -(document.documentElement || document.body).clientWidth * this.__index + "px"
    };
    e.__onMouseWheel = function(a) {
        var b = 0;
        a.wheelDelta ? (b = a.wheelDelta / Math.abs(a.wheelDelta), B._$ISOP && (b = -b)) : a.detail && (b = -a.detail / Math.abs(a.detail));
        this.__onNext( - b)
    };
    var f = [37, 38, 39, 40, 27];
    e.__onShortcutPress = function(a) {
        var b = U._$indexOf(f, a && (a.which || a.keyCode));
        V._$stop(a);
        if ( - 1 != b) switch (V._$getElement(a), b) {
        case 0:
        case 1:
            this.__onNext( - 1);
            break;
        case 2:
        case 3:
            this.__onNext(1);
            break;
        case 4:
            this.__onExit()
        }
    };
    e.__onExit = function(a) {
        V._$stop(a);
        a = document.documentElement || document.body;
        a.style.overflowY = this.__bodyOverflowY || "";
        a.style.overflowX = this.__bodyOverflowX || "";
        document.documentElement.scrollTop = document.body.scrollTop = this.__scrollTop;
        g._$$PhotoShow._$recycle(this)
    };
    var b = E._$addNodeTemplate('<table class="photowrap" style="width:1640px;"><tr><td>\t\t\t\t\t\t<div class="bphoto" style="background-color:transparent;">\t\t\t\t\t\t\t<img class="xtag a-show a-show-photo">\t\t\t\t\t\t\t<a class="rphlink xtag" href="#" target="_blank" style="display:none;">\u67e5\u770b\u539f\u56fe\uff081280x1024\uff09&gt;</a>\t\t\t\t\t\t\t<div class="rinfo xtag" onclick="loft.g.stopBubble(event);" style="display:none;transition:opacity 0.3s;-webkit-transition:opacity 0.3s;-moz-transition:opacity 0.3s;-o-transition:opacity 0.3s;"></div>\t\t\t\t\t\t\t<div class="w-load2 xtag" style="display:none;"><div class="load">&nbsp;</div></div>\t\t\t\t\t\t</div>\t\t\t\t\t</td></tr></table>');
    g._$$PhotoItem = C();
    e = g._$$PhotoItem._$extend(P(N.ut)._$$Item, !0);
    e._$initialize = function() {
        this._$super(b);
        this.__exifJST = E._$addHtmlTemplate("<div class=\"exif\" style=\"display:none;\" onclick=\"loft.g.stopBubble(event);\">                    <div class=\"exifbg\"></div>                    <a class=\"w-ii\"  onclick=\"this.parentNode.className= 'exif exif-open'\"></a><a class=\"w-ii w-ii-hover\" onclick=\"this.parentNode.className='exif'\"></a>                    <table>                        <tbody>                            <tr><th>\u54c1\u724c</th><td>${make||'-'}</td></tr>                            <tr><th>\u578b\u53f7</th><td>${model||'-'}</td></tr>                            <tr><th>\u7126\u8ddd</th><td>${focalLength||'-'}</td></tr>                            <tr><th>\u5149\u5708</th><td>${apertureValue||'-'}</td></tr>                            <tr><th>\u5feb\u95e8\u901f\u5ea6</th><td>${exposureTime||'-'}</td></tr>                            <tr><th>ISO</th><td>${isoSpeedRatings||'-'}</td></tr>                            <tr><th>\u66dd\u5149\u8865\u507f</th><td>${exposureBiasValue||'-'}</td></tr>                            <tr><th>\u955c\u5934</th><td><div class=\"exifitm\" title=\"${lens||''}\">${lens||'-'}</div></td></tr>                        </tbody>                    </table>                </div>");
        var a = E._$getElementsByClassName(this.__body, "xtag"),
        d = 0;
        this.__img = a[d++];
        this.__openOrign = a[d++];
        this.__contextMenu = a[d++];
        this.__loading = a[d++];
        V._$addEvent(this.__openOrign, "click", V._$stopBubble._$bind(null));
        V._$addEvent(this.__img.parentNode, "contextmenu", this.__onShowContextMenu._$bind(this));
        V._$addEvent(this.__img.parentNode, "mouseover", this.__imageMouseOverOrOut._$bind(this, !0));
        V._$addEvent(this.__img.parentNode, "mouseout", this.__imageMouseOverOrOut._$bind(this, !1));
        V._$addEvent(this.__img, "load", this.__onLoad._$bind(this))
    };
    e._$setData = function(a) {
        g._$$PhotoItem._$supro._$setData.call(this, a);
        this.__photo = a;
        this.__loadingState = !0;
        this.__src = this.__photo.orign || "";
        this.__ow = this.__photo.ow || 1;
        this.__oh = this.__photo.oh || 1;
        this.__ratio = this.__ow / this.__oh;
        1680 < this.__ow && (this.__ow = 1680, this.__oh = parseInt(1680 / this.__ratio));
        B._$ISSF && (this.__src != N.rc.r + "empty.png" && this.__img.src == this.__src) && (this.__src = this.__src + "?copyone_" + U._$randNumberString());
        var a = document.documentElement || document.body,
        b = a.clientHeight;
        this.__body.style.width = a.clientWidth + "px";
        this.__body.style.height = b + "px";
        this.__img.style.visibility = "hidden";
        this.__img.style.width = "500px";
        this.__img.style.height = 500 / this.__ratio + "px";
        this.__img.style.display = "";
        this.__lazyLoadImage();
        this.__contextMenu.style.display = "none"
    };
    e.__lazyLoadImage = function() {
        i || this.__firstShowPhoto == this.__photo ? (window.setTimeout(function() {
            this.__img.src = this.__src
        }._$bind(this), 20), window.setTimeout(function() {
            this.__loading.style.display = this.__loadingState ? "": "none"
        }._$bind(this), 100), this.__loadExif(this.__src)) : window.setTimeout(this.__lazyLoadImage._$bind(this), 100)
    };
    e._$reset = function(a) {
        a = a || O;
        this.__imageProtected = !!a.imageProtected;
        this.__contextValue = a.contextValue || "";
        this.__cctype = a.cctype || 0;
        this.__firstShowPhoto = a.firstShowPhoto;
        this._$addEvent("onblack", a.onblack || F)
    };
    e._$destroy = function() {
        E._$delClassName(this.__img, "a-show-do");
        this.__img.src = N.rc.r + "empty.png";
        this.__img.style.opacity = 1;
        this.__img.style.display = "none";
        this.__loading.style.display = "none";
        E._$removeElementByEC(this.__cctypeElement);
        this.__openOrign.style.display = "none";
        g._$$PhotoItem._$supro._$destroy.apply(this, arguments)
    };
    e._$dispear = function() {
        var a = parseInt(this.__img.style.width) || 0,
        b = parseInt(this.__img.style.height) || 0;
        0 < a && 0 < b && (this.__img.style.height = b / 4 + "px", this.__img.style.width = a / 4 + "px");
        this.__img.style.opacity = 0.5
    };
    e._$appear = function() {
        this._$resize();
        this.__img.style.opacity = 1
    };
    e._$resize = function() {
        var a = document.documentElement || document.body,
        b = a.clientWidth,
        a = a.clientHeight;
        this.__body.style.width = b + "px";
        this.__body.style.height = a + "px";
        this.__loadingState || (this.__ratio > b / a ? this.__ow > b - 100 ? (this.__img.style.width = b - 100 + "px", this.__img.style.height = (b - 100) / this.__ratio + "px") : (this.__img.style.width = this.__ow + "px", this.__img.style.height = this.__oh + "px") : this.__oh > a - 100 ? (this.__img.style.height = a - 100 + "px", this.__img.style.width = (a - 100) * this.__ratio + "px") : (this.__img.style.height = this.__oh + "px", this.__img.style.width = this.__ow + "px"))
    };
    e.__onLoad = function() {
        this.__img.src != N.rc.r + "empty.png" && (this.__loadingState = !1, i = !0, this.__loading.style.display = "none", this.__img.style.visibility = "visible", E._$addClassName(this.__img, "a-show-do"), this._$resize(), this.__resetCCType(), this.__imageProtected ? this.__openOrign.style.display = "none": (this.__openOrign.style.display = "", this.__openOrign.innerText = "\u67e5\u770b\u539f\u56fe\uff08" + this.__ow + "x" + this.__oh + "\uff09>", this.__openOrign.href = this.__src))
    };
    e.__onShowContextMenu = function(a) {
        if (this.__imageProtected) {
            this.__contextMenu.innerHTML = this.__contextValue || "TEST";
            var b = E._$offsetX(this.__img),
            c = E._$offsetY(this.__img);
            this.__contextMenu.style.left = V._$pointerX(a) - b + "px";
            this.__contextMenu.style.top = V._$pointerY(a) - c + "px";
            this.__contextMenu.style.opacity = "0.8";
            this.__contextMenu.style.display = "";
            this.__contextMenuTimer1 && (this.__contextMenuTimer1 = window.clearTimeout(this.__contextMenuTimer1));
            this.__contextMenuTimer2 && (this.__contextMenuTimer2 = window.clearTimeout(this.__contextMenuTimer2));
            this.__contextMenuTimer1 = window.setTimeout(function() {
                this.__contextMenu.style.opacity = "0"
            }._$bind(this), 2700);
            this.__contextMenuTimer2 = window.setTimeout(function() {
                this.__contextMenu.style.display = "none"
            }._$bind(this), 3E3)
        }
        this.__imageProtected && V._$stop(a);
        a.returnValue = !this.__imageProtected;
        return ! this.__imageProtected
    };
    e.__resetCCType = function() {
        var a;
        this.__cctypeElement && E._$removeElement(this.__cctypeElement);
        switch (this.__cctype) {
        case 1:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by-nc-nd/2.5/deed.zh" class="w-cc1 w-cc1-1" target="_blank" title="\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528-\u7981\u6b62\u6f14\u7ece">\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528-\u7981\u6b62\u6f14\u7ece</a>';
            break;
        case 2:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by-nc-sa/2.5/deed.zh" class="w-cc1 w-cc1-2" target="_blank" title="\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528-\u76f8\u540c\u65b9\u5f0f\u5171\u4eab">\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528-\u76f8\u540c\u65b9\u5f0f\u5171\u4eab</a>';
            break;
        case 3:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by-nc/2.5/deed.zh" class="w-cc1 w-cc1-3" target="_blank" title="\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528">\u7f72\u540d-\u975e\u5546\u4e1a\u6027\u4f7f\u7528</a>';
            break;
        case 4:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by-nd/2.5/deed.zh" class="w-cc1 w-cc1-4" target="_blank" title="\u7f72\u540d-\u7981\u6b62\u6f14\u7ece">\u7f72\u540d-\u7981\u6b62\u6f14\u7ece</a>';
            break;
        case 5:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by-sa/2.5/deed.zh" class="w-cc1 w-cc1-5" target="_blank" title="\u7f72\u540d-\u76f8\u540c\u65b9\u5f0f\u5171\u4eab">\u7f72\u540d-\u76f8\u540c\u65b9\u5f0f\u5171\u4eab</a>';
            break;
        case 6:
            a = '<a onclick="loft.g.stopBubble(event);" href="http://creativecommons.org/licenses/by/2.5/deed.zh" class="w-cc1 w-cc1-6" target="_blank" title="\u7f72\u540d">\u7f72\u540d</a>'
        }
        a && (this.__cctypeElement = E._$parseElement(a), this.__img.parentNode.appendChild(this.__cctypeElement))
    };
    e.__imageMouseOverOrOut = function(a, b) {
        this.__exifElement && (V._$getElement(b,
        function(a) {
            return E._$hasClassName(a, "exif") || "IMG" == a.tagName ? !0 : !1
        }) && "exif exif-open" !== this.__exifElement.className) && (this.__exifElement.style.display = a ? "": "none")
    };
    e.__loadExif = function(a) {
        if (a) {
            var b = U._$md5(a),
            c = k[b];
            this.__exifElement && (E._$removeElement(this.__exifElement), delete this.__exifElement);
            c ? (!U._$isType(c, "string") || !("loading" === c || "none" === c)) && this.__cbLoadExif(b, c) : /\.(?:jpg|jpeg)$/.test(a) ? (k[b] = "loading", J._$loadDataByTAG("http://" + location.host + "/dwr", "PublicBean", "getExif", a, this.__cbLoadExif._$bind(this, b))) : k[b] = "none"
        }
    };
    e.__cbLoadExif = function(a, b) {
        k[a] = b || "none";
        b && (this.__exifElement = E._$parseElement(E._$getHtmlTemplate(this.__exifJST, b)), this.__img.parentNode.appendChild(this.__exifElement))
    }
});
define("{pro}widget/photo/pagephotoshow.js", "{lib}base/global.js {lib}base/browser.js {lib}base/util.js {lib}base/element.js {lib}base/event.js {lib}base/destroy.js {lib}util/event.js {lib}util/item.js {lib}util/extend/md5.js {lib}util/extend/jst.js {lib}util/ajax/tag.js {lib}util/ajax/xdr.js {lib}util/ajax/dwr.js {lib}ui/abstract.js {pro}widget/photo/photoshow.js".split(" "),
function() {
    var g = P("loft.w"),
    e;
    g._$$PagePhotoShow = C();
    e = g._$$PagePhotoShow._$extend(P(N.ut)._$$Event);
    g._$$PagePhotoShow._$bind = function(e, k) {
        if (e = E._$getElement(e)) return new g._$$PagePhotoShow(e, k)
    };
    P("loft.w.g").initPagePhotoShow = function(e, k) {
        return g._$$PagePhotoShow._$bind(e, k)
    };
    e._$initialize = function(e, g) {
        this._$super();
        this.__imgsContainer = E._$getElement(e);
        this._$resetOption(g)
    };
    e._$resetOption = function(e) {
        e = e || {};
        this.__imggroup = e.imggroup || "imggroup";
        this.__bigimgsrc = e.bigimgsrc || "bigimgsrc";
        this.__bigimgwidth = e.bigimgwidth || "bigimgwidth";
        this.__bigimgheight = e.bigimgheight || "bigimgheight";
        this.__imgclasstag = e.imgclasstag || "imgclasstag";
        if (this.__imgsContainer && this.__bigimgsrc) {
            e = this.__imgclasstag ? E._$getElementsByClassName(this.__imgsContainer, this.__imgclasstag) || [] : this.__imgsContainer.getElementsByTagName("img") || [];
            this.__showBigImgs = [];
            for (var g = 0; g < e.length; g++) if (e[g].getAttribute(this.__bigimgsrc) || e[g].getAttribute("src")) {
                this.__showBigImgs.push(e[g]);
                V._$addEvent(e[g], "click", this.__onShowBigImg._$bind(this, e[g]))
            }
        }
    };
    e.__onShowBigImg = function(e, g) {
        V._$stop(g);
        if (e) {
            var f, b = [],
            a = e.getAttribute(this.__imggroup),
            d = 0,
            c;
            if (a) {
                if (!e.id) {
                    c = "id_" + U._$randNumberString();
                    e.id = c
                }
                for (var h = 0,
                j = 0; h < this.__showBigImgs.length; h++) if (this.__showBigImgs[h].getAttribute("imggroup") == a) {
                    f = {};
                    f.orign = this.__showBigImgs[h].getAttribute(this.__bigimgsrc) || this.__showBigImgs[h].getAttribute("src");
                    f.ow = this.__showBigImgs[h].getAttribute(this.__bigimgwidth);
                    f.oh = this.__showBigImgs[h].getAttribute(this.__bigimgheight);
                    b.push(f);
                    if (e.id && e.id == this.__showBigImgs[h].id) {
                        d = j;
                        if (c) e.id = ""
                    }
                    j++
                }
            } else {
                f = {};
                f.orign = e.getAttribute(this.__bigimgsrc) || e.getAttribute("src");
                f.ow = e.getAttribute(this.__bigimgwidth);
                f.oh = e.getAttribute(this.__bigimgheight);
                b.push(f)
            }
            P("loft.w")._$$PhotoShow._$allocate(document.body, {
                singleton: true,
                index: d,
                photos: b
            })
        }
    }
});
define("{pro}theme/thements.js", [],
function() {
    P("Thements.dwr").post = J._$postDataByDWR
});