from django import template
register = template.Library()

#注册自定义简单标签
@register.simple_tag
def addstr_tag(strs):
    return 'Hello'%strs