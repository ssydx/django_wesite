from django.urls import path,include

urlpatterns = [

]
from index.views import *
from django.views.generic import RedirectView
urlpatterns += [
    path('', test_html, name='test_html'),
]
urlpatterns += [
    path('allbook/', BookName, name='allbook'),
]
urlpatterns += [
    path('loaderView/', loaderView, name='loaderView'),
]
urlpatterns += [
    path('renderView/', renderView, name='renderView'),
] 