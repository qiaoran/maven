with (document)
	0[(getElementsByTagName('head')[0] || body)
			.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='
			+ ~(-new Date() / 36e5)];

$(function() {

	$(".share").mouseenter(function() {
		$(this).find(".boxsharebox").stop().fadeIn(100);
	}).mouseleave(function() {
		$(this).find(".boxsharebox").stop().fadeOut(200);
	});

	// 分享展示图片 分享链接
	var thisImage, thisUrl = window.location.href, thisTitle, thisText;

	window._bd_share_config = {
		common : {
			bdText : thisTitle,
			bdDesc : thisText,
			bdUrl : thisUrl,
			bdPic : thisImage
		},
		share : [ {
			"bdSize" : 24
		// 图标大小
		} ]
	}

	share();
})

share = function() {
	var html = '<div class="boxsharebox">' + '<div class="boxshare">'
			+ '<div class="boxinstructions"></div>'
			+ '<div class="bdsharebuttonbox" data-tag="share"></a> '
			+ '<a class="bds_tsina" data-cmd="tsina"> <span>微博</span></a> '
			+ '<a class="bds_qzone" data-cmd="qzone"> <span>QQ空间</span></a> '
			+ '<a class="bds_tqq" data-cmd="tqq"> <span>腾讯微博</span></a> '
			+ '<a class="bds_renren" data-cmd="renren"> <span>人人网</span></a> '
			+ '<a class="bds_weixin" data-cmd="weixin"> <span>微信</span></a> '
			+ '<a class="bds_sqq" data-cmd="sqq"> <span>QQ好友</span></a> '
			+ '</div>' + '</div>' + '</div>';

	$(".share").append(html);
	$(".bdsharebuttonbox  a").css({
		position : 'relative',
		marginBottom : '40px',
		marginLeft : '20px',
		marginRight : '20px'
	})
	$(".bdsharebuttonbox  a span").css({
		position : 'absolute',
		display : 'block',
		paddingLeft : '0px',
		marginLeft : '0px',
		border : '0px',
		textAlign : 'center',
		width : '60px',
		fontSize : '12px',
		color : '#333',
		top : '28px',
		left : '-18px',
	})
}
