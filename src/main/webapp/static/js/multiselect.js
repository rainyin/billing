/**
 * 
 * gridId: 页面中 grid id
 * width: 弹出窗口的宽度
 * height: 弹出窗口的高度
 * container: 弹出窗口所在的父结点 id
 * paramHiddenName: 弹出窗口隐藏域的 属性 name
 * paramSelectName: 弹出窗口下拉框的 属性 name
 * attrSelectSize: 弹出窗口下拉框的 属性 size
 * remindTitle: 警告窗口的 title
 * popupTitle: 弹出窗口的 title
 * getItemUrl: 多选框中数据请求 url
 * submitUrl: 弹出窗口中提交的 url
 */

var MultiselectDialog = function(){
	
	function MultiselectDialog(setting){
		this.container = $("#" + setting.container);
		this.container.empty();
		
		this.remindDialog = $("<div title='注意' style='display:none'><p></p></div>");
		this.popup_dialog = $("<div title='' style='display:none'>" +
								"<form>" +
									"<input type='hidden' name=''/>" +
									"<select name='' multiple='multiple' size='11'></select>" + 
								"</form>" +
							"</div>");
		this.container.append(this.remindDialog).append(this.popup_dialog);
		
		this.grid = $("#" + setting.gridId);
		this.width = setting.width || 400;
		this.height = setting.height || 600;
		
		this.paramHiddenName = setting.paramHiddenName;
		
		this.remindDialog.find("p:first").html(setting.remindTitle);
		this.popup_dialog.attr('title', setting.popupTitle);

		this.getItemUrl = setting.getItemUrl;
		this.submitUrl = setting.submitUrl;
		
		this.form = this.popup_dialog.find("form:first");
		
		this.hiddenEle = this.form.find("input:first[type='hidden']");
		this.hiddenEle.attr('name', this.paramHiddenName);
		
		this.selectEle = this.form.find("select:first");
		this.selectEle.attr('name', setting.paramSelectName);
		this.selectEle.attr('size', setting.attrSelectSize);
		
		this.initMultiselectPopup = function (){
			var context = this;
			this.popup_dialog.dialog({
				autoOpen: false,
				height: this.height,
				width: this.width,
				modal: true,
				buttons: {
					"确定": function() {
						$.ajax({url: context.submitUrl, data: context.form.serialize(), success: function(data){
								context.grid.trigger("reloadGrid");
								context.popup_dialog.dialog("close");
							}
						});
					},
					"取消": function() {
						context.popup_dialog.dialog("close");
					}
				}
			});
		};
		
		this.onClickFunc = function (){
			var itemId = this.grid.getGridParam('selrow');
			var context = this;
			if(itemId){ 
				this.hiddenEle.val(itemId);
				var param = this.paramHiddenName + "=" + itemId;
				$.ajax({url: this.getItemUrl, data: param, success: function(data){
						context.selectEle.html($(data).html());
						context.popup_dialog.dialog("open");
						context.selectEle.multiselect2side("destroy");
						context.initItemMultiselect();
					},
					dataType: "html"});
			} else { 
				$("#dialog:ui-dialog").dialog("destroy");
				this.remindDialog.dialog({ modal: true });
			} 
		};
		
		this.initItemMultiselect = function (){
			this.selectEle.multiselect2side({
				search: "查询",
				labelTop: "顶部",
				labelBottom: "底部",
				labelUp: "向上",
				labelDown: "向下",
				labelSort: "排序",
				labelsx: "可关联",
				labeldx: "已关联"
			});
		};
		
		this.initMultiselectPopup();
	}
	
	return MultiselectDialog;
	
}();
