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
            'author': AuthorModel.objects.get(pk=pk),
            'fields': AuthorModel.objects.get(pk=pk)._meta.fields,
        }
    )

import io
from django.http import FileResponse
from reportlab.pdfgen import canvas

def some_view(request):
    buffer = io.BytesIO()
    p = canvas.Canvas(buffer)
    p.drawString(100, 100, "Hello world.")
    p.showPage()
    p.save()
    buffer.seek(0)
    return FileResponse(buffer, as_attachment=True, filename="hello.pdf")

from novel.forms import *
from django.http import HttpResponseRedirect,HttpResponse
def formView(request):
    if request.method=='POST':
        form = MyForm(request.POST)
        if form.is_valid():
            return HttpResponseRedirect(reverse('novel:authors'))
    else:
        form = MyForm()
    return render(
        request,
        'novel/form.html',
        context={
            'form': form,
        }
    )

def authorFormView(request):
    return render(
        request,
        'novel/1.html',
        context={
            'form': AuthorForm(),
        }
    )

def urlView(request):
    return HttpResponse('<h1>url</h1>')