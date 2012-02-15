registerNamespace("bl_report_param");

bl_report_param.year = [2011, 2012, 2013, 2014, 2015];
bl_report_param.month = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];

bl_report_param.formEle = $('<form style="width:98%;height:40px;margin:10px 0px 0px 0px;padding:0px;"></form>');
bl_report_param.customerEle = $('<div style="float:left;margin-left:10px;"><label>客户:</label><select name="customerId" style="width:120px;"></select>');
bl_report_param.projectEle = $('<div style="float:left;margin-left:10px;"><label>项目:</label><select name="projectId" style="width:120px;"><option value="">请选择</option></select></div>');
bl_report_param.yearEle = $('<div style="float:left;margin-left:10px;"><label>年份:</label><select name="year" style="width:80px;"></select></div>');
bl_report_param.monthEle = $('<div style="float:left;margin-left:10px;"><label>月份:</label><select name="month" style="width:80px;"></select></div>');
bl_report_param.btnQueryEle = $('<div style="float:left;margin-left:10px;"><button name="query" type="button">查询</button></div>');
bl_report_param.toggleQueryEle = $('<div style="float:left;margin-left:10px;"><button name="toggle" type="button">数据或图表切换</button></div>');

bl_report_param.initYear = function() {
	var curYear = new Date().getFullYear();
	var option = $('<option></option>');
	for(var i = 0 ; i < bl_report_param.year.length ; i++){
		var op = option.clone();
		op.val(bl_report_param.year[i]);
		op.text(bl_report_param.year[i]);
		
		if(curYear == bl_report_param.year[i]) {
			op.attr('selected', true);
		}
		bl_report_param.yearEle.find('select').append(op);
	}
}();

bl_report_param.initMonth = function() {
	var curMonth = new Date().getMonth() + 1;
	var option = $('<option></option>');
	for(var i = 0 ; i < bl_report_param.month.length ; i++){
		var op = option.clone();
		op.val(bl_report_param.month[i]);
		op.text(bl_report_param.month[i]);
		
		if(curMonth == bl_report_param.month[i]) {
			op.attr('selected', true);
		}
		bl_report_param.monthEle.find('select').append(op);
	}
}();

var ReportParam = function(){
	
	function ReportParam(setting){
		this.container = $("#" + setting.container);
		this.container.empty();
		
		this.year = setting.year || '1';
		this.month = setting.month || '1';
		this.chartId = setting.chartId;
		this.chartUrl = setting.chartUrl;
		this.gridId = setting.gridId;
		this.grid = $("#" + setting.gridId);
		this.renderCount = 0;
		
		this.displayToggle = function(){
			this.renderCount++;
			$("#gbox_" + this.gridId).toggle();
			$("#" + this.chartId).toggle();	
		};
		
		this.serializeParam = function(){
			var projectId = this.form.find("select[name='projectId']").val();
			var year = this.form.find("select[name='year']").val();
			var month = this.form.find("select[name='month']").val();
			
			var param = "1=1";
			if(projectId) param += "&projectId=" + projectId;
			if(year) param += "&year=" + year;
			if(month) param += "&month=" + month;
			
			return param;
		};
		
		this.query = function(){
			if(this.renderCount % 2 == 0) {
				this.renderGrid();
			} else {
				this.renderChart();
			}
		};
		
		this.renderChart = function() {
			var chart = new FusionCharts(APP_PATH + "/static/chart/FCF_Column3D.swf", this.chartContainer, "1050", "450", "0", "0");
			var url = escape(this.chartUrl + this.serializeParam());
			chart.setDataURL(url);
			chart.render(this.chartId);
		};
		
		this.renderGrid = function(){
			this.url = this.url || this.grid.getGridParam('url');
			var url = this.url + this.serializeParam();
			this.grid.setGridParam({url : url});
			this.grid.trigger("reloadGrid");
		};
		
		this.init = function (){
			this.form = bl_report_param.formEle.clone(true);
			
			var custEle = bl_report_param.customerEle.clone(true);
			var projEle = bl_report_param.projectEle.clone(true);
			
			this.form.append(custEle);
			this.form.append(projEle);
			if(this.year == '1') this.form.append(bl_report_param.yearEle.clone(true));
			if(this.month == '1') this.form.append(bl_report_param.monthEle.clone(true));
			this.form.append(bl_report_param.btnQueryEle.clone(true));
			this.form.append(bl_report_param.toggleQueryEle.clone(true));
			
			bl_common.allCustomer(function(data){
				custEle.find('select').html(data.html());
			});
			
			custEle.find('select').change(function(){
				var customerId = custEle.find('select').val();
				if(customerId != '') {
					bl_common.projectOfCust(customerId, function(data){
						projEle.find('select').html(data.html());
					});
				}
			});
			
			this.container.append(this.form);
			var context = this;
			this.form.find("button[name='query']").click(function(){
				context.query();
			});
			this.form.find("button[name='toggle']").click(function(){
				context.displayToggle();
				context.query();
			});
			
			this.renderChart();
		};
		this.init();
	};

	return ReportParam;
}();
