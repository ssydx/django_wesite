from django.shortcuts import render

# Create your views here.

def index(request):
    return render(
        request,
        'novel/base.html',
    )

from django.views import generic
from novel.models import *
class AuthorsView(generic.ListView):
    model = AuthorModel
    template_name = 'novel/authors.html'
    context_object_name = 'authors'

def tests(request):
    return render(
        request,
        'novel/tests.html',
        context={
            'authors': AuthorModel.objects.all()
        }
    )

def test(request, pk):
    return render(
        request,
        'novel/test.html',
        context={
            'author': AuthorModel.objects.get(pk=pk)
        }
    )