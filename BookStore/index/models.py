from django.db import models

# Create your models here.
class PubName(models.Model):
    pubname=models.CharField('名称',max_length=255,unique=True)
    def __str__(self):
        return self.pubname

class Book(models.Model): #创建 book 表
    title=models.CharField( max_length=30,unique=True, verbose_name='书名')
    price=models.DecimalField(max_digits=7,decimal_places=2,verbose_name='定价')
    pub=models.ForeignKey(to=PubName,on_delete=models.CASCADE,null=True)
    def default_price(self):
        return '￥30'
    retail_price=models.DecimalField(max_digits=7,decimal_places=2,verbose_name='零售价',default=default_price)
    def __str__(self):
        return self.title
class Author(models.Model): #创建作者表
    name=models.CharField(max_length=30,verbose_name='姓名')
    email=models.EmailField(verbose_name='邮箱')
    def __str__(self):
        return '作者：%s'%(self.name)
class UserInfo(models.Model): #创建用户信息表
    username=models.CharField(max_length=24,verbose_name='用户注册')
    password =models.CharField(max_length=24,verbose_name='密码')
    choices = (
        ('male', '男性'),
        ('female', '女性'),
        )
    gender = models.CharField(max_length=10,choices = choices,default='male',verbose_name='性别')






