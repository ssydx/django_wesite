# Generated by Django 4.2.16 on 2024-11-25 18:29

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='AuthorModel',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(db_column='姓名', db_comment='输入作者姓名', default='张三', help_text='输入作者姓名', max_length=10, verbose_name='姓名')),
                ('gender', models.CharField(choices=[('M', '男'), ('F', '女')], db_column='性别', db_comment='选择作者性别', default='M', help_text='选择作者性别', max_length=1, verbose_name='性别')),
            ],
            options={
                'verbose_name': '作者',
                'verbose_name_plural': '作者列表',
                'db_table': '作者表',
                'db_table_comment': '作者信息表',
            },
        ),
        migrations.CreateModel(
            name='GenreModel',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(db_column='类别', db_comment='输入文章类别', default='HTML', help_text='请输入文章类别', max_length=20, unique=True, verbose_name='类别')),
                ('desc', models.CharField(db_column='类别描述', db_comment='输入文章类别描述', default='层叠样式表——或 CSS——是你在学完 HTML 之后应该学习的第一门技术。HTML 用于为你的内容定义结构和语义，CSS 用于为内容提供样式和对内容进行布局。例如，你可以使用 CSS 更改内容的字体、颜色、大小和间距，将内容分成多列，或添加动画和其它装饰特性。', help_text='请输入类别描述', max_length=200, verbose_name='类别描述')),
                ('content', models.TextField(db_column='类别文档', db_comment='输入文章类别文档', default='层叠样式表——或 CSS——是你在学完 HTML 之后应该学习的第一门技术。HTML 用于为你的内容定义结构和语义，CSS 用于为内容提供样式和对内容进行布局。例如，你可以使用 CSS 更改内容的字体、颜色、大小和间距，将内容分成多列，或添加动画和其它装饰特性。', help_text='请输入类别文档', verbose_name='类别文档')),
            ],
            options={
                'verbose_name': '类型',
                'verbose_name_plural': '类型列表',
                'db_table': '类型表',
                'db_table_comment': '类型信息表',
            },
        ),
        migrations.CreateModel(
            name='ArticleModel',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(db_column='标题', db_comment='输入文章标题', default='入门', help_text='输入文章标题', max_length=20, unique=True, verbose_name='标题')),
                ('desc', models.CharField(db_column='简介', db_comment='输入文章简介', default='这是一段入门介绍', help_text='输入文章简介', max_length=200, verbose_name='简介')),
                ('content', models.TextField(db_column='文章内容', db_comment='输入文章内容', default='<p>Hello World!</p>', help_text='输入文章内容', verbose_name='文章内容')),
                ('create_datetime', models.DateTimeField(auto_now_add=True, db_column='创建时期', db_comment='文章创建时期', help_text='不可修改', verbose_name='创建时期')),
                ('update_datetime', models.DateTimeField(auto_now=True, db_column='修改时期', db_comment='文章修改时期', help_text='不可修改', verbose_name='修改时期')),
                ('author', models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, related_name='articles', to='program.authormodel')),
                ('genre', models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, related_name='aritcles', to='program.genremodel')),
            ],
            options={
                'verbose_name': '文章',
                'verbose_name_plural': '文章列表',
                'db_table': '文章表',
                'db_table_comment': '文章信息表',
            },
        ),
    ]
