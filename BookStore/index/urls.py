from django.urls import path,include

urlpatterns = [

]
from index.views import *
from django.views.generic import RedirectView
from index.forms import *
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
urlpatterns += [
    path('logView/', LogView.as_view(), name='logView')
]
urlpatterns += [
    path('login/', login, name='loginView')
]
urlpatterns += [
    path('sendemail/', send_email, name='send_email')
]
urlpatterns += [
    path('upload/', upload, name='upload')
]

urlpatterns += [
    path('csv/', test_csv, name='csv')
]