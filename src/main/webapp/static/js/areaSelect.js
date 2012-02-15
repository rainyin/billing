registerNamespace("bl_area_selector");

bl_area_selector.areaIdFormatter = function(cellvalue, options, rowObject){
	var checked = cellvalue == 'true' ? 'checked' : '';
	var cells;
	if(rowObject.textContent) {
		cells = rowObject.textContent.trim().split('\n');
	} else {
		cells = rowObject.text.trim().split(' ');
	}
	var classStyle = "area_ch_" + cells[4].trim();
	return "<input type='checkbox' onclick='bl_area_selector.areaCheckEvent(this)' name='areaId'" + checked +" value='" + options.rowId + "' class='" + classStyle + "' />";
};
bl_area_selector.areaCheckEvent = function(obj){
	var id = $(obj).val();
	var classStyle = "area_ch_" + id;
	
	var children = $("." + classStyle);
	if($(obj).attr('checked')){
		children.attr('checked', true);
	} else {
		children.attr('checked', false);
	}
};

/**
 * 
 * gridId: 页面中 grid id
 * width: 弹出窗口的宽度
 * height: 弹出窗口的高度
 * container: 弹出窗口所在的父结点 id
 * paramHiddenName: 弹出窗口隐藏域的 属性 name
 * remindTitle: 警告窗口的 title
 * queryUrl:  查询区域的 url
 * submitUrl: 弹出窗口中提交的 url
 */
var AreaSelectDialog = function(){
	
	function AreaSelectDialog(setting){
		this.container = $("#" + setting.container);
		this.container.empty();
		
		this.remindDialog = $("<div title='注意' style='display:none'><p></p></div>");
		this.popup_dialog = $("<div title='关联区域' style='display:none'>" +
				"<form>" +
					"<input type='hidden' name=''/>" +
					"<table></table>" + 
				"</form>" +
			"</div>");
		this.container.append(this.remindDialog).append(this.popup_dialog);
		
		this.width = setting.width || 600;
		this.height = setting.height || 500;
		this.paramHiddenName = setting.paramHiddenName;
		this.grid = $("#" + setting.gridId);
		this.remindDialog.find("p:first").html(setting.remindTitle);
		this.queryUrl = setting.queryUrl;
		this.submitUrl = setting.submitUrl;
		this.form = this.popup_dialog.find("form:first");
		this.areaGridId = "areaGrid-" + setting.gridId;
		this.popup_dialog.find("table:first").attr("id", this.areaGridId);
		this.hiddenEle = this.form.find("input:first[type='hidden']");
		this.hiddenEle.attr('name', this.paramHiddenName);
		
		this.initAreaSelectPopup = function (){
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

		this.onClickFunc = function() {
			var itemId = this.grid.getGridParam('selrow');
			var context = this;
			if(itemId){ 
				context.popup_dialog.dialog("open");
				this.hiddenEle.val(itemId);
				var url = this.queryUrl + "?" + this.paramHiddenName + "=" + itemId;
				this.initAreaGrid(url);
			} else { 
				$("#dialog:ui-dialog").dialog("destroy");
				this.remindDialog.dialog({ modal: true });
			} 
		};
		
		this.initAreaGrid = function(urlWithParam) {
			if(this.areaGrid){
				this.areaGrid.setGridParam({url : urlWithParam});
				this.areaGrid.trigger("reloadGrid");
				return;
			}
			this.areaGrid = $("#" + this.areaGridId).jqGrid({
				url : urlWithParam,
				treeGrid : true,
				treeGridModel : 'adjacency',
				ExpandColumn : 'name',
				datatype : "xml",
				mtype : 'GET',
				colNames : [ 'id', '名称', '状态'],
				colModel : [ {name : 'id',index : 'id',key : true,hidden : true,width : 100},
				             {name : 'name',index : 'name',width : 300}, 
				             {name : 'areaId',index : 'areaId',width : 180, formatter:bl_area_selector.areaIdFormatter}
				           ],
				height : 360
			});	
		};
		this.initAreaSelectPopup();
	};
	return AreaSelectDialog;
}();
