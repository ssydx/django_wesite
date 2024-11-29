from django import forms

class MyForm(forms.Form):
    name = forms.CharField(max_length=20,label='名字')
    age = forms.IntegerField(max_value=60, min_value=18,label='年龄')


from django.forms import ModelForm
from novel.models import *
class AuthorForm(ModelForm):
    class Meta:
        model = AuthorModel
        fields = ['name','age','gender',]