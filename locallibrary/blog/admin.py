from django.contrib import admin
from .models import *
# Register your models here.
admin.site.register(BlogAuthorModel)
admin.site.register(BlogCommentModel)
class BlogCommentInline(admin.TabularInline):
    model = BlogCommentModel
    extra = 1
@admin.register(BlogContentModel)
class BlogContent(admin.ModelAdmin):
    inlines = [BlogCommentInline]



