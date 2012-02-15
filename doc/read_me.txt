
10A 代码移植步骤：

1. 添加编译宏
	option.mak 中添加如下
	FEE_CODE = LIB
	ifeq ($(strip $(FEE_CODE)),LIB)
		COM_DEFS += __CODE_MTK__
		COMPOBJS += plutommi\mmi\code\XXX.lib	
	endif

2. 添加短信屏蔽
	在函数mmi_sms_handle_new_msg_ind中函数体头部添加
	#ifdef __CODE_MTK__
	{
	    //extern int code_club_check_lbs_msg(srv_sms_event_struct* event_data);
	    if (code_eif_received_msg_parse_proc(event_data))
	    {
			return MMI_RET_OK;
	    }
	}
	#endif

3. 添加初始化
	在函数ExtraInit中添加
	#ifdef __CODE_MTK__
		code_main_init();
	#endif

4. 添加lib
	copy code文件夹至plutommi\mmi
	
	
	
	fuqiang5@163.com/18676675058
	