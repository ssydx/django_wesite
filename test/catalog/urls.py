from django.urls import path
from catalog.views import *
urlpatterns = [
    path('', index,name='index'),
]
urlpatterns += [
    path('author/<int:pk>', AuthorView.as_view(), name='author')
]