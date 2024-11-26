from django.contrib import admin
from novel.models import *
# Register your models here.

@admin.register(AuthorModel)
class AuthorAdmin(admin.ModelAdmin):
    pass

@admin.register(GenreModel)
class GenreAdmin(admin.ModelAdmin):
    pass


@admin.register(ArticleModel)
class ArticleAdmin(admin.ModelAdmin):
    list_display=[
        'title','display_genre','property_genre',
    ]