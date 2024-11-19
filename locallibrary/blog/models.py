from django.db import models

from django.contrib.auth.models import User
from django.urls import reverse
class BlogAuthorModel(models.Model):
    name = models.CharField(max_length=100,verbose_name='博主姓名')
    age = models.IntegerField(verbose_name='博主年龄')
    desc = models.TextField(verbose_name='博主简介')
    class Meta:
        verbose_name='博主'
        verbose_name_plural='博主列表'
        ordering = ['-age', ]
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('blogauthor', args=[str(self.id)])
class BlogContentModel(models.Model):
    name = models.CharField(max_length=200,verbose_name='博文名称',help_text='帮助文本')
    upload_date = models.DateField(verbose_name='上传日期')
    author = models.ForeignKey(BlogAuthorModel,on_delete=models.CASCADE,verbose_name='博文作者',related_name='blogcontents')
    content = models.TextField(verbose_name='博文内容')
    class Meta:
        verbose_name='博文'
        verbose_name_plural='博文列表'
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        return reverse('blogcontent', args=[str(self.id)])
class BlogCommentModel(models.Model):
    name = models.ForeignKey(User, on_delete=models.CASCADE,verbose_name='评论者姓名',related_name='blogcomments')
    pub_datetime = models.DateTimeField(verbose_name='评论时间')
    comment = models.TextField(verbose_name='评论内容')
    blog = models.ForeignKey(BlogContentModel,on_delete=models.CASCADE,verbose_name='博文内容',related_name='blogcomments')
    class Meta:
        verbose_name='评论'
        verbose_name_plural='评论列表'
    def __str__(self):
        return str(self.name)
    def get_absolute_url(self):
        return reverse('blogcomment', args=[str(self.id)])