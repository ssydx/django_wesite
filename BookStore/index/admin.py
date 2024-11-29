from django.contrib import admin

# Register your models here.
from index.models import Book, Author,UserInfo #这个需要我们自己导入相应的模型类（数据表）
admin.site.register([Book,Author,UserInfo])