a=[2,42,13,67,34,255,7,1,13,55]

for i in range(len(a)):
    for j in range(len(a)-i-1):
        if a[j] >a[j+1]:

            a[j],a[j+1]=a[j+1],a[j]

print(a)