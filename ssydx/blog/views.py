from typing import Any
from django.db.models.query import QuerySet
from django.shortcuts import render
from blog.models import *
from django.views import generic
from django.apps import apps
# Create your views here.


def index(request):
    app_label = 'blog'
    modelnames = []

    # 获取指定应用的模型字典
    app_models = apps.all_models.get(app_label, {})

    for model_name, model_class in app_models.items():
        modelnames.append(model_class._meta.verbose_name)

    # 获取所有模型实例
    models_instances = {}
    for model_name, model_class in app_models.items():
        instances = model_class.objects.all()
        models_instances[model_name] = instances

    return render(
        request,
        'blog/index.html',
        context={
            'modelnames': modelnames,
            'models_instances': models_instances,
        },
    )


class ArticlesView(generic.ListView):
    model = ArticleModel
    template_name = 'blog/articles.html'
    context_object_name = 'articles'
    def get_queryset(self):
        return super().get_queryset().order_by('genre')
class ArticleView(generic.DetailView):
    model = ArticleModel
    articles = ArticleModel.objects.order_by('genre')
    extra_context = {'articles': articles,}
    template_name = 'blog/article.html'
    context_object_name = 'article'
class GenreView(generic.DetailView):
    model = GenreModel
    articles = ArticleModel.objects.order_by('genre')
    extra_context = {'articles': articles,}
    template_name = 'blog/article.html'
    context_object_name = 'article'




def origin(request):
    return render(
        request,
        'origin.html',
)
def blog(request):
    return render(
        request,
        'blog.html',
)
def base(request):
    return render(
        request,
        'blog/base.html',
)