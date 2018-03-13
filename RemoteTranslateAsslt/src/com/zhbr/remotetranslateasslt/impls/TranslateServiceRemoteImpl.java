package com.zhbr.remotetranslateasslt.impls;

import java.util.concurrent.ConcurrentHashMap;

import com.zhbr.translateasslt.service.TranslateService;

/**
 * Զ�̷������֣�ʵ��TranslateService�ӿ�
 */
public class TranslateServiceRemoteImpl implements TranslateService{

	private static final ConcurrentHashMap<String, String> dictonary = new ConcurrentHashMap<String, String>();
	static{
        dictonary.put("cat", "Сè");
        dictonary.put("dog", "С��");
    }
	
	@Override
	public String translate(String word) {
		System.out.println("RemoteTranslateAsslt Service---------->");
        String result = dictonary.get(word);
        if(null == result){
            result = "δ�ҵ������鵥�����壬���鵥���Ƿ���ȷ!";
        }
        return result;
	}

}
