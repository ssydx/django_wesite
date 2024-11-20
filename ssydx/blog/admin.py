from django.contrib import admin
from blog.models import *
# Register your models here.

@admin.register(ArticleModel)
class ArticleAdmin(admin.ModelAdmin):
    list_display = [
        'title',
        'author',
    ]
    list_filter = [
        'author',
    ]
    search_fields = [
        'title',
    ]
    date_hierarchy = 'create_datetime'
    list_per_page = 20
    fieldsets = [
        (
            '基础信息',
            {
                'fields': [('title','author',),'desc','content'],
                'description': '这里列出文章的基本信息',
            }
        ),
        (
            '附加信息',
            {
                'fields': [('create_datetime','update_datetime',),],
                'description': '这里列出文章的附加信息',
                'classes': ['collapse',],
            }
        ),
    ]
    readonly_fields = [
        'create_datetime',
        'update_datetime',
    ]

@admin.register(AuthorModel)
class AuthorAdmin(admin.ModelAdmin):
    radio_fields = {'gender': admin.HORIZONTAL,}