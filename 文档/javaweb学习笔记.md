﻿TOC
# ip地址解析的过程
1、浏览器根据主机名"www.gacl.cn"去操作系统的Hosts文件中查找主机名对应的IP地址
2.浏览器如果在操作系统的Hosts文件中没有找到对应的IP地址，就去互联网上的DNS服务器上查找"www.gacl.cn"这台主机对应的IP地址。
3、浏览器查找到"www.gacl.cn"这台主机对应的IP地址后，就使用IP地址连接到Web服务器。
4、浏览器连接到web服务器后，就使用http协议向服务器发送请求，发送请求的过程中，浏览器会向Web服务器以Stream(流)的形式传输数据，告诉Web服务器要访问服务器里面的哪个Web应用下的Web资源。
总结：主机→DNS

