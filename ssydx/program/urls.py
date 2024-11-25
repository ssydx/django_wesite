from django.urls import path

app_name = "program"

urlpatterns = [

]
from django.views.generic import RedirectView
urlpatterns = [
    path('', RedirectView.as_view(url='index/'))
]

from program import views
urlpatterns += [
    path('index/', views.index, name='index')
]

urlpatterns += [
    path('origin/', views.origin, name='origin'),
]
urlpatterns += [
    path('main/', views.main, name='main'),
]
urlpatterns += [
    path('program/index/', views.base, name='base'),
]


urlpatterns += [
    path('program/articles/', views.ArticlesView.as_view(), name='articles')
]
urlpatterns += [
    path('program/article/<int:pk>', views.ArticleView.as_view(), name='article')
]
urlpatterns += [
    path('program/genre/<int:pk>', views.GenreView.as_view(), name='genre')
]


