create table bl_customer (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	name varchar(100) comment '名称',
	tel varchar(100) comment '固定电话',
	address varchar(255) comment '地址',
	status varchar(50) comment '状态',
	memo varchar(255) comment '备注'
);

create table bl_project (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	name varchar(100) comment '项目名称',
	customer_name varchar(100) comment '客户名称',
	customer_id bigint(20) comment '客户ID',
	status varchar(100) comment '状态',
	cellphone_schema varchar(100) comment '手机方案',
	cellphone_resolution varchar(100) comment '手机分辨率',
	keyboard bit(1) default 1 comment '是否键盘',
	touch bit(1) default 1 comment '是否触摸',
	shield_sms bit(1) default 1 comment '是否屏蔽短信',
	monthly_fee int comment '月扣费金额',
	deduct_fee bit(1) comment '服务状态：是否扣费',
	shield_cycle int comment '屏蔽周期:分钟',
	synchronize_cycle int comment '同步周期:精确到分钟',
	valid_start int comment '有效相应时间起点',
	valid_end int comment '有效相应时间终点',
	switch_server varchar(255) comment '切换服务器',
	extension varchar(100) comment '扩展字段',
	memo varchar(255) comment '备注'
)auto_increment=5000;

create table bl_channel_provider (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	name varchar(100) comment '通道商名称',
	tel varchar(100) comment '联系电话',
	address varchar(100) comment '地址',
	service_code varchar(100) comment '服务代码',
	cut_percent int comment '分成比率',
	switch_server varchar(255) comment '切换服务器URL',
	memo varchar(255) comment '备注'
);

create table bl_sms_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	channel_provider_name varchar(100) comment '通道商名称',
	channel_provider_id bigint(20) comment '通道商ID',
	instruction varchar(100) comment '指令',
	port varchar(100) comment '端口 ',
	business_name varchar(100) comment '业务名称 ',
	fee_standard int comment '资费',
	carrier varchar(100) comment '运营商 ',
	match_type varchar(100) comment '匹配类型 ',
	order_type varchar(100) comment '点播/包月 ',
	shield_cycle int comment '屏蔽周期',
	shield_key varchar(255) comment '下发短信屏蔽关键字',
	memo varchar(255) comment '备注'
);

create table bl_ivr_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	channel_provider_name varchar(100) comment '通道商名称',
	channel_provider_id bigint(20) comment '通道商ID',
	name varchar(100) comment '名称',
	carrier varchar(100) comment '运营商 ',
	dial_number varchar(100) comment '拔打号码 ',
	call_duration int comment '通话时长/秒 ',
	price int comment '价格/分钟',
	key_order varchar(255) comment '按键顺序 ',
	sms_key varchar(100) comment '短信关键字 ',
	delay int comment '延时(分钟) ',
	memo varchar(255) comment '备注'
);

create table bl_gp_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	channel_provider_name varchar(100) comment '通道商名称',
	channel_provider_id bigint(20) comment '通道商ID',
	name varchar(100) comment '名称',
	url varchar(255) comment 'URL ',
	price int comment '价格/分钟',
	cust_steps varchar(255) comment '定制步骤',
	cancel_day int comment '退订执行日期/日 ',
	cancel_instruction varchar(255) comment '退订指令 ',
	instruction_to varchar(50) comment '指令发送号码 ',
	cust_shield_key varchar(255) comment '定制短信屏蔽关键字 ',
	cancel_shield_key varchar(255) comment '退订短信屏蔽关键字 ',
	shield_cycle int comment '屏蔽周期 ',
	phone_model varchar(100) comment '手机型号',
	x_wap_profile varchar(100) comment 'wap 概要文件',
	memo varchar(255) comment '备注'
);

create table bl_gp_channel_project (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	gp_channel_id bigint(20) comment 'G+通道ID',
	project_id bigint(20) comment '项目ID'
);

create table bl_ivr_channel_project (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	ivr_channel_id bigint(20) comment 'ivr通道ID',
	project_id bigint(20) comment '项目ID'
);

create table bl_sms_channel_project (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	sms_channel_id bigint(20) comment '通道ID',
	project_id bigint(20) comment '项目ID',
	send_times int comment '发送次数'
);

create table bl_area (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	name varchar(100) comment '地区名称：省名/城市名/县名 ',
	cm_code char(5) comment '移动区号',
	cu_code char(5) comment '联通区号',
	level varchar(100) comment '级别：省/城市/县 ',
	parent_id bigint(20) comment '上级地区id ',
	area_link varchar(100) comment '父级到子级ID '
)auto_increment=10000;

create table bl_area_sms_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	sms_channel_id bigint(20) comment '通道id',
	area_id bigint(20) comment '地区id'
);

create table bl_area_ivr_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	ivr_channel_id bigint(20) comment '通道id',
	area_id bigint(20) comment '地区id'
);

create table bl_area_gp_channel (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	gp_channel_id bigint(20) comment 'G+通道id',
	area_id bigint(20) comment '地区id'
);

create table bl_question (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	content varchar(255) comment '短信内容 ',
	answer varchar(255) comment '答案 '
);

create table bl_channel_request (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	uid char(18) comment '流水号 ',
	imsi varchar(50) comment '手机卡唯一识别号码 ',
	sc char(5) comment '区号 ',
	plmn char(7) comment '运营商编号',
	project_id bigint(20) comment '项目id ',
	project_name varchar(100) comment '项目名称 ',
	ver varchar(100) comment '客户端版本号 '
);

create table bl_user (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	
	address varchar(100) comment '地址',
    name varchar(20) comment '姓名 ',
    password varchar(80) comment '密码',
    tel varchar(50) comment '电话',
    status varchar(50) comment '状态',
    username varchar(50) comment '登录用户名',
    email varchar(50) comment '邮箱',
    memo varchar(255) comment '备注'
)auto_increment=10;

create table bl_terminal (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	
	uid char(18) comment '流水号',
	imsi varchar(50) comment '手机卡唯一标识',
	number char(13) comment '手机号',
	project_id bigint(20) comment '项目ID',
	project_name  varchar(100) comment '项目名称',
	carrier  char(7) comment '运营商编码',
	area_code  char(5) comment '区号',
	cat_number  char(11) comment '短信猫上手机号',
	version  varchar(100) comment '客户端版本号'
)auto_increment=1;

create table bl_cat_number (
	id bigint(20) auto_increment primary key,
	created_at datetime  comment '创建日期',
	updated_at datetime  comment '更新日期',
	operator_id bigint(20) comment '操作员id',
	
	number char(11) comment '手机号',
	status varchar(50) comment '状态',
	memo varchar(255) comment '备注'
)auto_increment=1;

create table bl_resource (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment '最后更新时间 ',
  operator_id bigint(20) comment '操作员',
  res_name varchar(40)  comment '名称',
  res_type varchar(40)  comment '类型',
  res_value varchar(60)  comment '值'
)auto_increment=10000; 

create table bl_right (
  id bigint(20) auto_increment primary key,
  created_at datetime ,
  updated_at datetime   comment '更新时间',
  operator_id bigint(20) comment '操作员',
  memo varchar(255)  comment '备注',
  name varchar(40)   comment '名称'
)auto_increment=10000; 

create table bl_resource_right (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment '最后更新时间 ',
  operator_id bigint(20) comment '操作员',
  right_id bigint(20) ,
  resource_id bigint(20)
)auto_increment=10000; 

create table bl_role (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment  '更新日期',
  operator_id bigint(20) comment '操作员',
  memo varchar(255)  comment '备注',
  name varchar(40) comment '角色名称'
)auto_increment=10000; 

create table bl_right_role (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment '最后更新时间 ',
  operator_id bigint(20) comment '操作员',
  role_id bigint(20) ,
  right_id bigint(20)
)auto_increment=10000; 

create table bl_user_role (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment '最后更新时间 ', 
  operator_id bigint(20) comment '操作员',
  user_id bigint(20) ,
  role_id bigint(20)
)auto_increment=10000;

create table bl_blacklist (
  id bigint(20)  auto_increment primary key,
  created_at datetime  comment  '创建日期',
  updated_at datetime  comment '最后更新时间 ', 
  operator_id bigint(20) comment '操作员',
  phone_number varchar(20)  comment '手机号',
  memo varchar(255) comment '备注'
);

create table bl_my_sequence(
	id bigint(20) auto_increment primary key,
	sequence bigint(20) not null,
	name char(20) not null,
	updated_at datetime  comment '最后更新时间 '
);

alter table `bl_my_sequence` add unique (`name`);
alter table `bl_cat_number` add unique (`number`);
alter table `bl_terminal` add unique (`uid`);
alter table `bl_terminal` add unique (`imsi`);
alter table `bl_terminal` add index ind_terminal_project_id(`project_id`);
alter table `bl_terminal` add index ind_terminal_area_code(`area_code`);
alter table `bl_area` add index ind_area_area_cm_code(`cm_code`);
alter table `bl_area` add index ind_area_area_cu_code(`cu_code`);
alter table `bl_channel_request` add index ind_channel_request_project_id(`project_id`);
alter table `bl_gp_channel_project` add index ind_gp_channel_project_id(`project_id`);
alter table `bl_gp_channel_project` add index ind_gp_channel_channel_id(`gp_channel_id`);
alter table `bl_ivr_channel_project` add index ind_ivr_channel_project_id(`project_id`);
alter table `bl_ivr_channel_project` add index ind_ivr_channel_channel_id(`ivr_channel_id`);
alter table `bl_sms_channel_project` add index ind_sms_channel_project_id(`project_id`);
alter table `bl_sms_channel_project` add index ind_sms_channel_channel_id(`sms_channel_id`);
alter table `bl_area_sms_channel` add index ind_area_sms_channel_channel_id(`sms_channel_id`);
alter table `bl_area_sms_channel` add index ind_area_sms_channel_area_id(`area_id`);
alter table `bl_area_ivr_channel` add index ind_area_ivr_channel_channel_id(`ivr_channel_id`);
alter table `bl_area_ivr_channel` add index ind_area_ivr_channel_area_id(`area_id`);
alter table `bl_area_gp_channel` add index ind_area_gp_channel_channel_id(`gp_channel_id`);
alter table `bl_area_gp_channel` add index ind_area_gp_channel_area_id(`area_id`);
alter table `bl_right_role` add index ind_right_role_right_id(`right_id`);
alter table `bl_right_role` add index ind_right_role_role_id(`role_id`);
alter table `bl_resource_right` add index ind_resource_right_right_id(`right_id`);
alter table `bl_resource_right` add index ind_resource_right_resource_id(`resource_id`);
alter table `bl_user_role` add index ind_user_role_user_id(`user_id`);
alter table `bl_user_role` add index ind_user_role_role_id(`role_id`);

drop function if exists getnextvalue;
delimiter //
set global log_bin_trust_function_creators = 1;
create function getnextvalue (sname varchar(50), size int) RETURNS int(10)
	begin
	    declare nextVal integer;
	    set nextval = 0;
	    select sequence into nextVal from bl_my_sequence where name = sname; 
	    update bl_my_sequence set sequence = sequence + size, updated_at = now() where name = sname;
	    return nextval;
	end
//
delimiter ;

set global event_scheduler=1;
CREATE EVENT `reset_uid` 
ON SCHEDULE EVERY 1 DAY STARTS '2000-01-01 23:59:59' 
ON COMPLETION PRESERVE ENABLE 
DO update bl_my_sequence set sequence =1, updated_at = now() where name ='UID';
