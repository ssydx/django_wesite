from django.db import models
import uuid

# Create your models here.

class class_tb(models.Model):
    name = models.CharField(max_length=10, help_text='教室名')
    size = models.IntegerField(help_text='教室大小', unique=True)

    # def __str__(self):
    #     return self.name


class stu_tb(models.Model):
    name = models.CharField(max_length=10, help_text='学生姓名')
    age = models.IntegerField(help_text='学生年龄')
    sex = (
        ('m', 'male'),
        ('f', 'female'),
    )
    gender = models.CharField(max_length=1, choices=sex, help_text='性别')
    class_name = models.ForeignKey(class_tb, models.SET_NULL, related_name='stu_by_class_name', null=True, blank=True)
    # class_size = models.ForeignKey(class_tb, models.CASCADE, to_field='size', related_name='stu_by_class_size', default=1)
    desciption = models.TextField(help_text='个人描述', default='这是一段个人描述', blank=True, null=True)

    def __str__(self):
        return self.name
    

class prod(models.Model):
    name = models.CharField(max_length=10, primary_key=True)
    price = models.FloatField()

class prod1(models.Model):
    myid = models.AutoField(primary_key=True)
    # 数字类
    price = models.IntegerField()
    price1 = models.DecimalField(max_digits=5, decimal_places=2)
    price2 = models.FloatField(default=20.0001)
    bool = models.BooleanField(default=True)
    positiveprice = models.PositiveIntegerField(default=1)
    # 日期类
    dedate = models.DateField(default='2024-10-01')
    detime = models.TimeField(default='12:00:00')
    datetime = models.DateTimeField()
    createtime = models.DateTimeField(auto_now_add=True)
    modifytime = models.DateTimeField(auto_now=True)
    # 文本
    name = models.CharField(max_length=20)
    desc = models.TextField()
    # 特殊
    email = models.EmailField(default='ssydx@qq.com')
    url = models.URLField(default='www.baidu.com')

    file1 = models.FileField(upload_to='documents/')
    image1 = models.ImageField(upload_to='images/')

    uid = models.UUIDField(default=uuid.uuid4)
    uid1 = models.CharField(max_length=50, default=uuid.uuid4, help_text='唯一标识', verbose_name='易读名称')

    seq = [
        ('1', '一'),
        ('2', '二'),
        ('3', '三'),
    ]
    choice = models.CharField(max_length=1, choices=seq)


class AbstractModel(models.Model):
    name = models.CharField(max_length=20,)
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
    def __str__(self):
        return self.name
    def get_absolute_url(self):
        pass
    class Meta:
        abstract=True
        ordering=['name']


class M1(AbstractModel):
    home_group = models.CharField(max_length=5)


class InhreritModel(models.Model):
    name = models.CharField(max_length=20,)


class I1(InhreritModel):
    home_group = models.CharField(max_length=5)

class ProxyModel(I1):
    class Meta:
        proxy=True
        ordering=['?']
    def __str__(self):
        return self.name + self.home_group
    



class HandField(models.Field):
    description = "A hand of cards (bridge style)"

    def __init__(self, *args, **kwargs):
        kwargs["max_length"] = 104
        super().__init__(*args, **kwargs)

class temp(models.Model):
    n = HandField()


