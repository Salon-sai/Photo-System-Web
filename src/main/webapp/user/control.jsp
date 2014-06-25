<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="author" content="netease">
<meta name="version" content="1.0">
<meta name="keywords" content="">
<meta name="description" content="">
<style type="text/css">
*{margin:0;padding:0;}
html,body{position:absolute;top:0;width:100%;height:100%;overflow:hidden;}
body{top:7px;text-align:left;font-size:12px;line-height:normal;font-family:"Hiragino Sans GB","Microsoft YaHei","微软雅黑",tahoma,arial,simsun,"宋体";}
li{list-style:none;}
a,a:hover{text-decoration:none;}
.f-cb:after{clear:both;display:block;visibility:hidden;height:0;overflow:hidden;content:'.';}
.f-cb{zoom:1;}

.boprt,.boprt ul,.boprt li,.boprt a,.boprt em{height:23px;line-height:23px;}
.boprt ul{float:right;}
.boprt li{display:inline;float:left;margin:0 5px 0 0;}
.boprt a,.boprt em{float:left;background:url(http://l.bst.126.net/rsc/img/control/operatenew24.png?004) no-repeat;_background:url(http://l.bst.126.net/rsc/img/control/operatenew8.png?005) no-repeat;}
.boprt a{padding:0 2px 0 0;cursor:pointer;text-decoration:none;background-position:right 0;}
.boprt a:hover{text-decoration:none;background-position:right -870px;}
.boprt em{padding:0 5px 0 26px;white-space:nowrap;font-weight:normal;font-style:normal;}
.boprt em,
.boprt a:hover em{color:#fff;}
.boprt .notxt{width:24px;}
.boprt .notxt em{width:100%;padding:0;overflow:hidden;text-indent:-2000px;}
.boprt .boprt01 em{background-position:0 -30px;}
.boprt .boprt01:hover em{background-position:0 -60px;}
.boprt .boprt02 em{background-position:0 -90px;}
.boprt .boprt02:hover em{background-position:0 -120px;}
.boprt .boprt03 em{background-position:0 -150px;}
.boprt .boprt03:hover em{background-position:0 -180px;}
.boprt .boprt04 em{background-position:0 -270px;}
.boprt .boprt04:hover em{background-position:0 -300px;}
.boprt .boprt05 em{background-position:0 -330px;}
.boprt .boprt05:hover em{background-position:0 -360px;}
.boprt .boprt06 em{background-position:0 -390px;}
.boprt .boprt06:hover em{background-position:0 -420px;}
.boprt .boprt07 em{background-position:0 -450px;}
.boprt .boprt07:hover em{background-position:0 -480px;}
.boprt .boprt08 em{background-position:0 -510px;}
.boprt .boprt08:hover em{background-position:0 -540px;}
.boprt .boprt09 em{background-position:0 -570px;}
.boprt .boprt09:hover em{background-position:0 -600px;}
.boprt .boprt10 em{background-position:0 -630px;}
.boprt .boprt10:hover em{background-position:0 -660px;}
.boprt .boprt11 em{background-position:0 -690px;}
.boprt .boprt11:hover em{background-position:0 -720px;}
.boprt .boprt12 em{background-position:0 -210px;}
.boprt .boprt12:hover em{background-position:0 -240px;}
.boprt .boprt13 em{background-position:0 -750px;}
.boprt .boprt13:hover em{background-position:0 -780px;}

.boprt .boprt20 em{background:url(http://l.bst.126.net/rsc/img/control/installipad24.png?001) 0 0 no-repeat;}
.boprt .boprt20:hover em{background-position:0 -30px;}


.m-card .close,.m-card .btn{background:url(http://l.bst.126.net/rsc/img/control/operate2.png?002) no-repeat;_background:url(http://l.bst.126.net/rsc/img/control/operate2-8.png?002) no-repeat;}
.m-card-1 .logo{background:url(http://l.bst.126.net/rsc/img/lofter-logo.png?001) no-repeat;_background:url(http://l.bst.126.net/rsc/img/lofter-logo-8.png?001) no-repeat;}
.m-card .join-1 b{background:url(http://l.bst.126.net/rsc/img/weibo.png?029) no-repeat;_background:url(http://l.bst.126.net/rsc/img/weibo-8.png?029) no-repeat;}

.m-card{position:absolute;z-index:10;right:5px;top:2px;padding:12px 15px 15px;width:180px;box-shadow:0 0 2px 0 rgba(0,0,0,0.3);-webkit-box-shadow:0 0 3px 0 rgba(0,0,0,0.3);*border:1px solid #ececec;background:#fff;opacity:.95;filter:alpha(opacity=95);-webkit-border-radius:2px;-moz-border-radius:2px;border-radius:2px;}
.m-card .cont{position:relative;}
.m-card .close{position:absolute;top:3px;right:0;_right:15px;display:block;width:10px;height:10px;background-position:0 -218px;/*font-family:arial;font-size:26px;color:#a4abb4;*/}
.m-card .close:hover{background-position:-27px -218px;/*color:#818181;*/}
.m-card .bd{padding:0 0 15px;}
.m-card .hdimg{float:left;width:30px;height:30px;margin:3px 10px 0 0;}
.m-card .name,.m-card .dmn{width:120px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;}
.m-card .name{font-size:14px;font-weight:bold;color:#444;line-height:17px;}
.m-card .dmn{color:#888;line-height:16px;}
.m-card .btn{display:block;width:180px;height:42px;line-height:40px;text-align:center;}
.m-card .focus{padding-left:10px;width:170px;*padding-left:0;*width:180px;background-position:0 0;}
.m-card .focus:hover{background-position:0 -53px;}
.m-card .focus b{margin:0 6px 0 0;color:#fff;font-family:arial;font-size:24px;font-weight:bold;text-shadow:0 1px 0 #759b00;}
.m-card .focus span{font-size:16px;color:#fff;text-shadow:0 1px 0 rgba(117,155,0,0.65);letter-spacing:10px;vertical-align:2px;}
.m-card .join,.m-card .join:hover{margin:5px 0 0;font-size:16px;color:#777;background-position:0 -106px;}
.m-card .join:hover{background-position:0 -160px;}
.m-card .join-1,.m-card .join-1:hover{color:#fff;background-position:0 -244px;}
.m-card .join-1:hover{background-position:0 -294px;}
.m-card .join-1 b{float:left;width:16px;height:16px;margin:12px 5px 0 22px;background-position:-1px -338px;}
.m-card .join-1 span{float:left;}
.m-card-1{padding-bottom:22px;}
.m-card-1 .bd{color:#444;line-height:1.8;}
.m-card-1 .bd-1{padding-top:24px;border-top:1px solid #eee;text-align:center;}
.m-card-1 .focus{margin:0 0 25px;background-position:0 -106px;}
.m-card-1 .focus:hover{background-position:0 -160px;}
.m-card-1 .focus b,.m-card-1 .focus span{color:#777;text-shadow:none;}
.m-card-1 .join,.m-card-1 .join:hover{background-position:0 0;color:#fff;text-shadow:0 1px 0 rgba(117,155,0,0.65);}
.m-card-1 .join:hover{background-position:0 -53px;}
.m-card-1 .logo{margin:0 0 16px;height:40px;background-position:10px 0;}

.a-control {position:relative;transition:top 0.3s, opacity 0.8s;-webkit-transition:top 0.3s, opacity 0.8s;-moz-transition:top 0.3s, opacity 0.8s;-o-transition:top 0.3s, opacity 0.8s;}
</style>
<script src="../control_data/ga.js" async="" type="text/javascript"></script><script>
window.isForbidUser = false;
window.hostBlogName = 'kaxiuptd';
window.hostUrl = 'http://kaxiuptd.lofter.com';
</script>


<script>
var genRedirectUrl =function(){
var postUrl = document.referrer;
var editPostLinkNode = document.getElementById('editPostLink');
var reblogPostLinkNode = document.getElementById('reblogPostLink');
if(!!editPostLinkNode && !!editPostLinkNode.href){
editPostLinkNode.href = editPostLinkNode.href + '#redirectTo=' + postUrl;
}

if(!!reblogPostLinkNode && !!reblogPostLinkNode.href){
reblogPostLinkNode.href = reblogPostLinkNode.href + '#redirectTo=' + postUrl;
}

};

(function(){
var __cookieKey = 'ipadclientdownloadtipkey';
var __cookies;                 // cookie数据缓存
var __resp = /\s*\;\s*/;       // cookie分隔符
var refreshCookie = function(){
__cookies = {};
for(var i=0,_arr=document.cookie.split(__resp),l=_arr.length,_index;i<l;i++){
_index = _arr[i].indexOf('=');
__cookies[_arr[i].substring(0,_index)] = _arr[i].substr(_index+1);
}
};

var getCookie = function(_key){
return __cookies[_key]||'';
};

var isIpad = function(){
var _userAgent = window.navigator.userAgent.toLowerCase();
return _userAgent.indexOf('ipad')>=0;
};

refreshCookie();

window.showInstallIpadClietTip = function(){
if(isIpad()){
var _value = getCookie(__cookieKey);
if(!_value){
var _node = document.getElementById('installIPadClient');
if(!!_node) _node.style.display = '';
}
}
};

})();

var getCookie = function(_CookieName){
if (document.cookie.length>0){
var c_start=document.cookie.indexOf(_CookieName + "=");
if (c_start!=-1){
c_start=c_start + _CookieName.length+1
c_end=document.cookie.indexOf(";",c_start)
if (c_end==-1){
c_end=document.cookie.length;
}
return unescape(document.cookie.substring(c_start,c_end));
}
}
return "";
}

var onBodyLoad = function(){
genRedirectUrl();
window.showInstallIpadClietTip();
setSize(false, '');

document.body.style.visibility = '';
document.body.style.opacity = 1;
document.body.style.filter = 'none';
};

var setSize = function(showcard, cardflag) {
var _iframe = document.createElement('iframe');
_iframe.width = 0;
_iframe.height = 0;
_iframe.style.display = 'none';
document.body.appendChild(_iframe); _iframe.src = 'http://kaxiuptd.lofter.com/controlproxy.html#dimension=' + (showcard?235:390) + ',' + (showcard?(!!cardflag&&cardflag=='controlcard'?222:document.getElementById('control-card').clientHeight+11):32);
};

var closeCard = function() {
(new Image()).src = 'http://www.lofter.com/rsc/img/sniff.png?target=noshowcard';

var _time = new Date().getTime();
var _value = getCookie('nocard');
if(!!_value){
var datas = _value.split('|');
if(datas.length == 2){
if(datas[0] == '1'){
setCookie('nocard', '2|'+_time, 365);
}else  if(datas[0] == '2'){
setCookie('nocard', '3|'+_time, 365);
}
}
}else{
setCookie('nocard', '1|'+_time, 365);
}

setSize(false);
document.getElementById('control-card').style.display = 'none';
document.getElementById('control').style.display = 'block';
};

var setCookie = function(name, value, expirationInDays, path, domain) {
var cookie = escape(name) + "=" + escape(value);
if (expirationInDays) {
var date = new Date();
date.setDate(date.getDate() + expirationInDays);
cookie += "; expires=" + date.toGMTString();
}

if (path) {
cookie += ";path=" + path;
}
if (domain) {
cookie += ";domain=" + domain;
}

document.cookie = cookie;
}

</script>

</head>
<body style="opacity: 1; filter: none;" onload="onBodyLoad()">
<div class="boprt a-control" style="top: 0px; opacity: 1;" id="control">
	<ul>
<li><form><a href="${pageContext.request.contextPath }/user/profile.jsp" class="boprt05" target="_top"><em>博客设置</em></a></form></li>
<li><form><a href="${pageContext.request.contextPath }/user/home.jsp" class="boprt01" target="_top"><em>返回首页</em></a></form></li>

    </ul>
</div>
<script type="text/javascript">
window.setTimeout(function(){
var _e = document.getElementById('control');
_e.style.top = 0;
_e.style.opacity = 1;

var _e = document.getElementById('control-card');
if (!!_e) {
_e.style.top = '2px';
_e.style.opacity = 1;
}
}, 500);
</script>
<script type="text/javascript">

location.dwr='http://www.lofter.com/dwr';
location.hosturl = 'http://www.lofter.com';
location.dirhost = 'http://l.bst.126.net';
location.cloudMusicFlashUrl = 'http://s1.music.126.net/style/swf/LofterMusicPlayer.swf?004';

location.f110 = 'http://l.bst.126.net/rsc/img/ava/110.png';


Date.servTime = '05/16/2014 17:37:08';

window.CF = {
debugMode:false,
testDBMode:false,
devSourceMode:false,
visitor:{
userId:2455014,
email:'kaxiu_ptd@163.com',
mainBlogId:2455014,
isFromMobile:'',
isForbidUser:false
}
};
window.CF.visitor.visitorEmail = 'kaxiu_ptd@163.com';

CF.blogs = [];
CF.blogs.push({blogId:2455014,
role:10,
blogName:'kaxiuptd',
blogNickName:'Salon.sai',
bigAvaImg: 'http://img1.ph.126.net/AdVum_joIsFJkf-oJTroBg==/143270763245961553.jpg',
newNoticeCount: 0,
newRecommendNoticeCount: 0,
newActivityTagNoticeCount: 0
});
window.CF.visitor.blogName = 'kaxiuptd';
window.CF.visitor.blogNickName = 'Salon.sai';
window.CF.visitor.bigAvaImg = 'http://img1.ph.126.net/AdVum_joIsFJkf-oJTroBg==/143270763245961553.jpg';

CF.activityTags = '你最爱吃的零食,星座控,365励志计划,给未来的宝宝写封信,你有參與過姐弟戀嗎？,我眼中的厦门,想想古时候的你,那些你最喜欢的动漫cp,晒晒你的“懒”,审查官先生：陈道明脑丝,女孩子最美的瞬间,一条触及你内心的短信,黑白交错简单的美,你有过哪些可笑的想法,我养过一只狗,你一直羡慕什么样的人,我最亲爱的你,动漫教会我们的成长,那些年一起追过的动漫,敢不敢发个童年照,大学怎么过,还记得初次见你,一句话证明你热爱生活,发现你身边的古董,那些没能推荐给你的歌,最艰难的时刻,你好夏天,互换明信片ⅱ,拍拍摄影师,k剧场版倒数100,寄往陌生的你,你在坚持什么,什么改变了你？,那些一起陪你2的小伙伴,睡前童话,瞎扯淡,青春的符号,那年十八岁,我没有女朋友,下班路上,摄影者自拍像,你听过最温暖的话,宫崎骏的世界你懂多少,最美华工,喜欢是什么爱是什么,药不能停,脸缠胶带照,发条短信给五年前的自己你说什么,醒来以后我还记得我做过的梦,给恐怖分子竖中指,如果时光倒流十年,你爱过的人怎么样了,那些年我们在旅行中偷拍的情侣,喜欢一个人是什么感觉呢？,那些让你无法忘怀的悬疑片,写给今天的你一句话,讲个故事,做过最勇敢的事,多年前与现在的对比照片,晒晒你的大学,最喜欢的一张照片,这是一座山城,你好，五月“天”,那一刻你决定跟他（她）在一起,摄影成长记,罪己诏,说说你的梦吧,我们的城市我们的故事,晒晒你的房间和你窗外的风景,你的手机铃声是哪首歌？,无法对家人说出口的话或事,说说你那些神经质的怪癖,那些坚持又放弃了的东西,你的毕业季,美食与地点,想ta的时候你会听什么歌,那些和长辈们看的尴尬剧,相亲奇葩多,最近一次因为什么而哭,写一封遗书,我在赖床,別拿手機不當幹部,最怀念,你心目中的男（女）神,你的书单,你想对50年后的自己说些什么,谁是双子座^_^？,幸福的瞬间,每天给你一首情歌,敢不敢爆你喜欢的人的照片,说说你最喜欢那句电影台词,最遗憾的事情是什么？,描述自己心情的一首歌,秀恩爱吧不秀是备胎。,睡前对自己说一句话,用一句话形容你自己,你的那帮二货死党,在烟台,让我再珍惜一会儿,像成都一样生活,那些年我们抽过的风,蓝河生贺,记录自己做的梦,网络还是纸笔,你见过的最文艺店名,晒晒校园之美,记录生活1000件幸福小事,glee,老照片,现在拿起手边的纸笔会写些什么？,我们能在此停留多久,我最期待的是,因为什么你失眠了,向身边的“老师”请教一个问题,喜欢拍照的我的本职工作是,生活就像是屁,让我看看你穿帆布鞋的样子,假装十八岁,脑海中的设定,全职相关十题,世界上最变态的地方,我是学生,喜欢的咖啡店晒出来,晒晒你p的图,打动你的旋律&歌词,还记得儿时的你嘛？,密室逃脱的故事,这么晚了为什么还不睡,晒晒你的背影照,原来只是个错觉,旅行这件事,一日一记一季,文手画手求同好,《咔啪》5~7月影赛“风景建筑篇”,where are you ,夜拍,无病呻吟,舌尖上的杭州,我听的第一首英文歌曲,说说你丢失的那些心爱的东西,《咔啪》7月主题月赛\"水\",你做过最二的事！,你最想拥抱的人,打发时间的探讨别认真,现在的你活成了什么样子,因为一句话爱上一处风景,这五年来你没有换过什么？,那些即将逝去的老街,我开始疯狂的想你们了知道吗？,心死不过一瞬间,如果有时光机你最想去到什么时候,淡妆浓抹总相宜,世界读书日我在读书,和另一半相似的地方,这草你到底还吃不吃？,你对聋哑人怎样的看法,show出你的美丽鞋纸,for  you,我收集的感动,想不通的事情,晒晒你们的毕业照,我喜欢你我就给你写情书,你萌过的最热和最冷的西皮分别是什么,初遇那件小事,猜猜你还会在坑里躺多久,枕边书,心甘情愿做的事,我爱的四字,那些最温柔的字眼,一句话一幅图,说一说为什么来lofter,你想放弃却又一直在的东西,画出你记忆中的模样,最喜欢的婚礼音乐,村落与城镇化,大城市里的拼搏还是小城市里的安定,送给自己的一句话,若我回到从前,此刻想对你的初恋说的话,妹子们在镜头下最美和最毁的照片,你最怕的事,爸妈我想对你说,黑白的自己,遇到坎的时候是什么让你坚持下去的？,那些经典,和喜欢的人做过最疯狂的事情,我的闺蜜是女神,你是帽子控么？,show出你的手指给我看,那些年我们玩过的游戏,致那些令人心酸的反派,和谁的旅行最难忘？,多久换一个新手机？,熊事儿,听过的梦话,因为他爱上篮球,he is not the one,当你回去找她,最喜欢的文人是谁？,好多好多冷cp,印象桂林,小伙伴,暗恋日记,看看你的手机装的啥,写个笑话撒,字得其乐,闺蜜和我,现在你还相信爱情么,你好，过去的我,记个梦呗,那些做过的梦,谈谈如何拉近准媳妇和准婆婆的距离,生活，喜怒哀樂,音乐色彩,有没有一个人他的聊天记录你不舍得删？,一個人生活,多久没有写封信,一个独身女人的日常,适合深夜听的歌,关于朋友,你還在拍貓嗎該拍一下狗了,heysummer time,无后期,i和you中添一个词哪个能让你感动？,是什么让你坚持至今, 你有多久没有回家？,发现美丽景点,锁骨放硬币,用一张照片证明你爱ta,早餐店的单曲循环,童年与现在的你,灵感橱窗,今天的你最美,好看到会推荐给别人的电视剧,带给你正能量的那句话儿,一部叫做生活的电影,你愿意当别人口中的女汉子吗？,每天写一件最想做的事,美丽的漏光,送给母亲的话,2014 音乐节,你最想对ta撒的谎,最值得你怀念的某件事,母亲节给妈妈的话,365摄影,一张最搞怪的自拍照,即将毕业答辩了你想说点什么么？,身边的红绿灯。,生活在别处,想成为什么样的人？,籍着情诗说爱你,他和她的回忆,人生第一张照片,po出你的剪刀手照片,五一你要去哪儿？,你想成为的最好的自己,雨后的早晨什么样,给母亲照张像,我爱的男孩,你认为必须为男友做的一件事,what a fucking day!,胡言乱语,第一首taylor swift的歌,你眼中最好的爱情电影,让我看看你眯眼或是睡着的样子,模仿自己也那么难,纯景,我是手控,暴走上海滩,推荐摄影师,让麻豆来拍摄影师,如何改掉自卑不自信的毛病,校园生活,当你笑的像孩子,日记本,你为什么还不睡,拍过最美的花,工作面积,动漫里的二货,那些说好了却没做到的事,单人旅途中遇到的不可思议。,你的考试复习到哪儿了,图文互换,让你窒息到想哭的一瞬间,最令你刻骨铭心的一句话,记录家的味道,你拍的陌生人,猫的徘句,童心未泯,让我看看你的搭配,那些动漫里的唯美,你现在最想说的一句话,为马航遇难者默哀！,运动歌曲专享,蹩脚的英文翻译,影子不说话,在广州,40mm,童年的独家记忆,在古镇,无聊不无聊！,父亲母亲的模样,最近累什么,我们之间总隔了点什么,让你没有抵抗力的人或物,写个字拍给我吧,生命中美好的事都是免费的,35mm,那一刻,365写作计划,给明年的自己写封信,那些触动神经的歌词,读书顶个x,你还记得你童年的梦想吗？,你是怎样写字的,我喜欢却穿不了的美衣,五月天给我们的勇气,悄悄告诉我你正用心的干什么呢？,红五月的故事,喜欢ta的感觉,八一八踢球的帅哥们,幸福每一天,爱与被爱关於你身边的爱宠,至今热度最高的作品,我的摄影要反省,毕业旅行去哪儿,我有几个我,理想国,我的深夜日记,喝茶,你住过的那些国际青年旅舍,他/她最让你心安的一个画面是什么？,晒出你的素颜照,你的情止于谁❤,那些人,我没有男朋友,为爱受过的伤为爱做过的傻事,有没有那么一瞬发现家乡是最美,窗外的风景,最让你难忘的一部美剧,喂，你在干嘛,如果你能娶（嫁给）外国人,一起去西藏,我眼中的自己,说说你最孤单的时刻,一句话送别马尔克斯,最智慧的人,那年的愿望,你知道哪些好听的手机铃声？,永远在路上,你是怎样邂逅lofter的,毕业前的我们,你曾经说过最让父母伤心的话,大家心中的鬼白,你在哪里吃饭,那些听着会莫名伤感的歌,你几岁你几点睡？,你的梦想,妈妈的家常菜,最惹妈妈生气的一件事,游戏绘画,心动是怎样的,三言两语最美的你,筑于人心的建筑,今天，你减肥了吗,你有过哪些可笑的事情,每周一省,属于我们的那些小事,你钟爱的食物是纳尼？,糟糕我又失眠了,大鼻子先森,如果只推荐一部电影,还会在坑里躺多久？,孩子哭了笑了,少年素锦时,关于她他的故事,你是我的眼,晒晒各位大神的电脑 ,说说你的强迫症吧,什么事情让这一刻的你开心or不快乐？,每天对你说一句晚安,晒一晒你和同桌现在的关系,說說你做過的最浪漫的事,你在哪喜欢现在的生活吗？,我们都是可爱的射手座,中考高考囚犯进行时 ,关注您身边的人,说说男友最帅的那个瞬间,我爱过的你,5月感恩母亲,自恋进行时,戴妍琦生贺,最喜欢的动漫有哪些？,耳非耳——音乐的世界,你的前任教会了你什么,你最讨厌的女主角是谁？,说说你博客的昵称由来,林敬言生贺,身边的猫,有feeling的网络美女图片,如果恨你会如何恨,那些美味的甜点,拍下走过的路,那一刻的温情,唱見,人生的第一份工作,一人一秘密,那些因为封面而让我们爱上的书,金牛座,关注你身边的街拍,说说自己的朋友,最佳损友,来签个到,那张照片证明了昨天却不证明谁的誓言,学生时代的绰号,五月忙什么？,对初恋说的一句话,我们都是帆布控,晒一晒小时候和妈妈在一起的照片,被小偷照顾之后的感觉,你身边的小家碧玉,失恋集中营,秀出你的原创诗歌,不想看到自己不好的样子,孤独和寂寞是什么样子的？,让你触动的一句歌词,手势,说一句你觉得最温暖的话,每天一件新鲜事儿,致我操蛋的生活,不能长久的是真爱吗,有没有一句歌词惊艳了时光触动了你？,全职高手里你最想写【想画】的那些梗,我写的歌词,来自星星的你们,一张图表达你此时此刻的心情,那一刻我整个人都酥麻了,最喜欢的季节,黑白界,家有儿女,你干过的那些蠢事,第一次遇见你的地方,致nba96黄金一代,我们不近视，但是我们就喜欢眼镜,在中国福建,我在东莞,你最爱的外国电视剧,北京夜,我一个人吃饭,毕业季  ,你爱ta多久了,用手中的笔再爱一次你最爱的动漫,青春祭,ta在哪？,窗外的世界,交换明信片,来发牢骚吧！,你听过最美的一句话？,让我为你说晚安,与朋友的小酌时光,因为什么爱上一座城,5月20日の爱情,如果当时,暗恋那一刻，拍下来了！,  让你的心属于自己,那些名不副实的菜名,一起来个鬼脸照,让你动容的一刻,快乐的旅行,过曝又如何,心水的电视剧,懷念哥哥（張國榮）,那些不甘心的事情最后变得怎么样了？,短发女人,拍拍身边事物,此刻的心情,大学同胞们谈谈自己吧,我和我的男闺蜜,追忆那逝去的...,看电影时被惊到的插曲,最轻松的赚钱方式,毕业季的离愁别绪,十年之后的你还会在哪里,那时候的心情,你最爱的一位亲人是谁,又是一年毕业季,叶修生贺,今天我遇到了开心事,那些你想说但没说出来的话,如果有时光机你会选择干什么,在上海,你心情如何？,宫崎骏,晒出你的包,时尚影像,戴耳机的我们,骑行,学舞蹈的时候,你做过爱情备胎吗？,突然睡不著的時候，你/妳會？,经典难忘台词,一生中今你最感动的人与事,说说想念却不想见的人,半边脸的美,truth or dare,你都用过什么奇葩的理由请假,大学毕业前最想做的事,画一画你的本命,景非景,大头照,请让我看看你的床头柜,365天早餐不重样,十年前的你,你的手机铃声是什么,灯下漫笔,循环一百遍的歌,把自己觉得最美的一张照片发上来,寻找最真实的黑白面孔,你的倒数日里是什么？,大家是怎么开始初恋,第一届剧情接龙,我最爱那啰嗦的爸妈,剧照2333,最喜欢老妈做的哪个菜,一张最开心的照片,巅峰视界,冲动是天使冲动是魔鬼,那些记忆里的乐章,来推荐一本你喜欢的书吧,回忆朋友青春,我拍到飞碟啦,ting-sense我们身边常忽略的小事,同桌的你,一个人的空间里你都干些什么,鲜为人知的好电影,为父母拍张照,那段青春被狗吃了,你粘ta但ta嫌烦怎么办？,你来出题我来写/画,你清澈的眼睛还在吗,让你念念不忘的人,一句歌词you love,忏悔录,你最喜欢的英雄联盟英雄,一周和文章,我是企划主,说说你的坏毛病,未能成行的信,每天一句话一张图,晒一张你爱慕的女神男神照片,你几岁到过几个城市？,那些让你得意的拿手好菜,毕业了,秘密,我只是过客,我有强迫症,孤独,随手拍,我爱过的人,我的美容日记,敢不敢掀个刘海,那些你想去的地方,那些年追过的剧,时光机k886号起航,能治愈我的东西,拍下我的座驾,在遗憾之前说一句话,说说你最近看的电影,大学毕业时你的年龄？？,这个世界到底是什么样子呢,记录你的下一秒,让人动容的话语,来谈谈对异地恋的看法,我们来晒晒脚吧！,描述一下你最无助的时候,说说你的怪癖,9个问题,那些年你错过什么,为自己做一张遗像,auto口尼康老镜头,深爱的人是谁？,我和我的他,朋友圈越大真的越孤独么,旅途中的那些事,我就是喜欢画画没有理由,我看的第一部日漫,我的背影,在杭州,美食每刻,还记得空间的第一条说说吗？,最深刻的感悟,大学毕业要答辩了写出你想说的话。,寻找遗失的美好,在路上,你会是夜跑一族吗？,说说那些关于遗憾的事,记忆中的海子,心底唯一的那个人现在在哪里,蛋糕发现之旅游,送给母亲的花,记得第一个玩具,纯音乐,躺在回忆里的旧物,你为她（他）做过最傻的事,那些经典的老歌,你手机里的第一张照片,hey，一起鬼脸照吧！,喜欢喊你爱的人什么名字,一闪而过的念头,放学了,在北京,来晒晒你的房间,再远也远不过生死,清晨醒来的模样,随心记录,在深圳,无主情话,我看看你头像牛逼吗？,我的青春在广州,你为什么喜欢《小王子》？,你干过的最丢脸的三件事,画不完的往昔记忆,爱笑的人心事多？,我们一起萌动起来,live·说说你最喜欢的音乐现场,最开心的事,印象南京,读（死）书（磕）笔记,那些经典好听的广告曲,现在和爱的人在一起吗,黑子的篮球里喜欢的cp,我的下一站！,错误,遗愿清单,哇塞，下班了耶,遇到乞丐你会给钱吗,发现世界的美,你还坚守着那份爱吗？,内心里的一句话,粤影粤叻,让我看看你的纹身,我对初恋的定义,如果我们的青春没有周杰伦,毕业设计伤不起,my childhood,一句最触景伤情的歌词,你的梦想是什么？,古诗词笑起来,写给二十年后的自己,舍与得,2014我们呆的办公室,找个人去旅行,雨天怎么过,前任留下来的物品,我镜头中的世界,我們都曾愛的很用心,寻找葉子,我是一个没有相机的摄影爱好者,分享你最爱的短篇小说,你在坚持做的觉得有意义快乐的事情,那一刻我活着,你对lofter的看法,你为什么睡不着？,文字龙之力,地雷炸出游戏党,你为自己做过什么？,喜欢张国荣？！,对应你身边女人的一首歌,来吧亮出你的底牌！,爱你一兆年,你在哪？,想回到过去,又到了眼花缭乱的季节,谁没个强迫症,billboard,《咔啪》5~7月影赛“人像篇”,一些事一些情,莫奈特展·启蒙我的画,为毕业说点什么,你和你对象是怎么认识的,你在世界的哪个角落？,手写handwriting,一句话送给你遇见的那个对的人,二十五岁的时光,五一去哪儿,小说阁,我爱广州,都是夜归人,一起来聊聊香水,光盘废物利用,summer is coming！,你订阅后从来没有更新过的tag,有没有那么一首歌让你想起他（她）,上学路上,记录青春,晒晒你戴眼镜的样子,你身边的夏天！,那些网络上漂亮的gif动态图片,乡村和城市,回想上山下乡的日子,你曾唱过什么歌,fighting for what,那些熟悉or陌生的小伙伴,时常会想起的场景,短情书,去你的重新开始！,影像视觉户外旅行摄影大赛,说说那些让你瞬间沸腾的音乐,和你在一起的时候,组队去拉萨,爸爸回来了,如有你喜爱的故事就寄出一张明信片,听了两年以上的歌曲,今天你为什么生气了？,让我看看你的眼神,那些让你一见钟情的诗句,《同桌的你》,你最喜爱的一部动漫,最让你难忘的画,“婚”了の季节,母亲说过的话,拍下你的同桌,摄影新手最需要什么帮助？,让你感动过的动漫,写一首诗,那段疯狂日子叫做青春,你的那些二货萌宠,最美的一句话,哪一句歌词最代表你现在的心情,你发起过得秒沉的活动,如何说再见,关爱母亲,给我讲讲你的故事吧,带个你最大价值的手机app,最美的宋词三百首,你拿筷子的方式,你做过的最nb的事,我的一天,你眼中的朋友,1000朵盛开的樱花,我喜欢的话,女生喜欢一个男生的感觉,爱生活,舌尖上的美食,爱ta请留言,夏天,网络中认识的第一个陌生人,你的死党,keep a diary,你有强迫症吗,我们都爱汪星人,hello world,用四个字概括你的过去,長髮綰君心,一个很严肃的问题,你认为男（女）朋友的第一条件是什么？,记录每天做的梦,你最难以忍受的一瞬间,那些年调戏过你的老师,寻找杏花樱花桃花,好书征集令,看到别人跳广场舞的那一刻你在想什么,第一人稱視角,我怀念的,喻魏活动,叶秋生贺,手写爱❤,我们都在哪里？,世间每一朵花都是造物主的宠儿,every little ting,我的妈妈是女神,那些还不及推荐的手机app,大学那点事,人生中你最怕什么？,我也曾因为一句话而双眼惶惶,给他的礼物,如果世界只剩下8秒钟,《器》, 最动听的情话,在另一个世界里的自己,你好錶喔！,如果你是土豪你要做什么,喜欢的28件东西,把你甩了还说你是朋友的男人你觉得如何？,折原临也生贺,我也借过钱,深夜碎碎念,每日一首纯音乐,我的独自远行,母亲节快乐,寻找一个思念的角度,听妈妈的话你呢,大学里难忘的话,我们毕业了,旅行孤独症,那些萌化人心的小猫咪,一个故事证明你的坚强,运动的妹子最美,then and now,《咔啪》5~7月影赛“人文小品篇”,你最想开的小店,你的理想人生是怎样的？,说说另一个你,收到过最感动的礼物,哪些相见恨晚的好网站？,愿望清单,人丑就要多读书,秀出你的桌面,你写过的情诗,我身边的灵异故事,记忆中的初恋,说说你做过的梦吧,我拍过的高压塔,说出印象深刻的电影,今天这样穿,让我们建一堵微笑墙,暧昧的那个ta,最美大学时光,最勵志感人的圖片或故事,如果真的有如果你会怎样？,连自己都不能忍受的缺点,来不及,花卉植物爱哪样？,你写过最美的情书,唯一 一次的告白,你至今做过的最疯狂的事,劳动者最美丽,你办公桌的样子,翻包不停,每天推首歌给你,你喜欢的那张相片,你曾经获过奖的,原风景—世界如你所想,你们是怎么在一起的。,时间都去哪了？,在厦门,秀出你手机里的小“盆”友,你最想去哪里旅行,我如何成为我,精神和肉体，无法接受哪个出轨？,你爱修图吗,看天空,现在的沈阳,30岁前你想干什么？,晒出你最喜欢的一张照片,冒充小朋友,我写故事你来接,让你凝视很久的一张图片,最得意的作品,你有哪些压迫症,让我哭成傻逼的电影,翻跟头亲亲,抱歉那时没有对你说抱歉,给初恋的一句话,爱宠的名字,身边的女神经病,初恋关系,面对老问你借卫生纸的异性同事你是啥看法,爸妈的结婚照,电子音乐季,你最遗憾的事,自家小宠,陪伴我们青春的漫画们,你做过的坏事,那首歌能阐述你的想念,那5秒,女人心❤,说说你看过的烂片,留下故事的火车站,家乡的味道,世界静音，带走的一首歌,在这个爱的国度有你,想拍就拍随手一族,我逆光死,好朋友的醉酒状,对自己说all is well,一句话送给你错过的ta,倩女幽魂绘画大赛,关于宠物和绿植关于孤单和陪伴,藏着最爱的图片文件夹,镜头里的普通人,亲亲你的锁骨,在重庆,最好的朋友跟了你几年了？,2014西安草莓音乐节上你怎么穿才出彩,你今天穿的什么鞋,早上起来突然发现性转你会怎么安排生活,晒一晒你正准备买的那本书 ,白羊座,同桌的她或他,手边物拟人,野外烧烤,辞职去旅行,近期你最想改变的现状是,旧时光里有哪些你念念不忘的记忆。,在青岛,忘不了的那句歌词,你做过的最少女的事情,那些年爱过的书中人,带给你力量的那句话,我不是那样的一个人,你是怎样遇见lofter的,最特别的礼物,最让你讨厌的一句话,你的闺蜜,我只想找人说句话,最难以忘怀的校园一角,和一颗树的合影,“当下”——用心创作,一句不能说而又希望ta在不经意间看到的话,我们拍过的那些剧照,为什么年纪轻轻的我如此悲哀,越努力越幸运,你拍过的影子,我只要一次爱情,晒出你现在正在使用的手机,喵星人接力,睡前读什么？,什么是安全感,在異鄉,此时此刻你的心情是,app首页交给你,总有一只猫让你柔软下来,那句直戳心脏的歌词,最浪漫的一首歌,初心·回到摄影的原点,那些为ta写下的只言片语,上班路上,我们爱穿情侣装,夜深了我还没睡,你想给自己录一段什么样的视频,说说你梦境中的的未来,发几首相见恨晚的歌曲,为ta干的那些傻事,那些年我们喝过的酒,稻草人,你钟爱的日文歌曲,最重要的纪念日,在坐车时会干些什么,喂，你在干嘛呢,泪了也是一种情绪！,述说春天的故事,我身边的故事,你几岁开始不喜欢泡面？,如果有一次免费旅行你最想去哪里？,你最深刻旧梦片段,我是女伪球迷,有故事的图片,你喜欢的宋词,不随手拍,5月生如夏花,杭城往事,一张图的想象,地铁上你看什么书？,镜头里的车模,你最喜欢的一首诗,在amoy,是否会有一首歌一直在脑循环,每天必须完成三件事,公园里,一封情书,晒晒你的电脑桌面,你都如何去回忆,说说我们身边当之无愧的女神,我们都有书可读,家是个什么样的地方,正能量,如果现在你有个男朋友,晒晒宿舍里你的桌子,你相信远距离恋爱吗？,讨厌的食材,秀秀你的handwriting,最爱你的短发,不见童年,如果你也是黑白控,每天大家在烦恼什么,你有安全感吗？,如果我再年轻一岁,你喜欢的人和人们,你说过最浪漫的话是什么,祭奠毕业,存下那些温暖的电影,那些年我们拍过的云,抓拍到的‘神’表情,只谈情不说爱,清明时节回忆故乡,一天一句心情,楼冠宁生贺,你的兴趣是什么？,给你的ta上颜色,你记得的“梦”,我就是我，是颜色不一样的烟火。,我多想爱她（他）,他（她）留给你的,总有那么一瞬想哭,去野户外,那些使你印象深刻的著作,我家爱宠,一生中令你最感动的人与事,想戒掉还迷恋的嗜好,2014《国家地理》全球摄影大赛,520林方日,一个城市一张照片,撑同志，反歧视,最喜欢的电影台词,让我们回想起童年的事,关于你的泰迪熊的名字,你有几个自己,对不起,你的我的拖延症,和绘画有关的电影,秀秀你的手写字体,《咔啪》主题月赛“拥抱五彩斑斓の夏”,你在骑车的时候在想什么,那些年卖萌的妹子们,你眼中的那个他,圆脸在身边,张国荣,目前你看过的最好看的书,你的十八岁,最喜欢最有意义的电影,你在看什么动漫？,办公桌面透露你的秘密,莫奈特展·我拍过的桥,穿校服的样子,爱我请留言,古诗词改三句半,最打动你的歌,图片的故事,第一次拍的那个妹子,我是神经病,每天进步一点点,一句话描述你现在的状态,伤心的时候听什么歌,作业用音乐,树洞：说出来我们安慰你,有态度,这个春天你写的那些诗句,一张图说明你最想去的地方,我的feellife,慢跑的时候你在想些什么？,人在高三,我们就是情绪化,深夜的那首歌,笔尖的文字,你心中的中国民谣,爱的天地,说一下你的想法呗,那些令人唏嘘的爱情,你应该要什么样的对象？,麦当劳叔叔才是个有爱的人,分享你的浏览器界面,你拍过最丑的照片,你的毕业照,如何看待当今社会好人好报与弱肉强食,李轩生贺,你坚持了多久？,食摄巴蜀,给陌生人的一封信,在川西,我们都爱star☆,写给3个月后的自己,你和他(她)第一次遇见的地方,你做过最二的事情是什么？,你敢说出他/她的名字吗？,天气这么好却要______，情绪难以形容,你想对心里那个不可能的ta说什么呐？,同人作者们的调查问卷,活到现在最令你后悔的一件事,说一搞笑外号,万能吐槽模版,最浪漫的事,纪录片,新发现的歌,说说你现在的身份,那些震撼心灵的歌声,思思新婚快乐,在东北,手机里第一张照片,写在歌词里的地方,展出自己的个人名片,随手拍多肉植物,放弃忘记,你做过最丢脸的一件事,对妈妈说句话,在哪里,曾经吹过的牛,一张图证明你单身,生活需要一点颜色！,那些年的黑（玛）历（丽）史（苏）,易得的快乐人生or奋斗的苦逼人生,当音乐响起你会想起谁,一道菜证明你是哪里人,窗户外的风景,镜中的我,那些回不去的年少时光,你说未来的我会怎样？,爱很简单,梦的追随者,去年的今天你在哪做什么,说走就走的毕业旅行,小时候你想长大了干什么,一句让你坚持，给你力量的话,那些年少捧腹的事,还记得小学吗,网易云阅读礼品设计征集,我最爱的一张壁纸,起名字啦,文手恩爱十五题,get a real life,我想有人能和我一起坚持早睡,距离最初的自己有多远,触碰过心灵的音乐,未来你想好了么,给自己的忠告,我最爱摇滚,acfun生贺,渴望新生,你的初恋,说说你们最近喜欢的音乐,毕业季,最想去的一个地方,送给2015年的自己,自拍的时候你在想什么,男生喜欢一个女生是什么感觉,你养的是什么宠物和植物,偷拍,天天听歌,晒书单,我的小伙伴,心情发酵了,我有一个叫xx的同班同学/老师,2014吴邪生贺,感觉累了时,纠结的我,我爱英伦,你眼中的长沙,说些温暖的话让我爱上你,第一次接吻的感觉,反转想象力,一见倾心,说说你的丢人事,照片墙照片征集,我的状态,工作上的那些事,说说你眼中的星座某,那个给你勇气继续下去的梦想,说说你和她(他)的故事吧,哪句歌词刻骨铭心,心情不好的时候我会...,生态环境破坏,你们分手的理由,说说你的爱情观,那些年循环的慢情歌,拍拍自己的桌台,说说你的口头禅,说不出去的话'.split(',');

var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-31007899-1'],['_setLocalGifPath', '/UA-31007899-1/__utm.gif'],['_setLocalRemoteServerMode']);
_gaq.push(['_setDomainName', 'lofter.com']);
_gaq.push(['_trackPageview']);

(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = 'http://wr.da.netease.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
</script><script src="../control_data/core.js" type="text/javascript"></script><script src="../control_data/pt_page_control.js" type="text/javascript"></script>



<iframe src="../control_data/controlproxy.html" style="display: none;" height="0" width="0"></iframe></body></html>
