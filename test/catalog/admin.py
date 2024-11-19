from django.contrib import admin
admin.site.disable_action("delete_selected")
# Register your models here.
from catalog.models import *




@admin.register(AuthorModel)
class AuthorAdmin(admin.ModelAdmin):
    # 详情界面
    fieldsets = [
        (
            '基础信息',
            {
                'fields':['name',('age','gender'),],
                'description':'这是基础信息',
            }
        ),
        (
            '附加信息（不可修改）',
            {
                'fields':[('create_datetime','update_datetime'),],
                'classes':['collapse',],
            }
        ),
    ]
    readonly_fields = [
        'create_datetime',
        'update_datetime',
    ]
    radio_fields = {'gender': admin.HORIZONTAL}
    view_on_site = False
    # 列表页面
    list_display = ['name','age']
    list_display_links = ['age']
    list_editable = ['name']
    ordering = ['-name']
    list_filter = ['gender']
    search_fields = ['name']
    search_help_text = '输入要搜索的作者名称'
    date_hierarchy = 'update_datetime'
    list_per_page = 5
    list_max_show_all = 20
    actions_on_top = False
    actions_on_bottom = True
    actions_selection_counter = False
    actions = ['delete']
    show_full_result_count = False
    @admin.action(description='更新所选作者的性别')
    def delete(self, request, queryset):
        queryset.update(gender='F')


@admin.register(BookModel)
class BookAdmin(admin.ModelAdmin):
    autocomplete_fields = ['author']
    pass




