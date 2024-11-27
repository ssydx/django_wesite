from django.urls import path
from novel import views
from django.views.generic import RedirectView

app_name = "novel"

urlpatterns = [
    path('', RedirectView.as_view(url='index/')),
]
urlpatterns += [
    path('index/', views.index, name='index'),
]
urlpatterns += [
    path('authors/', views.AuthorsView.as_view(), name='authors'),
]
urlpatterns += [
    path('tests/', views.tests, name='tests'),
]
urlpatterns += [
    path('test/<int:pk>', views.test, name='test'),
]