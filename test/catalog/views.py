from django.shortcuts import render
from django.views.generic import *
from catalog.models import *
# Create your views here.

def index(request):
    return render(
        request,
        'index.html',
        context={
            'a':1,
            'b':2,
        }
    )

class AuthorView(DetailView):
    model = AuthorModel
    template_name = 'index.html'










