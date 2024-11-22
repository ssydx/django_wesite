# Generated by Django 4.2.16 on 2024-11-24 07:56

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('blog', '0003_alter_articlemodel_genre'),
    ]

    operations = [
        migrations.AlterField(
            model_name='articlemodel',
            name='author',
            field=models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, related_name='articles', to='blog.authormodel'),
        ),
    ]
