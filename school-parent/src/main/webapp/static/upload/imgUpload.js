function initYzUpload(callback){
    $.getScript("/static/upload/plupload.full.min.js",callback);
}
function getUploader(browse_button,multiselet){
   var  uploader = new plupload.Uploader({ //实例化一个plupload上传对象
        browse_button: browse_button,
        url: '/upload',
        flash_swf_url: '/static/js/upload/Moxie.swf',
        silverlight_xap_url: '/static/js/upload/Moxie.xap',
        file_data_name: 'file',
        //drop_element: 'drag-area',
        //multipart_params: {name: '1212121'},//携带参数
        multi_selection: multiselet,//多选
        filters: {
            mime_types: [ //只允许上传图片文件
                {title: "图片文件", extensions: "jpg,gif,png"}
            ]
        }
    });
    uploader.init(); //初始化
    return uploader;
}

function getUploaderRegion(browse_button,multiselet){
	   var  uploader = new plupload.Uploader({ //实例化一个plupload上传对象
	        browse_button: browse_button,
	        url: '/common/upload',
	        flash_swf_url: '/static/js/upload/Moxie.swf',
	        silverlight_xap_url: '/static/js/upload/Moxie.xap',
	        file_data_name: 'file',
	        //drop_element: 'drag-area',
	        //multipart_params: {name: '1212121'},//携带参数
	        multi_selection: multiselet,//多选
	        filters: {
	            mime_types: [ //只允许上传图片文件
	                {title: "图片文件", extensions: "jpg,gif,png"}
	            ]
	        }
	    });
	    uploader.init(); //初始化
	    return uploader;
	}


function fileUploaded(uploader,callback){
    uploader.bind('FileUploaded', function (uploader,file,responseObject) {
        var obj=eval("("+responseObject.response+")");
        if(obj.success){
            callback(obj.url);
        }
    });
}

function fileUploadeAdded(uploader,callback){
    uploader.bind('FilesAdded',callback);
}

function deleteImage(url,callback) {
    /*if(url && url.length>0){
        $.ajax({
            url : '/public/deleteImage',
            data: {'url': url},
            success: function(rs) {
                if(eval(rs.success)) {
                    callback();
                }
            }
        });
    }*/
}

