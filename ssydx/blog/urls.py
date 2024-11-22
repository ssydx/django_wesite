from django.urls import path

urlpatterns = [

]
from blog import views
urlpatterns += [
    path('', views.index, name='index')
]
urlpatterns += [
    path('articles/', views.ArticlesView.as_view(), name='articles')
]
urlpatterns += [
    path('article/<int:pk>', views.ArticleView.as_view(), name='article')
]
urlpatterns += [
    path('test1/', views.test1, name='test1'),
]
urlpatterns += [
    path('test2/', views.test2, name='test2'),
]