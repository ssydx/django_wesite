# Generated by Django 4.2.16 on 2024-12-01 16:05

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('index', '0003_pubname_alter_userinfo_gender_book_pub'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='book',
            name='public',
        ),
    ]