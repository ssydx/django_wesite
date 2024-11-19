# 载入模型
from django.forms.models import BaseModelForm
from django.http import HttpResponse
from .models import *

# 视图函数
from django.shortcuts import render
def index(request):
    auth_num = BlogAuthorModel.objects.count()
    blog_num = BlogContentModel.objects.count()
    comment_num = BlogCommentModel.objects.count()
    return render(
        request,
        'blog/index.html',
        context= {
            'auth_num':auth_num,
            'blog_num':blog_num,
            'comment_num':comment_num,
        }
    )

# 视图
from django.views.generic import *
class BlogAuthorsView(ListView):
    model = BlogAuthorModel
    template_name = 'blog/authors.html'
    context_object_name = 'blogauthors'
class BlogContentsView(ListView):
    model = BlogContentModel
    template_name = 'blog/contents.html'
    context_object_name = 'blogcontents'
class BlogAuthorView(DetailView):
    model = BlogAuthorModel
    template_name = 'blog/author.html'
    context_object_name = 'blogauthor'
class BlogContentView(DetailView):
    model = BlogContentModel
    template_name = 'blog/content.html'
    context_object_name = 'blogcontent'
    def get_context_data(self, **kwargs):
        context =  super().get_context_data(**kwargs)
        context['blogcomments'] = self.object.blogcomments.all().order_by('pub_datetime')
        return context
from django.urls import reverse_lazy
from django.utils import timezone
class CommentCreate(CreateView):
    model = BlogCommentModel
    fields = ['pub_datetime','comment']
    template_name = 'blog/comment_form.html'
    initial = {
        'comment':'博主写的太好了',
    }
    def get_initial(self):
        initial = super().get_initial()
        initial['pub_datetime'] = timezone.now()
        return initial
    def get_success_url(self):
        # 获取 blog_content_id 从 URL 参数中
        blog_content_id = self.kwargs['pk']
        return reverse_lazy('blogcontent', kwargs={'pk': blog_content_id})
    def form_valid(self, form):
        form.instance.name = self.request.user
        form.instance.pub_datetime = timezone.now()
        bloginst = BlogContentModel.objects.get(pk=self.kwargs['pk'])
        form.instance.blog = bloginst
        return super().form_valid(form)
    def get_form(self, form_class=None):
        form = super().get_form(form_class)
        form.fields['pub_datetime'].widget.attrs['readonly'] = True
        return form


