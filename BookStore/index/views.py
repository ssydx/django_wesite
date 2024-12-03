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