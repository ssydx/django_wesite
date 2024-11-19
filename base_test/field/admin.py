from django.contrib import admin

# Register your models here.

from .models import class_tb, stu_tb, prod, prod1

admin.site.register(class_tb)
admin.site.register(stu_tb)
admin.site.register(prod)
admin.site.register(prod1)
