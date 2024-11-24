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
    path('genre/<int:pk>', views.GenreView.as_view(), name='genre')
]


urlpatterns += [
    path('origin/', views.origin, name='origin'),
]
urlpatterns += [
    path('blog/', views.blog, name='blog'),
]
urlpatterns += [
    path('base/', views.base, name='base'),
]