	package com.zhbr.translateclient.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpService;

import com.zhbr.translateasslt.service.TranslateService;

/**
 * TranslateServiceServlet通过配置文件注入TranslateService和HttpService
 */
public class TranslateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpService httpService;
    
	public TranslateService translateService;

	/**
     * 注入HttpService
     */
    public void setHttpService(HttpService httpService){
    	System.out.println("1");
        try {
            httpService.registerServlet("/servlet/translateServlet", this, null, null);
            httpService.registerResources("/page", "src/pages", null);//http://localhost:8010/page/translate.html
            System.out.println("翻译助手服务已启动成功，请通过/page/translate.html访问!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 注销HttpService
     * @param httpService
     */
    public void unsetHttpService(HttpService httpService){
    	System.out.println("2");
        if(httpService != this.httpService){
            return;
        }
        try {
            httpService.unregister("/servlet/translateServlet");
            httpService.unregister("/page");
            System.out.println("翻译助手服务已停用成功，谢谢使用！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.httpService = null;
    } 
    
    /**
     * 注入TranslateService
     */
    public void setTranslateService(TranslateService translateService){
    	System.out.println("3");
        this.translateService = translateService;
    }
    
    /**
     * 注销TranslateService
     */
    protected void unsetTranslateService(TranslateService translateService){
    	System.out.println("4");
        if(translateService != this.translateService){
            return;
        }
        this.translateService = null;
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1、取得用户传来的英文单词
		String queryWord = req.getParameter("query_word");

		// 2、调用方法查找中文含义
		resp.setContentType("text/html;charset=GBK");
		PrintWriter writer = resp.getWriter();
		if (translateService == null) {
			writer.println("没有开放翻译服务！");
			writer.close();
			return;
		}
		
		// 3、返回结果给用户
		String result = translateService.translate(queryWord);
		writer.println("结果" + result);
		writer.close();
		return;
	}
	
}
