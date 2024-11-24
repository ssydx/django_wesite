from django.db import models
from django.urls import reverse
# Create your models here.

class AuthorModel(models.Model):
    name = models.CharField(
        max_length=10,
        verbose_name='姓名',
        help_text='输入作者姓名',
        default='张三',
        db_column='姓名',
        db_comment='输入作者姓名',
    )
    SEX = [
        ('M', '男'),
        ('F', '女'),
    ]
    gender = models.CharField(
        max_length=1,
        choices=SEX,
        verbose_name='性别',
        help_text='选择作者性别',
        default='M',
        db_column='性别',
        db_comment='选择作者性别',
    )
    class Meta:
        db_table='作者表'
        db_table_comment='作者信息表'
        verbose_name='作者'
        verbose_name_plural='作者列表'
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('author', kwargs={'pk': self.id})

class GenreModel(models.Model):
    name = models.CharField(
        max_length=20,
        verbose_name='类别',
        help_text='请输入文章类别',
        default='HTML',
        db_column='类别',
        db_comment='输入文章类别',
        unique=True,
    )
    desc = models.CharField(
        max_length=200,
        verbose_name='类别描述',
        help_text='请输入类别描述',
        default='层叠样式表——或 CSS——是你在学完 HTML 之后应该学习的第一门技术。HTML 用于为你的内容定义结构和语义，CSS 用于为内容提供样式和对内容进行布局。例如，你可以使用 CSS 更改内容的字体、颜色、大小和间距，将内容分成多列，或添加动画和其它装饰特性。',
        db_column='类别描述',
        db_comment='输入文章类别描述',
    )
    content= models.TextField(
        verbose_name='类别文档',
        help_text='请输入类别文档',
        default='层叠样式表——或 CSS——是你在学完 HTML 之后应该学习的第一门技术。HTML 用于为你的内容定义结构和语义，CSS 用于为内容提供样式和对内容进行布局。例如，你可以使用 CSS 更改内容的字体、颜色、大小和间距，将内容分成多列，或添加动画和其它装饰特性。',
        db_column='类别文档',
        db_comment='输入文章类别文档',
    )
    class Meta:
        db_table='类型表'
        db_table_comment='类型信息表'
        verbose_name='类型'
        verbose_name_plural='类型列表'
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('genre', kwargs={'pk': self.id})

class ArticleModel(models.Model):
    name = models.CharField(
        max_length=20,
        unique=True,
        verbose_name='标题',
        help_text='输入文章标题',
        default='入门',
        db_column='标题',
        db_comment='输入文章标题',
    )
    desc = models.CharField(
        max_length=200,
        verbose_name='简介',
        help_text='输入文章简介',
        default='这是一段入门介绍',
        db_column='简介',
        db_comment='输入文章简介',
    )
    content = models.TextField(
        verbose_name='文章内容',
        help_text='输入文章内容',
        default='<p>Hello World!</p>',
        db_column='文章内容',
        db_comment='输入文章内容',
    )
    author = models.ForeignKey(
        AuthorModel,
        on_delete=models.CASCADE,
        related_name='articles',
        default=1,
    )
    genre = models.ForeignKey(
        GenreModel,
        on_delete=models.CASCADE,
        related_name='aritcles',
        default=1,
    )
    create_datetime = models.DateTimeField(
        auto_now_add=True,
        verbose_name='创建时期',
        help_text='不可修改',
        db_column='创建时期',
        db_comment='文章创建时期',  
    )
    update_datetime = models.DateTimeField(
        auto_now=True,
        verbose_name='修改时期',
        help_text='不可修改',
        db_column='修改时期',
        db_comment='文章修改时期',  
    )
    class Meta:
        db_table='文章表'
        db_table_comment='文章信息表'
        verbose_name='文章'
        verbose_name_plural='文章列表'
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('article', kwargs={'pk': self.id})