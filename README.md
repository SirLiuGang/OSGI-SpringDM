# OSGI-SpringDM
此次开发使用了OSGI-SpringDM框架，涉及到的项目包：
_Readme：开发结束后的一些总结
LocalTranslateAsslt：本地翻译助手的实现类，通过Spring进行自动注入
RemoteTranslateAsslt：远程翻译助手的实现类
TranslateAsslt：定义了翻译助手的接口类
TranslateClient：翻译助手的客户端，实现了注册Servlet服务，静态资源的开发，Servlet中DoGet、DoPost方法的处理