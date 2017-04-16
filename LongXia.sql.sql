DROP DATABASE IF EXISTS LongXia;			#存在LongXia 数据库则删除
CREATE DATABASE LongXia;				#创建LongXia 数据库
USE longxia;

#创建贴吧一级分类表
DROP TABLE IF EXISTS lx_barcategory;
CREATE TABLE lx_barcategory(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,	#贴吧分类表ID主键自增长
	categoryname VARCHAR(10) NOT NULL 		#贴吧分类名称
);

#创建贴吧二级分类表
DROP TABLE IF EXISTS lx_barcategory2;
CREATE TABLE lx_barcategory2(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,	#二级分类表ID主键自增长
	categoryname VARCHAR(10) NOT NULL,		#二级贴吧分类名称
	categoryid INT NOT NULL,			#所属一级分类ID,外键
	CONSTRAINT FOREIGN KEY(categoryid) REFERENCES lx_barcategory(id)
);

#创建会员表
DROP TABLE IF EXISTS lx_user; 				#若存在 会员表则删除 
CREATE TABLE lx_user(					#会员表
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#会员 ID 主键自增长
	nickname VARCHAR(20) NOT NULL,			#会员昵称
	sex INT NOT NULL,				#会员性别	0 为女性 1 为男性
	age INT NOT NULL,				#会员年龄
	headimage VARCHAR(200) NULL,			#头像路径							
	username VARCHAR(20) NOT NULL,			#登录名
	`password` VARCHAR(20) NOT NULL,		#登陆密码
	createtime DATETIME NOT NULL, 			#账号创建时间
	fanscount INT NOT NULL DEFAULT 0,		#粉丝
	attentioncount INT NOT NULL DEFAULT 0 		#关注贴吧数
);

#贴吧表
DROP TABLE IF EXISTS lx_bar;
CREATE TABLE lx_bar(	
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#贴吧ID
	NAME VARCHAR(10) NOT NULL,			#吧名
	ownerid INT NOT NULL,				#吧主
	categoryid INT NOT NULL,			#所属二级分类ID,外键
	CONSTRAINT FOREIGN KEY (ownerid) REFERENCES lx_user(id),
	CONSTRAINT FOREIGN KEY (categoryid) REFERENCES lx_barcategory2(id)	
);

#创建帖子表
DROP TABLE IF EXISTS lx_thread;
CREATE TABLE lx_thread(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#帖子表 主键自增长
	title VARCHAR(50) NOT NULL,			#帖子标题
	content VARCHAR(500) NULL,			#帖子内容
	image VARCHAR(50) NULL,				#图片路径
	userid INT NOT NULL,				#发布者
	barid	INT NOT NULL,				#所属贴吧		
	createdate DATETIME NOT NULL ,			#创建时间
	isTop INT NOT NULL DEFAULT 0,			#是否置顶 0未置顶  1置顶  每个吧两条置顶
	replycount INT NOT NULL DEFAULT 0,		#回复数量
	CONSTRAINT FOREIGN KEY (userid) REFERENCES lx_user(id),	
	CONSTRAINT FOREIGN KEY (barid) REFERENCES lx_bar(id)
);

#创建回复表
DROP TABLE IF EXISTS lx_reply;
CREATE TABLE lx_reply(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#回复 ID
	content VARCHAR(100) NOT NULL,			#回复内容
	userid INT NOT NULL,				#回复人ID
	barid	INT NOT NULL,				#所属贴吧
	threadid INT NOT NULL,				#所属帖子
	replytime DATETIME NOT NULL ,	#回复时间
	CONSTRAINT FOREIGN KEY (userid) REFERENCES lx_user(id),			
	CONSTRAINT FOREIGN KEY (barid) REFERENCES lx_bar(id),				
	CONSTRAINT FOREIGN KEY (threadid) REFERENCES lx_thread(id)	
);

#创建等级名称表
DROP TABLE IF EXISTS lx_levelname;
CREATE TABLE lx_levelname(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#等级名称ID 主键自增长
	levelname VARCHAR(4) NOT NULL,			#等级名称
	LEVEL INT NOT NULL,				#等级数
	userid INT NOT NULL,				#会员id 外键
	barid	INT NOT NULL,				#所属贴吧 外键
	CONSTRAINT FOREIGN KEY (barid) REFERENCES lx_bar(id),	
	CONSTRAINT FOREIGN KEY (userid) REFERENCES lx_user(id)	
);

#创建关注贴吧表
DROP TABLE IF EXISTS lx_attentionbar;
CREATE TABLE lx_attentionbar(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#关注表主键自增长
	userid INT NOT NULL,				#关注者
	barid	INT NOT NULL,				#所关注贴吧ID
	CONSTRAINT FOREIGN KEY (userid) REFERENCES lx_user(id),	
	CONSTRAINT FOREIGN KEY (barid) REFERENCES lx_bar(id)	
);

#创建关注帖子表
DROP TABLE IF EXISTS lx_attentionthread;
CREATE TABLE lx_attentionthread(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#关注帖子主键自增长
	userid INT NOT NULL,				#关注者
	threadid INT NOT NULL,				#所关注帖子
	CONSTRAINT FOREIGN KEY (userid) REFERENCES lx_user(id),			
	CONSTRAINT FOREIGN KEY (threadid) REFERENCES lx_thread(id)
);


#创建会员关注表
DROP TABLE IF EXISTS lx_userattention;
CREATE TABLE lx_userattention(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,	#会员关注表ID
	attentionuserid INT NOT NULL,			#关注者
	coverattentionuserid INT NOT NULL,		#被关注者
	CONSTRAINT FOREIGN KEY (attentionuserid) REFERENCES lx_user(id),			
	CONSTRAINT FOREIGN KEY (coverattentionuserid) REFERENCES lx_user(id)
);


#贴吧分类表插入数据	#DELETE FROM lx_barcategory
INSERT INTO lx_barcategory(categoryname) VALUES('娱乐明星');
INSERT INTO lx_barcategory(categoryname) VALUES('爱综艺');
INSERT INTO lx_barcategory(categoryname) VALUES('追剧狂');
INSERT INTO lx_barcategory(categoryname) VALUES('看电影');
INSERT INTO lx_barcategory(categoryname) VALUES('体育');
INSERT INTO lx_barcategory(categoryname) VALUES('小说');
INSERT INTO lx_barcategory(categoryname) VALUES('生活家');
INSERT INTO lx_barcategory(categoryname) VALUES('闲·趣');
INSERT INTO lx_barcategory(categoryname) VALUES('游戏');
INSERT INTO lx_barcategory(categoryname) VALUES('动漫宅');
INSERT INTO lx_barcategory(categoryname) VALUES('高校');
INSERT INTO lx_barcategory(categoryname) VALUES('地区');
INSERT INTO lx_barcategory(categoryname) VALUES('人文自然');

#用户表插入数据
INSERT INTO lx_user(nickname,sex,age,headimage,username,PASSWORD,createtime) VALUES('大王叫我来巡山',1,20,'','是朕','qwert',SYSDATE());



#贴吧二级分类测试数据
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('港台东南亚明星',1);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('内地明星',1);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('韩国明星',1);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('日本明星',1);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('时尚人物',1);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('内地综艺',2);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('台湾综艺',2);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('韩国综艺',2);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('时尚·生活服务',2);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('体育运动·健身',2);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('韩国电视剧',3);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('香港电视剧',3);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('美剧',3);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('日本电视剧',3);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('内地电视剧',3);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('香港电影',4);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('欧美电影',4);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('内地电影',4);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('韩国电影',4);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('日本电影',4);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('台湾电影',4);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('足球',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('篮球',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('NBA',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('CBA',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('乒乓球',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('网球',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('舞蹈',5);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('健身',5);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('奇幻',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('言情',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('灵异',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('穿越',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('连载',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('修真',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('历史',6);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('架空文',6);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('小而美',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('DIY',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('美食',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('摄影',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('旅行',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('变美',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('留学移民',7);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('文玩',7);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('萌宠',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('萝莉',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('重口味',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('吐槽',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('恐怖',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('星座',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('爆料',8);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('喵星人',8);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('客户端网游',9);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('桌游',9);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('游戏角色',9);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('网页版网游',9);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('手机游戏',9);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('小游戏',9);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('日本动漫',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('国产动漫',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('欧美动漫',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('搞笑漫画',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('热血动漫',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('推理',10);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('声优',10);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('北京院校',11);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('山东院校',11);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('江苏院校',11);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('四川院校',11);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('湖北院校',11);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('河北院校',11);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('山东',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('河北',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('河南',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('山西',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('江苏',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('辽宁',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('四川',12);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('广东',12);

INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('艺术',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('军事',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('历史',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('自然',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('鉴赏收藏',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('民族文化',13);
INSERT INTO lx_barcategory2(categoryname,categoryid) VALUES('语言文化',13);

#贴吧插入测试数据
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('周杰伦吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('霍华健吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('钟汉良吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('陈奕迅吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('张国荣吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('林俊杰吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('邓紫棋吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('刘德华吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('陈乔恩吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('周星驰吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('孙燕姿吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('angelababy吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('五月天吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('柯震东吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('蔡依林吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('黄家驹吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('林心如吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('陈冠希吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('谢霆锋吧',1,1);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('张学友吧',1,1);

INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('杨洋吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('李易峰吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('易昕吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('snh48吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('鹿晗吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('vae吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('赵丽颖吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('吴亦凡吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('tfboys吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('唐嫣吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('郑爽吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('刘亦菲吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('杨幂吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('王俊凯吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('姚贝娜吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('张艺兴吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('宋茜吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('演员马可吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('李宇春吧',1,2);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('张杰吧',1,2);

INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('快乐大本营吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('爸爸去哪儿',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('极限挑战吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('中国好声音吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('我们相爱吧吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('我们15个吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('天天向上吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('非诚勿扰吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('深圳卫视极速前进吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('加油吧新郎吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('老梁故事汇吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('欢乐喜剧人吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('我是歌手吧吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('费曼feynman吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('真正男子汉吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('爸爸回来了吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('奇葩说吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('非常近距离吧',1,6);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('非常完美吧',1,6);

INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('康熙来了吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('国光帮帮忙吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('女人我最大吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('旗米拉吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('娱乐百分百吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('综艺玩很大吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('食尚玩家吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('tvbs哈新闻吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('大学生了没吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('爱玩客吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('超级星光大道吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('综艺大热门吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('完全娱乐吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('格拉苏蒂吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('我爱黑涩会吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('型男大主厨吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('天才冲冲冲吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('来自星星的事吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('三只小猪吧',1,7);
INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('全民大新闻吧',1,7);

#INSERT INTO lx_bar(NAME,ownerid,categoryid)VALUES('吧',1,7);

SELECT * FROM lx_bar;












