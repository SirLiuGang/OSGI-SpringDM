此次开发使用了OSGI-SpringDM框架，涉及到的项目包：
	_Readme：开发结束后的一些总结
	LocalTranslateAsslt：本地翻译助手的实现类，通过Spring进行自动注入
	RemoteTranslateAsslt：远程翻译助手的实现类
	TranslateAsslt：定义了翻译助手的接口类
	TranslateClient：翻译助手的客户端，实现了注册Servlet服务，静态资源的开发，Servlet中DoGet、DoPost方法的处理

上传的时候发现jar包和压缩包上传不了
解决方法：D:\Git\Github\OSGI-SpringDM\.gitignore中# Package Files #对jar包进行了忽略，删除掉需要上传的文件格式即可。

_Readme项目：
	loadjar里边放的是需要导入的低版本的jar包和剩余的所有包，不兼容的话将低版本的包导入进去
	springDM里边放的是SpringDM框架需要引入的包
	word中是此次学习的总结及经验

	由于此处使用的SpringDM为低版本，导致对应需要导入的jar包也只能为低版本的
	jdk版本为1.6

	注意：引入了ds的包才可以实现XML文件的解析，不然无法实现Spring的自动注入功能
	org.mortbay.jetty也是必须的，需要启动jetty服务器



	SpringDM的包在官网上没有找到/(ㄒoㄒ)/~~




GitHub代码路径：https://github.com/SirLiuGang/OSGI-SpringDM.git