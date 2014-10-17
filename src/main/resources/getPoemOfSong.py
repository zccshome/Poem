import re, MySQLdb
#coding: utf-8

class PoemClass:
	def __init__(self, book_info, poem_info, title, author, poem):
		self.book_info = book_info
		self.poem_info = poem_info
		self.title = title
		self.author = author
		self.poem = poem
	def __str__(self):
		return self.book_info + ' ' + self.poem_info + ' ' + self.title + ' ' + self.author + ' ' + self.poem

def preservePage(poemClass):
	if poemClass.poem == '':
		return
	try:
		conn = MySQLdb.connect(host='localhost',user='root',passwd='123',db='poem', charset='utf8')
	except Exception, e:
		print e
		sys.exit()
	
	cursor = conn.cursor()	
	sql = "insert into poemsong(poemBookNum, poemPoemNum, poemTitle, poemAuthor, poemContent) values ('%s', '%s', '%s', '%s', '%s')" % (poemClass.book_info, poemClass.poem_info, poemClass.title, poemClass.author, poemClass.poem)
	try:
		cursor.execute(sql)
	except Exception, e:
		print e
	conn.commit()
	cursor.close()
	conn.close()
		
if __name__ == '__main__':
	bookNum = 0
	poemNum = 0
	title = ''
	author = ''
	content = ''
	
	isPreserve = 0
	
	f = open('quansongshi.txt', 'r+')
	line = f.readline()
	while line:
		line = line.decode('utf-8', 'ignore').encode('gbk', 'ignore')
		if line.startswith('<1>'):
			if isPreserve == 1:
				poem = PoemClass(str(bookNum).zfill(6), str(poemNum).zfill(6), title, author, content.decode('gbk', 'ignore'))
				'''
				print(poem.title)
				print(poem.author)
				print(poem.poem)
				'''
				preservePage(poem)
				isPreserve = 0
			bookNum += 1
			poemNum = 0
		elif line.startswith('<2>'):
			if isPreserve == 1:
				poem = PoemClass(str(bookNum).zfill(6), str(poemNum).zfill(6), title, author, content.decode('gbk', 'ignore'))
				'''
				print(poem.title)
				print(poem.author)
				print(poem.poem)
				'''
				preservePage(poem)
				isPreserve = 0
			author_result = re.search(u'<2>([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</2>', line.decode('gbk', 'ignore'))
			if author_result:
				author = author_result.group(1)
				print(author)
		elif line.startswith('<B>'):
			if isPreserve == 1:
				poem = PoemClass(str(bookNum).zfill(6), str(poemNum).zfill(6), title, author, content.decode('gbk', 'ignore'))
				'''
				print(poem.title)
				print(poem.author)
				print(poem.poem)
				'''
				preservePage(poem)
			else:
				isPreserve = 1
			content = ''
			poemNum += 1
			title_result = re.search(u'<B>([\u0020-\u007f_\u4e00-\u9fff_\uff01-\uffee_\u3002_\u3001_\u2026_\u201d_\u201c_\u2019_\u2018_\u300a_\u300b]+)</B>', line.decode('gbk', 'ignore'))
			if title_result:
				title = title_result.group(1)
				#print(title)
		else:
			content = content + line
			#print(content)
		line = f.readline()
	preservePage(poem)
	f.close()
		