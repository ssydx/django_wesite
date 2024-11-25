from typing import Any
from django.db.models.query import QuerySet
from django.shortcuts import render
from program.models import *
from django.views import generic
from django.apps import apps
# Create your views here.


def origin(request):
    return render(
        request,
        'origin.html',
)

def main(request):
    return render(
        request,
        'main.html',
)


def index(request):
    modelnames = []

    # 获取指定应用的模型字典
    app_models = apps.all_models.get('program', {})

    for model_name, model_class in app_models.items():
        modelnames.append(model_class._meta.verbose_name)

    # 获取所有模型实例
    models_instances = {}
    for model_name, model_class in app_models.items():
        instances = model_class.objects.all()
        models_instances[model_name] = instances

    return render(
        request,
        'index.html',
        context={
            'modelnames': modelnames,
            'models_instances': models_instances,
        },
    )


def base(request):
    return render(
        request,
        'program/base.html',
)


class ArticlesView(generic.ListView):
    model = ArticleModel
    template_name = 'program/articles.html'
    context_object_name = 'articles'
    def get_queryset(self):
        return super().get_queryset().order_by('genre')
class ArticleView(generic.DetailView):
    model = ArticleModel
    articles = ArticleModel.objects.order_by('genre')
    extra_context = {'articles': articles,}
    template_name = 'program/article.html'
    context_object_name = 'article'
class GenreView(generic.DetailView):
    model = GenreModel
    articles = ArticleModel.objects.order_by('genre')
    extra_context = {'articles': articles,}
    template_name = 'program/article.html'
    context_object_name = 'article'





