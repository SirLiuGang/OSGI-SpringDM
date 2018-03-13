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
 * TranslateServiceServletͨ�������ļ�ע��TranslateService��HttpService
 */
public class TranslateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpService httpService;
    
	public TranslateService translateService;

	/**
     * ע��HttpService
     */
    public void setHttpService(HttpService httpService){
    	System.out.println("1");
        try {
            httpService.registerServlet("/servlet/translateServlet", this, null, null);
            httpService.registerResources("/page", "src/pages", null);//http://localhost:8010/page/translate.html
            System.out.println("�������ַ����������ɹ�����ͨ��/page/translate.html����!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ע��HttpService
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
            System.out.println("�������ַ�����ͣ�óɹ���ллʹ�ã�");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.httpService = null;
    } 
    
    /**
     * ע��TranslateService
     */
    public void setTranslateService(TranslateService translateService){
    	System.out.println("3");
        this.translateService = translateService;
    }
    
    /**
     * ע��TranslateService
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

		// 1��ȡ���û�������Ӣ�ĵ���
		String queryWord = req.getParameter("query_word");

		// 2�����÷����������ĺ���
		resp.setContentType("text/html;charset=GBK");
		PrintWriter writer = resp.getWriter();
		if (translateService == null) {
			writer.println("û�п��ŷ������");
			writer.close();
			return;
		}
		
		// 3�����ؽ�����û�
		String result = translateService.translate(queryWord);
		writer.println("���" + result);
		writer.close();
		return;
	}
	
}
