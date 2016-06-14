(function($){

	//输入框有默认
	$('.placeholder').on('focus',function(){
		if($(this).val() == $(this).attr('data-value')){
			$(this).val("");
		}
		$(this).css({'color':'#000'})
	}).on('blur',function(){
		if($(this).val() == ""){
			$(this).val($(this).attr('data-value')).css({'color':'#c5c5c5'});
		}
	}).trigger('blur');
	//复选框
	$('.spancheck').on('click',function(){
		$(this).toggleClass('spanchecked');
	});


	//下拉
	$('.smiSel').on('click','span',function(){
		$(this).siblings('ul').toggle();
	}).on('mouseleave',function(){
		$(this).children('ul').hide();
	}).on('click','li',function(){
		var text = $(this).text();
	/*	alert($(this).attr ("id"));
		alert(($(this).parents('.smiSel')).attr ("id"));*/
		$(this).parents('.smiSel').find('span').text(text);
		$(this).parents('.smiSel').trigger('mouseleave');
		selectsban($(this).parents('.smiSel').attr("id"),$(this).attr ("id"));
	});
	//操作
	$('.myplat_main').on('click','.mm_delete',function(){
		$('.layerBg').show();
		$('.deleteLayer').show();
		$('.deleteLayer').unbind('click');
		var trIndex = $(this).parents('tr').index('.mm_table tr');
		$('.deleteLayer').on('click','.certainBtn',function(){
			$('.mm_table tr').eq(trIndex).remove();
			$(this).parents('.windowLayer').hide();
			$(this).parents('.windowLayer').siblings('.layerBg').hide();
		});
	}).on('click','.mm_update',function(){
		$('.layerBg').show();
		$('.updateLayer').show();
	}).on('click','.mm_copy',function(){
		$('.layerBg').show();
		$('.copyLayer').show();
	}).on('click','.mm_release',function(){
		$('.layerBg').show();
		$('.releaseLayer').show();
	});
	$('.mm_release_all').on('click',function(){
		$('.layerBg').show();
		$('.releaseLayer').show();
	});
	$('.mm_delete_all').on('click',function(){
		$('.layerBg').show();
		$('.deleteLayer').show();
		$('.deleteLayer').on('click','.certainBtn',function(){
			$('.spanchecked').parents('.mm_table tr').remove();
			$(this).parents('.windowLayer').hide();
			$(this).parents('.windowLayer').siblings('.layerBg').hide();
		});
	});
	//新建
	$('.mm_new').on('click',function(){
		$('.layerBg').show();
		$('.createLayer').show();
	});

	//取消
	$('.cancelBtn').on('click',function(){
		$(this).parents('.windowLayer').hide();
		$(this).parents('.windowLayer').siblings('.layerBg').hide();
	});
	$('.yesBtn').on('click',function(){
		$(this).parents('.windowLayer').hide();
		$(this).parents('.windowLayer').siblings('.layerBg').hide();
	});
	//
	$('.cr_certain').on('click',function(){
		$(this).parents('.createLayer').hide();
		$(this).parents('.createLayer').siblings('.layerBg').hide();
	});
	$('.cr_close').on('click',function(){
		$(this).parents('.createLayer').hide();
		$(this).parents('.createLayer').siblings('.layerBg').hide();
	});
	//0513add 输入框模糊查询
	$('.smiInput').on('keydown','input',function(){
		var thisWidth = $(this).parent().outerWidth(),
			thisHeight = $(this).parent().outerHeight();
		$(this).siblings('ul').css({'width':thisWidth-1,'top':thisHeight-1}).show();
	}).on('click','.lf_inp_ul li',function(){
		var text = $(this).text();
		$(this).parents('.smiInput').find('input').val(text);
		$(this).parent().hide();
		selectsban($(this).parents('.smiInput').attr("id"),$(this).attr ("id"));
	}).on('mouseleave',function(){
		$(this).find('ul').hide();
	});


})(jQuery);