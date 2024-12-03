from django import forms
from django.http import HttpResponse
from django.shortcuts import render
class LoginForm(forms.Form):
    user_name=forms.CharField(label='用户名', min_length=6,max_length=12)
    user_password=forms.CharField(label='用户密码',min_length=6)

def login(request):
    if request.method == "POST":
        form = LoginForm(request.POST)
        if form.is_valid():
            return HttpResponse('登录成功')
    else:
        form = LoginForm()
    return render(request, 'index/login.html', context={'form': form})