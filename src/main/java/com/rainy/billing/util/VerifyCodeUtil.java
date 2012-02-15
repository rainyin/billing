package com.rainy.billing.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
/**
 * Title: <br>
 * Description: 关于登录验证码
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-28
 * @author rainy
 * @version 1.0
 */
public class VerifyCodeUtil {
	
	private static Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
	
	private static String getRandCode(int size){
        Random random = new Random();
        StringBuilder sRandom = new StringBuilder();
		for (int i=0;i<size;i++){
		    String rand;
		    if(random.nextInt(10) > 5) {
		    	rand = String.valueOf((char)(random.nextInt(10) + 48));
		    } else {
		    	rand = String.valueOf((char)(random.nextInt(26) + 65));
		    }
		    sRandom.append(rand);
		}
		
		return sRandom.toString();
    }
	
	public static String drawCode(Graphics graph, int width, int height){
		Random random = new Random();
		
		graph.setColor(getRandColor(200,250));
		graph.fillRect(0, 0, width, height);
		graph.setFont(new Font("Times New Roman",Font.PLAIN,18));
		graph.setColor(getRandColor(160,200));
		
		for (int i=0;i<155;i++)
		{
			int x = random.nextInt(width);
			int y = random.nextInt(height);
	        int xl = random.nextInt(12);
	        int yl = random.nextInt(12);
			graph.drawLine(x,y,x+xl,y+yl);
		}
		
		int size = 5;
		String code = getRandCode(size);
		for(int i = 0 ; i < code.length() ; i++){
			 graph.setColor(new Color(random.nextInt(125),random.nextInt(125),random.nextInt(125)));
			 graph.drawString(String.valueOf(code.charAt(i)),13*i+6,16);
		}

		graph.dispose();
		
		return code;
	}

}
