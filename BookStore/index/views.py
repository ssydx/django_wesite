from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
from django.template import loader
def loaderView(request):
    t=loader.get_template('index/test1.html')
    html = t.render({'name': 'zhangsan',})
    return HttpResponse(html)

def renderView(request):
    cnt = request.session.get('cnt', 0)
    cnt += 1
    request.session['cnt'] = cnt
    print(cnt)
    return render(
        request,
        'index/test2.html',
        context={
            'name': 'lisi',
            'cnt': cnt,
        }
    )

def test_html(request):
    a={} #创建空字典，模板必须以字典的形式进行传参
    a['name']='C语言中文网'
    a['course']=["Python","C","C++","Java"]
    a['b']={'name':'C语言中文网','address':'http://c.biancheng.net/'}
    a['test_hello']=test_hello
    a['class_obj']=Website()
    return render(request,'index/test.html',a)

def test_hello():
    return '欢迎来到C语言中文网'

class Website:
    def Web_name(self):
        return 'Hello，C语言中文网!'
        #Web_name.alters_data=True #不让Website()方法被模板调用
from index.models import *

def BookName(request):
    books=Book.objects.raw("select * from index_book") #书写sql语句
    return render(request,"index/allbook.html",locals())


from django.views.generic import View
class LogView(View):
    def get(self, request):
        return HttpResponse('登录成功！')

from django.conf import settings
from django.core.mail import send_mail
def send_email(request):
    subject = 'C语言中文网链接' # 主题
    from_email = settings.EMAIL_HOST_USER # 发件人，在settings.py中已经配置
    to_email = '3267722727@qq.com' # 邮件接收者列表
    # 发送的消息
    message = 'c语言中文网欢迎你点击登录 http://c.biancheng.net/' # 发送普通的消息使用的时候message
    # meg_html = '<a href="http://www.baidu.com">点击跳转</a>' # 发送的是一个html消息 需要指定
    send_mail(subject, message, from_email, [to_email])
    return HttpResponse('OK,邮件已经发送成功!')




import os
def upload(request):
    if request.method=='GET':
        return render(request,'index/upload.html')
    elif request.method=='POST':
        #使用request.FILES['myfile']获得文件流对象file
        file=request.FILES['myfile']
        #文件储存路径，应用settings中的配置，file.name获取文件名
        filename=os.path.join(settings.MEDIA_ROOT,file.name)
        #写文件
        with open(filename,'wb') as f:
        #file.file 获取文件字节流数据
            data = file.file.read()
            f.write(data)
            return HttpResponse('成功保存了 %s 文件'%(file.name))

# 生成csv文本导出
import csv
def test_csv(request):
    #生成csv文本
    #生成response的content-type头
    res=HttpResponse(content_type='text/csv')
    #固定格式,添加 content-Disposition头，设置以附件方式下载，并给文件添加默认文件名
    res['Content-Disposition']='attachment;filename="allUser.csv"'
    # 获取数据库中数据
    users=UserInfo.objects.all()
    # 生成writer的写对象
    writer=csv.writer(res)
    # 写csv表头，即想要展示字段名
    writer.writerow(['username','gender'])
    # 写具体数据
    for user in users:
        writer.writerow([user.username,user.gender])
    return res
