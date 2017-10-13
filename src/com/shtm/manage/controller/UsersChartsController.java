package com.shtm.manage.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shtm.controller.BaseController;
import com.shtm.manage.po.echarts.ECharts;
import com.shtm.manage.service.UsersChartsServiceI;

/**
  * Title:
  * <p>
  * Description:用户图标controller;
  * <p>
  * @author Kor_Zhang
  * @date 2017年10月9日 下午5:25:21
  * @version 1.0
  */
@RequestMapping("/userscharts")
@Scope("prototype")
@Controller
public class UsersChartsController extends BaseController<UsersChartsServiceI>{
	/**
	  * Title:
	  * <p>
	  * Description:获取echarts的饼状图的数据;
	  * <p>
	  * @author Kor_Zhang
	  * @date 2017年10月10日 上午8:49:41
	  * @version 1.0
	  * @return
	  * @throws Exception
	  */
	@RequiresAuthentication
	@RequiresPermissions("users:select")
	@RequestMapping("getUsersSexCircleChartData")
	public @ResponseBody ECharts getUsersSexCircleChartData() throws Exception{
		
		
		ECharts echarts = new ECharts();
		try {
			
			echarts = service.getUsersSexCircleChartData();
			
			echarts.setMsg("获取性别分布成功");
			
			echarts.setResult(RESULT.TRUE);
			
		} catch (Exception e) {
			e.printStackTrace();

			echarts.setMsg(e.getMessage());
			
			echarts.setResult(RESULT.FALSE);
		}
		return echarts;
	}
	/**
	  * Title:
	  * <p>
	  * Description:获取echarts所需的用户月注册数折线图的数据;
	  * <p>
	  * @author Kor_Zhang
	  * @date 2017年10月10日 上午8:41:14
	  * @version 1.0
	  * @return
	  * @throws Exception
	  */
	@RequiresAuthentication
	@RequiresPermissions("users:select")
	@RequestMapping("getUsersMonthRegistNumberChartData")
	public @ResponseBody ECharts getUsersMonthRegistNumberChartData() throws Exception{
		
		
		ECharts echarts = new ECharts();
		try {
			
			echarts = service.getUsersMonthRegistNumberChartData();
			
			echarts.setMsg("获取注册数成功");
			
			echarts.setResult(RESULT.TRUE);
			
		} catch (Exception e) {
			e.printStackTrace();

			echarts.setMsg(e.getMessage());
			
			echarts.setResult(RESULT.FALSE);
		}
		return echarts;
	}
	
}
