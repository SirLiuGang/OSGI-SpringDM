package com.zhbr.localtranslateasslt.impls;

import java.util.concurrent.ConcurrentHashMap;

import com.zhbr.translateasslt.service.TranslateService;

/**
 * ���ط������֣�ʵ��TranslateService�ӿ�
 */
public class TranslateServiceLocalImpl implements TranslateService{

	private static final ConcurrentHashMap <String, String> dictonary = new ConcurrentHashMap<String, String>();
    static{  
        dictonary.put("CHINA", "�й�");
        dictonary.put("USA", "����");
    }
	
	@Override
	public String translate(String word) {
		System.out.println("LocalTranslateAsslt Service---------->");
        String result = dictonary.get(word);
        if(null == result){
            result = "δ�ҵ������鵥�����壬���鵥���Ƿ���ȷ!";
        }
        return result;
	}
	
}
