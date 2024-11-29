
class Peo:
    def __init__(self, name: str, age: int) -> None:
        self.name = name
        self.age = age
    def getAgeAddTen(self):
        return self.age + 10
    @property
    def getName(self):
        return 'name:' + self.name
    
p1 = Peo('张三', 20)
print(p1.name)
print(p1.getAgeAddTen())
print(p1.getName)

class myPeo(Peo):
    score = 90
    def __init__(self, name: str, age: int, sex: str) -> None:
        super().__init__(name, age)
        self.sex = sex
    def getAgeAddTen(self):
        return self.age + 20
    def __str__(self):
        return 'mypeo'
p2 = myPeo('张三', 20, '男')

print(p2.sex)
print(p2.getAgeAddTen())
print(p2.getName)
print(p2.__class__)
print(p2.score)
print(myPeo)
print(p2)
