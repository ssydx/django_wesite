# 原始文件
import os
import django
# 设置 Django 设置模块
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'locallibrary.settings')
# 初始化 Django
django.setup()

from catalog.models import *
model = Author
print(model.objects.all())
for author in model.objects.all():
    print(author.gender)
