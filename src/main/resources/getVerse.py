import urllib2, urlparse, re, MySQLdb
#coding: utf-8

class VerseClass:
	def __init__(self, title, subtitle, author, content1, content2):
		self.title = title
		self.subtitle = subtitle
		self.author = author
		self.content1 = content1
		self.content2 = content2
	def __str__(self):
		return self.title + ' ' + self.subtitle + ' ' + self.author + ' ' + self.content1 + ' ' + self.content2

def getVerse():
	for i in range(1, 1486):
		pageNum = str(i).zfill(4)
		req = urllib2.Request('http://www.guoxue.com/qsc/'+pageNum+'.htm', headers={'User-Agent' : "Magic Browser"})
		webpage= urllib2.urlopen(req)
		webcontent = webpage.read()
		#print(webcontent)
		
		author_result = re.search(u'<font color="#CC33FF"><br><br>([\u4e00-\u9fa5|&nbsp|;]+)</font></b></font>', webcontent.decode('gbk', 'ignore'))
		if author_result:
			author = author_result.group(1)
			author = author.replace('&nbsp;', '')
			print(author)
		'''
		verses_result = re.findall(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font><span><font size="2" color="#FF00FF">[\u0020-\u007f_\u00B7_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font></span></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+\r\n</font><p></p>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+', webcontent.decode('gbk', 'ignore'))
		
		for verse in verses_result:
			verse_result = re.search(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font><span><font size="2" color="#FF00FF">([\u0020-\u007f_\u00B7_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font></span></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)\r\n</font><p></p>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)', verse)
			title = verse_result.group(1)
			print(title)
			subtitle = verse_result.group(2)
			#print(subtitle)
			
			content1 = verse_result.group(3)
			#print(content1)
			content2 = verse_result.group(4)
			#print(content2)
			
			verse = VerseClass(title, subtitle, author, content1, content2)
			preservePage(verse)
		
		verses_result = re.findall(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+\r\n</font><p></p>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+', webcontent.decode('gbk', 'ignore'))
		
		for verse in verses_result:
			verse_result = re.search(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)\r\n</font><p></p>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)', verse)
			title = verse_result.group(1)
			print(title)
			subtitle = ''
			#print(subtitle)
			
			content1 = verse_result.group(2)
			#print(content1)
			content2 = verse_result.group(3)
			#print(content2)
			
			verse = VerseClass(title, subtitle, author, content1, content2)
			preservePage(verse)
		'''
		verses_result = re.findall(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+\r\n</font><p></p>\r\n</ul><p></p>', webcontent.decode('gbk', 'ignore'))
		
		for verse in verses_result:
			verse_result = re.search(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)\r\n</font><p></p>\r\n</ul><p></p>', verse)
			title = verse_result.group(1)
			print(title)
			subtitle = ''
			#print(subtitle)
			
			content1 = verse_result.group(2)
			#print(content1)
			content2 = ''
			#print(content2)
			
			verse = VerseClass(title, subtitle, author, content1, content2)
			preservePage(verse)
		
		verses_result = re.findall(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font><span><font size="2" color="#FF00FF">[\u0020-\u007f_\u00B7_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+</font></span></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;[\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+\r\n</font><p></p>\r\n</ul><p></p>', webcontent.decode('gbk', 'ignore'))
		
		for verse in verses_result:
			verse_result = re.search(u'<p align="center"><font face="\u9ed1\u4f53" size="3" color="#000080">([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font><span><font size="2" color="#FF00FF">([\u0020-\u007f_\u00B7_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</font></span></font></font></p>\r\n<ul>\r\n&nbsp;&nbsp;&nbsp;&nbsp;([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)\r\n</font><p></p>\r\n</ul><p></p>', verse)
			title = verse_result.group(1)
			print(title)
			subtitle = verse_result.group(2)
			print(subtitle)
			
			content1 = verse_result.group(3)
			#print(content1)
			content2 = ''
			#print(content2)
			
			verse = VerseClass(title, subtitle, author, content1, content2)
			preservePage(verse)
		
def preservePage(verseClass):
	try:
		conn = MySQLdb.connect(host='localhost',user='root',passwd='123',db='poem', charset='utf8')
	except Exception, e:
		print e
		sys.exit()
	cursor = conn.cursor()
	sql = "insert into verse(title, subtitle, author, content1, content2) values ('%s', '%s', '%s', '%s', '%s')" % (verseClass.title, verseClass.subtitle, verseClass.author, verseClass.content1, verseClass.content2)
	try:
		cursor.execute(sql)
	except Exception, e:
		print e
	conn.commit()
	cursor.close()
	conn.close()

if __name__ == '__main__':
	print('Hello World!')
	#getPage(1, 1)
	getVerse()