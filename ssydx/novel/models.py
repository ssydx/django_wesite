from django.db import models
from django.urls import reverse
# Create your models here.

class AuthorModel(models.Model):
    name = models.CharField(
        max_length=20,
        help_text='输入姓名',
        verbose_name='姓名',
    )
    SEX = [
        ('M', '男',),
        ('F', '女'),
    ]
    gender = models.CharField(
        max_length=1,
        choices=SEX,
        default='M',
        verbose_name='性别',
    )
    age = models.IntegerField(
        verbose_name='年龄',
        default=20,
    )
    class Meta:
        ordering=['-gender','name']
        constraints=[
            models.CheckConstraint(
                check=models.Q(age__gte=18) & models.Q(age__lte=65),
                name='年龄不得小于18或大于65',
                violation_error_message='违反约束：“%(name)s”'
            ),
            models.UniqueConstraint(
                fields=['name','gender'],
                name='姓名性别唯一'
            )
        ]
        permissions=[
            ('new perm', '新权限'),
        ]
        default_permissions=('add', 'change', 'delete',)
        verbose_name='作者'
        verbose_name_plural='作者列表'
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        pass

class GenreModel(models.Model):
    genre = models.CharField(
        max_length=10,
        help_text='输入类型',
        verbose_name='类型',
        unique=True,
        default='玄幻',
    )
    class Meta:
        verbose_name='类型'
        verbose_name_plural='类型列表'
    def __str__(self):
        return self.genre
    def get_absolute_url(self):
        pass

from django.contrib import admin

class ArticleModel(models.Model):
    title = models.CharField(
        max_length=20,
        help_text='输入标题',
        verbose_name='标题',
        default='遮天',
        primary_key=True,
    )
    author = models.ForeignKey(
        AuthorModel,
        on_delete=models.CASCADE,
        related_name='articles',
    )
    genre = models.ManyToManyField(
        GenreModel,
        related_name='articles',
    )
    LENGTH = [
        (
            "短篇",
            (
                ("10000", "一万"),
                ("50000", "五万"),
            ),
        ),
        (
            "中篇",
            (
                ("200000", "二十万"),
                ("500000", "五十万"),
            ),
        ),
        (
            "长篇",
            (
                ("1000000", "一百万"),
                ("2000000", "两百万"),
            ),
        ),
        ("超长篇", "两百万以上"),
    ]
    length = models.CharField(
        max_length=10,
        verbose_name='长度',
        choices=LENGTH,
    )
    desc = models.TextField(
        default='在第一个 JavaScript 板块，带领各位体验编写 JavaScript 程序前，首先回答一些基本问题：「什么是 JavaScript？」，「它看上去是什么样的？」，「它能做什么？」。此后，我们将详细讨论一些关键构件，例如变量、字符串、数值和数组。',
        verbose_name='描述',
    )
    content = models.TextField(
        default='在第一个 JavaScript 板块，带领各位体验编写 JavaScript 程序前，首先回答一些基本问题：「什么是 JavaScript？」，「它看上去是什么样的？」，「它能做什么？」。此后，我们将详细讨论一些关键构件，例如变量、字符串、数值和数组。'
    )
    class Meta:
        verbose_name='作品'
        verbose_name_plural='作品列表'
    def __str__(self):
        return self.title
    def get_absolute_url(self):
        pass
    @admin.display(description='书籍类型')
    def display_genre(self):
        return ', '.join([genre.genre for genre in self.genre.all()])
    @property
    def property_genre(self):
        return ', '.join([genre.genre for genre in self.genre.all()])


class GenericModel(models.Model):
    name = models.CharField(
        max_length=10,
    )
    create_datetime = models.DateField(
        verbose_name='创建时间',
        auto_now_add=True,
        editable=False,
    )
    update_datetime = models.DateField(
        verbose_name='修改时间',
        auto_now=True,
        editable=False,
    )
    field = models.CharField()
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        pass
    class Meta:
        abstract=True
