define(['jquery'], function ($) {
    //序列化表单为json字符串
    $.fn.serializeForm = function(){
        var params = this.serializeArray();
		 var values = {};
		 for( x in params ){
		 	values[params[x].name] = params[x].value;
		 }
		//  var idata = JSON.stringify(values);
        return values;
    }
})
