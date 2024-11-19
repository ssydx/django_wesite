from django.db import models
from django.urls import reverse
# Create your models here.


class AuthorModel(models.Model):
    name = models.CharField(
        max_length=10,
        help_text='输入作者的姓名',
        verbose_name='作者姓名',
        db_column='作者姓名',
        unique=True,
    )
    age = models.IntegerField(
        verbose_name='作者年龄',
        db_column='作者年龄',
        default=20,
    )
    SEX = [
        ('M', '男'),
        ('F', '女'),
    ]
    gender = models.CharField(
        max_length=1,
        verbose_name='作者性别',
        db_column='作者性别',
        choices=SEX,
        default='M',
    )
    create_datetime = models.DateTimeField(
        auto_now_add=True,
        verbose_name='创建时间',
        db_column='创建时间',
        editable=False,
    )
    update_datetime = models.DateTimeField(
        auto_now=True,
        verbose_name='修改时间',
        db_column='修改时间',
        editable=False,
    )
    class Meta:
        ordering = ['gender','-age']
        verbose_name = '作者信息'
        verbose_name_plural = '作者列表'
        db_table = '作者信息表'
        constraints = [
            models.CheckConstraint(check=models.Q(age__gte=18) & models.Q(age__lte=60),name='年龄约束')
        ]
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('author',kwargs={'pk':self.pk, })

class BookModel(models.Model):
    title = models.CharField(
        default='西游记',
        max_length=50,
        help_text='输入一个书籍标题',
        verbose_name='书籍名称',
        db_column='书籍名称',
        unique=True,
    )
    desc = models.TextField(
        help_text='输入简短描述',
        verbose_name='书籍简介',
        db_column='书籍简介',
    )
    author = models.ForeignKey(
        to=AuthorModel,
        on_delete=models.CASCADE,
        to_field='name',
        related_name='书籍集合',
        db_column='作者姓名',
        blank=True,
        null=True,
    )
    chrcount = models.DecimalField(
        default=123.32,
        max_digits=6,
        decimal_places=2,
        help_text='书籍字数，单位为万',
        verbose_name='书籍字数(万)',
        db_column='书籍字数(万)'
    )
    class Meta:
        ordering = ['?']
        verbose_name = '书籍信息'
        verbose_name_plural = '书籍列表'
        db_table = '书籍信息表'
        permissions = [
            ('can_delete_book','删除书籍'),
            ('can_update_book','更新书籍'),
            ('can_add_book','增加书籍'),
        ]
        indexes = [
            models.Index(fields=['title','author'],name='联合索引'),
            models.Index(fields=['author'],name='作者索引'),
        ]
    def __str__(self):
        return self.title
    def get_absolute_url(self):
        return reverse('books',kwargs={'pk':self.pk, })