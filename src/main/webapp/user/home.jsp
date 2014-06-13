<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>LOFTER</title>
	
	<meta http-equiv="X-UA-Compatible" content="IE=10">
	<meta name="author" content="netease">
	<meta name="version" content="1.0">
	<meta name="keywords" content="">
	<meta name="description" content="">
	
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css">
	
	<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/ajaxfileupload.js"></script>

	
	<script type="text/javascript" src="../home_ui/js/ga.js"></script>
	<script type="text/javascript">
		(function(window,document){
		    if(top!=window) top.location=location.href;
		    document.uniqueID!=document.uniqueID&&!!location.hash&&(location.hash=location.hash);
		    window.focus();
		})(this,document);
	</script>
    
	<link href="../home_ui/css/pt_lib_macro.css" type="text/css" rel="stylesheet">
	<link href="../home_ui/css/pt_page_newpublish_dashboardnew.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../home_ui/css/ueditor.css">
    <link rel="stylesheet" type="text/css" href="../home_ui/css/homecss.css">

	<script type="text/javascript">
		window.isInDashboard = true;
	</script>
	<link href="../home_ui/css/pt_page_newpublish_dashboard_common.css" type="text/css" rel="stylesheet">
  	<style type="text/css">
  	
	</style>

	<script type="text/javascript" src="../home_ui/js/codemirror.js"></script>
	<link rel="stylesheet" type="text/css" href="../home_ui/css/codemirror.css">
	</head>
  	<body class="page-lofter js-bodyCoverShow">
	<a style="display:none;" rel="nofollow" href="" class="w-fank">意见反馈</a>
	<div id="lofterheadbar" class="g-hd">
    <h1 class="m-logo"><a href="LOFTER.html">LOFTER-网易轻博</a></h1>
    <div class="m-nav" id="topbar">
	        <ul class="nav1 tbtag">
	            <li class="j-crt"><a rel="nofollow" href="${pageContext.request.contextPath }/user">首页</a><a href="../home_ui/LOFTER.html" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc tbtag">5</span></a></li>
				<li class=""><a href="http://www.lofter.com/view?act=dashboardclick_20130514_01">浏览</a></li>
				<li style="display:none;" id="arturl"><a target="_blank" rel="nofollow" href="http://www.lofter.com/art?act=qbart_20140403_09">ART</a><a target="_blank" href="http://www.lofter.com/art?act=qbart_20140403_09" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc">绘画</span></a></li>
	            <li>
	            	<a href="http://www.lofter.com/#" class="tbtag">更多<span class="more tbtag">&nbsp;&nbsp;&nbsp;</span></a>
	            	<a href="http://www.lofter.com/#" class="w-tip f-dn" id="uapptip1"><span class="tipc">新</span></a>
	            	<div class="a-w-sel a-w-sel-4 tbtag">
		            	<div class="w-sel w-sel-4" style="margin-top: -258px;">
		                	<div class="selc">
		                    	<div class="selcc tbtag">
		                            <div class="seli"><a class="nx-1" href="http://www.lofter.com/setting">帐号设置</a></div>
		                            <div class="seli"><a class="nx-2" href="http://www.lofter.com/inviteelist#siteIndex=0&typeIndex=0">寻找好友</a></div>
		                            <div class="seli"><a class="nx-6" href="http://www.lofter.com/export">导入导出</a></div>
		                            <div class="seli"><a class="nx-3" href="http://www.lofter.com/app?act=qbappentry_20140303_01">移动客户端</a></div>
		                            <div style="_display:block;_position:static;_zoom:1;_visibility:hidden;_overflow:hidden;_height:0;_border:none;" class="seli f-dn" id="uapptip2"><a class="nx-7" href="http://www.lofter.com/uappsetting">UAPP-创建个人应用</a><span class="newicn"></span></div>
		                            <div class="seli"><a class="nx-4" href="http://www.lofter.com/help">帮助及反馈</a></div>
		                            <div class="seli"><a class="nx-5" href="http://www.lofter.com/logout">退出</a></div>
		                        </div>
		                    </div>
		                </div>
		            </div>
	            </li>
	        </ul>

	        <div class="nav2 m-ssch-act" id="schtagbox">
	        	<div class="ssch tbtag">
	                <form class="xtag">
	                	<a href="${pageContext.request.contextPath }/user" class="btn xtag"></a>
	                	<label class="xtag" style="display:none;">搜索标签、博客</label>
	                    <input type="text" placeholder="搜索标签、博客" class="xtag" onfocus="this.isfocus = true;">
	                    <div class="xtag a-show-mask f-op0">
		                    <div class="new" style="display:none;" id="nav2flnew"></div>
	                    </div>
	                </form>
	            </div>
	            <div class="m-ssch2  m-ssch-act" style="position:absolute;top:100%;">
	            	<div class="suggest">
                    	<div class="sugbox xtag" style="visibility: hidden;">
                        </div>
                    </div>
                    <div class="a-w-sel a-w-sel-5 a-w-sel-do" style="display:none;">
	                    <div id="taglist" class="w-sel w-sel-5 tbtag" style="margin-top: 0px;">
			            	<div class="selc">
				            	<div id="favtagcnew" class="selcc tags">
				            	</div>
			            	</div>
		            	</div>
	            	</div>
	            </div>
	        </div>

	</div>
</div>
    <div class="g-bd">
    <div class="g-bdc">
	<div class="g-mn" id="main">
		<div id="publishBarArea" class="publishBarArea">
		  <ul id="publishPostBar" class="m-nav2">
			<li class="user"><a href="${pageContext.request.contextPath }/user/home.action"><img src="../home_ui/143270763245961553.jpg"></a></li>
		        <li><a class="publishlink n21" id="publish_text_bn" href="" data-toggle="modal" data-target="#publish_text">文字</a></li>
		        <li><a class="publishlink n22" href="" data-toggle="modal" data-target="#publish_photo">图片</a></li>
		        <li><a class="publishlink n23" href="" >音乐</a></li>
		        <li><a class="publishlink publishlink-video n24" href="">视频</a></li>
		  </ul>
		</div>
		<div style="display:none" id="tempSaveTipArea" class="tempSaveTipArea"><div class="tempsavetipwrap">你还有一篇未发布的文章。<a class="gotemppost" href="http://www.lofter.com/#">查看</a><a class="closetip icon2-8" href="http://www.lofter.com/#" hidefocus="true">&nbsp;</a></div></div>
		<div style="display:none" id="bulletinTipArea" class="tempSaveTipArea"><div class="tempsavetipwrap"><div class="bulletincontain"><span class="ztag bulletintxt"></span><a class="gotemppost ztag" href="http://www.lofter.com/#" target="_blank">查看</a></div><a class="closetip icon2-8 ztag" href="http://www.lofter.com/#" hidefocus="true">&nbsp;</a></div></div>
          <div id="noticetip" class="a-slide a-slide-do"><div class="m-mlist slide" style="display:none;">
	    <div class="mlistcnt">
	        <div class="isay">
	            <div class="isayt3"></div>
	            <div class="isaym3 mtag">
	                <div class="isayh"><h3>通知</h3><a class="w-close2 mtag" href="http://www.lofter.com/#" title="关闭">关闭</a></div>
	            </div>
	            <div class="isayb"></div>
	        </div>
	    </div>
		</div></div>
		<div class="w-load2" id="loadfirst" style="display: none;"><div class="load">加载中</div></div>

	<div class="m-mlist">
	    <div class="mlistimg js-447673">
	        <div class="w-img" style="z-index:1;">
	            <a href="http://alohamei.lofter.com/" target="_blank">
	                <img class="js-447673" src="../home_ui/saved_resource(3)">
	            </a>
	        </div>
	    </div>
	    <div class="mlistcnt">
	        <div class="isay">
	            <div class="isayt">
	                <a class="isayc js-447673" href="http://alohamei.lofter.com/post/7701e_11eff9a"
	                title="查看全文 - 04/24 22:41" target="_blank">
	                    打开新页
	                </a>
	            </div>
	            <div class="isaym">
	                <div class="w-who">
	                    <a href="http://alohamei.lofter.com/" class="js-447673" target="_blank">
	                        你好，曖昧
	                    </a>
	                </div>
	                <div class="js-447673">
	                    <div class="m-icnt">
	                        <div class="cnt">
	                            <div class="img js-732629">
	                                <div class="imgc" style="height: auto;">
	                                    <a href="http://www.lofter.com/#" hidefocus="true">
	                                        <img width="164" src="../home_ui/1749366980357430301.jpg">
	                                        <span class="total">
	                                            <span class="totalbg">
	                                            </span>
	                                            <span class="totalnum">
	                                                2
	                                            </span>
	                                        </span>
	                                    </a>
	                                </div>
	                                <ol style="display:none;">
	                                    <li>
	                                        <div class="imgc">
	                                            <a href="http://www.lofter.com/#" hidefocus="true">
	                                                <img width="500" large="http://imglf0.ph.126.net/sQUbPm9uTIK-Te1EgqMEbg==/4937634041558614467.jpg"
	                                                imgsrc="http://imglf1.ph.126.net/Crqh9_L6FjRRH4tY-xpZXw==/1749366980357430301.jpg">
	                                            </a>
	                                        </div>
	                                        <div class="more more-2">
	                                            <a class="w-zoom" onclick="loft.x.stopEvent(event);loft.m.g.mp416692.photoshow(0);return false;">
	                                                查看大图
	                                            </a>
	                                        </div>
	                                        <p>
	                                        </p>
	                                    </li>
	                                    <li>
	                                        <div class="imgc">
	                                            <a href="http://www.lofter.com/#" hidefocus="true">
	                                                <img width="500" large="http://imglf1.ph.126.net/eSaVinOv_QtBt7Na4NVdhA==/6608208918957570361.jpg"
	                                                imgsrc="http://imglf0.ph.126.net/1vmpYklX1ubEHFUmGQQwBA==/6608210018469198135.jpg">
	                                            </a>
	                                        </div>
	                                        <div class="more more-2">
	                                            <a class="w-zoom" onclick="loft.x.stopEvent(event);loft.m.g.mp416692.photoshow(1);return false;">
	                                                查看大图
	                                            </a>
	                                        </div>
	                                        <p>
	                                        </p>
	                                    </li>
	                                </ol>
	                            </div>
	                            <div class="txt js-732629">
	                                <p>
	                                    重新弄了一下明信片。
	                                </p>
	                                <p>
	                                    第一张，也最喜欢的一张吧。
	                                </p>
	                            </div>
	                            <div class="txt js-732629" style="display:none;">
	                                <p>
	                                    重新弄了一下明信片。
	                                </p>
	                                <p>
	                                    第一张，也最喜欢的一张吧。
	                                </p>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="w-opt">
	                    <div class="opta js-447673" style="width: 247px;">
	                        <span class="opti">
	                            <a href="http://www.lofter.com/tag/%E6%98%8E%E4%BF%A1%E7%89%87">
	                                <span>
	                                    明信片
	                                </span>
	                            </a>
	                        </span>
	                        <span class="opti">
	                            <a href="http://www.lofter.com/tag/%E6%9A%A7%E6%98%A7">
	                                <span>
	                                    暧昧
	                                </span>
	                            </a>
	                        </span>
	                    </div>
	                    <div class="optb">
	                        <span class="opti">
	                            <a href="http://www.lofter.com/#" class="js-447673" hidefocus="true">
	                                评论(2)
	                            </a>
	                            <span class="opticrt">
	                            </span>
	                        </span>
	                        <span class="opti opti-reblog">
	                            <a href="http://www.lofter.com/reblog/7701e_11eff9a" class="js-447673"
	                            target="_blank">
	                                转载
	                            </a>
	                        </span>
	                        <span class="opti opti-shareTo">
	                            <a href="http://www.lofter.com/#" class="js-447673" hidefocus="true">
	                                分享
	                            </a>
	                            <span class="opticrt">
	                            </span>
	                        </span>
	                        <span class="opti">
	                            <a class="js-447673" hidefocus="true" href="http://www.lofter.com/#">
	                                推荐
	                            </a>
	                        </span>
	                        <span class="opti">
	                            <a class="w-icn w-icn-0b js-447673" hidefocus="true" href="http://www.lofter.com/#"
	                            title="喜欢">
	                                喜欢
	                                <span>
	                                </span>
	                                <span>
	                                </span>
	                            </a>
	                        </span>
	                    </div>
	                </div>
	            </div>
	            <div class="a-isaym2">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-81px;">
	                </div>
	            </div>
	            <div class="a-isaym2">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-81px;">
	                </div>
	            </div>
	            <div class="a-isaym2 a-isaym2-shareTo">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-125px;">
	                </div>
	            </div>
	            <div class="isayb">
	            </div>
	        </div>
	    </div>
	</div>

	<div class="m-mlist">
	    <div class="mlistimg js-447673">
	        <div class="w-img" style="z-index:1;">
	            <a href="http://alohamei.lofter.com/" target="_blank">
	                <img class="js-447673" src="../home_ui/saved_resource(3)">
	            </a>
	        </div>
	        <div class="w-img" style="height:0px;padding:0;z-index:10;">
	            <div class="a-w-sel a-w-sel-7">
	            </div>
	        </div>
	    </div>
	    <div class="mlistcnt">
	        <div class="isay">
	            <div class="isayt">
	                <a class="isayc js-447673" href="http://alohamei.lofter.com/post/7701e_1171f27"
	                title="查看全文 - 04/18 02:26" target="_blank">
	                    打开新页
	                </a>
	            </div>
	            <div class="isaym">
	                <div class="w-who">
	                    <a href="http://alohamei.lofter.com/" class="js-447673" target="_blank">
	                        你好，曖昧
	                    </a>
	                </div>
	                <div class="js-447673">
	                    <div class="m-icnt">
	                        <h2 class="tit js-322113">
	                            对正能量小姐的吐槽与反思
	                        </h2>
	                        <div class="cnt">
	                            <div class="txt js-322113">
	                                <p>
	                                    <br>
	                                    我很困，但还是想把我的一个朋友正能量小姐给描写下来。
	                                    <br>
	                                    <br>
	                                    有些人，永远不知道自己传播的自以为是正能量的东西，其实是负能量，因为太过正了。你们是否懂这种感觉。当正能量小姐自己的一切，可以影响几个人，甚至借此成为别人的谈资的时候，她自己是否知晓？如果她知道自己能让身边的朋友对她所喜欢的大部分事物，作出反向的选择，这是该值得嘉奖的话，不知道该颁多少个奖项给她。
	                                    <br>
	                                    <br>
	                                    比如，正能量小姐喜欢的明星，经常哼唱的歌，会让朋友在任何渠道上，都不想接触到那人和歌，哪怕只是在朋友圈上另外一个朋友发的对那明星爱慕之情，第一反应就是“怎么他也喜欢那个明星啊”。你会厌恶她喜欢的大部分。哪怕她发的任何一个朋友圈，被认为是大补的砒霜靓汤...
	                                </p>
	                            </div>
	                            <div class="txt js-322113" style="display:none;">
	                                <p>
	                                    <br>
	                                    我很困，但还是想把我的一个朋友正能量小姐给描写下来。
	                                    <br>
	                                    <br>
	                                    有些人，永远不知道自己传播的自以为是正能量的东西，其实是负能量，因为太过正了。你们是否懂这种感觉。当正能量小姐自己的一切，可以影响几个人，甚至借此成为别人的谈资的时候，她自己是否知晓？如果她知道自己能让身边的朋友对她所喜欢的大部分事物，作出反向的选择，这是该值得嘉奖的话，不知道该颁多少个奖项给她。
	                                    <br>
	                                    <br>
	                                    比如，正能量小姐喜欢的明星，经常哼唱的歌，会让朋友在任何渠道上，都不想接触到那人和歌，哪怕只是在朋友圈上另外一个朋友发的对那明星爱慕之情，第一反应就是“怎么他也喜欢那个明星啊”。你会厌恶她喜欢的大部分。哪怕她发的任何一个朋友圈，被认为是大补的砒霜靓汤。面对正能量小姐发出的能量波，我只能大喊:“不是臣妾做不到，是臣妾忍受不了”。可如果你说，屏蔽就好了啦。但是正所谓“no
	                                    zuo no die”,人不作死就不会死。笔者有自虐倾向。
	                                    <br>
	                                    <br>
	                                    寒假回来，我发现正能量小姐的穿衣风格改变了，还挺不错的挺适合挺正常的风格，可那也仅仅局限于夏天来临前的那一两套。夏天到了，对于笔者来说，万恶的裙子出动，而对于正小姐则是长裙短裙飘飘的季节到了。
	                                    <br>
	                                    鉴于中国人民对“一白遮三丑”的想法根深蒂固，大部分美女不是白就是瘦，不然身材高挑皮肤白皙面容姣好长发飘飘，说白了就是女神范的白富美。说个题外话，今儿跟另外两个朋友讨论了这个问题，白为什么很重要？
	                                    <br>
	                                    一个说，在她的概念里，把一个人白不白和家庭出身环境联系在一起，如果那个人比较白，在感觉上呢，那个人的生活是过得比较滋润的。
	                                    <br>
	                                    另一个说，美女必须得白，不然就只能落得还好这个评价。
	                                    <br>
	                                    这个题外话，扯得有点远。不过，和正小姐还是有关系，主因是她不白，而且也不符合我对黑美人的标准。可是呢，正小姐喜欢的裙子的颜色不是小清新还是小清新，满柜子的粉红白色青绿色。笔者朋友曾问，为啥她总喜欢穿那种不合适她的裙子。笔者也只是小小腹黑一下:额，因为显黑。
	                                    <br>
	                                    <br>
	                                    我也常在反思究竟什么原因致使自己如此为正能量小姐捉急，可能正因为我修养还不到境界；并且思考为啥我会有如此强烈的反应。
	                                    <br>
	                                    <br>
	                                    正能量小姐常沉浸在个人的世界，不知是朋友的其乐融融，显得她有点落寞，亦或是她只是不知如何参与进来而已。是否这样的状况久了，别人的小团体把她隔离在外，还是她自己让自己游离在别人之外，一直在思考，却不得答案。因为我不是她。
	                                    <br>
	                                    <br>
	                                    生活并不可怕，可怕的是要一起生活。生活会把其中的人的缺点，无限放大。身处其中的你我他只能远离或者接受，大抵都是后者。我对正小姐的第一印象不差，所以至今感觉仍不会差到哪里去，只是感觉她有点与我很不同。大部分正常时间，我都不抗拒和她待在一块，只要她不打键盘，不吃东西发出声音。我都很乐意很喜欢她。喜欢她的原因，正能量小姐很好人，极度亲民。
	                                    <br>
	                                    <br>
	                                    某朋友总嫌弃我纠结于细节。只是我认同，爱情是死于你不能容忍的细枝末节上，何况是日夜相处的朋友呢。
	                                    <br>
	                                    <br>
	                                    正能量小姐有点偏执，只要她认为是对的，她自己喜欢的，可以不在意他人看法。不过也是，一句“我喜欢就好”，就能让你刚到嘴边的吐槽，默默地咽下去。
	                                    <br>
	                                    <br>
	                                    正能量小姐异常勇敢，瞒住全部人，穿越千山万水到达陌生的人潮拥挤的京都，只为与交谈几年却素未谋面的网友见面。哪怕我们知道，却都阻止不了她，幸亏她平安回来。
	                                    <br>
	                                    <br>
	                                    越了解一个人，越不认识一个人，是悖论感觉又是真理，正如自己不会全面认识己身一般。
	                                    <br>
	                                    <br>
	                                    对于正能量小姐，我又喜欢又嫌弃，仿佛那是另一个很不同的自己。
	                                    <br>
	                                    <br>
	                                    这只是关于一个朋友的故事，其故事的真假性，有待考究。晚安。
	                                    <br>
	                                    于二零一四年四月十八日凌晨两点二十五分大山中记录。
	                                    <br>
	                                </p>
	                            </div>
	                        </div>
	                        <div class="more" style="">
	                            <a class="w-more js-322113 w-more-open" href="http://www.lofter.com/#">
	                                展开
	                            </a>
	                        </div>
	                    </div>
	                </div>
	                <div class="w-opt">
	                    <div class="opta js-447673" style="width: 190px;">
	                        <span class="opti">
	                            <a title="日志在该标签下列为精选" class="w-jing" href="http://www.lofter.com/tag/%E9%9A%8F%E7%AC%94?first=7701e_1171f27">
	                                <span>
	                                    随笔
	                                </span>
	                            </a>
	                        </span>
	                        <span class="opti">
	                            <a href="http://www.lofter.com/tag/%E6%9C%8B%E5%8F%8B">
	                                <span>
	                                    朋友
	                                </span>
	                            </a>
	                        </span>
	                    </div>
	                    <div class="optb">
	                    	<span class="opti">
	                            <a href="http://www.lofter.com/#" class="js-447673" hidefocus="true">
	                                热度(7)
	                            </a>
	                            <span class="opticrt">
	                            </span>
	                        </span>
	                        <span class="opti">
	                            <a href="http://www.lofter.com/#" class="js-447673" hidefocus="true">
	                                评论(5)
	                            </a>
	                            <span class="opticrt">
	                            </span>
	                        </span>
	                        <span class="opti opti-reblog">
	                            <a href="http://www.lofter.com/reblog/7701e_1171f27" class="js-447673"
	                            target="_blank">
	                                转载
	                            </a>
	                        </span>
	                        <span class="opti opti-shareTo">
	                            <a href="http://www.lofter.com/#" class="js-447673" hidefocus="true">
	                                分享
	                            </a>
	                            <span class="opticrt">
	                            </span>
	                        </span>
	                        <span class="opti">
	                            <a class="js-447673" hidefocus="true" href="http://www.lofter.com/#">
	                                推荐
	                            </a>
	                        </span>
	                        <span class="opti">
	                            <a class="w-icn w-icn-0b js-447673" hidefocus="true" href="http://www.lofter.com/#"
	                            title="喜欢">
	                                喜欢
	                                <span>
	                                </span>
	                                <span>
	                                </span>
	                            </a>
	                        </span>
	                    </div>
	                </div>
	            </div>
	            <div class="a-isaym2">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-81px;">
	                </div>
	            </div>
	            <div class="a-isaym2">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-81px;">
	                </div>
	            </div>
	            <div class="a-isaym2 a-isaym2-shareTo">
	                <div class="isaym2 isaym2-open js-447673" style="margin-top:-125px;">
	                </div>
	            </div>
	            <div class="isayb">
	            </div>
	        </div>
	    </div>
	</div>
	</div>

	<div class="modal fade" id="public_text" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		        <fieldset>
		        	<div id='photo0'>
		        		<label for='photo'>Photo</label>
		        		<input type='file' name='image'>
		        		<br>
		        		<img name="origin" width='558'>
		        		<div class="col-lg-6">
						    <div class="input-group" style="float: left;">
						      <span class="input-group-addon" style="width: 40px">
						        <input name="filterType" type="radio" value="gray">Gray
						      </span>
						    </div><!-- /input-group -->
						    <div class="input-group" style="float: left;">
						      <span class="input-group-addon" style="width: 40px">
						        <input name="filterType" type="radio" value="chrome">chrome
						      </span>
						    </div><!-- /input-group -->
					  	</div><!-- /.col-lg-6 -->
		        	</div>
		        </fieldset>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" id="publish_bn">Publish</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
  	  </div>
	</div>
	
	<div class="modal fade" id="message">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        <p>AAAA</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div class="m-loadm" id="loadmore" style="display: none;">
	    <div class="loadm">
	        载入更多内容
	    </div>
	</div>
	<a title="回到顶部" class="w-top" href="http://www.lofter.com/#" id="gtotop"
	hidefocus="true" style="visibility: hidden; opacity: 0;">
	    回到顶部
	</a>
	<div id="atinput" class="m-at" style="visibility:hidden;left:-150px;top:0;">
	    <div class="inputNode">
	        <label class="xtag">
	            想用@提到谁？
	        </label>
	        <input id="atinputb" class="input xtag">
	    </div>
	    <div class="scrollNode xtag">
	        <div class="result xtag">
	        </div>
	        <div class="vSlideWayNode xtag">
	            <div hidefocus="true" class="vSlideBtn xtag">
	                &nbsp;
	            </div>
	        </div>
	        <div class="hSlideWayNode xtag">
	            <div hidefocus="true" class="hSlideBtn xtag">
	                &nbsp;
	            </div>
	        </div>
	    </div>
	    <div id="atshadow" class="shadow">
	    </div>
	</div>
	<div id="preOpenCoverForPublish" class="preOpenCoverForPublish" style="display:none;opacity:1;">
	</div>



    <script type="text/javascript">
    	function createphotoDIV(html,id){
    		var newid = 'image'+(Number(id.substr(id.length-1))+1);
    		var newhtml = html
    			.replace(id,newid);
    		$('#'+id).before(newhtml);
    		$('#'+newid).children(':file').bind('change',function(e){
    			imagechange(e.target);
    		});
    	};
    	
    	function removephotoDIV(){
    		$(this).parent().remove();
    	};
		
		function getObjectURL(file){
			var url = null;
			if(window.createObjectURL != undefined){//basic
				url = window.createObjectURL(file);
			}else if(window.URL != undefined){ // firefox
				url = window.URL.createObjectURL(file);
			}else if(window.webkitURL != undefined){ //chrome or webkit
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		};
		
		function imagechange(target){
			var img = $(target).siblings("[name='origin']");
			var flag = false;
			if(!img.attr('src')){
				flag = true;
			}
			var objurl = getObjectURL(target.files[0]);
			console.log('objURL = '+objurl);
			if(objurl && flag){
				var id = $(target).parent().attr('id');
				var html = $(target).parent().prop('outerHTML');
				createphotoDIV(html,id);
				img.attr('src',objurl);
			}else if(objurl){
				img.attr('src',objurl);
			}
		};
		
		function requestMessage(message){
			$('#message').find('p').html(message);
			$('#message').modal();
			setTimeout(function(){$('#message').find('.close').trigger('click');}, 900);
		};
		
    	$(function(){
    		$('#publish_text_bn').click(function(){
    			$('#public_text').modal({keyboard : false});
    		});
    		
    		$(":file[name='image']").change(function(e){
    			imagechange(e.target);
    		});
    		
    		$('#publish_bn').click(function(){
/*     			var radio = $("[name='filterType']").val();
    			alert(radio); */
       			$.ajaxFileUpload(
    					{
    						url : '${pageContext.request.contextPath }/publish/publishPost.action',
    						fileElementId : ['image','filterType'],
    						dataType : 'json',
    						success : function(data, status){
    							requestMessage('success');
    						}
    					});
      				requestMessage('success');
    		}); 
    	});
    </script>
  	<script src="../home_ui/js/core.js" type="text/javascript"></script>
	<script src="../home_ui/js/pt_page_newpublish_dashboardnew.js" type="text/javascript"></script>

	<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe>
	<div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div>
</body>
</html>